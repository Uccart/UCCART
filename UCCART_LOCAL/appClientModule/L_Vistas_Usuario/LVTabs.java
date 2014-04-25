package L_Vistas_Usuario;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import L_Vistas.LVMiCuenta;

@SuppressWarnings("all")
public class LVTabs extends JTabbedPane {
	private LVUsuario lvu;
	private LVMiCuenta lvmc;
	public LVTabs(JFrame padre){
		super();
		lvu = new LVUsuario(padre);
		lvmc = new LVMiCuenta();
	}
	public void init(String usuario, JLabel jlnu){
		lvu.init(usuario);
		lvmc.init(usuario, jlnu);
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		//this.addTab("Inicio", null, lvi, "Buscar Carreras, Materias y Cursos");
		this.addTab("Usuarios", null, lvu, "Ingresar y eliminar Usuarios");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
	}
	public LVUsuario getLvu(){
		return lvu;
	}
}
