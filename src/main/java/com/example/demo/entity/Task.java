package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title")
        private String title;
        @Column(name = "description")
        private String description;
        @Column(name = "duedate")
        private LocalDate dueDate;
        @Column(name = "completed")
        private boolean completed;
        @Column(name = "dependencies")
        private String dependencies;

        @ManyToOne //there is going to be n tasks related to one user
        @JoinColumn(name = "user_id")
        private User user;
        public String getDependencies() {
                return dependencies;
        }

        public void setDependencies(String dependencies) {
                this.dependencies = dependencies;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public LocalDate getDueDate() {
                return dueDate;
        }

        public void setDueDate(LocalDate dueDate) {
                this.dueDate = dueDate;
        }

        public boolean isCompleted() {
                return completed;
        }

        public void setCompleted(Boolean completed) {
                this.completed = completed;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
