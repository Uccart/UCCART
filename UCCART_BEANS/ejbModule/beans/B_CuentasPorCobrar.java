
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.CuentasPorCobrar;

/**
 * Session Bean implementation class B_Arancel
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_CuentasPorCobrar  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private CuentasPorCobrar cuentasPorCobrar;

	public B_CuentasPorCobrar(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		cuentasPorCobrar = new CuentasPorCobrar();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getCuentasPorCobrar());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar las Cuentas");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(CuentasPorCobrar.class, cuentasPorCobrar.getCuentascobrar_id()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String idFacturaEntrada, float saldo) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			cuentasPorCobrar = em.merge(cuentasPorCobrar);
			//arancel.setArancelId(id);
			cuentasPorCobrar.setCuentascobrar_id(id);
			cuentasPorCobrar.setCuentascobrar_id_factura_entrada(idFacturaEntrada);
			cuentasPorCobrar.setCuentascobrar_saldo(saldo);
			
			
			em.getTransaction().commit();
			em.refresh(cuentasPorCobrar);
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
			cuentasPorCobrar = em.find(CuentasPorCobrar.class,cod);

			if(cuentasPorCobrar == null){
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
			Query q =em.createNativeQuery("select * from cuentas_por_cobrar where cuentascobrar_id ilike '"+cod+"';", CuentasPorCobrar.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setCuentasPorCobrar(String id, String idFacturaEntrada, float saldo) {
		cuentasPorCobrar.setCuentascobrar_id(id);
		cuentasPorCobrar.setCuentascobrar_id_factura_entrada(idFacturaEntrada);
		cuentasPorCobrar.setCuentascobrar_saldo(saldo);
	}
	
	public void setCuentasPorCobrar(CuentasPorCobrar cuenta) {
		cuentasPorCobrar = cuenta;
	}


	public CuentasPorCobrar getCuentasPorCobrar() {

		return  this.cuentasPorCobrar;
	}
	
	public List<CuentasPorCobrar> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from cuentas_por_cobrar", CuentasPorCobrar.class);

		
		List<CuentasPorCobrar> results = q.getResultList();
		
		return results;
	}
	
	
	public List<CuentasPorCobrar> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<CuentasPorCobrar> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from cuentas_por_cobrar where cuentascobrar_id similar to '["+rango+"]%'", CuentasPorCobrar.class);
		}else{
			q =em.createNativeQuery("select * from cuentas_por_cobrar", CuentasPorCobrar.class);
		}
		return q.getResultList();
	}
	
	public List<CuentasPorCobrar> cuentasPorEstudiante(String id){
		String query = "select cuentascobrar_id, cuentascobrar_id_factura_entrada, cuentascobrar_saldo from cuentas_por_cobrar join facturas_entrada on cuentascobrar_id_factura_entrada = facturas_entrada_id where facturas_entrada_id_estudiante = '"+id+"';";
		em = emf.createEntityManager();
		Query q =em.createNativeQuery(query, CuentasPorCobrar.class);
		List<CuentasPorCobrar> results = q.getResultList();
		
		return results;
	}
	
	

}
