package dao;

import model.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void save(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    public List<Libro> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Libro> libros = em.createQuery("FROM Libro", Libro.class).getResultList();
        em.close();
        return libros;
    }

    public Libro findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, id);
        em.close();
        return libro;
    }

    public void update(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(libro) ? libro : em.merge(libro));
        em.getTransaction().commit();
        em.close();
    }
}
