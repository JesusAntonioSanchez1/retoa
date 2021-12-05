/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.controller;

import co.sergioarboleda.retos.entity.Cookware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.sergioarboleda.retos.service.CookwareService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/cookware")
public class CookwareController {
    
    @Autowired
    private CookwareService cookwareService;
    
    @GetMapping("/all")
    public List<Cookware> getUsers(){
        return cookwareService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware save(@RequestBody Cookware clothe){
        return cookwareService.save(clothe);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update (@RequestBody Cookware clothe){
        return cookwareService.update(clothe);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") String id){
       return cookwareService.deleteById(id);
    }
    
}
