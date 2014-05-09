
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.FacturaEntrada;
import model.Estudiante;
/**
 * Session Bean implementation class B_Arancel
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_FacturaEntrada  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private FacturaEntrada facturaEntrada;

	public B_FacturaEntrada(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		facturaEntrada = new FacturaEntrada();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getFacturaEntrada());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar arancel");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(FacturaEntrada.class, facturaEntrada.getFacturas_entrada_id()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String empleado, String estudiante, String nombre, String direccion, String telefono, String metodopago,
			Float total) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			facturaEntrada = em.merge(facturaEntrada);
			facturaEntrada.setFacturas_entrada_id(id);
			facturaEntrada.setFacturas_entrada_id_empleado(empleado);
			facturaEntrada.setFacturas_entrada_id_estudiante(estudiante);
			facturaEntrada.setFacturas_entrada_nombre(nombre);
			facturaEntrada.setFacturas_entrada_direccion(direccion);
			facturaEntrada.setFacturas_entrada_telefono(telefono);
			facturaEntrada.setFacturas_entrada_metodo_de_pago(metodopago);
			facturaEntrada.setfacturas_entrada_total(total);
			
			em.getTransaction().commit();
			em.refresh(facturaEntrada);
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;
		}
	}


	public boolean find(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			facturaEntrada = em.find(FacturaEntrada.class,cod);

			if(facturaEntrada == null){
				System.out.println("No se pudo borrar");
				return false;

			}else{return true;}    
		}catch(Exception e){System.out.println("No se pudo borrar");
		return false;
		}
	}	

	
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from aranceles where facturas_entrada_id ilike '"+cod+"';", FacturaEntrada.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setFactura(String id, String empleado, String estudiante, String nombre, String direccion, String telefono, String metodopago,
			Float total) {
		facturaEntrada.setFacturas_entrada_id(id);
		facturaEntrada.setFacturas_entrada_id_empleado(empleado);
		facturaEntrada.setFacturas_entrada_id_estudiante(estudiante);
		facturaEntrada.setFacturas_entrada_nombre(nombre);
		facturaEntrada.setFacturas_entrada_direccion(direccion);
		facturaEntrada.setFacturas_entrada_telefono(telefono);
		facturaEntrada.setFacturas_entrada_metodo_de_pago(metodopago);
		facturaEntrada.setfacturas_entrada_total(total);
	}
	
	public void setFactura(FacturaEntrada factura){
		facturaEntrada = factura;
	}


	public FacturaEntrada getFacturaEntrada() {

		return  this.facturaEntrada;
	}
	
	public List<FacturaEntrada> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from facturas_entrada", FacturaEntrada.class);

		
		List<FacturaEntrada> results = q.getResultList();
		
		return results;
	}
	
	
	public List<FacturaEntrada> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<FacturaEntrada> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from facturas_entrada where reciboEntrada_descripcion similar to '["+rango+"]%'", FacturaEntrada.class);
		}else{
			q =em.createNativeQuery("select * from facturas_entrada", FacturaEntrada.class);
		}
		return q.getResultList();
	}
	
	

}
