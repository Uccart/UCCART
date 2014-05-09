package L_Vistas_Financiero;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import model.Usuario;
import beans.B_Usuario;
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
	private LVFacturacion facturacion; // Facturacion
	private LVFacturacionSalida fsalida;
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
	private LVCuentasCobrar lvcuentasCobrar;
	private LVCuentasPagar lvcuentasPagar;
	private Usuario usuarioActual;
	
	
	public LVContador(JFrame padre){
		super();
		lva = new LVAranceles(padre);
		facturacion = new LVFacturacion(padre);	// Facturacion
		fsalida = new LVFacturacionSalida(padre);
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
		lvcuentasCobrar = new LVCuentasCobrar(padre);
		lvcuentasPagar = new LVCuentasPagar(padre);
	}
	public void init(String usuario,JLabel jlnu){
		lva.init(false);
		facturacion.setUsuarioActual(usuarioActual);
		facturacion.init(false); // Facturacion
		fsalida.init(false);
		lvc.init(false);
		lvi.init();
		lvm.init(false);
		lvca.init(false);
		lvp.init(false);
		lvpe.init(false);
		lvma.init(false);
		lvb.init(false);
		lvpa.init(false);
		lvu.init(usuario);
		lvmc.init(usuario, jlnu);
		lvprof.init(false);
		lvinv.init(false);
		lvemp.init(false);
		lvcuentasCobrar.init(false);
		lvcuentasPagar.init(false);
		
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		this.addTab("FacturaciónEntrada", null, facturacion, "Realizar un Recibo de Entrada");
		this.addTab("FacturacionSalida", null, fsalida, "Realizar un Recibo de Salida");
		this.addTab("Cuentas Por Cobrar", null, lvcuentasCobrar, "Lista Las Cuntas Por Cobrar");
		this.addTab("Cuentas Por Pagar", null, lvcuentasPagar, "Lista Las Cuentas Por Pagar");
		this.addTab("Empleados", null, lvemp, "Ingresa, modifica y busca Empleados");
		this.addTab("Aranceles", null, lva, "Ingresa, modifica y busca Aranceles");
		this.addTab("Inventario", null, lvinv, "Ingresa, modifica y busca Articulos a un Inventario");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
		
	}
	
	public void setUsuarioActual(Usuario usuario){
		usuarioActual = usuario;
	}
	
	public Usuario getUsuarioActual(){
		return usuarioActual;
	}
}
