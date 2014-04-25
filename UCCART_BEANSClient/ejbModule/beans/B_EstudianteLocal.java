package beans;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface B_EstudianteLocal {
	public void insertar(String id, String nom, String ape1, String ape2, String codcarr, int cel, 
			int tel, String correo, int stat, boolean bec, int codbeca, String dir, String nacimi,
			boolean genero, Date nac, int codtit, String trab);
	public void borrar();
	
}
