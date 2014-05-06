package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;


import model.Beca;
import model.Carrera;
//import model.Cobro;
import model.Curso;
import model.Estudiante;
import model.Nota;
import model.Padron;
import model.Titulo;
import model.Usuario;
import model.FacturaEntrada;

/**
 * Session Bean implementation class B_Estudiante
 */
@Stateless
@SuppressWarnings("all")
public class B_Estudiante {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Estudiante estudiante;

	public B_Estudiante() {

		emf = Persistence.createEntityManagerFactory("UCCART");
		em = emf.createEntityManager();
		estudiante = new Estudiante();
	}

	public boolean insert() {
		// TODO Auto-generated method stub
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(estudiante);
			em.getTransaction().commit();
			em.close();
			return true;    
		}catch(Exception ex){

			System.out.println("No se puedo insertar Estudiante");
			return false;	
		}	

	}

	public boolean validapk(String cod){
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query q =em.createNativeQuery("select * from Estudiante where personas_id ilike '"+cod+"';", Estudiante.class);
			if( q.getResultList().size() == 0)
				return true;
			else 
				return false;
		}catch(Exception e){
			System.out.println("Error al buscar pk");
			return false;
		}
	}

	public List<Estudiante> selectXcarreraalfa(String rango, String codcarr){
		em = emf.createEntityManager();
		List<Estudiante> results = new ArrayList();
		Query q;
		if(!"Sin filtro".equals(codcarr)){
			q =em.createNativeQuery("select * from Padron where pad_codcarr = '"+codcarr+"'", Padron.class);
			List<Padron> resultsaux = q.getResultList();
			if(!"Sin filtro".equals(rango)){
				for(int i = 0; i< resultsaux.size(); i++){
					q =em.createNativeQuery("select * from Estudiante where personas_id = '"+resultsaux.get(i).getEstudiante().getEstId()+"'and personas_apellido1 similar to '["+rango+"]%'", Estudiante.class);
					if(!(q.getResultList().size() == 0))
						results.add((Estudiante)q.getResultList().get(0));
				}
			}else{
				for(int i = 0; i< resultsaux.size(); i++){
					results.add(resultsaux.get(i).getEstudiante());
				}
			}
		}else{
			q =em.createNativeQuery("select * from Estudiante", Estudiante.class);
			results = q.getResultList();
		}


		return results;
	}
	
	public List<Estudiante> selectXalfa(String rango){
		em = emf.createEntityManager();
		List<Estudiante> results = new ArrayList();
		Query q; 
		if(!"Sin filtro".equals(rango)){
			q =em.createNativeQuery("select * from Estudiante where personas_apellido1 similar to '["+rango+"]%'", Estudiante.class);
		}else{
			q =em.createNativeQuery("select * from Estudiante", Estudiante.class);
		}
		return q.getResultList();
	}

	public List<Estudiante> selectAll(){
		em = emf.createEntityManager();
		Query q =em.createNativeQuery("select * from Estudiante", Estudiante.class);

		List<Estudiante> results = q.getResultList();

		return results;
	}



	public boolean delete() {
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			estudiante = em.find(Estudiante.class, estudiante.getEstId());
			em.remove(estudiante);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo eliminar");
			return false;
		}
	}



	public boolean find(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		estudiante = em.find(Estudiante.class,id);
		if(estudiante == null){
			System.out.println("No se pudo encontrar estudiante");
			return false;

		}else{return true;}

	}



