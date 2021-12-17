/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CookwareRepository {
    
    @Autowired
    private CookwareCrudRepository cookwareCrudRepository;
    
    //Get ALl
    public List<Cookware> getAll(){
        return (List<Cookware>) cookwareCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Cookware> getUserById(String id){
        return cookwareCrudRepository.findById(id);
    }
    
     public Cookware save(Cookware cookware){
        return cookwareCrudRepository.save(cookware);
    }
     
     public void delete (String id){
        cookwareCrudRepository.deleteById(id);
    }

    public void deleteById (String id){
        cookwareCrudRepository.deleteById(id);
    }
    
     public List<Cookware> getClotheByPrice(Integer precio){
        return  cookwareCrudRepository.findByPriceNotLike(precio);
    }
     
     public List<Cookware> getClotheByDescription(String dc){
        return  cookwareCrudRepository.findByDescriptionContainingIgnoreCase(dc);
    }
     
     public Optional <Cookware> getCookwareByReference(String reference){
        return  cookwareCrudRepository.findByReference(reference);
    }
    
    
    
}
