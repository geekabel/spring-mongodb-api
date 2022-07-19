package com.esgis.commerce.services;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    public Produits saveProduit(Produits p);
    public Optional<Produits> findById(String id);
    public List<Produits> findAll();
    public void deleteProduit(String id);
    public void findProduitByCategories(String categories);
}
