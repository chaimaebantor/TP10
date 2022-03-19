package ma.cigma.pfe.dao;

import ma.cigma.pfe.models.Facture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
@Repository
public class FactureDaoImpl implements IFactureDao
{
    @PersistenceContext
    EntityManager em;
    public FactureDaoImpl() {
        System.out.println(" FactureDaoImpl ....");
    }

    @Override
    public Facture save(Facture f) {
        em.persist(f);
        return null;
    }

    @Override
    public Facture update(Facture newFacture) {
        em.getTransaction().begin();
        Facture currentFacture = em.find(Facture.class, newFacture.getId());
        currentFacture.setAmount(newFacture.getAmount());
        currentFacture.setDate(newFacture.getDate());
        em.persist(currentFacture);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void deleteById(long idFacture) {
        em.getTransaction().begin();
        Facture factureInDataBase = em.find(Facture.class,idFacture);
        em.remove(factureInDataBase);
        em.getTransaction().commit();
    }

    @Override
    public Facture findById(long idFacture) {
        return em.find(Facture.class,idFacture);
    }

    @Override
    public List<Facture> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Facture> criteria = builder.createQuery(Facture.class);
        criteria.from(Facture.class);
        List<Facture> factureList = em.createQuery(criteria).getResultList();

        return factureList;
    }
}
