package beans;


import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.*;

import model.Beca;  
/**
 * Session Bean implementation class B_Beca
 */
@Stateless
public class B_Beca  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Beca beca;

	public B_Beca(){
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		beca = new Beca();
	}


	public boolean insert() {

		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getBeca());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar beca");
			return false;
		}	
	}


	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Beca.class, beca.getBecaIdestudiante()));
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo borrar");
			return false;
		}
	}


	public boolean update(String idest, Date in, Date ven, int t, int por) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			beca.setBecaIdestudiante(idest);
			beca.setBecaInicio(ven);
			beca.setBecaVencimiento(in);
			beca.setBecaPorcentaje(por);
			beca.setBecaTipo(t);
			em.getTransaction().commit();
			em.close();	
			return true;
		}catch(Exception e){

			System.out.println("No se pudo modificar");
			return false;
		}
	}


	public boolean find(int cod) {
		try{	   
			em = emf.createEntityManager();
			em.getTransaction().begin();
			beca = em.find(Beca.class, cod); 

			if(beca ==null){

				System.out.println("No se pudo encontrar1");

				return false;
			}else{return true;}

		}catch(Exception e){

			System.out.println("No se pudo encontrar");
			return false;
		}
	}


	public void setBeca(String idest, Date in, Date ven, int t, int por) {
		beca.setBecaIdestudiante(idest);
		beca.setBecaInicio(ven);
		beca.setBecaVencimiento(in);
		beca.setBecaPorcentaje(por);
		beca.setBecaTipo(t);
	}


	public Beca getBeca() {

		return  this.beca;
	}

	public static void main(String[] args){

		B_Beca b= new B_Beca();
		b.find(123);
	}

}
