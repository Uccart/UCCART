
package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.ReciboEntrada;
import model.Estudiante;
/**
 * Session Bean implementation class B_Arancel
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_ReciboEntrada  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private ReciboEntrada reciboEntrada;

	public B_ReciboEntrada(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		reciboEntrada = new ReciboEntrada();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getReciboEntrada());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar reciboEntrada");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(ReciboEntrada.class, reciboEntrada.getIdReciboEntrada()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String idFacturaEntrada, String idEmpleado, Date fecha, String descripcion, 
			Float saldoAnterior, Float recargoPorMora, Float esteAbono, Float saldoActual) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			reciboEntrada = em.merge(reciboEntrada);
			
			reciboEntrada.setIdReciboEntrada(id);
			reciboEntrada.setIdFacturaEntrada(idFacturaEntrada);
			reciboEntrada.setIdEmpleado(idEmpleado);
			reciboEntrada.setFecha(fecha);
			reciboEntrada.setDescripcion(descripcion);
			reciboEntrada.setSaldoAnterior(saldoAnterior);
			reciboEntrada.setRecargoPorMora(recargoPorMora);
			reciboEntrada.setEsteAbono(esteAbono);
			reciboEntrada.setSaldoActual(saldoActual);
			
			em.getTransaction().commit();
			em.refresh(reciboEntrada);
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;
		}
	}


	public boolean find(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			reciboEntrada = em.find(ReciboEntrada.class,cod);

			if(reciboEntrada == null){
				System.out.println("No se pudo borrar");
				return false;

			}else{return true;}    
		}catch(Exception e){System.out.println("No se pudo borrar");
		return false;
		}
	}	

	
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from recibo_entrada where reciboEntrada_id ilike '"+cod+"';", ReciboEntrada.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setReciboEntrada(String id, String idFacturaEntrada, String idEmpleado, Date fecha, String descripcion, 
			Float saldoAnterior, Float recargoPorMora, Float esteAbono, Float saldoActual) {
		reciboEntrada.setIdReciboEntrada(id);
		reciboEntrada.setIdFacturaEntrada(idFacturaEntrada);
		reciboEntrada.setIdEmpleado(idEmpleado);
		reciboEntrada.setFecha(fecha);
		reciboEntrada.setDescripcion(descripcion);
		reciboEntrada.setSaldoAnterior(saldoAnterior);
		reciboEntrada.setRecargoPorMora(recargoPorMora);
		reciboEntrada.setEsteAbono(esteAbono);
		reciboEntrada.setSaldoActual(saldoActual);
		
	}


	public ReciboEntrada getReciboEntrada() {

		return  this.reciboEntrada;
	}
	
	public List<ReciboEntrada> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from recibo_entrada", ReciboEntrada.class);

		
		List<ReciboEntrada> results = q.getResultList();
		
		return results;
	}
	
	
	public List<ReciboEntrada> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<ReciboEntrada> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from recibo_entrada where reciboEntrada_descripcion similar to '["+rango+"]%'", ReciboEntrada.class);
		}else{
			q =em.createNativeQuery("select * from recibo_entrada", ReciboEntrada.class);
		}
		return q.getResultList();
	}
	
	

}
