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
import model.CuentasPorCobrar;
import model.DetalleFacturaEntrada;
import model.FacturaEntrada;
import model.MetodoDePago;
import model.Usuario;
import beans.B_Arancel;
import beans.B_CuentasPorCobrar;
import beans.B_DetalleFacturaEntrada;
import beans.B_FacturaEntrada;
import beans.B_MetodoDePago;
import beans.B_Usuario;
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

@SuppressWarnings("all")
public class LVFacturacion extends LVPanel {

	private JSuggestField clienteSuggestField;
	private JComboBox metodoDePagoComboBox;

	private JPanel clientePanel;
	private JLabel clienteIdLabel;
	private JLabel clienteNombreLabel;
	private JLabel clienteTipoLabel;

	private JPanel cuentasPorCobrarPanel;
	private JLabel cuentasPorCobrarLabel;
	private DefaultTableModel cuentasPorCobrarTableModel;

	private JPanel arancelPanel;
	private JSuggestField arancelSuggestField;
	private JFormattedTextField arancelCantidadTextField;
	private JLabel arancelTotalLabel;
	private JButton arancelAgregarButton;

	private JPanel detallePanel;
	private DefaultTableModel detalleTableModel;
	private JLabel granTotalLabel;

	private JButton limpiarButton;
	private JButton facturarButton;
	
	private Usuario usuarioActual;

