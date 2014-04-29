package beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Carrera;
import model.Curso;
import model.Materia;

/**
 * Session Bean implementation class B_Materia
 */
@Stateless
@SuppressWarnings("all")
public class B_Materia  {

	/**
	 * Default constructor. 
	 */
	private EntityManagerFactory emf;
	private EntityManager em;
	private Materia materia;

	public B_Materia(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		materia = new Materia();
	}



	public boolean find(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			materia = em.find(Materia.class, cod);
			if(materia == null){
				System.out.print("No se pudo encontrar ");
				return false;

			}else{return true;

			}

		}catch(Exception e){
			System.out.print("No se pudo encontrar ");
			return false;
		}


	}
	public boolean insert() {

		// TODO Auto-generated method stub
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(materia);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo Materia ");
			return false;	
		}	
	}
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Materia where materia_id ilike '"+cod+"';", Materia.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}



	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(materia));
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo borrar"+e);	
			return false;
		}
	}
	


	public boolean update(String id,String nombre,int lab, int creditos,String area) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			materia = em.merge(materia);
			materia.setMateriaArea(area);
			materia.setMateriaCreditos(creditos);
			materia.setMateriaLab(lab);
			materia.setMateriaId(id);
			materia.setMateriaNombre(nombre);
			
			em.getTransaction().commit();
			em.refresh(materia);
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;
		}
	}
	
	
	public void setMateria(String id,String nombre,int lab, int creditos,String area){
		materia.setMateriaArea(area);
		materia.setMateriaCreditos(creditos);
		materia.setMateriaLab(lab);
		materia.setMateriaId(id);
		materia.setMateriaNombre(nombre);
	}

	public List<Materia> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Materia", Materia.class);

		List<Materia> results = q.getResultList();

		return results;
	}

	public Materia getMateria() { 
		return materia;
	}


	public List<Curso> getCursos(String cod) {
		if(this.find(cod))
			return this.getMateria().getCursos();
		else
			return null;
	}


}
