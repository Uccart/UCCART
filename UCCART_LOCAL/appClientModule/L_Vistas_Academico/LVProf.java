package L_Vistas_Academico;

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
public class LVProf extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel profesores;
	private B_Profesor bprofesor;
	private JButton jbelimProf, jbrefreProf, jbmodifProf, jbinseProf;
	private JTable tableProf;
	private final JTextField filterTextProf;
	private LVProIngresar lvprof;
	private LVProModificar lvpm;
	private JComboBox jcbalfab;
	private int selectal;
	private boolean bandera;
	public LVProf(JFrame padre){
		super();
		lvprof = new LVProIngresar(padre, true, fo);
		lvpm = new LVProModificar(padre, true, fo);
		profesores = new DefaultTableModel();
		bprofesor = new B_Profesor();
		
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
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] { "Sin filtro", "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z" }));
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
		
		
		List<Profesor> listProf = new ArrayList<Profesor>();
		
		listProf = bprofesor.selectXalfa(this.jcbalfab.getSelectedItem().toString());
		
		for(Profesor p : listProf){
			
			String[] fila = {p.getProfId(),p.getProfApellido1()+" "+p.getProfApellido2()+", "+p.getProfNombre(),
					p.getProfGradoacademico(),p.getProfTelefono().toString(),p.getProfCorreo()};
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
		
		jbinseProf = new JButton("Ingresar");
		jbinseProf.addActionListener(this);
		jbinseProf.setFont(fo);
		jbinseProf.setToolTipText("Ingresar un nuevo Profesor!");
		jbinseProf.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseProf, BorderLayout.CENTER);
		
		jbmodifProf = new JButton("Modificar");
		jbmodifProf.addActionListener(this);
		jbmodifProf.setFont(fo);
		jbmodifProf.setToolTipText("Modificar Profesor seleccionado!");
		jbmodifProf.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifProf, BorderLayout.CENTER);

		jbelimProf = new JButton("Eliminar");
		jbelimProf.addActionListener(this);
		jbelimProf.setFont(fo);
		jbelimProf.setToolTipText("Eliminar Profesor seleccionado!");
		jbelimProf.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimProf, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableProf));
	}
	public void reducir(){
		jbelimProf.setVisible(false);
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubelse{
		if(e.getSource() == jbelimProf) {
			if(tableProf.getSelectedRowCount() == 1){
				if(bprofesor.find((String)tableProf.getValueAt(tableProf.getSelectedRow(), 0))){
					if(bprofesor.delete()){
						JOptionPane.showMessageDialog(null, "Profesor eliminado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Profesor no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 profesor", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbinseProf) {
				lvprof = new LVProIngresar((JFrame)lvprof.getParent(), true, fo);
				lvprof.init();   
				lvprof.setLocationRelativeTo(lvprof.getParent());
				
					lvprof.setVisible(true);
			}
			else{
				if(e.getSource() == jbmodifProf) {
					if(tableProf.getSelectedRowCount() == 1){
						if(bprofesor.find((String)tableProf.getValueAt(tableProf.getSelectedRow(), 0))){
							lvpm = new LVProModificar((JFrame)lvpm.getParent(), true, fo);
							lvpm.init(bprofesor);
							lvpm.setLocationRelativeTo(lvpm.getParent());
							lvpm.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Período no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 período", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		this.removeAll();
		profesores = new DefaultTableModel();
		tableProf = new JTable(profesores){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);
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
