package beans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//import model.Cobro;
import model.Estudiante;


/**
 * Session Bean implementation class B_Cobro
 */
/*

@Stateless
@LocalBean
public class B_Cobro{

	private EntityManagerFactory emf;
	private EntityManager em;
	private Cobro cobro;
	
    public B_Cobro() {
    	emf = Persistence.createEntityManagerFactory("UCCART");
    	em = emf.createEntityManager();
		cobro = new Cobro();
    }

	
	public boolean insert() {
		try{
			em.getTransaction().begin();
		    em.persist(this.getCobro());
		    em.getTransaction().commit();
		    em.close();
		    return true;    
		}catch(Exception e){
				
					System.out.println("No se puedo insertar Cobro");
					return false;		
		}	
	}


	public boolean  delete() {
		   try{
				em.getTransaction().begin();
			     cobro = em.find(Cobro.class, cobro.getCobroId());
			    em.remove(cobro);
			    em.getTransaction().commit();
			    em.close();	
			    return true;
		      }catch(Exception e){
		    	  System.out.println("No se pudo borrar");
		    		return false;
		      }
		
	}


	public  boolean  update(int cod, String cod_est, float monto,int letra, Date pago,
			Date venc, boolean status, int interes, String detalle) {
   try{
		em.getTransaction().begin();
		cobro.setCobroId(cod);
		cobro.setCobroDetalle(detalle);
		cobro.setCobroInteres(interes);
		cobro.setCobroMonto(monto);
		cobro.setCobroStatus(status);
		  cobro.setCobroFechapago(pago);
		cobro.setCobroVencimiento(venc);
		cobro.setCorboLetra(letra);
		cobro.setEstudiante( em.find(Estudiante.class,cod_est));
		
		em.getTransaction().commit();
		em.close();
		return true;
	}catch(Exception e){
		
		
		return false;
	}}

	
	public Cobro getCobro() {
		return this.cobro;
	    
	    
	    
	}

	
	public void setCobro(int cod, String cod_est, float monto,int letra, Date pago,
			Date venc, boolean status, int interes, String detalle) {
		em.getTransaction().begin();
		cobro.setCobroId(cod);
		cobro.setCobroDetalle(detalle);
		cobro.setCobroInteres(interes);
		cobro.setCobroMonto(monto);
		cobro.setCobroStatus(status);
		  cobro.setCobroFechapago(pago);
		cobro.setCobroVencimiento(venc);
		cobro.setCorboLetra(letra);
		cobro.setEstudiante( em.find(Estudiante.class,cod_est));
		em.close();
	}

	

	
	public  boolean find(int cod) {
		try{
		em.getTransaction().begin();
		 cobro = em.find(Cobro.class, cod);
	     return true;
		}catch(Exception e){
		
		
	 return false;	
	}}

}*/
