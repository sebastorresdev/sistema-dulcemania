package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Timestamp fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = true)
	private EstadoDocumento documento;
	
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "id_direccion_cliente", nullable = true)
	private DireccionCliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_medio_pago", nullable = true)
	private MedioPago medioPago;
	
	private String observacion;

	public Pedido() {
		super();
	}

	public Pedido(int id, Timestamp fecha, EstadoDocumento documento, BigDecimal total, DireccionCliente cliente,
				  MedioPago medioPago, String observacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.documento = documento;
		this.total = total;
		this.cliente = cliente;
		this.medioPago = medioPago;
		this.observacion = observacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public EstadoDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(EstadoDocumento documento) {
		this.documento = documento;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public DireccionCliente getCliente() {
		return cliente;
	}

	public void setCliente(DireccionCliente cliente) {
		this.cliente = cliente;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	

}
