package L_Vistas_Financiero;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import L_Vistas.LVMiCuenta;
import L_Vistas_Financiero.LVAranceles;
import L_Vistas_Registro.LVBeca;
import L_Vistas_Registro.LVEstudiante;
import L_Vistas_Registro.LVMatricula;
import L_Vistas_Registro.LVPadron;
import L_Vistas_Usuario.LVUsuario;
import L_Vistas_Academico.LVCurso;
import L_Vistas_Academico.LVMateria;
import L_Vistas_Academico.LVInicio;
import L_Vistas_Academico.LVCarrera;
import L_Vistas_Academico.LVPlan;
import L_Vistas_Academico.LVPeriodo;
import L_Vistas_Academico.LVProf;
import L_Vistas_Academico.LVRector;
import L_Vistas_Financiero.LVEmpleados;


@SuppressWarnings("all")
public class LVContador extends JTabbedPane {
	private LVAranceles lva;
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
	private LVInventario lvinv;
	private LVEmpleados lvemp;
	
	
	public LVContador(JFrame padre){
		super();
		lva = new LVAranceles(padre);
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
		lvinv = new LVInventario(padre);
		lvemp = new LVEmpleados(padre);
	}
	public void init(String usuario,JLabel jlnu){
		lva.init(false);
		lvc.init(false);
		lvi.init();
		lvm.init(false);
		lvca.init(false);
		lvp.init(false);
		lvpe.init(false);
		//lve.init(false);
		lvma.init(false);
		lvb.init(false);
		lvpa.init(false);
		lvu.init(usuario);
		lvmc.init(usuario, jlnu);
		lvprof.init(false);
		lvinv.init(false);
		lvemp.init(false);
		
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		//this.addTab("Usuarios", null, lvu, "Ingresar y modificar Usuarios");
		//this.addTab("Carrera", null, lvca, "Ingresar y modificar Carreras");
		//this.addTab("Plan de Estudio", null, lvp, "Añadir Cursos a un plan de estudios");
		//this.addTab("Materia", null, lvm, "Ingresar y modificar Materias");
		//this.addTab("Curso", null, lvc, "Ingresar y modificar Cursos");
		//this.addTab("Profesor", null, lvprof, "Ingresar, eliminar y modificar profesores");
		//this.addTab("Período", null, lvpe, "Ingresar y modificar Períodos");
		//this.addTab("Estudiante", null, lve, "Ingresar, eliminar y modificar estudiantes");
		//this.addTab("Matrícula", null, lvma, "Matricular y desmatricular estudiantes");
		//this.addTab("Padrón", null, lvpa, "Agregar estudiantes al padrón de carreras");
		//this.addTab("Auditoría", null, null, "Registro de actividad del sistema SECAU");
		this.addTab("RecibosEntrada", null, null, "Realizar un Recibo de Entrada");
		this.addTab("RecibosSalida", null, null, "Realizar un Recibo de Salida");
		this.addTab("Empleados", null, lvemp, "Ingresa, modifica y busca Empleados");
		this.addTab("Aranceles", null, lva, "Ingresa, modifica y busca Aranceles");
		this.addTab("Inventario", null, lvinv, "Modificar información personal");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
		
	}
}
