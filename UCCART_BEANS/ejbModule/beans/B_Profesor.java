package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Curso;
import model.Estudiante;
import model.Profesor;

/**
 * Session Bean implementation class B_Profesor
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Profesor  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Profesor profesor;

	public B_Profesor(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		profesor = new Profesor();
	}


	public boolean insert() {
		//		// TODO Auto-generated method stub
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(profesor);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo insertar Profesor ");
			return false;		
		}

	}

	public boolean find(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			profesor = em.find(Profesor.class, cod);
			if(profesor == null){

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
			profesor = em.find(Profesor.class, profesor.getProfId());
			em.remove(profesor);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo borrar");
			return false;	
		}	
	}


	public boolean update(String nombre,String apellido1,String apellido2, String gradoacademico,int telefono, String  correo) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			profesor = em.merge(profesor);
			profesor.setProfApellido1(apellido1);
			profesor.setProfApellido2(apellido2);
			profesor.setProfGradoacademico(gradoacademico);
			profesor.setProfCorreo(correo);
			profesor.setProfNombre(nombre);
			profesor.setProfTelefono(telefono);
			em.getTransaction().commit();
			em.refresh(profesor);
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo modificar");
			return false;	
		}

	}

	public void setProfesor(String id, String nombre,String apellido1,String apellido2, String gradoacademico,int telefono, String  correo){

		profesor.setProfApellido1(apellido1);
		profesor.setProfApellido2(apellido2);
		profesor.setProfGradoacademico(gradoacademico);
		profesor.setProfCorreo(correo);
		profesor.setProfId(id);
		profesor.setProfNombre(nombre);
		profesor.setProfTelefono(telefono);


	}

	public List<Profesor> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("SELECT * FROM Profesor ORDER BY prof_apellido1, prof_apellido2", Profesor.class);

		List<Profesor> results = q.getResultList();

		return results;
	}

	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Profesor where prof_id ilike '"+cod+"';", Profesor.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public Profesor getProfesor() {

		return profesor;
	}
	
	public List<Curso> getCursosXperiodo(String cod, String per) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q =em.createNativeQuery("SELECT * FROM Curso WHERE curso_codprofesor = '"+cod+"'and curso_periodo = '"+per+"';", Curso.class);
		List<Curso> results = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return results;
	}

	public List<Profesor> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<Estudiante> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from Profesor where prof_apellido1 similar to '["+rango+"]%'", Profesor.class);
		}else{
			q =em.createNativeQuery("select * from Profesor", Profesor.class);
		}
		return q.getResultList();
	}
	
	
	public List<Curso> getCursos(String cod) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		profesor = em.find(Profesor.class, cod);
		em.refresh(profesor);
		em.getTransaction().commit();
		em.close();
		return profesor.getCursos();
	}

}
