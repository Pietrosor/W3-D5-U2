package dao;

import entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class LibroDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public LibroDAO() {

        emf = Persistence.createEntityManagerFactory("CatalogoBibliografico");
        em = emf.createEntityManager();
    }


    public void save(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }


    public Libro findById(String isbn) {
        return em.find(Libro.class, isbn);
    }


    public List<Libro> findAll() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }


    public void update(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }


    public void delete(Libro libro) {
        em.getTransaction().begin();

        if (!em.contains(libro)) {
            libro = em.merge(libro);
        }
        em.remove(libro);
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