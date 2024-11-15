package dao;

import model.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AutorDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");

    public void save(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }

    public List<Autor> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery("FROM Autor", Autor.class).getResultList();
        em.close();
        return autores;
    }

    public Autor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        em.close();
        return autor;
    }

    public void update(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(autor) ? autor : em.merge(autor));
        em.getTransaction().commit();
        em.close();
    }
}
