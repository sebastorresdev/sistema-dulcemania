package com.api.dulcemaria.models;



import jakarta.persistence.Column;

import java.sql.Timestamp;


import jakarta.persistence.*;


@Entity
@Table(name = "medio_pagos")
public class MedioPago {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String descripcion;
	@Column
	private boolean esActivo = true;
	@Column
	private Timestamp fechaRegistro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getEsActivo() {
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

