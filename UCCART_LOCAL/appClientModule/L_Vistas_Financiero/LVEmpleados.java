package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Empleado;
import beans.B_Empleado;
import L_Vistas.FileChooser;
import L_Vistas.LVPanel;

import java.text.DateFormat;


@SuppressWarnings("all")
public class LVEmpleados extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel empleados;
	private B_Empleado bempleado;
	private JButton jbelimEm, jbrefreEm, jbmodifEm, jbinseEm;
	private JTable tableEmp;
	private final JTextField filterTextEm;
	private LVEmpIngresar lvei;
	private LVEmpModificar lvem;
	private JComboBox jcbalfab, jcbcarreras;
	private int selectal, selectcarr;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);


	public LVEmpleados(JFrame padre){
		super();
		lvei = new LVEmpIngresar(padre, true, fo);
		lvem = new LVEmpModificar(padre, true, fo);
		empleados = new DefaultTableModel();
		bempleado = new B_Empleado();
		tableEmp = new JTable(empleados){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
			filterTextEm = new JTextField(20);
			selectal = 0;
			selectcarr = 0;
	}


	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));

		jcbalfab = new JComboBox<String>();
		jcbalfab.setFont(fo);
		jcbalfab.setToolTipText("Lista de empleados por orden alfabético");
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] {  "Sin filtro", "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z" }));
		jcbalfab.setSelectedIndex(selectal);
		jcbalfab.setMaximumSize(jcbalfab.getPreferredSize() );
		panel2.add(jcbalfab);
		jcbalfab.addItemListener(this);

		panel2.add(new JLabel("  "));

		// hola
		empleados.addColumn("ID");
		empleados.addColumn("Nombre");
		empleados.addColumn("Primer Apellido");
		empleados.addColumn("Segundo Apellido");
		empleados.addColumn("Fecha De Nacimiento");
		empleados.addColumn("Telefono");
		empleados.addColumn("Celular");
		empleados.addColumn("Direccion");
		empleados.addColumn("Genero");
		empleados.addColumn("Nacionalidad");
		empleados.addColumn("Correo");
		empleados.addColumn("Salario");
		empleados.addColumn("Puesto");

		List<Empleado> listEmp = bempleado.selectAll();

		if(listEmp.size() != 0){
			listEmp = bempleado.selectXalfa(jcbalfab.getSelectedItem().toString());

			for(int i=0;i<listEmp.size();i++){
				String[] fila = {listEmp.get(i).getEmpleadoId().toString(), listEmp.get(i).getEmpleadoNombre(), listEmp.get(i).getEmpleadosApellido1(), listEmp.get(i).getEmpleadosApellido2(), dateFormat.format(listEmp.get(i).getEmpleadosFechaN()),  
						listEmp.get(i).getEmpleadosTelefonoCasa(), listEmp.get(i).getEmpleadosTelefonoCel(), listEmp.get(i).getEmpleadosDireccion(), listEmp.get(i).getEmpleadosGenero(), listEmp.get(i).getEmpleadosNacionalidad(), listEmp.get(i).getEmpleadosCorreo(),	String.valueOf(listEmp.get(i).getEmpleadosSalario()), listEmp.get(i).getEmpleadosPuesto()};
				empleados.addRow(fila);
			}
		}

		this.buildTabla(empleados, tableEmp, filterTextEm);

		filterTextEm.setAlignmentX(CENTER_ALIGNMENT);
		filterTextEm.setSize(10, 5);
		filterTextEm.setFont(fo);
		filterTextEm.setMaximumSize(filterTextEm.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreEm = new JButton(imagen);
		jbrefreEm.addActionListener(this);
		jbrefreEm.setToolTipText("Actualizar tabla!");
		jbrefreEm.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreEm, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Empleado:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextEm, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));

		jbinseEm = new JButton("Ingresar");
		jbinseEm.addActionListener(this);
		jbinseEm.setFont(fo);
		jbinseEm.setToolTipText("Ingresar un nuevo Empleado!");
		jbinseEm.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseEm, BorderLayout.CENTER);

		jbmodifEm = new JButton("Modificar");
		jbmodifEm.addActionListener(this);
		jbmodifEm.setFont(fo);
		jbmodifEm.setToolTipText("Modificar Empleado seleccionado!");
		jbmodifEm.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifEm, BorderLayout.CENTER);

		jbelimEm = new JButton("Eliminar");
		jbelimEm.addActionListener(this);
		jbelimEm.setFont(fo);
		jbelimEm.setToolTipText("Eliminar Empleado seleccionado!");
		jbelimEm.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimEm, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableEmp));
	}
	public void reducir(){
		jbelimEm.setVisible(false);
	}

///////////////////////////////////////////////////////////////

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/////////EVENTO PARA EL BOTON ELIMINAR////////////
		
				if(e.getSource() == jbelimEm) {
					if(tableEmp.getSelectedRowCount() == 1){
						if(bempleado.find(  (String)tableEmp.getValueAt(tableEmp.getSelectedRow(), 0))){
							if(bempleado.delete()){
								JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							}else
								JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Empleado no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 empleado", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
/////////EVENTO PARA EL BOTON INSERTAR////////////	
					
				}else{
					if(e.getSource() == jbinseEm) {
						lvei = new LVEmpIngresar((JFrame)lvei.getParent(), true, fo);
						lvei.init();
						lvei.setLocationRelativeTo(jbinseEm.getParent());
						lvei.setVisible(true);
						
						
					} 
					
					
/////////EVENTO PARA EL BOTON MODIFICAR////////////			
						
				else{
							if(e.getSource() == jbmodifEm) {
								if(tableEmp.getSelectedRowCount() == 1){
									if(bempleado.find((String)tableEmp.getValueAt(tableEmp.getSelectedRow(), 0))){
										lvem = new LVEmpModificar((JFrame)lvem.getParent(), true, fo);
										lvem.init(bempleado);
										lvem.setLocationRelativeTo(lvem.getParent());
										lvem.setVisible(true);
									}else{
										JOptionPane.showMessageDialog(null, "Empleado no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}else{
									JOptionPane.showMessageDialog(null, "Debe seleccionar 1 empleado", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
				}
				
				
				this.removeAll();
				empleados = new DefaultTableModel();
				tableEmp = new JTable(empleados){public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;}};
				this.init(bandera);
			}
	

	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectal = jcbalfab.getSelectedIndex();
			this.removeAll();
			empleados = new DefaultTableModel();
	        tableEmp = new JTable(empleados){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
	
	
	
	


}

