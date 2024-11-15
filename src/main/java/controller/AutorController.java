package controller;

import dao.AutorDAO;
import model.Autor;

import java.util.List;

public class AutorController {
    private AutorDAO autorDAO;

    public AutorController() {
        autorDAO = new AutorDAO();
    }

    public void agregarAutor(String nombre) {
        Autor autor = new Autor(nombre);
        autorDAO.save(autor);
    }

    public List<Autor> obtenerAutores() {
        return autorDAO.findAll();
    }

    public Autor obtenerAutorPorId(Long id) {
        return autorDAO.findById(id);
    }

    public void actualizarAutor(Long id, String nuevoNombre) {
        Autor autor = autorDAO.findById(id);
        if (autor != null) {
            autor.setNombre(nuevoNombre);
            autorDAO.update(autor);
        }
    }

    public void eliminarAutor(Long id) {
        Autor autor = autorDAO.findById(id);
        if (autor != null) {
            autorDAO.delete(autor);
        }
    }
}
