package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Carrera;
import model.Materia;
import model.Plan;
import model.Usuario;

/**
 * Session Bean implementation class B_Plan
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Plan {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Plan plan;

	public B_Plan() {
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		plan = new Plan();
	}


	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(plan);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se puedo Plan ");
			return false;	
		}	

	}

	public boolean find(int cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			plan = em.find(Plan.class,cod);

			if(plan == null){
				System.out.println("No se pudo borrar");
				return false;

			}else{return true;}    
		}catch(Exception e){System.out.println("No se pudo borrar");
		return false;
		}	


	}

	public List<Plan> getPlanesXcarrera(String carrera){

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q = em.createNativeQuery("select * from Plan where plan_carrera = '" + carrera +"' order by plan_ciclo",Plan.class);
			List<Plan> lista = q.getResultList();
			System.out.println(lista.toString());
			return lista;

		}catch(Exception e){
			System.out.println("no se encontraron planes");
			return null;

		}
	}
	public boolean delete(int cod) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			plan= em.find(Plan.class, cod);
			plan.setPlanCod(cod);
			System.out.println(cod+"\""+plan.getPlanCod()+"\"");
			em.remove(plan);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){System.out.println("No se pudo borrar");
		return false;
		}	

	}

	public List<Plan> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Plan", Plan.class);

		List<Plan> results = q.getResultList();

		return results;
	}

	public Plan getPlan(int cod) {

		return plan;
	}


	public void setPlan(String carrera, String materia,int ciclo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Integer i = 1, cod = -1;
		List l = em.createNativeQuery("SELECT PLAN_COD FROM PLAN ORDER BY PLAN_COD DESC LIMIT 1;").getResultList();
		if(l.size() != 0){
			int last =(int)l.get(0);
			while((cod == -1)&&(i <= last)){
				if(em.find(Plan.class,i)==null){
					cod = i;
				}
				i++;
			}
		}
		if(cod == -1){
			cod = i;
			em.createNativeQuery("SELECT NEXTVAL('PLAN_PLAN_COD_SEQ')");
		}
		plan.setPlanCod(cod);
		plan.setCarrera(em.find(Carrera.class, carrera));
		plan.setMateria(em.find(Materia.class, materia));
		plan.setPlanCiclo(ciclo);

	}

	public boolean update(int cod, String carrera, String materia,int ciclo) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			plan = em.find(Plan.class,cod);
			plan.setCarrera(em.find(Carrera.class, carrera));
			plan.setMateria(em.find(Materia.class, materia));
			plan.setPlanCiclo(ciclo);
			plan.setPlanCod(cod);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception e){
			System.out.println("No se pudo modificar");
			return false;
		}	
	}

}
