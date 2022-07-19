package com.esgis.commerce.services;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepo;

    @Override
    public Categorie saveCategorie(Categorie c) {
        return categorieRepo.save(c);
    }

    @Override
    public Optional<Categorie>findById(String id) {
        return categorieRepo.findById(id);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepo.findAll();
    }

    @Override
    public void deleteCategorie(String id) {
        Optional<Categorie> data = findById(id);
        if(data.isPresent()){
            categorieRepo.deleteById(id);
        }
    }
}
