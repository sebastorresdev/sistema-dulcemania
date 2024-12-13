package com.api.dulcemaria.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ventas")
public class Pedido {
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Timestamp fecha;
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = true)
	private EstadoDocumento documento;
	@Column
	private BigDecimal total;
	@ManyToOne
	@JoinColumn(name = "id_direccion_cliente", nullable = true)
	private DireccionCliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_medio_pago", nullable = true)
	private MedioPago medioPago;
	@Column
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetallePedido> detallePedidos =new ArrayList<>();
	@Column
	private String numeroDocumento;
	@Column
	private boolean esActivo = true;


	@Column
	private String tipoDocumento;


	// Constructos
	public Pedido() {
		super();
	}

	// Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetallePedido> getDetallePedidos() {
		return detallePedidos;
	}

	public void setDetallePedidos(List<DetallePedido> detallePedidos) {
		this.detallePedidos = detallePedidos;
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

}
