package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.Estudiante;
import model.Profesor;
import beans.B_Carrera;
import beans.B_Estudiante;
import beans.B_Profesor;
import L_Vistas.LVPanel;
import L_Vistas_Academico.LVMIngresar;

@SuppressWarnings("all")
public class LVCuentasPagar extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel profesores;
	private B_Profesor bprofesor;
	private JButton jbrefreProf, jbFacturas;
	private JTable tableProf;
	private final JTextField filterTextProf;
	private JComboBox jcbalfab;
	private int selectal;
	private boolean bandera;
	private LVConsultarFacturasPagar lvconsultarfacturas;
	
	
	public LVCuentasPagar(JFrame padre){
		super();

		profesores = new DefaultTableModel();
		bprofesor = new B_Profesor();
		lvconsultarfacturas =new  LVConsultarFacturasPagar(padre,bprofesor.getProfesor());
		tableProf = new JTable(profesores){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextProf = new JTextField(20);
		selectal = 0;
		
	}

	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		jcbalfab = new JComboBox<String>();
		jcbalfab.setFont(fo);
		jcbalfab.setToolTipText("Lista de profesores por orden alfabético");
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] {  "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z","Sin filtro" }));
		jcbalfab.setSelectedIndex(selectal);
		jcbalfab.setMaximumSize(jcbalfab.getPreferredSize() );
		panel2.add(jcbalfab);
		jcbalfab.addItemListener(this);
		
		panel2.add(new JLabel("  "));
		
		panel2.add(new JLabel("  "));
		

		profesores.addColumn("ID");
		profesores.addColumn("Nombre");
		profesores.addColumn("Grado academico");
		profesores.addColumn("Teléfono");
		profesores.addColumn("Email");
		profesores.addColumn("Salario");
		
		List<Profesor> listProf = new ArrayList<Profesor>();
		
		listProf = bprofesor.selectXalfa(this.jcbalfab.getSelectedItem().toString());
		
		for(Profesor p : listProf){
			
			String[] fila = {p.getProfId(),p.getProfApellido1()+" "+p.getProfApellido2()+", "+p.getProfNombre(),
					p.getProfGradoacademico(),p.getProfTelefono().toString(),p.getProfCorreo(), p.getProfSalario().toString()};
			profesores.addRow(fila);
		}
		
		
		

		
		this.buildTabla(profesores, tableProf, filterTextProf);
		///////////////////////////////////////////////////////////////
		
		filterTextProf.setAlignmentX(CENTER_ALIGNMENT);
		filterTextProf.setSize(10, 5);
		filterTextProf.setFont(fo);
		filterTextProf.setMaximumSize(filterTextProf.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreProf = new JButton(imagen);
		jbrefreProf.addActionListener(this);
		jbrefreProf.setToolTipText("Actualizar tabla!");
		jbrefreProf.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreProf, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Profesor:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextProf, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		
	

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableProf));
		
		jbFacturas =  new JButton("Consultar");
		jbFacturas.addActionListener(this);
		jbFacturas.setFont(fo);
		jbFacturas.setToolTipText("Consultar Cuenta!");
		jbFacturas.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbFacturas, BorderLayout.CENTER);
	}

	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbFacturas) {
			if(tableProf.getSelectedRowCount() == 1){
			bprofesor.find((String)tableProf.getValueAt(tableProf.getSelectedRow(), 0));
			lvconsultarfacturas = new LVConsultarFacturasPagar((JFrame)lvconsultarfacturas.getParent(), bprofesor.getProfesor());
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

			this.removeAll();
			profesores = new DefaultTableModel();
	        tableProf = new JTable(profesores){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
}
