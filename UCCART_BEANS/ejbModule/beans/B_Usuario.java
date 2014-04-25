package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



import model.Curso;
import model.Materia;
import model.Usuario;

/**
 * Session Bean implementation class B_Usuario
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Usuario {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Usuario usuario;

	public B_Usuario() {
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		usuario = new Usuario();
	}

	public boolean find(String cod) {
		try{	
			em = emf.createEntityManager();
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, cod); 
			em.clear();
			em.close();

			if(usuario ==null){

				System.out.println("No se pudo encontrar1");

				return false;
			}else{
				return true;
			}

		}catch(Exception e){

			System.out.println("No se pudo encontrar");
			return false;
		}
	}


	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo insertar Usuario ");
			return false;		
		}
	}
	
	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Usuario where us_id ilike '"+cod+"';", Usuario.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(usuario));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;	
		}	

	}


	public boolean update(String id, String pw,String nombre,int tipo) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, id);
			usuario.setUsNombre(nombre);
			usuario.setUsPw(pw);
			usuario.setUsTipo(tipo);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;	
		}	
	}

	public void setUsuario(String id,String pw,String nombre,int tipo){

		usuario.setUsId(id);
		usuario.setUsNombre(nombre);
		usuario.setUsPw(pw);
		usuario.setUsTipo(tipo);

	}
	public List<Usuario> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Usuario", Usuario.class);

		List<Usuario> results = q.getResultList();

		return results;
	}

	public Usuario getUsuario() {
		return usuario;

	}

}
