package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import model.Arancel;
import model.MetodoDePago;
import beans.B_Arancel;
import beans.B_MetodoDePago;
import L_Vistas.FileChooser;
import L_Vistas.LVPanel;
import L_Vistas_Academico.LVMIngresar;
import L_Vistas_Academico.LVPIngresar;
import L_Vistas_Academico.LVPModificar;
//imports
import JSuggestField.JSuggestField;
import model.Estudiante;
import beans.B_Estudiante;
import model.Profesor;
import beans.B_Profesor;
import model.Empleado;
import beans.B_Empleado;

@SuppressWarnings("all")
public class LVFacturacionSalida extends LVPanel {

	private JSuggestField clienteSuggestField;
	private JComboBox metodoDePagoComboBox;

	private JPanel clientePanel;
	private JLabel clienteIdLabel;
	private JLabel clienteNombreLabel;
	private JLabel clienteTipoLabel;

	private JPanel cuentasPorCobrarPanel;
	private JLabel cuentasPorCobrarLabel;
	private JTable cuentasPorCobrarTable;

	private JPanel arancelPanel;
	private JSuggestField arancelSuggestField;
	private JFormattedTextField arancelCantidadTextField;
	private JLabel arancelTotalLabel;
	private JButton arancelAgregarButton;

	private JPanel detallePanel;
	private JTable detalleTable;
	private JLabel granTotalLabel;

	private JButton limpiarButton;
	private JButton facturarButton;

	public LVFacturacionSalida(JFrame padre){
		super();
		// SuggestField con clientes
		clienteSuggestField = getClienteSuggestField(padre);

		//JComboBox con metodos de pago
		Vector<String> metodosDePago = getListaDeMetodosDePago();
		metodoDePagoComboBox = new JComboBox(metodosDePago);
		metodoDePagoComboBox.setSelectedIndex(0); // seleccionar contado por defecto.

		//JPanel con los datos del cliente seleccionado en clienteSuggestField 
		clientePanel = getPanelCliente(padre);

		//JPanel con las cuentas por cobrar del cliente seleccionado
		cuentasPorCobrarPanel = getPanelCuenta(padre);

		//JPanel con las opciones insercion de lineas de detalle a la factura
		arancelPanel = getArancelPanel(padre);

		// JPanel con las lineas de detalle de la factura
		detallePanel = getPanelDetalle(padre);

		limpiarButton = new JButton("limpiar");

		facturarButton = new JButton("Facturar");

	}

