package ma.cigma.pfe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "TClient")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="client_type")
//@DiscriminatorValue("client")
public class Client {
    @Id
    //identity= auto increment
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="CNAME")
    private String name;

    //this column will not be saved in the database bc it's calculable
    //@Transient
   // private double amount;
public Client(String name)
{

}
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private List<Facture> factures;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="my_join_table_client_promotion",joinColumns = @JoinColumn(
            name = "client_fk",
            referencedColumnName = "id"
    ),
            inverseJoinColumns = @JoinColumn(
                    name = "promotion_fk",
                    referencedColumnName = "id"
            ))
    private List<Promotion> promotions;



    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private CarteFidelio carteFidelio;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "client")
    private  Adresse adresse;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Client(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Client()
    {

    }
}
