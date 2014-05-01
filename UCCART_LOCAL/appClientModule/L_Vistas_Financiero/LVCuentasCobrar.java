package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.Estudiante;
import beans.B_Carrera;
import beans.B_Estudiante;
import L_Vistas.LVPanel;
import L_Vistas_Academico.LVMIngresar;
import L_Vistas_Academico.LVPModificar;
import L_Vistas_Registro.LVMatriculaC;

@SuppressWarnings("all")
public class LVCuentasCobrar extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel estudiantes;
	private B_Estudiante bestudiante;
	private B_Carrera bcarrera;
	private JButton  jbrefreEs, jbFacturas;
	private JTable tableEst;
	private final JTextField filterTextEst;
	private JComboBox jcbalfab, jcbcarreras;
	private int selectal, selectcarr;
	private boolean bandera;
	private List<Carrera> listcarr;
	private LVConsultarFacturasCobrar lvconsultarfacturas;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVCuentasCobrar(JFrame padre){
		super();
		estudiantes = new DefaultTableModel();
		bestudiante = new B_Estudiante();
		lvconsultarfacturas =new  LVConsultarFacturasCobrar(padre,bestudiante.getEstudiante());
		bcarrera = new B_Carrera();
		tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextEst = new JTextField(20);
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
		jcbalfab.setToolTipText("Lista de estudiantes por orden alfabético");
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] {  "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z","Sin filtro" }));
		jcbalfab.setSelectedIndex(selectal);
		jcbalfab.setMaximumSize(jcbalfab.getPreferredSize() );
		panel2.add(jcbalfab);
		jcbalfab.addItemListener(this);
		
		panel2.add(new JLabel("  "));
		
		jcbcarreras = new JComboBox<String>();
		jcbcarreras.setFont(fo);
		jcbcarreras.setToolTipText("Lista de estudiantes por orden de carrera");
        listcarr = bcarrera.selectAll();
		for(int i=0;i<listcarr.size();i++){
	        String item = listcarr.get(i).getCarrNombre();
	        jcbcarreras.addItem(item);
		}
		jcbcarreras.addItem("**Sin filtro**");
		if(listcarr.size() != 0)
			jcbcarreras.setSelectedIndex(selectcarr);
		jcbcarreras.setMaximumSize(jcbcarreras.getPreferredSize() );
		panel2.add(jcbcarreras);
		jcbcarreras.addItemListener(this);
		panel2.add(new JLabel("  "));
		

		estudiantes.addColumn("ID");
		estudiantes.addColumn("Nombre");
		estudiantes.addColumn("Teléfono 1");
		estudiantes.addColumn("Teléfono 2");
		estudiantes.addColumn("Correo");
		estudiantes.addColumn("Nacionalidad");
		estudiantes.addColumn("Fecha de nacimiento");
		
		if(listcarr.size() != 0){
			List<Estudiante> listest;
			if(listcarr.size()> selectcarr){
				listest = bestudiante.selectXcarreraalfa(jcbalfab.getSelectedItem().toString(), listcarr.get(selectcarr).getCarrCod());
			}else{
				listest = bestudiante.selectXcarreraalfa(jcbalfab.getSelectedItem().toString(), "Sin filtro");
			}
			
			
			
			for(int i=0;i<listest.size();i++){
				String[] fila = {listest.get(i).getEstId(),listest.get(i).getEstApellido1()+" "+listest.get(i).getEstApellido2()+", "+listest.get(i).getEstNombre(),
						listest.get(i).getEstCelular().toString(),listest.get(i).getEstTelefono().toString(),listest.get(i).getEstCorreo(),
						listest.get(i).getEstNacionalidad(),dateFormat.format(listest.get(i).getEstNacimiento())};
				estudiantes.addRow(fila);
			}
		}
		this.buildTabla(estudiantes, tableEst, filterTextEst);
		///////////////////////////////////////////////////////////////
		
		filterTextEst.setAlignmentX(CENTER_ALIGNMENT);
		filterTextEst.setSize(10, 5);
		filterTextEst.setFont(fo);
		filterTextEst.setMaximumSize(filterTextEst.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreEs = new JButton(imagen);
		jbrefreEs.addActionListener(this);
		jbrefreEs.setToolTipText("Actualizar tabla!");
		jbrefreEs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreEs, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Estudiante:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextEst, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableEst));
	
	
		jbFacturas =  new JButton("Consultar Est");
		jbFacturas.addActionListener(this);
		jbFacturas.setFont(fo);
		jbFacturas.setToolTipText("Consultar Estudiante!");
		jbFacturas.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbFacturas, BorderLayout.CENTER);
	
	
	
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbFacturas) {
			if(tableEst.getSelectedRowCount() == 1){
			bestudiante.find((String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
			lvconsultarfacturas = new LVConsultarFacturasCobrar((JFrame)lvconsultarfacturas.getParent(), bestudiante.getEstudiante());
			lvconsultarfacturas.init(bandera);
			lvconsultarfacturas.setLocationRelativeTo(lvconsultarfacturas.getParent());
			if(lvconsultarfacturas.getEstado())
				lvconsultarfacturas.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Debe seleccionar 1 estudiante", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectal = jcbalfab.getSelectedIndex();
			selectcarr = jcbcarreras.getSelectedIndex();
			this.removeAll();
			estudiantes = new DefaultTableModel();
	        tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
}
