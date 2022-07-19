package com.esgis.commerce.services;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;
import com.esgis.commerce.repositories.CategorieRepository;
import com.esgis.commerce.repositories.ProduitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements  ProduitService {

    @Autowired
    private ProduitsRepository produitsRepo;

    @Override
    public Produits saveProduit(Produits p) {
        return produitsRepo.save(p);
    }

    @Override
    public Optional<Produits> findById(String id) {
        return produitsRepo.findById(id);
    }

    @Override
    public List<Produits> findAll() {
        return produitsRepo.findAll();
    }

    @Override
    public void deleteProduit(String id) {
        Optional<Produits> data = findById(id);
         if (data.isPresent()) {
             produitsRepo.deleteById(id);
         }
    }

    @Override
    public void findProduitByCategories(String categories) {
        List<Produits> produitsList = produitsRepo.findAll(categories);
    }
}
