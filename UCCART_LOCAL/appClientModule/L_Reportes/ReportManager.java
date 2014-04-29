package L_Reportes;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Carrera;
import model.Curso;
import model.Estudiante;
import model.Nota;
import beans.B_Curso;
import beans.B_Estudiante;
import beans.B_Padron;
import beans.B_Periodo;
import beans.B_Profesor;

import com.javadocx.CreateDocx;

@SuppressWarnings("all")
public class ReportManager {
	private CreateDocx docx;
	 
	 public ReportManager(){
		docx = new CreateDocx("docx");
	 }
	 
	 
	 public List<Curso> ListaCursosXPeriodo(B_Periodo p){
	
		return p.getCursos(p.getPeriodo().getPerPeriodo());
		
	    
	 }
	 
	 public ArrayList<Estudiante> ListaEstudiantesXCurso(Curso c){
	     ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();  
		 for(Nota n : c.getNotas()){
	         		   estudiantes.add(n.getEstudiante()); 
	         	    }
	       return estudiantes;        	 
	 }
	 
	 public void ListaCreditos(B_Periodo p,String ruta){
		// ID    I APELLIDO II APELLIDO NOMBRE CEL MATERIA PROF PERIODO
		 
		    HSSFWorkbook libro = new HSSFWorkbook();

	        // Se crea una hoja dentro del libro
	        HSSFSheet hoja = libro.createSheet();

	        // Se crea una fila dentro de la hoja
	       // HSSFRow fila = hoja.createRow(0);

	        // Se crea una celda dentro de la fila
	       // HSSFCell celda = fila.createCell(0);

	        // Se crea el contenido de la celda y se mete en ella.
	      //  HSSFRichTextString texto = new HSSFRichTextString("UCCART REPORTE DE ESTTUDIANTES POR CURSO");
	        
	      //  celda.setCellValue(texto);
	        

			  HSSFRow header = hoja.createRow(0);
			  header.createCell(0).setCellValue(new HSSFRichTextString("ID           "));
			  header.createCell(1).setCellValue(new HSSFRichTextString("I APELLIDO"));
			  header.createCell(2).setCellValue(new HSSFRichTextString("II APELLIDO"));
			  header.createCell(3).setCellValue(new HSSFRichTextString("NOMBRE"));
			  header.createCell(4).setCellValue(new HSSFRichTextString("TELEFONO"));
			  header.createCell(5).setCellValue(new HSSFRichTextString("E-MAIL"));
			  header.createCell(6).setCellValue(new HSSFRichTextString("MATERIA"));
			  header.createCell(7).setCellValue(new HSSFRichTextString("PROFESOR"));
			  header.createCell(8).setCellValue(new HSSFRichTextString("CREDITOS"));
			  header.createCell(9).setCellValue(new HSSFRichTextString("BECA"));
			  
	        
			  int i = 1;
	        for(Curso cur : ListaCursosXPeriodo(p)){
				 for(Estudiante est : ListaEstudiantesXCurso(cur)){
					 System.out.println(est.getEstNombre());
					
					  HSSFRow fila = hoja.createRow(i);
					  fila.createCell(0).setCellValue(new HSSFRichTextString(est.getEstId()));
					  fila.createCell(1).setCellValue(new HSSFRichTextString(est.getEstApellido1()));
					  fila.createCell(2).setCellValue(new HSSFRichTextString(est.getEstApellido2()));
					  fila.createCell(3).setCellValue(new HSSFRichTextString(est.getEstNombre()));
					  fila.createCell(4).setCellValue(new HSSFRichTextString(est.getEstCelular().toString()));
					  fila.createCell(5).setCellValue(new HSSFRichTextString(est.getEstCorreo()));
							 
					  fila.createCell(6).setCellValue(new HSSFRichTextString(cur.getMateria().getMateriaNombre()));
					  fila.createCell(7).setCellValue(new HSSFRichTextString(cur.getProfesor().getProfNombre()+"  "+ cur.getProfesor().getProfApellido1() +" "+cur.getProfesor().getProfApellido2()));
						
					  fila.createCell(8).setCellValue(new HSSFRichTextString(cur.getMateria().getMateriaCreditos().toString())); 
					  if(est.getEstBecado()==true){
						  fila.createCell(9).setCellValue(new HSSFRichTextString(est.getBeca().getBecaPorcentaje().toString()));  
					  }else{
						  fila.createCell(9).setCellValue(new HSSFRichTextString("NA"));
					  }
					  i++;
				 }
	        
	        }
	        // Se salva el libro.
	        try {
	            FileOutputStream elFichero = new FileOutputStream(ruta);
	            libro.write(elFichero);
	            elFichero.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		
		 
		 
		 
		 
	 }
	 
	    
	 
	
	 
	 
	 public  void ListaCurso(B_Curso c, String ruta){
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		int i=0; 
		for(i =0; i<c.getNotas().size();i++){
			 estudiantes.add(c.getNotas().get(i).getEstudiante());
	        
			 
		 }
	
		 HashMap paramsText0 = new HashMap();
		  paramsText0.put("sz", "11");
	       	
			
	       paramsText0.put("i", "single");            //curiva
	       paramsText0.put("b", "single");           //Negrita
	       paramsText0.put("font", "Arial");
	       paramsText0.put("jc", "center");
	       

	       docx.addText("Universidad Continental de las Ciencias y las Artes", paramsText0);
		
	       docx.addBreak("line");
	       
	       
		 
		ArrayList valuesTable = new ArrayList();

       ArrayList row = new ArrayList();
       row.add("ID                     ");
       row.add("PRIMER APELLIDO        ");
       row.add("SEGUNDO APELLIDO       ");
       row.add("NOMBRE                 ");
      
       valuesTable.add(row);
      for(i=0;i<estudiantes.size();i++){
   	   ArrayList row1 = new ArrayList(); 
   	   row1.add(estudiantes.get(i).getEstId());
   	   row1.add(estudiantes.get(i).getEstApellido1());
   	   row1.add(estudiantes.get(i).getEstApellido2());
   	   row1.add(estudiantes.get(i).getEstNombre());
   	   valuesTable.add(row1);
      }  
          HashMap paramsText1 = new HashMap();
      
      paramsText1.put("sz", "11");       			
      paramsText1.put("i", "single");            //curiva
      paramsText1.put("b", "single");           //Negrita
      paramsText1.put("font", "Arial");
      
      docx.addText("Período: "+ c.getCurso().getPeriodo().getPerPeriodo(),paramsText1);
      docx.addBreak("line");
      docx.addText("Curso: "+ c.getCurso().getCursoId()+" - "+c.getCurso().getMateria().getMateriaNombre(),paramsText1);
      docx.addBreak("line");
      docx.addText("Profesor: "+ c.getCurso().getProfesor().getProfNombre()+", "+c.getCurso().getProfesor().getProfApellido1()+" "+c.getCurso().getProfesor().getProfApellido2(),paramsText1);

      docx.addBreak("line");
      
      
      HashMap paramsTable = new HashMap();
      
      
      
      paramsTable.put("border", "single");
      paramsTable.put("border_sz", "5");
      paramsTable.put("sz", "12");

      docx.addTable(valuesTable, paramsTable);
 
      
      docx.createDocx(ruta);
      
	 }
	 
	 
	 public  void ListaCursoNotas(B_Curso c, String ruta){
			ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
			int i=0; 
			for(i =0; i<c.getNotas().size();i++){
				 estudiantes.add(c.getNotas().get(i).getEstudiante());
				 
			 }
			
			 HashMap paramsText0 = new HashMap();
			  paramsText0.put("sz", "14");
		       	
				
		       paramsText0.put("i", "single");            //curiva
		       paramsText0.put("b", "single");           //Negrita
		       paramsText0.put("font", "Arial");
		       paramsText0.put("jc", "center");
		       

		       docx.addText("UCCART", paramsText0);
			
		       docx.addBreak("line");
		       docx.addBreak("line");
		       docx.addText("Acta de notas", paramsText0);
				
		       docx.addBreak("line");
			 
			ArrayList valuesTable = new ArrayList();

	        ArrayList row = new ArrayList();
	        row.add("ID                     ");
	        row.add("PRIMER APELLIDO        ");
	        row.add("SEGUNDO APELLIDO       ");
	        row.add("NOMBRE                 ");
	        row.add("NOTA                   ");
	       
	        valuesTable.add(row);
	       for(i=0;i<estudiantes.size();i++){
	    	   ArrayList row1 = new ArrayList(); 
	    	   row1.add(estudiantes.get(i).getEstId());
	    	   row1.add(estudiantes.get(i).getEstApellido1());
	    	   row1.add(estudiantes.get(i).getEstApellido2());
	    	   row1.add(estudiantes.get(i).getEstNombre());
	    	   row1.add("       ");
	    	   valuesTable.add(row1);
	       }  
	       HashMap paramsText1 = new HashMap();
	       
	       paramsText1.put("sz", "11");       			
	       paramsText1.put("i", "single");            //curiva
	       paramsText1.put("b", "single");           //Negrita
	       paramsText1.put("font", "Arial");
	       
	       docx.addText("Periodo"+ c.getCurso().getPeriodo().getPerPeriodo(),paramsText1);
	       docx.addBreak("line");
	       docx.addText("Curso: "+ c.getCurso().getCursoId()+" - "+c.getCurso().getMateria().getMateriaNombre(),paramsText1);
	       docx.addBreak("line");
	       docx.addText("Profesor: "+ c.getCurso().getProfesor().getProfNombre()+"  "+c.getCurso().getProfesor().getProfApellido1()+"  "+c.getCurso().getProfesor().getProfApellido2(),paramsText1);
	 
	       docx.addBreak("line");
	       
	       HashMap paramsTable = new HashMap();
	       
	       paramsTable.put("border", "single");
	       paramsTable.put("border_sz", "5");
	       paramsTable.put("sz", "12");

	       docx.addTable(valuesTable, paramsTable);
          docx.addBreak("line");
          paramsText1.clear();


          paramsText1.put("font", "Arial");
          paramsText1.put("sz", "12");
          paramsText1.put("jc", "left");
	       docx.addText("_____________________                             __________________ ",paramsText1);
	       docx.addBreak("line");
	       docx.addText("Firma del Profesor                                    Fecha");
	       docx.createDocx(ruta);
	       
		 }
	 
	
	 
	 public  void EstudianteHistorialNotas(B_Estudiante e, String ruta){
			ArrayList<Nota> notas = new ArrayList<Nota>();
			int i=0; 
			for(i =0; i<e.getEstudiante().getNotas().size();i++){
				 notas.add(e.getEstudiante().getNotas().get(i));
				 
			 }
			
			 HashMap paramsText0 = new HashMap();
			  paramsText0.put("sz", "14");
		       	
				
		       paramsText0.put("i", "single");            //curiva
		       paramsText0.put("b", "single");           //Negrita
		       paramsText0.put("font", "Arial");
		       paramsText0.put("jc", "center");
		       

		       docx.addText("Universidad Continental de las Ciencias y las Artes", paramsText0);
			
		       docx.addBreak("line");
		       docx.addBreak("line");
		       docx.addText("Historial de notas", paramsText0);
				
		       docx.addBreak("line");
			 
			ArrayList valuesTable = new ArrayList();

	        ArrayList row = new ArrayList();
	        row.add("ID CURSO               ");
	        row.add("NOMBRE                 ");
	        row.add("CREDITOS               ");
	        row.add("NOTA                   ");
	       
	        valuesTable.add(row);
	       for(i=0;i<notas.size();i++){
	    	   ArrayList row1 = new ArrayList(); 
	    	   row1.add(notas.get(i).getCurso().getCursoId());
	    	   row1.add(notas.get(i).getCurso().getMateria().getMateriaNombre());
	    	   row1.add(notas.get(i).getCurso().getMateria().getMateriaCreditos());
	    	   row1.add(notas.get(i).getNotaPromedio());
	    	   
	    	   valuesTable.add(row1);
	       }  
	       HashMap paramsText1 = new HashMap();
	       
	       paramsText1.put("sz", "11");       			
	       paramsText1.put("i", "single");            //curiva
	       paramsText1.put("b", "single");           //Negrita
	       paramsText1.put("font", "Arial");
	       
	       docx.addText("Estudiante:"+ e.getEstudiante().getEstId()+ "   "+e.getEstudiante().getEstNombre()+" "+e.getEstudiante().getEstApellido1()+" "+e.getEstudiante().getEstApellido2() ,paramsText1);
	       docx.addBreak("line");
	      
	       docx.addBreak("line");
	       
	       HashMap paramsTable = new HashMap();
	       
	       paramsTable.put("border", "single");
	       paramsTable.put("border_sz", "5");
	       paramsTable.put("sz", "12");

	       docx.addTable(valuesTable, paramsTable);
       docx.addBreak("line");
       paramsText1.clear();


       paramsText1.put("font", "Arial");
       paramsText1.put("sz", "12");
       paramsText1.put("jc", "left");
	       docx.addText("_____________________                             __________________ ",paramsText1);
	       docx.addBreak("line");
	       docx.addText("       Sello                                          Fecha");
	       docx.createDocx(ruta);
	       
		 }
	 
	 
	 public void listaProfes(B_Profesor p, String ruta){

		 HashMap paramsText0 = new HashMap();
		  paramsText0.put("sz", "14");
	       	
			
	       paramsText0.put("i", "single");            //curiva
	       paramsText0.put("b", "single");           //Negrita
	       paramsText0.put("font", "Arial");
	       paramsText0.put("jc", "center");
	       

	       docx.addText("UCCART", paramsText0);
		
	       docx.addBreak("line");
	       
	       docx.addText("Lista de Profesores", paramsText0);
			
	       docx.addBreak("line");
	       ArrayList valuesTable = new ArrayList();
	       
	        ArrayList row = new ArrayList();
	        row.add("ID                     ");
	        row.add("PRIMER APELLIDO        ");
	        row.add("SEGUNDO APELLIDO       ");
	        row.add("NOMBRE                 ");
	        row.add("GRADO ACADÃ‰MICO        ");
	        row.add("TELÃ‰FONO               ");
	        row.add("E-MAIL                 ");
	       
	        valuesTable.add(row);

		       for(int i=0;i<p.selectAll().size();i++){
		    	   ArrayList row1 = new ArrayList(); 
		    	   row1.add(p.selectAll().get(i).getProfId());
		    	   row1.add(p.selectAll().get(i).getProfApellido1());
		    	   row1.add(p.selectAll().get(i).getProfApellido2());
		    	   row1.add(p.selectAll().get(i).getProfNombre());
		    	   row1.add(p.selectAll().get(i).getProfGradoacademico());
		    	   row1.add(p.selectAll().get(i).getProfTelefono());
		    	   row1.add(p.selectAll().get(i).getProfCorreo());
		    	   valuesTable.add(row1);
		       }  
		       
		       HashMap paramsTable = new HashMap();
		       
		       paramsTable.put("border", "single");
		       paramsTable.put("border_sz", "5");
		       paramsTable.put("sz", "12");

		       docx.addTable(valuesTable, paramsTable);
	           docx.addBreak("line");
	           docx.createDocx(ruta);
		 
	 }
	 
	 public void listaPadron(B_Padron p, String ruta){
		 HashMap paramsText0 = new HashMap();
		  paramsText0.put("sz", "14");
	       	
			
	       paramsText0.put("i", "single");            //curiva
	       paramsText0.put("b", "single");           //Negrita
	       paramsText0.put("font", "Arial");
	       paramsText0.put("jc", "center");
	       

	       docx.addText("UCCART", paramsText0);
		
	       docx.addBreak("line");
	       docx.addBreak("line");
	       
	       List<Carrera> carreras = p.selectCarreras();
	       
	       for(int i=0; i<carreras.size();i++){
	    	   docx.addText("Carrera: "+ carreras.get(i).getCarrCod()+" - "+ carreras.get(i).getCarrNombre(), paramsText0);
	   		
		       docx.addBreak("line");
		       docx.addBreak("line");
		       ArrayList valuesTable = new ArrayList();
		       
		        ArrayList row = new ArrayList();
		        row.add("ID                     ");
		        row.add("PRIMER APELLIDO        ");
		        row.add("SEGUNDO APELLIDO       ");
		        row.add("NOMBRE                 ");
		       
		       
		        valuesTable.add(row);

			       for(int j=0;j<p.selectXcarreraalfa(carreras.get(i).getCarrCod()).size();i++){
			    	   ArrayList row1 = new ArrayList(); 
			    	   row1.add(p.selectXcarreraalfa(carreras.get(i).getCarrCod()).get(j).getEstId());
			    	   row1.add(p.selectXcarreraalfa(carreras.get(i).getCarrCod()).get(j).getEstApellido1());
			    	   row1.add(p.selectXcarreraalfa(carreras.get(i).getCarrCod()).get(j).getEstApellido1());
			    	   row1.add(p.selectXcarreraalfa(carreras.get(i).getCarrCod()).get(j).getEstNombre());
			    	   valuesTable.add(row1);
			       }  
			       
			       HashMap paramsTable = new HashMap();
			       
			       paramsTable.put("border", "single");
			       paramsTable.put("border_sz", "5");
			       paramsTable.put("sz", "12");

			       docx.addTable(valuesTable, paramsTable);
		           docx.addBreak("line");
		       
		       
		    	   
	    	   
	       }
	       
	       
	       docx.createDocx(ruta);
	       
		 
	 }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//c.find("AEI-400");
		B_Curso p = new B_Curso();
		p.find("LMU01-400");
		System.out.print("holi"+p.getNotas().get(0).getEstudiante().getEstId()+" , ");
		ReportManager rm = new ReportManager();
	//	rm.ListaCurso(p, ruta)
	   // rm.ListaCreditos(p);
		rm.ListaCurso(p,"C:\\Users\\Daniel\\Desktop\\"+p.getCurso().getCursoId());
 
	}
}