	public LVFacturacion(JFrame padre){
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
		limpiarButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e){
            	LimpiarFormulario();
            	arancelSuggestField.setSuggestData(getListaDeAranceles());
            	
            }
            });

		facturarButton = new JButton("Facturar");
		facturarButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e){
            	facturar();
            	LimpiarFormulario();
            	
            }
            });

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
	
	public void setUsuarioActual(Usuario usuario){
		usuarioActual = usuario;
	}
	
	public Usuario getUsuarioActual(){
		return usuarioActual;
	}

	public void reducir(){

	}

	// :::::::::::::::: Metodos privados ::::::::::::::::

	private JSuggestField getClienteSuggestField(JFrame padre){
		Vector<String> clientes = getListaDeEstudiantes();
		JSuggestField suggestField = new JSuggestField (padre, clientes);
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
					case "E":
						Estudiante estudiante = getEstudiante(id);
						clienteIdLabel.setText(estudiante.getEstId());
						clienteNombreLabel.setText(estudiante.getEstNombre() + " " + estudiante.getEstApellido1() + " " + estudiante.getEstApellido2());
						clienteTipoLabel.setText("Estudiante");
						break;
					default:
						clienteIdLabel.setText("[" + id + "] no se encuentra en el sistema" );
						clienteNombreLabel.setText("Sin nombre para [" + id + "]");
						clienteTipoLabel.setText("Sin tipo para [" + id + "]");
						break;
					}
					
					cargarCuentasPorCobrar(id);
				}
			}
		});

		return suggestField;
	}
	
	/* 
	 * Actualiza la vista de cuentas por cobrar con las cuentas por cobrar del estudiante cuyo id se recibe como parametro
	 */
	private void cargarCuentasPorCobrar(String id){
		Estudiante e = getEstudiante(id);
		B_Estudiante bean = new B_Estudiante();
		List<FacturaEntrada> listFacturas = bean.getFacturaEntrada(e.getEstId());
		
		limpiarTableModel(cuentasPorCobrarTableModel);
		
		for(int i=0;i<listFacturas.size();i++){
	    	
			String[] fila = {listFacturas.get(i).getFacturas_entrada_id(), listFacturas.get(i).getFacturas_entrada_id_estudiante(), listFacturas.get(i).getFacturas_entrada_nombre(),
					listFacturas.get(i).getDetalleFacturaEntrada().getDescripcion() ,listFacturas.get(i).getCuentasPorCobrar().getCuentascobrar_saldo().toString()};
			cuentasPorCobrarTableModel.addRow(fila);
		}
		
	}
	
	private void limpiarTableModel(DefaultTableModel tableModel){
		while(tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
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

		String[] encabezados = {"N.Factura","Identificación", "Nombre", "Detalle", "Monto"};
		cuentasPorCobrarTableModel = new DefaultTableModel(encabezados, 0);
		JTable cuentasPorCobrarTable = new JTable(cuentasPorCobrarTableModel){
									public boolean isCellEditable(int rowIndex, int colIndex) {
											return false;
											}
									};
		
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
		arancelAgregarButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e){

				try{
					String[] info = arancelSuggestField.getLastChosenExistingVariable().split("\\|");
					String id = info[0].trim(); // id del arancel
					String precio = info[2].trim().replace("₡", "").trim(); // precio unitario del arancel
					
					double precioUnitario = Double.parseDouble(precio);
					int cantidad = Integer.parseInt(arancelCantidadTextField.getText());
					double total = precioUnitario * cantidad;
					System.out.println(id + " " + info[1].trim() + " " + precioUnitario + " " + cantidad + " " + total);
					String[] fila = {id, info[1].trim(), String.valueOf(precioUnitario), String.valueOf(cantidad), String.valueOf(total) };
					
					if (cantidad > 0 ) detalleTableModel.addRow(fila);
					
					double granTotal = 0;
					for (int i = 0; i < detalleTableModel.getRowCount(); i++){
						granTotal += Double.parseDouble(String.valueOf(detalleTableModel.getValueAt(i, detalleTableModel.getColumnCount() - 1)));
					}
					
					granTotalLabel.setText("₡ " + String.valueOf(granTotal));
					arancelSuggestField.clearLastChosenExistingVariable();
					arancelSuggestField.setText(arancelSuggestField.getHint());
					
				
					
				}catch(NullPointerException exception){
					System.out.println("Error!! -> " + exception + " | Seleccione un arancél");
				}
				catch(NumberFormatException exception){
					System.out.println("Error!! -> " + exception + " | Digite una cantidad valida");
				}
				catch(Exception exception){
					System.out.println("Error!! -> " + exception);
					//System.out.println("Error!! [" + precio + "] no es un valor valido para el precio unitario");
				}
				
				
				System.out.println("You clicked the button");
            }
        }); 

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

	/**
	 * Construye y devuelve el panel de las lineas de detalle
	 */
	private JPanel getPanelDetalle(JFrame padre){
		JPanel panel = new JPanel();
		panel.setFont(fo.deriveFont((float)16));
		panel.setBorder(BorderFactory.createTitledBorder("Detalle de la Factura"));

		String [] encabezado = {"Codigo","Descripción","Precio Unitario", "Cantidad", "Total"};
		detalleTableModel = new DefaultTableModel(encabezado, 0) ;
		JTable detalleTable = new JTable(detalleTableModel);
		JScrollPane scrollpane = new JScrollPane(detalleTable);

		granTotalLabel = new JLabel("₡ 0");
		Font newLabelFont=new Font(granTotalLabel.getFont().getName(),granTotalLabel.getFont().getStyle(),22);
		granTotalLabel.setFont(newLabelFont);

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
	
	/**
	 * Limpia el formulario
	 */
	private void LimpiarFormulario(){
    	clienteSuggestField.clearLastChosenExistingVariable();
    	clienteSuggestField.setText(clienteSuggestField.getHint());
    	metodoDePagoComboBox.setSelectedIndex(0);
    	
    	clienteIdLabel.setText("");
    	clienteNombreLabel.setText("");
    	clienteTipoLabel.setText("");
    	
    	limpiarTableModel(cuentasPorCobrarTableModel);
    	
    	arancelSuggestField.clearLastChosenExistingVariable();
    	arancelSuggestField.setText(arancelSuggestField.getHint());
    	arancelCantidadTextField.setText("Digite la cantidad");
    	arancelTotalLabel.setText("₡ 0");
    	
    	limpiarTableModel(detalleTableModel);
    	granTotalLabel.setText("₡ 0");
	}
	
	private void facturar(){
		try{
			FacturaEntrada factura = new FacturaEntrada(); // nueva factura
			
			String[] info = clienteSuggestField.getLastChosenExistingVariable().split("\\|");
			String id = info[1].trim();
			Estudiante estudiante = getEstudiante(id);

			factura.setFacturas_entrada_id(getConsecutivo());
			factura.setFacturas_entrada_id_empleado(usuarioActual.getUsId());
			factura.setFacturas_entrada_id_estudiante(estudiante.getEstId());
			factura.setFacturas_entrada_nombre(estudiante.getEstNombre() + " " + estudiante.getEstApellido1() + " " + estudiante.getEstApellido2());
			factura.setFacturas_entrada_direccion(estudiante.getEstDireccion());
			factura.setFacturas_entrada_telefono(estudiante.getEstTelefono());
			
			if (metodoDePagoComboBox.getSelectedIndex() == 0)
				factura.setFacturas_entrada_metodo_de_pago("1"); //  Método de pago de contado
			if (metodoDePagoComboBox.getSelectedIndex() == 1)
				factura.setFacturas_entrada_metodo_de_pago("2"); //  Método de pago de credito
			
			factura.setfacturas_entrada_total(Float.parseFloat(granTotalLabel.getText().replace("₡", "").trim()));
			
			System.out.println(factura);
			B_FacturaEntrada bean = new B_FacturaEntrada();
			bean.setFactura(factura);
			bean.insert();
			
			// insertar lineas de detalle
			
			B_DetalleFacturaEntrada beanDetalle= new B_DetalleFacturaEntrada();
			List<DetalleFacturaEntrada> lista = beanDetalle.selectAll();
			int consecutivo = getConsecutivoDetalle();
			
			for (int i = 0; i < detalleTableModel.getRowCount(); i++){
				DetalleFacturaEntrada linea = new DetalleFacturaEntrada();
				
				linea.setId_detalle_factura(String.valueOf(consecutivo++));
				linea.setId_facturaEntrada(factura.getFacturas_entrada_id());
				linea.setIdArancel(String.valueOf(detalleTableModel.getValueAt(i, 0)));
				linea.setDescripcion(String.valueOf(detalleTableModel.getValueAt(i, 1)));
				linea.setNumeroLinea(i+1);
				linea.setPrecioUnitario(Float.parseFloat(String.valueOf(detalleTableModel.getValueAt(i, 2)).replace("₡", "").trim()));
				linea.setDescripcionDescuento("Sin descuento");
				linea.setTotalBruto(Float.parseFloat(String.valueOf(detalleTableModel.getValueAt(i, 4)).replace("₡", "").trim()));
				linea.setSubTotal(Float.parseFloat(String.valueOf(detalleTableModel.getValueAt(i, 4)).replace("₡", "").trim()));
				linea.setCantidad(Integer.parseInt(String.valueOf(detalleTableModel.getValueAt(i, 3))));
				
				System.out.println(linea);
				
				B_DetalleFacturaEntrada b = new B_DetalleFacturaEntrada();
				b.setDetalleFacturaEntrada(linea);
				b.insert();
				
			}
			
			if (metodoDePagoComboBox.getSelectedIndex() == 1){
				factura.setFacturas_entrada_metodo_de_pago("2"); //  Método de pago de credito
				int c = getConsecutivoCuentasPorCobrar();
				for (int i = 0; i<3; i++){
					CuentasPorCobrar cuenta = new CuentasPorCobrar();
					cuenta.setCuentascobrar_id(String.valueOf(c++));
					cuenta.setCuentascobrar_id_factura_entrada(factura.getFacturas_entrada_id());
					cuenta.setCuentascobrar_saldo(Float.parseFloat(granTotalLabel.getText().replace("₡", "").trim()) / 3);
					
					B_CuentasPorCobrar b = new B_CuentasPorCobrar();
					b.setCuentasPorCobrar(cuenta);
					b.insert();
				}
				
				// generar las cuentas por pagar
			}
			
			
			System.out.println("Factura insertada :");
	
		}catch(Exception exception){
			System.out.println("Error!! -> " + exception);
		}
		
	}
	
	private String getConsecutivo(){
		B_FacturaEntrada bean= new B_FacturaEntrada();
		List<FacturaEntrada> lista = bean.selectAll();
		int mayor = 0;
		for (int i = 0; i< lista.size(); i++){
			int consecutivo = Integer.parseInt(lista.get(i).getFacturas_entrada_id());
			if (consecutivo > mayor)
				mayor = consecutivo;
		}
		return String.valueOf(mayor + 1);
	}
	
	private int getConsecutivoDetalle(){
		B_DetalleFacturaEntrada bean= new B_DetalleFacturaEntrada();
		List<DetalleFacturaEntrada> lista = bean.selectAll();
		int mayor = 0;
		for (int i = 0; i< lista.size(); i++){
			int consecutivo = Integer.parseInt(lista.get(i).getId_detalle_factura());
			if (consecutivo > mayor)
				mayor = consecutivo;
		}
		return mayor + 1;
	}
	
	private int getConsecutivoCuentasPorCobrar(){
		B_CuentasPorCobrar bean= new B_CuentasPorCobrar();
		List<CuentasPorCobrar> lista = bean.selectAll();
		int mayor = 0;
		for (int i = 0; i< lista.size(); i++){
			int consecutivo = Integer.parseInt(lista.get(i).getCuentascobrar_id());
			if (consecutivo > mayor)
				mayor = consecutivo;
		}
		return mayor + 1;
	}

	/**
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

	/**
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

	/**
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

	/**
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


	/**
	 * Devuelve el estudiante cuyo id se recibe como parametro
	 * @param id La identificación del estudiante a carga
	 * @return El estudiante correspodiente al id
	 */
	private Estudiante getEstudiante(String id){
		B_Estudiante bean = new B_Estudiante();
		bean.find(id);
		Estudiante e = bean.getEstudiante();
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




