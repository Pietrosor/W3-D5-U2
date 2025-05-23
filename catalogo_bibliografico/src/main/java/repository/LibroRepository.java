package repository;

import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LibroRepository {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public LibroRepository() {

        emf = Persistence.createEntityManagerFactory("CatalogoBibliografico");
        em = emf.createEntityManager();
    }


    public void salva(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }


    public Libro trovaPerISBN(String isbn) {
        return em.find(Libro.class, isbn);
    }


    public List<Libro> trovaTutti() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }


    public Libro aggiorna(Libro libro) {
        em.getTransaction().begin();
        Libro updatedLibro = em.merge(libro);
        em.getTransaction().commit();
        return updatedLibro;
    }


    public void elimina(Libro libro) {
        em.getTransaction().begin();
        if (!em.contains(libro)) {
            libro = em.merge(libro);
        }
        em.remove(libro);
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