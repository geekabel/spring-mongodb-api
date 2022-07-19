package com.esgis.commerce.repositories;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie,String> {
}
