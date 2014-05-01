
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.MetodoDePago;
/**
 * Session Bean implementation class B_MetodoDePago
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_MetodoDePago  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private MetodoDePago metodo;

	public B_MetodoDePago(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		metodo = new MetodoDePago();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getMetodoDePago());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar metodo de pago");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(MetodoDePago.class, metodo.getId()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String metodo, String descripcion) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			this.metodo = em.merge(this.metodo);
			//metodo.setId(id);
			this.metodo.setMetodo(metodo);
			this.metodo.setDescripcion(descripcion);
			
			em.getTransaction().commit();
			em.refresh(metodo);
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
			metodo = em.find(MetodoDePago.class,cod);

			if(metodo == null){
				System.out.println("No se pudo encontrar");
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
			Query q =em.createNativeQuery("select * from metodos_de_pago where mdp_id ilike '"+cod+"';", MetodoDePago.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setMetodoDePago(String id, String metodo, String descripcion) {
		this.metodo.setId(id);
		this.metodo.setMetodo(metodo);
		this.metodo.setDescripcion(descripcion);
	}


	public MetodoDePago getMetodoDePago() {

		return  this.metodo;
	}
	
	public List<MetodoDePago> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from metodos_de_pago", MetodoDePago.class);

		
		List<MetodoDePago> results = q.getResultList();
		
		return results;
	}
	
	
	public List<MetodoDePago> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<MetodoDePago> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from metodos_de_pago where nombre similar to '["+rango+"]%'", MetodoDePago.class);
		}else{
			q =em.createNativeQuery("select * from metodos_de_pago", MetodoDePago.class);
		}
		return q.getResultList();
	}
	
	

}
