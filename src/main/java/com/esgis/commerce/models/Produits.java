package com.esgis.commerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("produits")
public class Produits {

    @Id
    private String id;
    private String nom;
    private String description;
    private int quantite;
    private double PU;
    private Date dateAjout;

    private List<Categorie> categories;
}
