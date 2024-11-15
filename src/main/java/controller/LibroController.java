package controller;

import dao.LibroDAO;
import model.Autor;
import model.Libro;

import java.util.List;

public class LibroController {
    private LibroDAO libroDAO;

    public LibroController() {
        libroDAO = new LibroDAO();
    }

    public void agregarLibro(String titulo, int añoPublicacion, String estado, Autor autor) {
        Libro libro = new Libro(titulo, añoPublicacion, estado, autor);
        libroDAO.save(libro);
    }

    public List<Libro> obtenerLibros() {
        return libroDAO.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return libroDAO.findById(id);
    }

    public void actualizarLibro(Long id, String titulo, int añoPublicacion, String estado) {
        Libro libro = libroDAO.findById(id);
        if (libro != null) {
            libro.setTitulo(titulo);
            libro.setAñoPublicacion(añoPublicacion);
            libro.setEstado(estado);
            libroDAO.update(libro);
        }
    }

    public void eliminarLibro(Long id) {
        Libro libro = libroDAO.findById(id);
        if (libro != null) {
            libroDAO.delete(libro);
        }
    }
}
