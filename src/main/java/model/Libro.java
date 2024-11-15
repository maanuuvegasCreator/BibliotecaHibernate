package model;

import javax.persistence.*;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private int añoPublicacion;
	private String estado;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	// Constructor con parámetros
	public Libro(String titulo, int añoPublicacion, String estado, Autor autor) {
		this.titulo = titulo;
		this.añoPublicacion = añoPublicacion;
		this.estado = estado;
		this.autor = autor;
	}

	// Constructor sin parámetros necesario para Hibernate
	public Libro() {
		// Este constructor está vacío, pero es necesario para que Hibernate lo utilice
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
