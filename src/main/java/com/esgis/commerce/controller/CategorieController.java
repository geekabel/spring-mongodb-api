package com.esgis.commerce.controller;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

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
    @PutMapping("/update/{categId}")
    public ResponseEntity<Categorie> updateCateg(@PathVariable String categId, @RequestBody Categorie c){
        try {
            if (categId != null){
                Categorie categories = categorieService.saveCategorie(c);
                return new ResponseEntity<>(categories, HttpStatus.OK);
            }
          return new ResponseEntity<>(null, HttpStatus.PARTIAL_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{categId}")
    public ResponseEntity<Optional<Categorie>> getCategById(@PathVariable String categId){
        try {
            Optional<Categorie> categories = categorieService.findById(categId);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{categId}")
    public ResponseEntity<Categorie> deleteCateg(@PathVariable String categId) {
        try {
            categorieService.deleteCategorie(categId);
            return new ResponseEntity("Categorie supprimer avec succès", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Un souci innatendue", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
