package L_Vistas_Registro;

import java.awt.*;

import javax.swing.*;

import L_Vistas.LVMiCuenta;


@SuppressWarnings("all")
public class LVRegistro extends JTabbedPane {
	private LVEstudiante lve;
	private LVMatricula lvm;
	private LVBeca lvb;
	private LVPadron lvp;
	private LVMiCuenta lvmc;
	public LVRegistro(JFrame padre){
		super();
		lve = new LVEstudiante(padre);
		lvm = new LVMatricula(padre);
		lvb = new LVBeca();
		lvp = new LVPadron(padre);
		lvmc = new LVMiCuenta();
	}
	public void init(boolean bandera, String usuario, JLabel jlnu){
		
		lve.init(bandera);
		lvm.init(bandera);
		lvb.init(bandera);
		lvp.init(bandera);
		lvmc.init(usuario, jlnu);
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		this.addTab("Estudiante", null, lve, "Ingresar, eliminar y modificar estudiantes");
		this.addTab("Matrícula", null, lvm, "Matricular y desmatricular estudiantes");
		this.addTab("Padrón", null, lvp, "Agregar estudiantes al padrón de carreras");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
		//this.addTab("Beca", null, lvb, "Ingresar, eliminar y modificar becas estudiantes");
	}
	public void reducir(){
		lve.reducir();
		lvp.reducir();
	}

}
