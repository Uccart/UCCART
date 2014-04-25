
package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Empleado;
import java.util.Date;
/**
 * Session Bean implementation class B_Empleado
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Empleado  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Empleado empleado;

	public B_Empleado(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		empleado = new Empleado();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getEmpleado());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar empleado");
			return false;
		}	
	}


	public boolean delete() {
		try{
			System.out.println("lo va a borrar");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Empleado.class, empleado.getEmpleadoId()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String id, String nombre, String ape1, String ape2, Date fecha, String telcasa, String telcel,
			String direccion, String correo, float salario, String puesto) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
	
			empleado = em.merge(empleado);
			empleado.setEmpleadosId(id);
			empleado.setEmpleadosNombre(nombre);
			empleado.setEmpleadosApellido1(ape1);
			empleado.setEmpleadosApellido2(ape2);
			empleado.setEmpleadosFechaN(fecha);
			empleado.setEmpleadosTelefonoCasa(telcasa);
			empleado.setEmpleadosTelefonoCel(telcel);
			empleado.setEmpleadosDireccion(direccion);
			empleado.setEmpleadosCorreo(correo);
			empleado.setEmpleadosSalario(salario);
			empleado.setEmpleadosPuesto(puesto);
			
			
			em.getTransaction().commit();
			em.refresh(empleado);
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
			empleado = em.find(Empleado.class,cod);

			if(empleado == null){
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
			Query q =em.createNativeQuery("select * from empleados where personas_id ilike '"+cod+"';", Empleado.class);
			
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public void setEmpleado(String id, String nombre, String ape1, String ape2, Date fecha, String telcasa, String telcel,
			String direccion, String correo, float salario, String puesto) {
		
		empleado = em.merge(empleado);
		empleado.setEmpleadosId(id);
		empleado.setEmpleadosNombre(nombre);
		empleado.setEmpleadosApellido1(ape1);
		empleado.setEmpleadosApellido2(ape2);
		empleado.setEmpleadosFechaN(fecha);
		empleado.setEmpleadosTelefonoCasa(telcasa);
		empleado.setEmpleadosTelefonoCel(telcel);
		empleado.setEmpleadosDireccion(direccion);
		empleado.setEmpleadosCorreo(correo);
		empleado.setEmpleadosSalario(salario);
		empleado.setEmpleadosPuesto(puesto);
		
	}


	public Empleado getEmpleado() {

		return  this.empleado;
	}
	
	public List<Empleado> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from empleados", Empleado.class);

		
		List<Empleado> results = q.getResultList();
		
		return results;
	}
	
	
	public List<Empleado> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<Empleado> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from empleados where empleados_nombre similar to '["+rango+"]%'", Empleado.class);
		}else{
			q =em.createNativeQuery("select * from empleados", Empleado.class);
		}
		return q.getResultList();
	}
	
	

}
