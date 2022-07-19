package com.esgis.commerce.services;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    public Categorie saveCategorie(Categorie c);
    public Optional<Categorie>findById(String id);
    public List<Categorie> findAll();
    public void deleteCategorie(String id);
}
