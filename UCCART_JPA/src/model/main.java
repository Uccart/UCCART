package model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SuppressWarnings("all")
public class main {
	
	public static boolean find(int cod) {
		try{	 
			 EntityManagerFactory emf = Persistence.createEntityManagerFactory("UCCART");
	         EntityManager em = emf.createEntityManager();
	         em.getTransaction().begin();
	         	Beca b = new Beca();
			 b = em.find(Beca.class, cod); 
			    return true;
		  }catch(Exception e){
	  	  
	  	  System.out.println("No se pudo encontrar");
	  	  return false;
	      }
	}

	public static void main(String[] args) {
	
	
		       find(14123);
		
		         EntityManagerFactory emf = Persistence.createEntityManagerFactory("UCCART");
		         EntityManager em = emf.createEntityManager();
		         em.getTransaction().begin();
		         	Beca b = new Beca();
				
				
		     	
		       
		        

		      b.setBecaInicio(new Date(92,3,23));
		      b.setBecaVencimiento(new Date(92,3,24));
		      b.setBecaTipo(2);
		      b.setBecaPorcentaje(100);
		      em.persist(b);
		//	  em.getTransaction().commit();
				  
				  /*
		         Carrera c = new Carrera();
		         c.setCarrCod("q4ab3d414");
		         c.setCarrNombre("ingdeas");
		         em.find(Carrera.class, "q4ab3d414").setCarrNombre(c.getCarrNombre());
		         em.getTransaction().commit();
		         
		     //   em.clear();
		        
		         
		        // em.getTransaction().notifyAll();
		 //       em.getTransaction().commit();
		         /*
		         Materia t = new Materia();
		         c =em.find(Carrera.class, "q4ab3d414");
		         t.setCarrera(c);
		         t.setMateriaCreditos(4);
		         t.setMateriaLab(0);
		         t.setMateriaId("asdgdfu14");
		         t.setMateriaNombre("asafdgs");
		         t.setMateriaArea("materiaArea");
		        
		        
		         em.persist(t);
				 em.getTransaction().commit();
				
		         emf = Persistence.createEntityManagerFactory("UCCART");
		         em = emf.createEntityManager();
		         em.getTransaction().begin();
		         em.flush();
				  c = em.find(Carrera.class, "q4ab3d414");
		       //  Query q =em.createNativeQuery("select * from Beca", Beca.class);
	              List<Materia> results = c.getMaterias();
	             
	              Query q =em.createNativeQuery("select * from Beca", Beca.class);
	              List<Beca> results = q.getResultList();
				  
	              for(int i=0;i<results.size();i++){
	            	  
	            	  System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	            	  System.out.println( "beca cod: "+ results.get(i).getMateriaNombre());
	            	  System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	              }*/
	              em.close();
	}

}
