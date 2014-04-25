package L_Vistas_Registro;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import model.Estudiante;
import model.Nota;
import beans.B_Estudiante;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVMatricula extends LVPanel implements ActionListener, ItemListener, MouseListener   {
	private DefaultTableModel estudiantes;
	private B_Estudiante bestudiante;
	private JButton jbrefrePa, jbmatriculaEs, jbdesmatEs, jbmatriculaCons;
	private JTable tableEst;
	private JLabel estinfo;
	private final JTextField filterTextEst;
	private LVMIngresar lvmi;
	private LVPEliminar lvpe;
	private LVMatriculaC lvmatriculaC;
	private JComboBox jcbalfab;
	private int selectal;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVMatricula(JFrame padre){
		super();
		bestudiante = new B_Estudiante();
		lvmatriculaC =new  LVMatriculaC(padre,bestudiante.getEstudiante());
		lvmi = new LVMIngresar(padre, true, fo);
		lvpe = new LVPEliminar(padre, true, fo, "");
		estudiantes = new DefaultTableModel();
		
		tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextEst = new JTextField(20);
		selectal = 0;
		estinfo = new JLabel();
		estinfo.setFont(fo);
	}

	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		JPanel panel3 =new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
		panel3.add(estinfo);
		
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
		tableEst.addMouseListener(this);
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

		JLabel label = new JLabel(" Buscar Estudiantes:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextEst, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		
		jbmatriculaEs = new JButton("Modificar");
		jbmatriculaEs.addActionListener(this);
		jbmatriculaEs.setFont(fo);
		jbmatriculaEs.setToolTipText("Matricular o desmatricular a un estudiante en algún curso!");
		jbmatriculaEs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmatriculaEs, BorderLayout.CENTER);
		
		
		jbmatriculaCons =  new JButton("Consultar Est");
		jbmatriculaCons.addActionListener(this);
		jbmatriculaCons.setFont(fo);
		jbmatriculaCons.setToolTipText("Consultar Estudiante!");
		jbmatriculaCons.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmatriculaCons, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableEst));
		this.add(panel3);
	}
	public void reducir(){
		
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubelse{
		if(e.getSource() == jbmatriculaEs) {
			if(tableEst.getSelectedRowCount() == 1){
				lvmi = new LVMIngresar((JFrame)lvmi.getParent(), true, fo);
				lvmi.init(bandera, (String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
				lvmi.setLocationRelativeTo(lvmi.getParent());
				if(lvmi.getEstado())
					lvmi.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 estudiante", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(tableEst.getSelectedRowCount() == 1){
				bestudiante.find((String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
				lvmatriculaC = new LVMatriculaC((JFrame)lvmatriculaC.getParent(), bestudiante.getEstudiante());
				lvmatriculaC.init(bandera);
				lvmatriculaC.setLocationRelativeTo(lvmatriculaC.getParent());
				if(lvmatriculaC.getEstado())
					lvmatriculaC.setVisible(true);
			
			
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 estudiante", "Error", JOptionPane.ERROR_MESSAGE);
			}

		this.removeAll();
		estinfo.setText("");
		estudiantes = new DefaultTableModel();
		tableEst = new JTable(estudiantes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);}
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
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (tableEst.getSelectedRowCount() == 1) {
			String texto = "<html>Información de estudiante<P>" +
            		"<html>Nombre: "+(String)tableEst.getValueAt(tableEst.getSelectedRow(), 1)+"<P>" +
            		"Cédula: "+(String)tableEst.getValueAt(tableEst.getSelectedRow(), 0)+"<P>" +
            		"<html>Créditos matriculados: <P>";
			
			List<Nota> listnotas = bestudiante.getNotas((String)tableEst.getValueAt(tableEst.getSelectedRow(), 0));
			if(listnotas != null){
			for(int i=0; i<listnotas.size(); i++)
				texto = texto+"<html>-"+listnotas.get(i).getCurso().getCursoId()+" "+listnotas.get(i).getCurso().getMateria().getMateriaNombre()+"<P>";
            texto = texto+"<html>\t                           >Total<P>";		
            estinfo.setText(texto);
        }
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}