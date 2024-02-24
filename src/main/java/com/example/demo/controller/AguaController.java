package com.example.demo.controller;

import com.example.demo.entity.Agua;
import com.example.demo.entity.Luz;
import com.example.demo.service.LuzService;
import com.example.demo.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/agua",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class AguaController {
    @Autowired
    WaterService service;
    @GetMapping
    public List<Agua> aguaSel(){
        return service.aguaSelect();

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agua aguaInsert(@RequestBody Agua x)
    {
        return service.aguaInsert(x);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Agua aguaUpdate(@RequestBody Agua x)
    {
        return service.aguaInsert(x);
    }
    @DeleteMapping("/{id}")
    public void aguaDelete(@PathVariable("id") Integer x)
    {
        service.aguaDelete(x);
    }
    @GetMapping("/{id}")
    public Agua aguaGet(@PathVariable("id") Integer x){
        return service.aguaGet(x);
    }
    @GetMapping("/sort")
    public List<Agua>  sortWater(@RequestParam(value = "atribute", required = true) String atribute,
                                 @RequestParam(value = "direction",required = true) String direction){
       return service.orderByattributes(atribute,direction);
    }


}
