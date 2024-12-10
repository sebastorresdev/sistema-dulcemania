package com.api.dulcemaria.services;

import com.api.dulcemaria.common.compras.CreateCompraRequest;
import com.api.dulcemaria.common.compras.DetailsCompras;
import com.api.dulcemaria.models.Compra;
import com.api.dulcemaria.models.DetalleCompra;
import com.api.dulcemaria.models.EstadoDocumento;
import com.api.dulcemaria.models.MedioPago;
import com.api.dulcemaria.models.Moneda;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.repositories.ICompraRepository;
import com.api.dulcemaria.repositories.IDetalleCompraRepository;
import com.api.dulcemaria.repositories.IEstadoDocumentoRepository;
import com.api.dulcemaria.repositories.IMedioPagoRepository;
import com.api.dulcemaria.repositories.IMonedaRepository;
import com.api.dulcemaria.repositories.IProductosRepository;
import com.api.dulcemaria.repositories.IProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class CompraService {
	@Autowired 
	ICompraRepository comre;
	
	@Autowired 
	IDetalleCompraRepository detalleCompraRepository;
	
	@Autowired 
	IProveedorRepository proveedorRepository;
	
	@Autowired 
	IMedioPagoRepository medioPagoRepository;
	
	@Autowired 
	IMonedaRepository monedaRepository;
	
	@Autowired 
	IEstadoDocumentoRepository estadoDocumentoRepository;
	
	@Autowired 
	IProductosRepository productosRepository;
	
	
	public List<Compra> listarcompras(){
		return (List<Compra>)comre.findAll();
	}
	
	public Compra guardarcompra (CreateCompraRequest c) {
		
		Proveedor proveedor = proveedorRepository.findById(c.idProveedor())
				.orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + c.idProveedor()));
		
		MedioPago medioPago = medioPagoRepository.findById(c.idPago())
				.orElseThrow(() -> new RuntimeException("Medio pago no encontrada con ID: " + c.idPago()));
		
		Moneda moneda = monedaRepository.findById(c.idMoneda())
				.orElseThrow(() -> new RuntimeException("Moneda no encontrada con ID: " + c.idMoneda()));
		
		EstadoDocumento documento = estadoDocumentoRepository.findById(c.idEstadoDocumento())
				.orElseThrow(() -> new RuntimeException("Estado documento no encontrada con ID: " + c.idEstadoDocumento()));
		
		
		
		Compra compra = new Compra();
		compra.setTipoDocumento(c.tipoDocumento());
		compra.setNumeroDocumento(c.numeroDocumento());
		compra.setProveedor(proveedor);
		compra.setMedioPago(medioPago);
		compra.setSubtotal(c.subtotal());
		compra.setIgv(c.igv());
		compra.setTotal(c.total());
		compra.setTasaCambio(c.tasaCambio());
		compra.setMoneda(moneda);
		compra.setDocumento(documento);
		compra.setUrlDocumento(c.urlDocumento());
		compra.setFecha(c.fecha());
		compra.setEsActivo(c.esActivo());
		compra.setObservacion(c.observacion());
		
		return comre.save(compra);
	}
	
	public Compra guardarCompraYDetalles(CreateCompraRequest c) {
		Compra compra = this.guardarcompra(c);
		if (compra == null ) return null;
		List<DetalleCompra> detalleCompras = new ArrayList<>();
	
		
		for (DetailsCompras dc : c.detailsCompras()) {
			DetalleCompra detalleCompra = new DetalleCompra();
			
			Producto  producto = productosRepository.findById(dc.idProducto())
					.orElseThrow(() -> new RuntimeException("Estado documento no encontrada con ID: " + dc.idProducto()));
			
			
			
			detalleCompra.setCompra(compra);
			detalleCompra.setProducto(producto);
			detalleCompra.setCantidad(dc.cantidad());
			detalleCompra.setPrecioUnitario(dc.precioUnitario());
			detalleCompra.setDescuento(dc.descuento());
			
			detalleCompra.setFechaRegistro(dc.fechaRegistro());
			
			BigDecimal subTotal = dc.precioUnitario().multiply(new BigDecimal(dc.cantidad())).subtract(dc.descuento());
			detalleCompra.setSubtotal(subTotal);
			
			detalleCompras.add(detalleCompra);
			
			
		}
		detalleCompraRepository.saveAll(detalleCompras);
		return compra;
	}
}


	/*public Optional<Compra> tipoDocumento(String tipoDocumento){
		return comre.findBytipoDocumento(tipoDocumento);
	}
	
	public Compra guardarcompra(Compra c) {
		Optional<Compra> reg=comre.findById(c.getId());
		if (!reg.isPresent()) 
			return comre.save(c);
		else
			return null;
		
	}
	
	public boolean eliminarcompra(Integer id) {
		Optional<Compra> reg=comre.findById(id);
		if (reg.isPresent()) {
			reg.ifPresent(p -> p.setEsActivo(false));
			comre.save(reg.get());
			
			return true;
		}
		else
			return false;
	}*/
		

