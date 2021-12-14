/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;


import co.sergioarboleda.retos.entity.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Desarrollo
 */
public interface CookwareCrudRepository extends MongoRepository<Cookware, String>{
    
    public Optional<Cookware> findById(String id); 
    
    //public List<Cookware> findByPrice(Integer precio);
    public List<Cookware> findByPriceNotLike(Integer precio);
    
    public List<Cookware> findByDescriptionContainingIgnoreCase(String title);
    
    
}
