package L_Vistas_Academico;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import L_Vistas.LVMiCuenta;


@SuppressWarnings("all")
public class LVAcademico extends JTabbedPane {
	private LVCurso lvc;
	private LVInicio lvi;
	private LVMateria lvm;
	private LVCarrera lvca;
	private LVPlan lvp;
	private LVPeriodo lvpe;
	private LVMiCuenta lvmc;
	public LVAcademico(JFrame padre){
		super();
		lvc = new LVCurso(padre);
		lvi = new LVInicio();
		lvm = new LVMateria(padre);
		lvca = new LVCarrera(padre);
		lvp = new LVPlan();
		lvpe = new LVPeriodo(padre);
		lvmc = new LVMiCuenta();
	}
	public void init(boolean bandera, String usuario, JLabel jlnu){
		lvc.init(bandera);
		lvi.init();
		lvm.init(bandera);
		lvca.init(bandera);
		lvp.init(bandera);
		lvpe.init(bandera);
		lvmc.init(usuario, jlnu);
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		//this.addTab("Inicio", null, lvi, "Buscar Carreras, Materias y Cursos");
		this.addTab("Carrera", null, lvca, "Ingresar y modificar Carreras");
		this.addTab("Plan de Estudio", null, lvp, "Añadir Cursos a un plan de estudios");
		this.addTab("Materia", null, lvm, "Ingresar y modificar Materias");
		this.addTab("Curso", null, lvc, "Ingresar y modificar Cursos");
		this.addTab("Período", null, lvpe, "Ingresar y modificar Períodos");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
	}
	public LVCurso getLvc(){
		return lvc;
	}
}
