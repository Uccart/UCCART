
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Inventario;

/**
 * Session Bean implementation class B_Inventario
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Inventario {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Inventario inventario;

	public B_Inventario(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		inventario = new Inventario();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getInventario());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar al inventario");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Inventario.class, inventario.getInventariolId()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String nom, String marca, String modelo, float valor, Integer cantidad, String provee ) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			inventario = em.merge(inventario);
			
			inventario.setInventarioId(id);
			inventario.setInventarioNombre(nom);
			inventario.setInventarioMarca(marca);
			inventario.setInventarioModelo(modelo);
			inventario.setInventarioValor(valor);
			inventario.setInventarioCantidad(cantidad);
			inventario.setInventarioProveedor(provee);
			
			em.getTransaction().commit();
			em.refresh(inventario);
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
			inventario = em.find(Inventario.class,cod);

			if(inventario == null){
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
			Query q =em.createNativeQuery("select * from inventario where inventario_id ilike '"+cod+"';", Inventario.class);
			System.out.println(q.getResultList().size());
			System.out.println("hola");
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setInventario(String id, String nom, String marca, String modelo, float valor, Integer cantidad, String provee) {
		inventario.setInventarioId(id);
		inventario.setInventarioNombre(nom);
		inventario.setInventarioMarca(marca);
		inventario.setInventarioModelo(modelo);
		inventario.setInventarioValor(valor);
		inventario.setInventarioCantidad(cantidad);
		inventario.setInventarioProveedor(provee);
	}


	public Inventario getInventario() {

		return  this.inventario;
	}
	
	public List<Inventario> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from inventario", Inventario.class);

		
		List<Inventario> results = q.getResultList();
		
		return results;
	}
	
	
	public List<Inventario> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<Inventario> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from inventario where inventario_nombre similar to '["+rango+"]%'", Inventario.class);
		}else{
			q =em.createNativeQuery("select * from inventario", Inventario.class);
		}
		return q.getResultList();
	}
	
	

}
