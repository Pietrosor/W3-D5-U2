package repository;

import entity.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RivistaRepository {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public RivistaRepository() {

        emf = Persistence.createEntityManagerFactory("CatalogoBibliografico");
        em = emf.createEntityManager();
    }

    public void salva(Rivista rivista) {
        em.getTransaction().begin();
        em.persist(rivista);
        em.getTransaction().commit();
    }


    public Rivista trovaPerISBN(String isbn) {
        return em.find(Rivista.class, isbn);
    }


    public List<Rivista> trovaTutte() {
        TypedQuery<Rivista> query = em.createQuery("SELECT r FROM Rivista r", Rivista.class);
        return query.getResultList();
    }


    public Rivista aggiorna(Rivista rivista) {
        em.getTransaction().begin();
        Rivista updatedRivista = em.merge(rivista);
        em.getTransaction().commit();
        return updatedRivista;
    }


    public void elimina(Rivista rivista) {
        em.getTransaction().begin();
        if (!em.contains(rivista)) {
            rivista = em.merge(rivista);
        }
        em.remove(rivista);
        em.getTransaction().commit();
    }


    public void chiudi() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}