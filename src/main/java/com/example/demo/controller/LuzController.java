package com.example.demo.controller;

import com.example.demo.entity.Luz;
import com.example.demo.repository.LuzRepository;
import com.example.demo.service.LuzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/luz", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE})
public class LuzController {
    @Autowired
    LuzService service;

    @GetMapping
    public List<Luz> luzSel(){
        return service.luzSel();

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Luz luzInsert(@RequestBody Luz x)
    {
        return service.luzInsertUpdate(x);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Luz luzUpdate(@RequestBody Luz x)
    {
        return service.luzInsertUpdate(x);
    }
    @DeleteMapping("/{id}")
    public void luzDelete(@PathVariable("id") Integer x)
    {
        service.luzDelete(x);
    }
    @GetMapping("/{id}")
    public Luz luzGet(@PathVariable("id") Integer x){
        return service.luzGet(x);
    }
    @GetMapping("/piso/{piso}")
    public List<Luz> luzBuscarPorPiso(@PathVariable("piso") Integer x){
        return service.findbyFloor(x);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Luz> luzBuscarPorNombre(@PathVariable("nombre") String y)
    {
        return service.findByName(y);
    }
    @GetMapping("/sort")
    public ResponseEntity<List<Luz>> ligthOrder(
            @RequestParam(value= "atribute", required = true) String atribute,
            @RequestParam(value = "direction", required = true) String direction){
        List<Luz> luces  = service.listwithOrder(atribute, direction);
        return new ResponseEntity<>(luces, HttpStatus.OK);
  }
  @GetMapping("/import/{import}")
    public List<Luz>  findByImport(@PathVariable("import") Integer i){
        return service.findByImport(i);
  }
  
}
//    @GetMapping("/calculate")
//    public ResponseEntity<Integer> Current(
//            @RequestParam(value= "current", required= true) Integer current,
//            @RequestParam(value = "previous", required = true) Integer previous){
//    }
//    )
