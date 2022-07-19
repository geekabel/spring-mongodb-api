package com.esgis.commerce.controller;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/create")
    public ResponseEntity<Categorie> createCateg(@RequestBody Categorie c ){
        try {
            Categorie categorie = categorieService.saveCategorie(c);
            return new ResponseEntity<>(categorie, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Categorie>> getAll(){
        try {
             List<Categorie> categories = categorieService.findAll();
             if(categories.isEmpty()){
                 return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
             }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
