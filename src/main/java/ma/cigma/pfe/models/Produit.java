package ma.cigma.pfe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Produit {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;


    public Produit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Produit(String name, Double price, Facture facture) {
        this.name = name;
        this.price = price;
        this.facture = facture;
    }

    public Produit() {
    }
}
