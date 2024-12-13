package com.api.dulcemaria.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="detalle_ventas")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", nullable = false)
	@JsonIgnore
	private Pedido pedido;
	
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;
	private boolean esActivo = true;

	private Timestamp fechaRegistro = Timestamp.valueOf(LocalDateTime.now());
	
	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = true)
	private Producto producto;

	public DetallePedido() {
		super();
	}

	public DetallePedido(Pedido pedido,
						int cantidad,
						BigDecimal precioUnitario,
						BigDecimal subtotal,
						Producto producto) {
		super();
		this.pedido = pedido;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
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
