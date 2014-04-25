package beans;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Carrera;
import model.Curso;
import model.Estudiante;
import model.Materia;
import model.Nota;
import model.Periodo;
import model.Profesor;

/**
 * Session Bean implementation class B_Curso
 */
@Stateless
@LocalBean
@SuppressWarnings("all")
public class B_Curso  {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Curso curso;

	public B_Curso() {
		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		curso = new Curso();
	}


	public boolean insert() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.getCurso());
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("No se puedo insertar Curso");
			return false;		
		}	

	}


	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			curso = em.find(Curso.class, curso.getCursoId());
			em.remove(curso);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo borrar");
			return false;
		}

	}

	// no modifica cantidad actual por qué se modifica mediante trigger en la base de datos 

	public boolean update(String cod,String aula,String sede,String codMateria,String periodo,
			String profesor,int cantmax,int cantmin,Date cursoInicio,Date cursoFinal,int dia1,Time d1i ,Time d1f, int dia2,Time d2i ,Time d2f) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			curso.setCursoAula(aula);
			curso.setCursoCantmax(cantmax);
			curso.setCursoCantmin(cantmin);
			curso.setCursoFinal(cursoFinal);
			curso.setCursoId(cod);
			curso.setCursoSede(sede);
			curso.setMateria(em.find(Materia.class, codMateria));
			curso.setPeriodo(em.find(Periodo.class, periodo));
			curso.setProfesor(em.find(Profesor.class, profesor));
			curso.setCursoInicio(cursoInicio);
			curso.setCursoDia1(dia1);
			curso.setCursoDia1inicio(d1i);
			curso.setCursoDia1final(d1f);
			curso.setCursoDia2(dia2);
			curso.setCursoDia2inicio(d2i);
			curso.setCursoDia2final(d2f);

			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){

			System.out.println("no se pudo modificar");
			return false;
		}
	}


	public Curso getCurso() {

		return curso;
	}


	public List<Nota> getNotas() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		curso = em.find(Curso.class,curso.getCursoId());
		em.refresh(curso);
		/*for(int i = 0; i < estudiante.getNotas().size(); i++){
			em.refresh(estudiante.getNotas().get(i).getCurso());
		}*/
		em.getTransaction().commit();
		em.close();
		if(curso.getNotas()==null)
			System.out.println("nulo notas");

		return  this.curso.getNotas();
	}


	public boolean full() {

		if(this.curso.getCursoCantactual() == this.curso.getCursoCantmax()){
			return true;

		}else{
			return false;
		}
	}

	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Curso where curso_id ilike '"+cod+"';", Curso.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}


	public boolean find(String cod) {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			curso = this.em.find(Curso.class, cod);
			if(curso == null){

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

	public List<Curso> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Curso", Curso.class);

		List<Curso> results = q.getResultList();

		return results;
	}


	public void setCurso(String cod,String aula,String sede,String codMateria,String periodo,
			String profesor,int cantmax,int cantmin,Date cursoInicio,Date cursoFinal,int dia1,Time d1i ,Time d1f, int dia2,Time d2i ,Time d2f) {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		curso.setCursoAula(aula);
		curso.setCursoCantactual(0);
		curso.setCursoCantmax(cantmax);
		curso.setCursoCantmin(cantmin);
		curso.setCursoFinal(cursoFinal);
		curso.setCursoId(cod);
		curso.setCursoSede(sede);
		curso.setMateria(em.find(Materia.class, codMateria));
		curso.setPeriodo(em.find(Periodo.class, periodo));
		if(profesor != null)
			curso.setProfesor(em.find(Profesor.class, profesor));
		curso.setCursoInicio(cursoInicio);
		curso.setCursoDia1(dia1);
		curso.setCursoDia1inicio(d1i);
		curso.setCursoDia1final(d1f);
		curso.setCursoDia2(dia2);
		curso.setCursoDia2inicio(d2i);
		curso.setCursoDia2final(d2f);
	}
}
