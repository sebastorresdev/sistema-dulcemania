package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="detalle_compras")
public class DetalleCompra {
	@Id
	 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_compra", nullable = true)
	private Compra compra;
	
	private int cantidad;
	private float precioUnitario;
	private float descuento;
	private float subtotal;
	private boolean esActivo;
	private Timestamp fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = true)
	private Producto producto;

	public DetalleCompra() {
		super();
	}

	public DetalleCompra(int id, Compra compra, int cantidad, float precioUnitario, float descuento, float subtotal,
                         boolean esActivo, Timestamp fechaRegistro, Producto producto) {
		super();
		this.id = id;
		this.compra = compra;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
		this.subtotal = subtotal;
		this.esActivo = esActivo;
		this.fechaRegistro = fechaRegistro;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	

}
