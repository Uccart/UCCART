package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Arancel;
import beans.B_Arancel;
import L_Vistas.FileChooser;
import L_Vistas.LVPanel;
import L_Vistas_Academico.LVMIngresar;
import L_Vistas_Academico.LVPIngresar;
import L_Vistas_Academico.LVPModificar;
//imports
import ch.rakudave.suggest.JSuggestField;
import model.Estudiante;
import beans.B_Estudiante;
import model.Profesor;
import beans.B_Profesor;

@SuppressWarnings("all")
public class LVFacturacion extends LVPanel {
	
	private JPanel panelCliente;
	private JSuggestField identificacionCliente;
	private JSuggestField metodo_de_pago;
	private JLabel valorClienteId;
	private JLabel valorClienteNombre;
	private JLabel valorClienteTipo;
	
	private JPanel panelCuentasPorCobrar;
	private JTable tablaCuentasPorCobrar;
	
	private JPanel panelDetalle;
	private JTable tablaDetalle;
	
	public LVFacturacion(JFrame padre){
		super();
		panelCliente = getPanelCliente(padre);
		panelCuentasPorCobrar = getPanelCuenta(padre);
		panelDetalle = getPanelDetalle(padre);
	}

	public void init(boolean bandera){
		
		//Layout
		GroupLayout groupLayout = new GroupLayout(this);
		this.setLayout(groupLayout);

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		groupLayout.setHorizontalGroup(
		groupLayout.createSequentialGroup()
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelCliente)
				.addComponent(panelDetalle)
			)
			.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelCuentasPorCobrar)
			)
		);

		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(panelCliente)
					.addComponent(panelCuentasPorCobrar)
				)
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					 .addComponent(panelDetalle)
				)
			);

		//this.add(panelCliente, BorderLayout.CENTER);
		//this.add(panelCuentasPorCobrar, BorderLayout.CENTER);
		//this.add(panelDetalle, BorderLayout.CENTER);
	}
	
	public void reducir(){

	}
	
	// :::::::::::::::: Metodos privados ::::::::::::::::
	
	/*
	 * Construye y devuelve el panel del cliente
	 */
	 private JPanel getPanelCliente(JFrame padre){
	    	JPanel panelCliente = new JPanel();
			panelCliente.setFont(fo.deriveFont((float)16));
			panelCliente.setBorder(BorderFactory.createTitledBorder("Información del Cliente"));
			
			Vector<String> clientes = getListaDeEstudiantes();
	    	
			JLabel etiquetaCliente = new JLabel("Cliente:");
			JLabel etiquetaClienteId = new JLabel("Identificación:");
			JLabel etiquetaClienteNombre = new JLabel("Nombre:");
			JLabel etiquetaClienteTipo = new JLabel("Tipo De Cliente:");
			
			valorClienteId = new JLabel();
			valorClienteNombre = new JLabel();
			valorClienteTipo = new JLabel();
			identificacionCliente = new JSuggestField (padre, clientes);
			
			identificacionCliente.setPreferredSize(new Dimension (350,50));
			identificacionCliente.setPreferredSuggestSize(new Dimension (350,50));
			identificacionCliente.setHint("Seleccione un cliente");
			identificacionCliente.addFocusListener(new FocusListener() {

	            @Override
	            public void focusGained(FocusEvent e) {
	            	//
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	            	String[] info = identificacionCliente.getLastChosenExistingVariable().split("\\|");
	            	System.out.println(identificacionCliente.getLastChosenExistingVariable());
	            	System.out.println(info[0].trim());
	            	System.out.println(info[1].trim());
	            	System.out.println(info[2].trim());
	            	valorClienteTipo.setText(getNombreLargoDeTipoDeCliente(info[0].charAt(0)));
	            	valorClienteId.setText(info[1].trim());
	            	valorClienteNombre.setText(info[2].trim());
	                
	                identificacionCliente.setText("");
	            }
	        });
			
			//Layout
			GroupLayout panelClienteLayout = new GroupLayout(panelCliente);
			panelCliente.setLayout(panelClienteLayout);

			panelClienteLayout.setAutoCreateGaps(true);
			panelClienteLayout.setAutoCreateContainerGaps(true);

			panelClienteLayout.setHorizontalGroup(
				panelClienteLayout.createSequentialGroup()
					.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(etiquetaCliente)
					.addComponent(etiquetaClienteTipo)
					.addComponent(etiquetaClienteId)
					.addComponent(etiquetaClienteNombre)
				)
					.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(identificacionCliente)
					.addComponent(valorClienteTipo)
					.addComponent(valorClienteId)
					.addComponent(valorClienteNombre)
				)
			);

			panelClienteLayout.setVerticalGroup(
				panelClienteLayout.createSequentialGroup()
				.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(etiquetaCliente)
					.addComponent(identificacionCliente)
				)
				.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(etiquetaClienteTipo)
					.addComponent(valorClienteTipo)
				)
				.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(etiquetaClienteId)
					.addComponent(valorClienteId)
				)
				.addGroup(panelClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(etiquetaClienteNombre)
					.addComponent(valorClienteNombre)
				)
			);

			return panelCliente;
	 }

	 /*
	  * Construye y devuelve el panel del detalle de la factura
	  */
	 private JPanel getPanelCuenta(JFrame padre){
		 JPanel panelCuenta = new JPanel();
		 panelCuenta.setFont(fo.deriveFont((float)16));
		 panelCuenta.setBorder(BorderFactory.createTitledBorder("Cuentas por Cobrar"));
		 
		 JLabel contenido = new JLabel("contenido");
		 
		 String[] colHeadings = {"factura","monto", "vencimiento"};
		 int numRows = 5 ;
		 DefaultTableModel model = new DefaultTableModel(numRows, colHeadings.length) ;
		 model.setColumnIdentifiers(colHeadings);
		 tablaCuentasPorCobrar = new JTable(model);
		 				
		 
		 //Layout
		 GroupLayout panelCuentaLayout = new GroupLayout(panelCuenta);
		 panelCuenta.setLayout(panelCuentaLayout);

		 panelCuentaLayout.setAutoCreateGaps(true);
		 panelCuentaLayout.setAutoCreateContainerGaps(true);

		 panelCuentaLayout.setHorizontalGroup(
				 panelCuentaLayout.createSequentialGroup()
				 .addGroup(panelCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(contenido)
						 .addComponent(tablaCuentasPorCobrar)
						 )
				 );

		 panelCuentaLayout.setVerticalGroup(
				 panelCuentaLayout.createSequentialGroup()
				 .addGroup(panelCuentaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						 .addComponent(contenido)
						 )
						 .addGroup(panelCuentaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								 .addComponent(tablaCuentasPorCobrar)
								 )
				 );

		 return panelCuenta;
	 }
	 
	 /*
	  * Construye y devuelve el panel de las cuentas por pagar
	  */
	 private JPanel getPanelDetalle(JFrame padre){
		 JPanel panel = new JPanel();
		 panel.setFont(fo.deriveFont((float)16));
		 panel.setBorder(BorderFactory.createTitledBorder("Detalle de la Factura"));
		 
		 String[] colHeadings = {"Codigo","Descripción", "Cantidad", "Total"};
		 int numRows = 10 ;
		 DefaultTableModel model = new DefaultTableModel(numRows, colHeadings.length) ;
		 model.setColumnIdentifiers(colHeadings);
		 tablaDetalle = new JTable(model);
		 				
		 panel.add(tablaDetalle);
		 return panel;
	 }


	 /*
	  * Devuelve un Vector<String> con la informacion de los estudiantes 
	  * con el formato E | identificacion | nombre
	  */
	    private Vector<String> getListaDeEstudiantes(){
	    	B_Estudiante bean= new B_Estudiante();
	        List<Estudiante> lista = bean.selectAll();
	        Vector<String> vector = new Vector<String>();
	        
		    for(int i=0;i<lista.size();i++){
		    	vector.add("E | " + lista.get(i).getEstId() + "\t | " + lista.get(i).getEstNombre() + " " + lista.get(i).getEstApellido1());
			}
		    
		    return vector;
	    }
	    
		 /*
		  * Devuelve un Vector<String> con la informacion de los profesores 
		  * con el formato P | identificacion | nombre
		  */
	    private Vector<String> getListaDeProfesores(){
	    	B_Profesor bean= new B_Profesor();
	        List<Profesor> lista = bean.selectAll();
	        Vector<String> vector = new Vector<String>();
	        
		    for(int i=0;i<lista.size();i++){
		    	vector.add("P | " + lista.get(i).getProfId() + "\t | " + lista.get(i).getProfNombre() + " " + lista.get(i).getProfApellido1());
			}
		    
		    return vector;
	    }
	    
	    private Component getStyling(){
	    	
	    	return (new DefaultListCellRenderer() {
	    	    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    	    	String valueString = value.toString();
	    	        valueString = valueString.substring(1,1);
	    	        return super.getListCellRendererComponent(list, valueString, index, isSelected,
	    	                cellHasFocus);
	    	    }
	    	});
	    }
	    
	    /*
	     * Devuleve el nombre del tipo de cliente
	     * Ejemplo: recibe E devuleve Empleado, recibe P devuelve Profesor
	     */
	    private String getNombreLargoDeTipoDeCliente(char tipo){
	    	String t;
	    	switch(tipo){
	    	case 'E':
	    		t = "Estudiante";
	    		break;
	    	case 'P':
	    		t = "Profedor";
	    		break;
	    	case 'F':
	    		t = "Funcionario";
	    		break;
	    	default:
	    		t = "Clientes Varios";
	    		break;
	    	}
	    	return t;
	    }
}