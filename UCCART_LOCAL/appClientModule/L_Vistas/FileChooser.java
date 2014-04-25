package L_Vistas;


import java.io.*;

import javax.swing.JFileChooser;




import beans.B_Curso;
import beans.B_Estudiante;
import beans.B_Padron;
import beans.B_Periodo;
import beans.B_Profesor;
import L_Reportes.ReportManager;


public class FileChooser {

	 private JFileChooser fc;
	 private ReportManager rm;
	 
	 public FileChooser(){
		  fc = new JFileChooser();
	      rm = new ReportManager();	  
		  
		  
	 }
	 public void ListaClase(B_Curso c){
		 int r = fc.showSaveDialog(null);
	     if (r == JFileChooser.APPROVE_OPTION) {
	         File archivo = fc.getSelectedFile();
	         try {
	             rm.ListaCurso(c, archivo.toString());
	         } catch (Exception ex) {
	             
	             ex.printStackTrace();
	         }
	     }
	     }
		
	     public void ActaNotas(B_Curso c){
			 int r = fc.showSaveDialog(null);
		     if (r == JFileChooser.APPROVE_OPTION) {
		         File archivo = fc.getSelectedFile();
		         try {
		             rm.ListaCursoNotas(c, archivo.toString());
		         } catch (Exception ex) {
		             
		             ex.printStackTrace();
		         }
		     } 
		 
	 }
	     
	     public void ListaCreditos(B_Periodo p){
			 int r = fc.showSaveDialog(null);
		     if (r == JFileChooser.APPROVE_OPTION) {
		         File archivo = fc.getSelectedFile();
		         try {
		             rm.ListaCreditos(p,archivo.toString());
		         } catch (Exception ex) {
		             
		             ex.printStackTrace();
		         }
		     }
	     }
	     
	     public void ListaProfesores(B_Profesor p){
			 int r = fc.showSaveDialog(null);
		     if (r == JFileChooser.APPROVE_OPTION) {
		         File archivo = fc.getSelectedFile();
		         try {
		             rm.listaProfes(p,archivo.toString());
		         } catch (Exception ex) {
		             
		             ex.printStackTrace();
		         }
		     }
	     }
	     
	     public void ListaPadron(B_Padron p){
	 			 int r = fc.showSaveDialog(null);
	 		     if (r == JFileChooser.APPROVE_OPTION) {
	 		         File archivo = fc.getSelectedFile();
	 		         try {
	 		             rm.listaPadron(p, archivo.toString());
	 		         } catch (Exception ex) {
	 		             
	 		             ex.printStackTrace();
	 		         }
	 		     }
	 	     }
	     
	     public void HistorialNotas(B_Estudiante e){
 			 int r = fc.showSaveDialog(null);
 		     if (r == JFileChooser.APPROVE_OPTION) {
 		         File archivo = fc.getSelectedFile();
 		         try {
 		             rm.EstudianteHistorialNotas(e, archivo.toString());
 		         } catch (Exception ex) {
 		             
 		             ex.printStackTrace();
 		         }
 		     }
 	     }
}
