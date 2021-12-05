/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.service;

import co.sergioarboleda.retos.entity.Cookware;
import co.sergioarboleda.retos.repository.CookwareRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookwareService {
    
    @Autowired
    private CookwareRepository cookwareRepository;
    
    public List<Cookware> getAll(){
        return cookwareRepository.getAll();
    }
  
    public Optional<Cookware> getUser(String id){
        return cookwareRepository.getUserById(id);
    }
    
     public Cookware save(Cookware cookware){
        if(cookware.getCategory() == null || cookware.getBrand()==null || cookware.getDescription()==null || 
             cookware.getPhotography()==null){
            return cookware;
        }else{
               Optional<Cookware> existClothe = cookwareRepository.getUserById(cookware.getReference());
                    if(existClothe.isEmpty()){
                        return cookwareRepository.save(cookware);
                    }else{
                        return cookware;
                    }
             
            }
        }
     
     
     public Cookware update(Cookware cookware){
        if(cookware.getReference()!=null){
            Optional<Cookware> cookwareExist = cookwareRepository.getUserById(cookware.getReference());
            if(cookwareExist.isPresent()){
                if(cookware.getBrand()!=null){
                    cookwareExist.get().setBrand(cookware.getBrand());
                }
                if(cookware.getCategory()!=null){
                    cookwareExist.get().setCategory(cookware.getCategory());
                }
                if(cookware.getMateriales()!=null){
                    cookwareExist.get().setMateriales(cookware.getMateriales());
                }
                if(cookware.getDimensiones()!=null){
                    cookwareExist.get().setDimensiones(cookware.getDimensiones());
                }
                  if(cookware.getDescription()!=null){
                    cookwareExist.get().setDescription(cookware.getDescription());
                }
                
               
                if(cookware.getPhotography()!=null){
                    cookwareExist.get().setPhotography(cookware.getPhotography());
                }
                
                 if(cookware.getQuantity()!=0){
                    cookwareExist.get().setQuantity(cookware.getQuantity());
                }
                 
                 if(cookware.getPrice()!=0){
                    cookwareExist.get().setPrice(cookware.getPrice());
                }
                return cookwareRepository.save(cookwareExist.get());
            }else{
                return cookware;
            }
        }else{
            return cookware;
        }
    }
     
     
     
     
     public String deleteById(String id){
        Optional<Cookware> clone = cookwareRepository.getUserById(id);
        if(clone.isPresent()){
            cookwareRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }
   
}
