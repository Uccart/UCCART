package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Curso;
import model.Materia;
import model.Usuario;

import model.Periodo;

/**
 * Session Bean implementation class B_Periodo
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Periodo  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Periodo periodo;
	public B_Periodo() {
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		periodo = new Periodo();
	}


	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
		
			em.persist(em.merge(periodo));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo Periodo ");
			return false;	
		}	

	}

	public boolean find(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			periodo = em.find(Periodo.class, cod);
			em.close();
			if(periodo == null){

				System.out.println("No se pudo encontrar");
				return false;

			}else{
				return true;
			}

		}catch(Exception e){
			System.out.println("No se pudo encontrar");
			return false;
		}
	}
	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();

			em.remove(em.merge(periodo));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo borrar");
			return false;
		}	

	}


	public boolean update(String per,Date web,Date local) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			periodo = em.merge(periodo);
			periodo.setPerLocal(local);
			periodo.setPerWeb(web);
			em.getTransaction().commit();
			em.refresh(periodo);
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo modificar");
			return false;
		}	
	}

	public void setPeriodo(String per,Date web,Date local){

		periodo.setPerPeriodo(per);
		periodo.setPerLocal(local);
		periodo.setPerWeb(web);

	}
	
	public Periodo ultimoPeriodo(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("SELECT * FROM PERIODO ORDER BY PER_WEB DESC LIMIT 1;", Periodo.class);

		return  (Periodo)q.getResultList().get(0);
	}
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Periodo where per_periodo ilike '"+cod+"';", Periodo.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}
	
	public Date getFechaServidor(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("SELECT current_timestamp;");
		return (Date)q.getResultList().get(0);
	}


	public List<Periodo> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Periodo", Periodo.class);

		List<Periodo> results = q.getResultList();

		return results;
	}
/*	
	public boolean  validaPeriodo(){
		
		List<Periodo> periodos = this.selectAll();
		for(Periodo per : periodos){
			
			
		}
		
	}
	*/

	public Periodo getPeriodo() {
		return periodo;
	}


	public List<Curso> getCursos(String cod) {
		em = emf.createEntityManager();
		periodo = em.find(Periodo.class, cod);
		em.refresh(periodo);
		for(int i = 0; i < periodo.getCursos().size(); i++){
			em.refresh(periodo.getCursos().get(i));
		}
		return this.getPeriodo().getCursos();
	}

}