/*

	public List<Cobro> getCobros(String id) {
		return estudiante.getCobros();
	}
*/




	public List<Nota> getNotas(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		estudiante = em.find(Estudiante.class,id);
		em.refresh(estudiante);
		/*for(int i = 0; i < estudiante.getNotas().size(); i++){
			em.refresh(estudiante.getNotas().get(i).getCurso());
		}*/
		em.getTransaction().commit();
		em.close();
		if(estudiante.getNotas()==null)
			System.out.println("nulo notas");
		return estudiante.getNotas();
	}


	public void setNotas(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		estudiante = em.find(Estudiante.class,id);
		em.refresh(estudiante);
		//Query q =em.createNativeQuery("select * from Nota where nota_codestudiante = '"+id+"';", Nota.class);
		List<Nota> notas = estudiante.getNotas();//q.getResultList();
		List<Nota> results = new ArrayList();
		Nota n = new Nota();
		for(int i = 0; i < notas.size(); i++){
			em.refresh(estudiante.getNotas().get(i));
			System.out.println(estudiante.getNotas().get(i).getCurso().getCursoCantactual());
			em.refresh(estudiante.getNotas().get(i).getCurso());
			System.out.println(estudiante.getNotas().get(i).getCurso().getCursoCantactual());
			/*n = em.find(Nota.class, notas.get(i).getId());
			em.refresh(n);
			Curso c = (Curso)em.createNativeQuery("select * from Curso where curso_id = '"+n.getId().getNotaCodcurso()+"';", Curso.class).getResultList().get(0);
			System.out.println((int)em.createNativeQuery("select curso_cantactual from Curso where curso_id = '"+n.getId().getNotaCodcurso()+"';").getResultList().get(0));
			System.out.println(c.getCursoCantactual());
			em.refresh(c);
			System.out.println(c.getCursoCantactual());
			n.setCurso(c);
			results.add(n);*/
		}
		//estudiante.setNotas(results);
		em.getTransaction().commit();
		em.close();
	}



	public boolean update(String nombre, String apellido1,String apellido2,String celular,String telefono,
			String correo,int status,boolean est_becado,String direccion, String nacionalidad,String est_genero,String trabajo) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
			estudiante = em.merge(estudiante);
			//estudiante.setBeca(em.find(Beca.class, codbeca));
			//estudiante.setContrasena(e.getContrasena());
			estudiante.setEstApellido1(apellido1);
			estudiante.setEstApellido2(apellido2);
			estudiante.setEstBecado(est_becado);
			estudiante.setEstCelular(celular);
			estudiante.setEstCorreo(correo);
			estudiante.setEstDireccion(direccion);
			estudiante.setEstGenero(est_genero);
			//estudiante.setEstNacimiento(nacimiento);
			estudiante.setEstNacionalidad(nacionalidad);
			estudiante.setEstNombre(nombre);
			estudiante.setEstStatus(status);
			estudiante.setEstTelefono(telefono);
			estudiante.setEstTrabajo(trabajo);
			//estudiante.setTitulo(em.find(Titulo.class, codtitulo));
			em.getTransaction().commit();
			em.refresh(estudiante);
			em.close();
			return true;
		}catch(Exception e){
			System.out.println("No se pudo modificar estudiante");
			return false;
		}
	}

	public void setEstudiante(String id , String nombre, String apellido1,String apellido2,String celular,String telefono,
			String correo,int status,boolean est_becado, String direccion, String nacionalidad,String est_genero,Date nacimiento,int codtitulo,String trabajo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		//estudiante.setContrasena(e.getContrasena());
		estudiante.setEstApellido1(apellido1);
		estudiante.setEstApellido2(apellido2);
		estudiante.setEstBecado(est_becado);
		estudiante.setEstCelular(celular);
		estudiante.setEstCorreo(correo);
		estudiante.setEstDireccion(direccion);
		estudiante.setEstGenero(est_genero);
		estudiante.setEstId(id);
		estudiante.setEstNacimiento(nacimiento);
		estudiante.setEstNacionalidad(nacionalidad);
		estudiante.setEstNombre(nombre);
		estudiante.setEstStatus(status);
		estudiante.setEstTelefono(telefono);
		estudiante.setEstTrabajo(trabajo);
		estudiante.setTitulo(em.find(Titulo.class, codtitulo));
		em.getTransaction().commit();
		em.close();

	}

	public Estudiante getEstudiante(){
		return estudiante;

	}


	public List<FacturaEntrada> getFacturaEntrada(String id) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		estudiante = em.find(Estudiante.class,id);
		em.refresh(estudiante);
		/*for(int i = 0; i < estudiante.getNotas().size(); i++){
			em.refresh(estudiante.getNotas().get(i).getCurso());
		}*/
		em.getTransaction().commit();
		em.close();
		if(estudiante.getFacturaEntrada()==null)
			System.out.println("nulo notas");
		return estudiante.getFacturaEntrada();
	}
	
	
	
	

}
