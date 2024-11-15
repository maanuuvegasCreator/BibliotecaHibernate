package view;

import controller.AutorController;
import controller.LibroController;
import model.Autor;
import model.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AutorLibroView {
    private JFrame frame;
    private AutorController autorController;
    private LibroController libroController;
    private JTextArea textArea;

    public AutorLibroView() {
        autorController = new AutorController();
        libroController = new LibroController();
        frame = new JFrame("Gestión de Autores y Libros");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton btnMostrarAutores = new JButton("Mostrar Autores");
        btnMostrarAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAutores();
            }
        });

        JButton btnMostrarLibros = new JButton("Mostrar Libros");
        btnMostrarLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLibros();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(btnMostrarAutores);
        panel.add(btnMostrarLibros);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void mostrarAutores() {
        List<Autor> autores = autorController.obtenerAutores();
        textArea.setText("Autores:\n");
        for (Autor autor : autores) {
            textArea.append(autor.getNombre() + "\n");
        }
    }

    private void mostrarLibros() {
        List<Libro> libros = libroController.obtenerLibros();
        textArea.setText("Libros:\n");
        for (Libro libro : libros) {
            textArea.append(libro.getTitulo() + " - " + libro.getAutor().getNombre() + "\n");
        }
    }
}