	public void init(boolean bandera){

		//Layout
		GroupLayout groupLayout = new GroupLayout(this);
		this.setLayout(groupLayout);

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(clienteSuggestField)
						.addComponent(metodoDePagoComboBox))
				.addGroup(groupLayout.createSequentialGroup()
								.addComponent(clientePanel)
								.addComponent(cuentasPorCobrarPanel))
				.addGroup(groupLayout.createSequentialGroup()
								.addComponent(arancelPanel))
				.addGroup(groupLayout.createSequentialGroup()
								.addComponent(detallePanel))
				.addGroup(groupLayout.createSequentialGroup()
								.addComponent(limpiarButton)
								.addComponent(facturarButton))

				);

		groupLayout.setVerticalGroup(
				groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(clienteSuggestField)
						.addComponent(metodoDePagoComboBox))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(clientePanel)
						.addComponent(cuentasPorCobrarPanel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(arancelPanel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(detallePanel))
				.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(limpiarButton)
						.addComponent(facturarButton))
				);

	}

	public void reducir(){

	}

	// :::::::::::::::: Metodos privados ::::::::::::::::

	private JSuggestField getClienteSuggestField(JFrame padre){
		Vector<String> clientes = getListaDeProfesores();
		Vector<String> empleados = getListaDeEmpleados();
		JSuggestField suggestField = new JSuggestField (padre, clientes);
		//JSuggestField suggestField1 = new JSuggestField (padre, empleados);
		suggestField.setHint("Seleccione un cliente");
		suggestField.setText("Seleccione un cliente");
		suggestField.setPreferredSize(new Dimension (300,50));
		suggestField.setPreferredSuggestSize(new Dimension (300,50));

		suggestField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(((JSuggestField) e.getComponent()).getLastChosenExistingVariable() != null){

					String[] info = ((JSuggestField) e.getComponent()).getLastChosenExistingVariable().split("\\|");
					String tipo = info[0].trim();
					String id = info[1].trim();
					switch (tipo){
					case "P":
						Profesor profesor = getProfesor(id);
						//Estudiante estudiante = getEstudiante(id);
						clienteIdLabel.setText(profesor.getProfId());
						clienteNombreLabel.setText(profesor.getProfNombre() + " " + profesor.getProfApellido1() + " " + profesor.getProfApellido2());
						clienteTipoLabel.setText("Profesor");
						break;
					case "F":
						Empleado empleado = getEmpleado(id);
						//Estudiante estudiante = getEstudiante(id);
						clienteIdLabel.setText(empleado.getEmpleadoId());
						clienteNombreLabel.setText(empleado.getEmpleadoNombre() + " " + empleado.getEmpleadosApellido1() + " " + empleado.getEmpleadosApellido2());
						clienteTipoLabel.setText("Funcionarios");
						break;
					default:
						clienteIdLabel.setText("[" + id + "] no se encuentra en el sistema" );
						clienteNombreLabel.setText("Sin nombre para [" + id + "]");
						clienteTipoLabel.setText("Sin tipo para [" + id + "]");
						break;
					}
				}
			}
		});

		return suggestField;
	}


	/*
	 * Construye y devuelve el panel del cliente
	 */
	private JPanel getPanelCliente(JFrame padre){
		JPanel panel = new JPanel();
		panel.setFont(fo.deriveFont((float)16));
		panel.setBorder(BorderFactory.createTitledBorder("Información del Cliente"));
		panel.setPreferredSize(new Dimension(400, 200));

		JLabel nombreLabel = new JLabel("Nombre:");
		JLabel idLabel = new JLabel("Identificación:");
		JLabel tipoLabel = new JLabel("Tipo De Cliente:");

		clienteNombreLabel = new JLabel();
		clienteIdLabel = new JLabel();
		clienteTipoLabel = new JLabel();

		//Layout
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);

		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(nombreLabel)
						.addComponent(idLabel)
						.addComponent(tipoLabel))
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(clienteNombreLabel)
						.addComponent(clienteIdLabel)
						.addComponent(clienteTipoLabel))
				);

		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(nombreLabel)
						.addComponent(clienteNombreLabel))
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(clienteIdLabel))
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tipoLabel)
						.addComponent(clienteTipoLabel))
				);

		return panel;
	}

	/*
	 * Construye y devuelve el panel del detalle de las cuentas por cobrar
	 */
	private JPanel getPanelCuenta(JFrame padre){
		JPanel panel = new JPanel();
		panel.setFont(fo.deriveFont((float)16));
		panel.setBorder(BorderFactory.createTitledBorder("Cuentas por Cobrar"));
		panel.setPreferredSize(new Dimension(300,300));

		cuentasPorCobrarLabel = new JLabel("");

		String[] encabezados = {"factura","monto", "vencimiento"};
		DefaultTableModel model = new DefaultTableModel(encabezados, 5);
		cuentasPorCobrarTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(cuentasPorCobrarTable);

		//Layout
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);

		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(cuentasPorCobrarLabel)
						.addComponent(scrollPane)
				);

		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
						.addComponent(cuentasPorCobrarLabel)
						.addComponent(scrollPane)
				);

		return panel;
	}

	private JSuggestField getArancelSuggestField(JFrame padre){
		Vector<String> clientes = getListaDeAranceles();
		JSuggestField suggestField = new JSuggestField (padre, clientes);

		suggestField.setPreferredSize(new Dimension (300,50));
		suggestField.setPreferredSuggestSize(new Dimension (300,50));
		suggestField.setHint("Seleccione un arancél");
		suggestField.setText("Seleccione un arancél");

		suggestField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//
			}

			@Override
			public void focusLost(FocusEvent e) {
				//
			}

		});

		return suggestField;
	}

	private JPanel getArancelPanel(JFrame padre){
		JPanel panel = new JPanel();
		panel.setFont(fo.deriveFont((float)16));
		panel.setBorder(BorderFactory.createTitledBorder("Seleccione el arancél a facturar"));

		arancelSuggestField = getArancelSuggestField(padre);

		NumberFormat integerFieldFormatter;
		integerFieldFormatter = NumberFormat.getIntegerInstance();
		integerFieldFormatter.setMaximumFractionDigits(0);

		arancelCantidadTextField = new JFormattedTextField(integerFieldFormatter );
		//arancelCantidadTextField.setColumns(5);
		arancelCantidadTextField.setPreferredSize(new Dimension (100,50));
		arancelCantidadTextField.setText("Digíte la cantidad");

		arancelTotalLabel = new JLabel("₡ 0");
		arancelTotalLabel.setPreferredSize(new Dimension (100,50));

		arancelAgregarButton = new JButton("Agregar linea");

		//Layout
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);

		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(arancelSuggestField)
						)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(arancelCantidadTextField)
								)
								.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(arancelTotalLabel)
										)
										.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(arancelAgregarButton)
												)
				);

		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(arancelSuggestField)
						.addComponent(arancelCantidadTextField)
						.addComponent(arancelTotalLabel)
						.addComponent(arancelAgregarButton)
						)
				);

		return panel;



	}

	/*
	 * Construye y devuelve el panel de las lineas de detalle
	 */
	private JPanel getPanelDetalle(JFrame padre){
		JPanel panel = new JPanel();
		panel.setFont(fo.deriveFont((float)16));
		panel.setBorder(BorderFactory.createTitledBorder("Detalle de la Factura"));

		String [] encabezado = {"Codigo","Descripción","Precio Unitario", "Cantidad", "Total"};
		DefaultTableModel model = new DefaultTableModel(encabezado, 8) ;
		detalleTable = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(detalleTable);

		granTotalLabel = new JLabel("₡ 0");

		//Install the custom editor on the first column
		//TableColumn columna = tablaDetalle.getColumnModel().getColumn(0);
		//columna.setCellEditor(new DetalleCellEditor(padre));
		//columna.setPreferredWidth(300);

		//Layout
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);

		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(scrollpane)
						)
						.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(granTotalLabel)
								)
				);

		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(scrollpane)
						.addComponent(granTotalLabel)
						)
				);

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
	
	
	private Vector<String> getListaDeEmpleados(){
		B_Empleado bean= new B_Empleado();
		List<Empleado> lista = bean.selectAll();
		Vector<String> vector = new Vector<String>();

		for(int i=0;i<lista.size();i++){
			vector.add("P | " + lista.get(i).getEmpleadoNombre() + "\t | " + lista.get(i).getEmpleadosApellido1() + " " + lista.get(i).getEmpleadosApellido2());
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

	/*
	 * Devuelve un Vector<String> con la informacion de los metodos de pago 
	 */
	private Vector<String> getListaDeMetodosDePago(){
		B_MetodoDePago bean= new B_MetodoDePago();
		List<MetodoDePago> lista = bean.selectAll();
		Vector<String> vector = new Vector<String>();

		for(int i=0;i<lista.size();i++){
			vector.add(lista.get(i).getMetodo());
		}

		return vector;
	}

	/*
	 * Devuelve un Vector<String> con la informacion de los aranceles 
	 * con el formato id | descripcion | precio
	 */
	private Vector<String> getListaDeAranceles(){
		B_Arancel bean= new B_Arancel();
		List<Arancel> lista = bean.selectAll();
		Vector<String> vector = new Vector<String>();

		for(int i=0;i<lista.size();i++){
			vector.add(lista.get(i).getArancelId() + "\t | " +lista.get(i).getArancelDescripcion() + "\t | ₡ " + lista.get(i).getArancelPrecio());
		}

		return vector;
	}

	private void cargarCuentasPorCobrar(Estudiante e){
		if (e != null){
			System.out.println("Cargando cxc de " + e.getEstNombre() + " " + e.getEstApellido1());
		}
	}

	private Estudiante getEstudiante(String id){
		B_Estudiante bean = new B_Estudiante();
		bean.find(id);
		Estudiante e = bean.getEstudiante();
		return e;
	}
	
	private Profesor getProfesor(String id){
		B_Profesor bean = new B_Profesor();
		bean.find(id);
		Profesor e = bean.getProfesor();
		return e;
	}
	
	private Empleado getEmpleado(String id){
		B_Empleado bean = new B_Empleado();
		bean.find(id);
		Empleado e = bean.getEmpleado();
		return e;
	}

	//////////////////////////////////// Clase DetalleCellEditor ////////////////////////////////////

	class DetalleCellEditor extends AbstractCellEditor implements TableCellEditor {

		private static final long serialVersionUID = 1L;

		// This is the component that will handle the editing of the cell value
		JComponent component;
		Vector<String> aranceles = getListaDeAranceles();

		public DetalleCellEditor(JFrame padre){

			component = new JSuggestField(padre,aranceles);
			component.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					System.out.println("focusGained: " + e);
				}

				@Override
				public void focusLost(FocusEvent e) {
					System.out.println("focusLost: " + e);

					if (((JSuggestField) component).getLastChosenExistingVariable() != null){ // Si hay algun valor seleccionado

						String[] info = ((JSuggestField) component).getLastChosenExistingVariable().split("\\|");

						//valorClienteTipo.setText(getNombreLargoDeTipoDeCliente(info[0].charAt(0)));
						//valorClienteId.setText(info[1].trim());
						//valorClienteNombre.setText(info[2].trim());
						String codigo = info[0].trim();
						String descripcion = info[1].trim();
						String precio = info[2].trim().replace("₡", "");

						System.out.println(codigo);
						System.out.println(descripcion);
						System.out.println(precio);

						Object source = e.getSource();
						((JSuggestField) source).setText("Hola Mundo");
						System.out.println("event: " + e);
						System.out.println("source: " + e.getSource());
						//System.out.println("event: " + e.super);
						//actualizarTabla();
					}else{

					}


				}
			});

		}

		// This method is called when a cell value is edited by the user.
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
			// 'value' is value contained in the cell located at (rowIndex, vColIndex)
			System.out.println("getTableCellEditorComponent");

			if (isSelected) {
				// cell (and perhaps other cells) are selected
				System.out.println("isSelected");
			}

			// Configure the component with the specified value
			((JSuggestField)component).setText((String)value);

			// Return the configured component
			return component;
		}

		// This method is called when editing is completed.
		// It must return the new value to be stored in the cell.
		public Object getCellEditorValue() {
			System.out.println("getCellEditorValue");
			return ((JTextField)component).getText();
		}


	}

	//////////////////////////////////// Fin de Clase DetalleCellEditor ////////////////////////////////////
}




