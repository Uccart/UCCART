package L_Vistas_Academico;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import L_Vistas.LVMiCuenta;
import L_Vistas_Registro.LVBeca;
import L_Vistas_Registro.LVEstudiante;
import L_Vistas_Registro.LVMatricula;
import L_Vistas_Registro.LVPadron;
import L_Vistas_Usuario.LVUsuario;


@SuppressWarnings("all")
public class LVRector extends JTabbedPane {
	private LVEstudiante lve;
	private LVMatricula lvma;
	private LVBeca lvb;
	private LVPadron lvpa;
	private LVCurso lvc;
	private LVInicio lvi;
	private LVMateria lvm;
	private LVCarrera lvca;
	private LVPlan lvp;
	private LVPeriodo lvpe;
	private LVUsuario lvu;
	private LVMiCuenta lvmc;
	private LVProf lvprof;
	public LVRector(JFrame padre){
		super();
		lve = new LVEstudiante(padre);
		lvma = new LVMatricula(padre);
		lvb = new LVBeca();
		lvpa = new LVPadron(padre);
		lvc = new LVCurso(padre);
		lvi = new LVInicio();
		lvm = new LVMateria(padre);
		lvca = new LVCarrera(padre);
		lvp = new LVPlan();
		lvpe = new LVPeriodo(padre);
		lvu = new LVUsuario(padre);
		lvmc = new LVMiCuenta();
		lvprof = new LVProf(padre);
	}
	public void init(String usuario,JLabel jlnu){
		lvc.init(false);
		lvi.init();
		lvm.init(false);
		lvca.init(false);
		lvp.init(false);
		lvpe.init(false);
		lve.init(false);
		lvma.init(false);
		lvb.init(false);
		lvpa.init(false);
		lvu.init(usuario);
		lvmc.init(usuario, jlnu);
		lvprof.init(false);
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		this.addTab("Usuarios", null, lvu, "Ingresar y modificar Usuarios");
		this.addTab("Carrera", null, lvca, "Ingresar y modificar Carreras");
		this.addTab("Plan de Estudio", null, lvp, "Añadir Cursos a un plan de estudios");
		this.addTab("Materia", null, lvm, "Ingresar y modificar Materias");
		this.addTab("Curso", null, lvc, "Ingresar y modificar Cursos");
		this.addTab("Profesor", null, lvprof, "Ingresar, eliminar y modificar profesores");
		this.addTab("Período", null, lvpe, "Ingresar y modificar Períodos");
		this.addTab("Estudiante", null, lve, "Ingresar, eliminar y modificar estudiantes");
		this.addTab("Matrícula", null, lvma, "Matricular y desmatricular estudiantes");
		this.addTab("Padrón", null, lvpa, "Agregar estudiantes al padrón de carreras");
		this.addTab("Auditoría", null, null, "Registro de actividad del sistema SECAU");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
	}
}
