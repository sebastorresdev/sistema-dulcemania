package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "clientes")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String tipoDocumento;
	@Column
	private String numeroDocumento;
	@Column
	private String razonSocialNombre;
	@Column
	private String contacto;
	@Column
	private String telefono;
	@Column
	private String paginaWeb;
	@Column
	private String correo;
	@Column 
	private boolean esActivo = true;
	@Column
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DireccionCliente> direccionClientes = new ArrayList<>();


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getRazonSocialNombre() {
		return razonSocialNombre;
	}
	public void setRazonSocialNombre(String razonSocialNombre) {
		this.razonSocialNombre = razonSocialNombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isEsActivo() {
		return esActivo;
	}
	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}
	public List<DireccionCliente> getDireccionClientes() {
		return direccionClientes;
	}

	public void setDireccionClientes(List<DireccionCliente> direccionClientes) {
		this.direccionClientes = direccionClientes;
	}
	

}
