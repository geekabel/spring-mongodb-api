package com.esgis.commerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document("categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

    @Id
    private String id;
    private String nom;
    private String description;

    @DBRef
    private List<Produits> produits;


}
