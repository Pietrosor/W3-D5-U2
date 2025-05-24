package dao;

import entity.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RivistaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public RivistaDAO() {

        emf = Persistence.createEntityManagerFactory("CatalogoBibliografico");
        em = emf.createEntityManager();
    }


    public void save(Rivista rivista) {
        em.getTransaction().begin();
        em.persist(rivista);
        em.getTransaction().commit();
    }


    public Rivista findById(String isbn) {
        return em.find(Rivista.class, isbn);
    }


    public List<Rivista> findAll() {
        TypedQuery<Rivista> query = em.createQuery("SELECT r FROM Rivista r", Rivista.class);
        return query.getResultList();
    }


    public void update(Rivista rivista) {
        em.getTransaction().begin();
        em.merge(rivista);
        em.getTransaction().commit();
    }


    public void delete(Rivista rivista) {
        em.getTransaction().begin();
        if (!em.contains(rivista)) {
            rivista = em.merge(rivista);
        }
        em.remove(rivista);
        em.getTransaction().commit();
    }


    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}