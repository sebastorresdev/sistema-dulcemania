package com.api.dulcemaria.models;

import jakarta.persistence.*;

@Entity
@Table(name="estado_documentos")
public class EstadoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	public EstadoDocumento() {
		super();
	}

	public EstadoDocumento(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
