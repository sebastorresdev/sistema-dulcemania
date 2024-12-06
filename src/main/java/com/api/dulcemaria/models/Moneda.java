package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name="monedas")
public class Moneda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private String nombre;
	private String simbolo;
	private boolean esActivo = true;
	private Timestamp fechaRegistro;
	
	public Moneda() {
		super();
	}

	public Moneda(int id, String codigo, String nombre, String simbolo, boolean esActivo, Timestamp fechaRegistro) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.esActivo = esActivo;
		this.fechaRegistro = fechaRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
}
