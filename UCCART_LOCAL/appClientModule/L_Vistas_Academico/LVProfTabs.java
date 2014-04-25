package L_Vistas_Academico;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import L_Vistas.LVMiCuenta;
import L_Vistas_Usuario.LVUsuario;

@SuppressWarnings("all")
public class LVProfTabs extends JTabbedPane {
	private LVProfesor lvp;
	private LVMiCuenta lvmc;
	public LVProfTabs(JFrame padre){
		super();
		lvp = new LVProfesor(padre);
		lvmc = new LVMiCuenta();
	}
	public void init( String usuario, JLabel jlnu){
		lvp.init( usuario);
		lvmc.init(usuario, jlnu);
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		//this.addTab("Inicio", null, lvi, "Buscar Carreras, Materias y Cursos");
		this.addTab("Cursos", null, lvp, "Obtener información de los cursos asignados, así como asignar notas");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
	}
}
