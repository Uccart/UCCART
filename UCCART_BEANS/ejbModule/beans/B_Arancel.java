
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Arancel;
import model.Estudiante;
/**
 * Session Bean implementation class B_Arancel
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Arancel  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Arancel arancel;

	public B_Arancel(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		arancel = new Arancel();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getArancel());
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
			em.remove(em.find(Arancel.class, arancel.getArancelId()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String desc, String tipo, float precio) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			arancel = em.merge(arancel);
			//arancel.setArancelId(id);
			arancel.setArancelDescripcion(desc);
			arancel.setArancelTipo(tipo);
			arancel.setArancelPrecio(precio);
			
			em.getTransaction().commit();
			em.refresh(arancel);
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
			arancel = em.find(Arancel.class,cod);

			if(arancel == null){
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
			Query q =em.createNativeQuery("select * from aranceles where aranceles_id ilike '"+cod+"';", Arancel.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setArancel(String id, String desc, String tipo, float precio) {
		arancel.setArancelId(id);
		arancel.setArancelDescripcion(desc);
		arancel.setArancelTipo(tipo);
		arancel.setArancelPrecio(precio);
	}


	public Arancel getArancel() {

		return  this.arancel;
	}
	
	public List<Arancel> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from aranceles", Arancel.class);

		
		List<Arancel> results = q.getResultList();
		
		return results;
	}
	
	
	public List<Arancel> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<Arancel> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from aranceles where aranceles_descripcion similar to '["+rango+"]%'", Arancel.class);
		}else{
			q =em.createNativeQuery("select * from aranceles", Arancel.class);
		}
		return q.getResultList();
	}
	
	

}
