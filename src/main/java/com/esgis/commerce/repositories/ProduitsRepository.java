package com.esgis.commerce.repositories;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProduitsRepository extends MongoRepository<Produits,String> {
   @Query(value="{categories:'?0'}", fields="{'nom' : 1, 'quantite' : 1,'description' : 1}")
    List<Produits> findAll(String categories);
}
