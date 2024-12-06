package com.api.dulcemaria.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name="detalle_pedidos")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = true)
	private Pedido pedido;
	
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal descuento;
	private BigDecimal subtotal;
	private boolean esActivo = true;
	private Timestamp fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = true)
	private Producto producto;

	public DetallePedido() {
		super();
	}

	public DetallePedido(int id, Pedido pedido, int cantidad, BigDecimal precioUnitario, BigDecimal descuento, BigDecimal subtotal,
			boolean esActivo, Timestamp fechaRegistro, Producto producto) {
		super();
		this.id = id;
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
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
