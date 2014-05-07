package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import model.DetalleFacturaEntrada;

/**
 * Session Bean implementation class B_DetalleFacturaEntrada
 */
@Stateless
@SuppressWarnings("all")
public class B_DetalleFacturaEntrada {
	private EntityManagerFactory emf;
	private EntityManager em;
	private DetalleFacturaEntrada detalleFacturaEntrada;

	public B_DetalleFacturaEntrada() {

		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		detalleFacturaEntrada = new DetalleFacturaEntrada();
	}

	public boolean insert() {
		// TODO Auto-generated method stub
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(detalleFacturaEntrada);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception ex){

			System.out.println("No se puedo insertar detalleFacturaEntrada");
			return false;	
		}	

	}

	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from detalles_de_factura_entrada where detfac_entrada_id_detalle_factura ilike '"+cod+"';", DetalleFacturaEntrada.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	
	public List<DetalleFacturaEntrada> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<DetalleFacturaEntrada> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from detalles_de_factura_entrada where detfac_entrada_id_detalle_factura similar to '["+rango+"]%'", DetalleFacturaEntrada.class);
		}else{
			q =em.createNativeQuery("select * from detalles_de_factura_entrada", DetalleFacturaEntrada.class);
		}
		return q.getResultList();
	}

	public List<DetalleFacturaEntrada> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from detalles_de_factura_entrada", DetalleFacturaEntrada.class);

		List<DetalleFacturaEntrada> results = q.getResultList();

		return results;
	}



	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			detalleFacturaEntrada = em.find(DetalleFacturaEntrada.class, detalleFacturaEntrada.getId_detalle_factura());
			em.remove(detalleFacturaEntrada);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo eliminar");
			return false;
		}
	}



	public boolean find(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		detalleFacturaEntrada = em.find(DetalleFacturaEntrada.class,id);
		if(detalleFacturaEntrada == null){
			System.out.println("No se pudo encontrar detalleFacturaEntrada");
			return false;

		}else{return true;}

	}


	public boolean update(String id_detalle_factura, String id_facturaEntrada, String id_Arancel, String descripcion,
			Integer numero_linea, Float precio_unitario, String descripcion_descuento, Float total_bruto, Float subtotal,
			Integer cantidad) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
			detalleFacturaEntrada = em.merge(detalleFacturaEntrada);
			detalleFacturaEntrada.setId_detalle_factura(id_detalle_factura);
			detalleFacturaEntrada.setId_facturaEntrada(id_facturaEntrada);
			detalleFacturaEntrada.setIdArancel(id_Arancel);
			detalleFacturaEntrada.setDescripcion(descripcion);
			detalleFacturaEntrada.setNumeroLinea(numero_linea);
			detalleFacturaEntrada.setPrecioUnitario(precio_unitario);
			detalleFacturaEntrada.setDescripcionDescuento(descripcion_descuento);
			detalleFacturaEntrada.setTotalBruto(total_bruto);
			detalleFacturaEntrada.setSubTotal(subtotal);
			detalleFacturaEntrada.setCantidad(cantidad);
			
			
			
			em.getTransaction().commit();
			em.refresh(detalleFacturaEntrada);
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo modificar detalleFacturaEntrada");
			return false;
		}
	}

	public void setDetalleFacturaEntrada(String id_detalle_factura, String id_facturaEntrada, String id_Arancel, String descripcion,
			Integer numero_linea, Float precio_unitario, String descripcion_descuento, Float total_bruto, Float subtotal,
			Integer cantidad){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//detalleFacturaEntrada.setContrasena(e.getContrasena());
		detalleFacturaEntrada = em.merge(detalleFacturaEntrada);
		detalleFacturaEntrada.setId_detalle_factura(id_detalle_factura);
		detalleFacturaEntrada.setId_facturaEntrada(id_facturaEntrada);
		detalleFacturaEntrada.setIdArancel(id_Arancel);
		detalleFacturaEntrada.setDescripcion(descripcion);
		detalleFacturaEntrada.setNumeroLinea(numero_linea);
		detalleFacturaEntrada.setPrecioUnitario(precio_unitario);
		detalleFacturaEntrada.setDescripcionDescuento(descripcion_descuento);
		detalleFacturaEntrada.setTotalBruto(total_bruto);
		detalleFacturaEntrada.setSubTotal(subtotal);
		detalleFacturaEntrada.setCantidad(cantidad);
		em.getTransaction().commit();
		em.close();

	}

	public DetalleFacturaEntrada getDetalleFacturaEntrada(){
		return detalleFacturaEntrada;

	}



}
