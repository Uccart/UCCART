package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Padron;
import model.Plan;
import model.Titulo;


@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Titulo  {

    private EntityManagerFactory emf;
	private EntityManager em;
	private Titulo titulo;
    
	public B_Titulo() {
       titulo = new Titulo();
       emf = Persistence.createEntityManagerFactory("UCCART");
   	   em = emf.createEntityManager();
       
    }
	
	
	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
		    em.persist(titulo);
		    em.getTransaction().commit();
		    em.close();
		      return true;    
		}catch(Exception e){
					
					System.out.println("No se puedo insertar título");
		   return false;	
		}		
	}
	
	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			titulo = em.find(Titulo.class, titulo.getTitCodigo());
		    em.remove(titulo);
		    em.getTransaction().commit();
		    em.close();
		    return true;    
		}catch(Exception e){
			System.out.println("No se pudo borrar");
		    return false;	
		}	
		
	}
	
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(int tomo,int folio,int asiento){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Integer i = 1, cod = -1;
		List l = em.createNativeQuery("SELECT TIT_CODIGO FROM TITULO ORDER BY TIT_CODIGO DESC LIMIT 1;").getResultList();
		if(l.size() != 0){
			int last =(int)l.get(0);
			while((cod == -1)&&(i <= last)){
				if(em.find(Titulo.class,i)==null){
					cod = i;
				}
				i++;
			}
		}
		if(cod == -1){
			cod = i;
			em.createNativeQuery("SELECT NEXTVAL('TITULO_TIT_CODIGO_SEQ')");
		}
		titulo.setTitAsiento(asiento);
		titulo.setTitCodigo(cod);
		titulo.setTitTomo(tomo);
		titulo.setTitFolio(folio);
		em.getTransaction().commit();
	    em.close();
		
	}
	
	public boolean update(int tomo,int folio,int asiento,int codigo) {
		try{
		em.getTransaction().begin();
	

		titulo.setTitAsiento(asiento);
		titulo.setTitCodigo(codigo);
		titulo.setTitTomo(tomo);
		titulo.setTitFolio(folio);
		em.getTransaction().commit();
		em.close();
	     return true;
	  }catch(Exception e){
		System.out.println("No se pudo borrar");
	    return false;	
	}	
		
	}


	public boolean find(int cod) {
		try{	   
			  em.getTransaction().begin();
			    titulo = em.find(Titulo.class, cod); 
			    
			    if(titulo ==null){
			    
			    System.out.println("No se pudo encontrar1");
			    
			    return false;
			    }else{return true;}
			    
		  }catch(Exception e){
	  	  
	  	  System.out.println("No se pudo encontrar");
	  	  return false;
	      }
		}

}
