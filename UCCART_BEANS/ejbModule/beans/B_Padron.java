package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Carrera;
import model.Estudiante;
import model.Padron;
import model.Titulo;

/**
 * Session Bean implementation class B_Padron
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Padron {
       
	private EntityManagerFactory emf;
	private EntityManager em;
	private Padron padron;
    /**
     * @see Padron#Padron()
     */
    public B_Padron() {
    	padron = new Padron();
        // TODO Auto-generated constructor stub
        emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
    }
    
    public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(em.merge(padron));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){

			System.out.println("No se puedo padron ");
			return false;	
		}	

	}

	public boolean find(int cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			padron = em.find(Padron.class, cod);
			em.close();
			if(padron == null){

				System.out.println("No se pudo encontrar");
				return false;

			}else{
				return true;
			}

		}catch(Exception e){
			System.out.println("No se pudo encontrar");
			return false;
		}
	}
	
	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(padron));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo borrar");
			return false;
		}	

	}


	public boolean update(String idest, String codcarr) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			padron.setEstudiante(em.find(Estudiante.class, idest));
			padron.setCarrera(em.find(Carrera.class, codcarr));
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo modificar");
			return false;
		}	
	}
	
	public boolean valida(String estid, String codcarr){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Padron where pad_idestudiante = '"+estid+"' and pad_codcarr = '"+codcarr+"'", Padron.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}
	
	public int getId(String estid, String codcarr){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println(estid+codcarr);
		Query q =em.createNativeQuery("select pad_serial from Padron where pad_idestudiante = '"+estid+"' and pad_codcarr = '"+codcarr+"'");
		int result =(int)q.getResultList().get(0);
		em.getTransaction().commit();
	    em.close();
	    return result;
	}

	public void setPadron(String idest, String codcarr){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Integer i = 1, cod = -1;
		List l = em.createNativeQuery("SELECT PAD_SERIAL FROM PADRON ORDER BY PAD_SERIAL DESC LIMIT 1;").getResultList();
		if(l.size() != 0){
			int last =(int)l.get(0);
			while((cod == -1)&&(i <= last)){
				if(em.find(Padron.class,i)==null){
					cod = i;
				}
				i++;
			}
		}
		if(cod == -1){
			cod = i;
			em.createNativeQuery("SELECT NEXTVAL('PADRON_PAD_SERIAL_SEQ')");
		}
		padron.setPadSerial(cod);
		padron.setEstudiante(em.find(Estudiante.class, idest));
		padron.setCarrera(em.find(Carrera.class, codcarr));
		em.getTransaction().commit();
	    em.close();

	}
	
	public List<Carrera> getpadronXid(String idest){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select pad_codcarr from Padron where pad_idestudiante = '"+idest+"'");

		List<String> codscarr = q.getResultList();
		List<Carrera> results = new ArrayList();
		for(int i = 0; i< codscarr.size(); i++){
			q = em.createNativeQuery("select * from Carrera where carr_cod = '"+codscarr.get(i)+"'", Carrera.class);
			results.add((Carrera)q.getResultList().get(0));
		}

		return results;
		
	}
	public List<Carrera> selectCarreras(){
		em = emf.createEntityManager();
		List<Carrera> results = new ArrayList();
		Query q =em.createNativeQuery("select * from Carrera where carr_cod = (select pad_codcarr from Padron) ORDER BY carr_nombre", Padron.class);
		results = q.getResultList();
		
		return results;

		
		
	}
	
	public List<Estudiante> selectXcarreraalfa(String codcarr){
		em = emf.createEntityManager();
		List<Estudiante> results = new ArrayList();
		Query q =em.createNativeQuery("select * from Padron where pad_codcarr = '"+codcarr, Padron.class);
		List<Padron> resultsaux = q.getResultList();
		
			for(int i = 0; i< resultsaux.size(); i++){
				results.add(resultsaux.get(i).getEstudiante());
			}
		return results;
	}

	public List<Padron> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Padron", Padron.class);

		List<Padron> results = q.getResultList();

		return results;
	}

	public Padron getPeriodo() {
		return padron;
	}

}
