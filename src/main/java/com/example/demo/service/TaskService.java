    package com.example.demo.service;

    import com.example.demo.entity.Luz;
    import com.example.demo.entity.Task;
    import com.example.demo.entity.User;
    import com.example.demo.repository.TaskRepository;
    import com.example.demo.repository.UserRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.*;
    import java.util.stream.Collectors;

    @Service // intermediario entre el repositorio
    public class TaskService {
        //            private LinkedList<Task> List = new LinkedList<>();
        //Tasks behave like nodes
        private final TaskRepository taskRepository;
        private final UserRepository userRepository;
        private final Queue<Integer> queue = new PriorityQueue<>();
        @Autowired
        public TaskService(TaskRepository taskRepository,
                           UserRepository userRepository) {
            this.taskRepository = taskRepository;
            this.userRepository = userRepository;
        }

        @Transactional
        public Task createTask(Task task) {
            return taskRepository.save(task);
        }

        @Transactional
        public Task updateTask(Task task) {
            return taskRepository.save(task);
        }

        @Transactional
        public void deleteTask(Integer idtask) {
            taskRepository.deleteById(idtask);
        }

        @Transactional
        public Task findById(Integer idtask) {
            return taskRepository.findById(idtask).get();
        }

        @Transactional
        public List<Task> getAll() {
            return taskRepository.findAll();
        }

        @Transactional
        public void markTaskAsComplete(Task task) {
            taskRepository.save(task);
            String[] dependencies = task.getDependencies().split(",");
            boolean allDependenciesCompleted = true;
            for (String dp : dependencies) {
                Integer id = Integer.parseInt(dp.trim());
                Task dependencyTask = taskRepository.findById(id).orElse(null);
                if (dependencyTask == null || !dependencyTask.isCompleted()) {
                    allDependenciesCompleted = false;
                    task.setCompleted(false);
                    break;
                }
                if (allDependenciesCompleted) { //quite unnecessary
                    task.setCompleted(true);
                    taskRepository.save(task);
                }
            }

        }
        public List<Task> tasknotCompleted(List<Task> task){
            return task.stream().filter(tsk -> !tsk.isCompleted()).toList();
        }
        public boolean taskCompleted(List<Task> task){
            return task.stream().allMatch(Task::isCompleted);
        }

        @Transactional
        public List<Task> listOfDependencies(Task task) {
            List<Task> depenTasks = new ArrayList<>();
            String[] dependecies = task.getDependencies().split(",");
            for (String dp : dependecies) {
                Integer id = Integer.parseInt(dp.trim());
                Task dependencyTask = taskRepository.findById(id).orElse(null);
                if (dependencyTask != null) {
                    depenTasks.add(dependencyTask);
                }
            }
            return depenTasks;
        }

//        @Transactional
//        public List<String> listofDependencies(Task task) { // manage the list of task dependencies
//            List<String> depenTasks = new ArrayList<>();
//            String[] dependencies = task.getDependencies().split(",");
//            for (String dp : dependencies) {
//                if (dp.startsWith("l"))
//                    try {
//                        int luzId = Integer.parseInt(dp.substring(1).trim());
//
//                    }
//                Luz dependencyLuz = taskRepository.findById(id).orElse(null);
//
//            }
//        }

        @Transactional
        public List<Task> getDependeciesById(Task task) {
            List<Task> dependencies = new ArrayList<>();
            String[] dependecyIds = task.getDependencies().split(",");
            for (String i : dependecyIds) {
                try {
                    Integer taskId = Integer.parseInt(i.trim());
                    Task taskDependency = taskRepository.findById(taskId).orElse(null);
                    if (taskDependency != null) {
                        dependencies.add(taskDependency);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return  dependencies;

        }
//        getTaskbyTaskName
        public List<Task> getTaskbyTaskName(String name){
            return taskRepository.findByTitle(name);
        }
        @Transactional
        public List<Task> prioritizeTasks(List<Task> tasks, String criteria) {
            // Implement task prioritization logic based on the specified criteria
            // For example, prioritize by due date, importance, or dependencies
            // Modify the order of tasks in the list accordingly
            // Sorting example based on due date
            switch (criteria){
                case "dueDate":
                    tasks.sort(Comparator.comparing(Task::getDueDate));
                    Collections.reverse(tasks);
                    break;

                case "dependencies":
                    tasks.sort(Comparator.comparing(Task -> Task.getDependencies().chars().filter(d->d == ',').count()));
                    break;
                case "completed":
                    tasks.stream().sorted(Comparator.comparing(Task::isCompleted)).collect(Collectors.toList());
                    break;

            }
            return tasks;
        }
        

    }
