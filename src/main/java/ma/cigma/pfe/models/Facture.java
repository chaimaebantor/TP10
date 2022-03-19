package ma.cigma.pfe.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TFacture")
public class Facture
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="CDATE")
    private Date date;
    @Column
    private Double amount;
    private String description;

   public Facture(Date date, Double amount) {
        this.date = date;
        this.amount = amount;
    }
    public Double getAmount() {
        return amount;
    }
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToMany(cascade ={CascadeType.PERSIST})
    @JoinTable(name = "my_join_table_Facture_Produit",joinColumns = @JoinColumn(name = "Facture_fk",referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name="Produit_fk",referencedColumnName="id"))
    private List<Produit> produits;

  public Facture(long id, Date date, Double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public Facture(Double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Facture(Double amount, String description, Client client) {
        this.amount = amount;
        this.description = description;
        this.client = client;
    }

    public Facture()
    {

    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
