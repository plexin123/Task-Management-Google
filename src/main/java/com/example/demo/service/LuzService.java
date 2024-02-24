    package com.example.demo.service;

    import com.example.demo.entity.Luz;
    import com.example.demo.repository.LuzRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Service;

    import java.util.Comparator;
    import java.util.List;

    @Service
    public class LuzService {
        @Autowired
        LuzRepository luzRep;
        public List<Luz> luzSel(){
            return luzRep.findAll();
        }
        public Luz luzInsertUpdate(Luz x){
            return luzRep.save(x);
        }
        public void luzDelete(Integer x){
            luzRep.deleteById(x);
        }
        public Luz luzGet(Integer x){
            return luzRep.findById(x).orElse(new Luz());
        }
        public List<Luz> findbyFloor(Integer x){
    //        return luzRep.buscarporPiso(x);
                return luzRep.findByPiso(x);
        }
        public List<Luz> findByName(String y){
            return luzRep.findByCasa(y);
        }
        public List<Luz> listwithOrder(String atribute, String direction){
            Sort sort = Sort.by(Sort.Direction.fromString(direction),atribute);
            return luzRep.findAll(sort);
        }
        public List<Luz> findByImport(Integer imp){
                return luzRep.findByImporte(imp);
        }
        // @Query("FROM Luz l WHERE l.casa= :string")
        //    List<Luz> buscarporNombre(@Param("string") String y);
//        public List<Luz> findbyName(String name){
//                return luzRep.buscarporNombre(name);
//        }
        //   @Query("FROM Luz l WHERE l.piso = :number")//native query by default is false
        //    List<Luz> buscarporPiso(@Param("number") int x); //JPQL
//        public List<Luz> findByFloor (Integer floor){
//                return luzRep.buscarporPiso(floor);
//        }

        @Transactional
        public List<Luz> sortByAtribute(List<Luz> electric,String atribute){
            switch(atribute){
                case "kwats":
                    electric.sort(Comparator.comparing(Luz::getKwats));
                    break;
                case "importe":
                    electric.sort(Comparator.comparing(Luz::getImporte));
                    break;
                case "start_Date":
                    electric.sort(Comparator.comparing(Luz::getStartDate));
                    break;
            }
            return electric;
        }

    }
