package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table (name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = true)
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_medio_pago", nullable = true)
	private MedioPago medioPago;
	
	private float subtotal;
	private float igv;
	private float total;
	private float tasaCambio;
	
	@ManyToOne
	@JoinColumn(name = "id_moneda", nullable = true)
	private Moneda moneda;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = true)
	private EstadoDocumento documento;
	
	private String urlDocumento;
	private Timestamp fecha;
	private boolean esActivo = true;
	private Timestamp fechaRegistro;
	private String observacion;
	
	public Compra() {
		super();
	}

	public Compra(int id, String tipoDocumento, String numeroDocumento, Proveedor proveedor, MedioPago medioPago,
                  float subtotal, float igv, float total, float tasaCambio, Moneda moneda, EstadoDocumento documento,
                  String urlDocumento, Timestamp fecha, boolean esActivo, Timestamp fechaRegistro, String observacion) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.proveedor = proveedor;
		this.medioPago = medioPago;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.tasaCambio = tasaCambio;
		this.moneda = moneda;
		this.documento = documento;
		this.urlDocumento = urlDocumento;
		this.fecha = fecha;
		this.esActivo = esActivo;
		this.fechaRegistro = fechaRegistro;
		this.observacion = observacion;
	}

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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

	public float getTasaCambio() {
		return tasaCambio;
	}

	public void setTasaCambio(float tasaCambio) {
		this.tasaCambio = tasaCambio;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public EstadoDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(EstadoDocumento documento) {
		this.documento = documento;
	}

	public String getUrlDocumento() {
		return urlDocumento;
	}

	public void setUrlDocumento(String urlDocumento) {
		this.urlDocumento = urlDocumento;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
