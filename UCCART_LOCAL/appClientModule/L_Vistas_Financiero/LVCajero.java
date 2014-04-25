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
public class LVCajero extends JTabbedPane {
	
	private LVFacturacion facturacion; // Facturacion
	private LVFacturacionSalida fsalida;
	private LVMiCuenta lvmc;
	private LVCuentasCobrar lvcuentasCobrar;
	private LVCuentasPagar lvcuentasPagar;
	
	
	public LVCajero(JFrame padre){
		super();
		facturacion = new LVFacturacion(padre);	// Facturacion
		fsalida = new LVFacturacionSalida(padre);
		lvmc = new LVMiCuenta();
		lvcuentasCobrar = new LVCuentasCobrar(padre);
		lvcuentasPagar = new LVCuentasPagar(padre);
	}
	public void init(String usuario,JLabel jlnu){

		facturacion.init(false); // Facturacion
		fsalida.init(false);
		lvmc.init(usuario, jlnu);
		lvcuentasCobrar.init(false);
		lvcuentasPagar.init(false);
		
		Font fo = new Font("Helvetica", 1, 16);
		this.setFont(fo);
		this.addTab("FacturaciónEntrada", null, facturacion, "Realizar un Recibo de Entrada");
		this.addTab("FacturacionSalida", null, fsalida, "Realizar un Recibo de Salida");
		this.addTab("Cuentas Por Cobrar", null, lvcuentasCobrar, "Lista Las Cuntas Por Cobrar");
		this.addTab("Cuentas Por Pagar", null, lvcuentasPagar, "Lista Las Cuentas Por Pagar");
		this.addTab("Mi Cuenta", null, lvmc, "Modificar información personal");
		
	}
}
