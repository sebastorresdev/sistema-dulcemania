package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = true)
	private Pedido pedido;
	
	private String tipoDocumento;
	private String numeroDocumento;
	
	@ManyToOne
	@JoinColumn(name = "id_medio_pago", nullable = true)
	private MedioPago medioPago;
	
	private float subtotal;
	private float igv;
	private float total;
	
	@ManyToOne
	@JoinColumn(name = "id_moneda", nullable = true)
	private Moneda  moneda;
	
	private float tasaCambio;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = true)
	private EstadoDocumento  documento;
	
	private Timestamp fecha;
	private boolean esActivo = true;
	private Timestamp fechaRegistro;
	
	public Venta() {
		super();
	}

	public Venta(int id, Pedido pedido, String tipoDocumento, String numeroDocumento, MedioPago medioPago,
			float subtotal, float igv, float total, Moneda moneda, float tasaCambio, EstadoDocumento documento,
			Timestamp fecha, boolean esActivo, Timestamp fechaRegistro) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.medioPago = medioPago;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.moneda = moneda;
		this.tasaCambio = tasaCambio;
		this.documento = documento;
		this.fecha = fecha;
		this.esActivo = esActivo;
		this.fechaRegistro = fechaRegistro;
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

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getIgv() {
		return igv;
	}

	public void setIgv(float igv) {
		this.igv = igv;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public float getTasaCambio() {
		return tasaCambio;
	}

	public void setTasaCambio(float tasaCambio) {
		this.tasaCambio = tasaCambio;
	}

	public EstadoDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(EstadoDocumento documento) {
		this.documento = documento;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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
