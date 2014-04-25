package L_Vistas_Registro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.Estudiante;
import beans.B_Carrera;
import beans.B_Estudiante;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVPadron extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel estudiantes;
	private B_Estudiante bestudiante;
	private JButton jbelimPa, jbrefrePa, jbinsePa;
	private JTable tableEst;
	private final JTextField filterTextEst;
	private LVPIngresar lvpi;
	private LVPEliminar lvpe;
	private JComboBox jcbalfab;
	private int selectal;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVPadron(JFrame padre){
		super();
		lvpi = new LVPIngresar(padre, true, fo, "", "");
		lvpe = new LVPEliminar(padre, true, fo, "");
		estudiantes = new DefaultTableModel();
		bestudiante = new B_Estudiante();
		tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextEst = new JTextField(20);
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
		jcbalfab.setToolTipText("Lista de estudiantes por orden alfabético");
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] {  "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z","Sin filtro" }));
		jcbalfab.setSelectedIndex(selectal);
		jcbalfab.setMaximumSize(jcbalfab.getPreferredSize() );
		panel2.add(jcbalfab);
		jcbalfab.addItemListener(this);
		

		estudiantes.addColumn("ID");
		estudiantes.addColumn("Nombre");
		estudiantes.addColumn("Teléfono 1");
		estudiantes.addColumn("Teléfono 2");
		estudiantes.addColumn("Correo");
		estudiantes.addColumn("Nacionalidad");
		estudiantes.addColumn("Fecha de nacimiento");
		List<Estudiante> listest = bestudiante.selectXalfa(jcbalfab.getSelectedItem().toString());
		for(int i=0;i<listest.size();i++){
			String[] fila = {listest.get(i).getEstId(),listest.get(i).getEstApellido1()+" "+listest.get(i).getEstApellido2()+", "+listest.get(i).getEstNombre(),
					listest.get(i).getEstCelular().toString(),listest.get(i).getEstTelefono().toString(),listest.get(i).getEstCorreo(),
					listest.get(i).getEstNacionalidad(),dateFormat.format(listest.get(i).getEstNacimiento())};
			estudiantes.addRow(fila);
		}
		this.buildTabla(estudiantes, tableEst, filterTextEst);
		///////////////////////////////////////////////////////////////
		
		filterTextEst.setAlignmentX(CENTER_ALIGNMENT);
		filterTextEst.setSize(10, 5);
		filterTextEst.setFont(fo);
		filterTextEst.setMaximumSize(filterTextEst.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefrePa = new JButton(imagen);
		jbrefrePa.addActionListener(this);
		jbrefrePa.setToolTipText("Actualizar tabla!");
		jbrefrePa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefrePa, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Materias:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextEst, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		
		jbinsePa = new JButton("Agregar");
		jbinsePa.addActionListener(this);
		jbinsePa.setFont(fo);
		jbinsePa.setToolTipText("Agregar estudiante a un nuevo padrón de una carrera!");
		jbinsePa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinsePa, BorderLayout.CENTER);

		jbelimPa = new JButton("Retirar");
		jbelimPa.addActionListener(this);
		jbelimPa.setFont(fo);
		jbelimPa.setToolTipText("Retirar al estudiante de un padrón!");
		jbelimPa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimPa, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableEst));
	}
	public void reducir(){
		jbelimPa.setVisible(false);
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubelse{
		if(e.getSource() == jbelimPa) {
			if(tableEst.getSelectedRowCount() == 1){
				lvpe = new LVPEliminar((JFrame)lvpe.getParent(), true, fo, (String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
				lvpe.init();
				lvpe.setLocationRelativeTo(lvpi.getParent());
				lvpe.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 estudiante", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbinsePa) {
				if(tableEst.getSelectedRowCount() == 1){
					lvpi = new LVPIngresar((JFrame)lvpi.getParent(), true, fo, (String)tableEst.getValueAt(tableEst.getSelectedRow(), 1), (String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
					lvpi.init();
					lvpi.setLocationRelativeTo(lvpi.getParent());
					lvpi.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar 1 estudiante", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		this.removeAll();
		estudiantes = new DefaultTableModel();
		tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectal = jcbalfab.getSelectedIndex();
			this.removeAll();
			estudiantes = new DefaultTableModel();
	        tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
}
