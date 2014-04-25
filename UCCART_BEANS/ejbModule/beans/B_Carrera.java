package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;


import model.Carrera;
import model.Curso;
import model.Materia;
import model.Plan;
/**
 * Session Bean implementation class B_Carrera
 */
@Stateless
@SuppressWarnings("all")
public class B_Carrera{

	/**
	 * Default constructor. 
	 */
	private EntityManagerFactory emf;
	private EntityManager em;
	private Carrera carrera;

	public B_Carrera() {

		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		carrera= new Carrera();
	}


	public boolean insert() {
		// TODO Auto-generated method stub
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getCarrera());
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo insertar Carrera");
			return false;
		}	

	}


	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			carrera = em.find(Carrera.class, carrera.getCarrCod());
			em.remove(carrera);
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){
			System.out.println("No se pudo borrar");
			return false;
		}

	}


	public boolean update(String cod, String n) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			carrera.setCarrCod(cod);
			carrera.setCarrNombre(n);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;
		}
	}


	public boolean find(String cod) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			carrera = em.find(Carrera.class,cod);
			return true;
		}catch(Exception e){
			System.out.println("No se pudo encontrar");
			return false;
		} 

	}
	
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Carrera where carr_cod ilike '"+cod+"';", Carrera.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}

	public List<Plan> getPlan(String cod) {
		return carrera.getPlans();
	}


	public void setCarrera(String cod, String n, int credmax) {
		carrera.setCarrCod(cod);
		carrera.setCarrNombre(n);
		carrera.setCarrCredmax(credmax);

	}
	public List<Carrera> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Carrera", Carrera.class);
        
		List<Carrera> results = q.getResultList();
        
        return results;
	}

	public Carrera getCarrera() {
		// TODO Auto-generated method stub
		return this.carrera;
	}


}
