package com.api.dulcemaria.models;

import jakarta.persistence.*;


@Entity
@Table(name="ubigeo")
public class Ubigeo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String departamento;
	private String provincia;
	private String distrito;
	
	public Ubigeo() {
		super();
	}

	public Ubigeo(String id, String departamento, String provincia, String distrito) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	
	

}

