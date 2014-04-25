package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import model.Carrera;
import model.Materia;
import model.Requisito;

/**
 * Session Bean implementation class B_Requisito
 */
@Stateless
@LocalBean
public class B_Requisito  {

    private Requisito req;
    private EntityManagerFactory emf;
	private EntityManager em;
	
    public B_Requisito() {
    	emf = Persistence.createEntityManagerFactory("UCCART");
    	em = emf.createEntityManager();
    	req = new Requisito();
    }

    public boolean find(int cod) {
    	try{	   
    		  em.getTransaction().begin();
    		    req = em.find(Requisito.class, cod); 
    		    
    		    if(req ==null){
    		    
    		    System.out.println("No se pudo encontrar");
    		    
    		    return false;
    		    }else{return true;}
    		    
    	  }catch(Exception e){
      	  
      	  System.out.println("No se pudo encontrar");
      	  return false;
          }
    	}
	public boolean insert() {
		try{
			em.getTransaction().begin();
		    em.persist(req);
		    em.getTransaction().commit();
		    em.close();
		    return true;    
		}catch(Exception e){
					
					System.out.println("No se puedo insertar Requisito ");
		            return false;	
		}
		
	}

	
	public boolean delete() {
		try{
			em.getTransaction().begin();
			
		    em.remove(req);
		    em.getTransaction().commit();
		    em.close();
		    return true;    
		}catch(Exception e){
			System.out.println("No se pudo borrar");
		    return true;	
		}	
		
	}

	
	public boolean update(int cod ,String requisito, String materia, String carrera,boolean tipo) {
		try{
			em.getTransaction().begin();
		
			req.setMateria1(em.find(Materia.class, requisito));
			req.setMateria2(em.find(Materia.class, materia));
			req.setCarrera(em.find(Carrera.class, carrera));
			req.setReqCod(cod);
			req.setReqTipo(tipo);
			em.getTransaction().commit();
			em.close();
		    return true;    
			}catch(Exception e){
				System.out.println("No se pudo borrar");
			    return true;	
			}	
	}
	
	public void setRequisito(int cod ,String requisito, String materia, String carrera,boolean tipo){
		req.setMateria1(em.find(Materia.class, requisito));
		req.setMateria2(em.find(Materia.class, materia));
		req.setCarrera(em.find(Carrera.class, carrera));
		req.setReqCod(cod);
		req.setReqTipo(tipo);
		
	}

	
	public Requisito getRequisito(int cod) {
		em.getTransaction().begin();
		req = em.find(Requisito.class, cod);
		
		return req;
	}

}
