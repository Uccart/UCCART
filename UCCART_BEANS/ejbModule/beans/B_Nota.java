package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Curso;
import model.Estudiante;
import model.Nota;
import model.NotaPK;

/**
 * Session Bean implementation class Nota
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Nota {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Nota nota;
	
    public B_Nota() {
    	emf = Persistence.createEntityManagerFactory("UCCART");
    	em = emf.createEntityManager();
		nota = new Nota();
    }

	
	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
		    em.persist(nota);
		    em.getTransaction().commit();
		    em.close();
		     return true;    
		}catch(Exception e){
					
					System.out.println("No se puedo insertar Nota");
			        return false;
		    }	
		
	}
	
	public boolean find(NotaPK pk){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
		    nota = em.find(Nota.class, pk);
		    em.getTransaction().commit();
		    em.close();
		    if(nota == null){
		    	 System.out.println("No se pudo encontrar");
		    	return false;
		    	
		    }else{return true;}
	      }catch(Exception e){
	    	  System.out.println("No se pudo encontrar");
	    	  return false;
	      }
		
		
	}

	
	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
		    em.remove(em.merge(nota));
		    em.getTransaction().commit();
		    em.close();
		    return true;
	      }catch(Exception e){
	    	  System.out.println("No se pudo borrar");
	    	  return false;
	      }
		
	}

	
	public Nota getNota() {
		
	    return nota; 
	}
	public Curso getCurso(){
		return nota.getCurso();
	}

	
	public boolean update(String codestudiante, String codcurso,int promedio,int condicion) {
	try{
		em = emf.createEntityManager();
		em.getTransaction().begin();
		NotaPK n = new NotaPK();
		n.setNotaCodcurso(codcurso);
		n.setNotaCodestudiante(codestudiante);
		nota = em.find(Nota.class, n);
	    nota.setNotaCondicion(condicion);
	    nota.setNotaPromedio(promedio);
		em.getTransaction().commit();
		em.close();
	    return true;
	
	   }catch(Exception e){
		   System.out.println("No se pudo modificar");
		   return false;}
	
	}
	
	
	
	public void setNota(String codestudiante, String codcurso,int promedio,int condicion){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		/*nota.setCurso(em.find(Curso.class, codcurso));
	    nota.setEstudiante(em.find(Estudiante.class, codestudiante));*/
	    NotaPK n = new NotaPK();
		n.setNotaCodcurso(codcurso);
		n.setNotaCodestudiante(codestudiante);
	    nota.setId(n);
	    nota.setNotaCondicion(condicion);
	    nota.setNotaPromedio(promedio);
	}
	
}
