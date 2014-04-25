package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import model.Contrasena;
import model.Estudiante;

/**
 * Session Bean implementation class B_Contrasena
 */
@Stateless
@LocalBean
public class B_Contrasena  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Contrasena ps;
	
    public B_Contrasena() {
    	emf = Persistence.createEntityManagerFactory("UCCART");
    	em = emf.createEntityManager();
		ps = new Contrasena();

    }

	 
	public boolean insert() {
		// TODO Auto-generated method stub
	try{
		em.getTransaction().begin();
	    em.persist(this.getContrasena());
	    em.getTransaction().commit();
	    em.close();
	    return true;    
	}catch(Exception e){
				
				System.out.println("No se puedo insertar contraseña");
	         return false;		
	}	
	}


	public boolean delete() {
		   try{
				em.getTransaction().begin();
			    
			    em.remove(this.getContrasena());
			    em.getTransaction().commit();
			    em.close();	
			    return true;
		      }catch(Exception e){
		    	  
		    	  System.out.println("No se pudo borrar");
		    	  return false;
		      }
		
	}

	 
	public boolean update(String pw, String id) {
	   try{
		em.getTransaction().begin();
	   ps.setContPw(pw);
	   ps.setEstudiante(ps.getEstudiante());
	   em.getTransaction().commit();
	   em.close();
	   return true;
	   }catch(Exception e){
		    
		   System.out.println("No se pudo encontrar");
	       return false;
	   }
	}

	 
	public boolean find(String cod) {
	  try{	em.getTransaction().begin();
		ps= em.find(Contrasena.class, cod);
     	return true;
	  }catch(Exception e){
		   System.out.println("No se pudo encontrar");
		   return false;
		  
	  }
	}

	

	 
	public void setContrasena(String pw, String id) {		
		em.getTransaction().begin(); 
		 ps.setContPw(pw);
		   ps.setEstudiante(em.find(Estudiante.class,id));
	
	}

	 
	public Contrasena getContrasena() {
		return this.ps;
	}

	

}
