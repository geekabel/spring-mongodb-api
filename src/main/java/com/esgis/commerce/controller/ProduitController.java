package com.esgis.commerce.controller;

import com.esgis.commerce.models.Categorie;
import com.esgis.commerce.models.Produits;
import com.esgis.commerce.services.ProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    public ProduitService produitService;

    @PostMapping("/create")
    public ResponseEntity<Produits> createProduit(@RequestBody Produits p ){
        try {
            Produits produits = produitService.saveProduit(p);
            return new ResponseEntity<>(produits, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Produits>> getAll(){
        try {
            List<Produits> produits = produitService.findAll();
            if(produits.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produits, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Produits> updateProduct(@PathVariable String productId, @RequestBody Produits p){
        try {
            if (productId != null){
                Produits produits = produitService.saveProduit(p);
                return new ResponseEntity<>(produits, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.PARTIAL_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{productId}")
    public  ResponseEntity<Produits> deleteCateg(@PathVariable String productId) {
        try {
            produitService.deleteProduit(productId);
            return new ResponseEntity("Produit supprimer avec succès", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Un souci innatendue", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
