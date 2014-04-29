package L_Vistas_Academico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Materia;
import beans.B_Carrera;
import beans.B_Curso;
import beans.B_Materia;
import L_Vistas.LVPanel;
import L_Vistas_Financiero.LVAranModificar;

@SuppressWarnings("all")
public class LVMateria extends LVPanel implements MouseListener, ActionListener {
	private LVMIngresar lvmi;
	private LVMModificar lvmm;
	private DefaultTableModel materias;
	private B_Materia bmateria;
	private JButton jbelimMa, jbrefreMa, jbmodifMa, jbinseMa;
	private JTable tableMat;
	private final JTextField filterTextMat;
	private boolean bandera;
	public LVMateria(JFrame padre){
		super();
		lvmi = new LVMIngresar(padre, true, fo);
		lvmm = new LVMModificar(padre, true, fo);
		materias = new DefaultTableModel();
		bmateria = new B_Materia();
		tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
			filterTextMat = new JTextField(20);
	}
	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();

		materias.addColumn("Código");
		materias.addColumn("Nombre");
		materias.addColumn("Área");
		materias.addColumn("Créditos");
		List<Materia> listcarr = bmateria.selectAll();
		for(int i=0;i<listcarr.size();i++){
			String[] fila = {listcarr.get(i).getMateriaId(),listcarr.get(i).getMateriaNombre(), listcarr.get(i).getMateriaArea(), listcarr.get(i).getMateriaCreditos().toString()};
			materias.addRow(fila);
		}
		this.buildTabla(materias, tableMat, filterTextMat);
		///////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		filterTextMat.setAlignmentX(CENTER_ALIGNMENT);
		filterTextMat.setSize(10, 5);
		filterTextMat.setFont(fo);
		filterTextMat.setMaximumSize(filterTextMat.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreMa = new JButton(imagen);
		jbrefreMa.addActionListener(this);
		jbrefreMa.setToolTipText("Actualizar tabla!");
		jbrefreMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreMa, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Materias:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextMat, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
		
		jbinseMa = new JButton("Ingresar");
		jbinseMa.addActionListener(this);
		jbinseMa.setFont(fo);
		jbinseMa.setToolTipText("Ingresar una nueva Materia!");
		jbinseMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseMa, BorderLayout.CENTER);
		
		jbmodifMa = new JButton("Modificar");
		jbmodifMa.addActionListener(this);
		jbmodifMa.setFont(fo);
		jbmodifMa.setToolTipText("Modificar Materia seleccionada!");
		jbmodifMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifMa, BorderLayout.CENTER);

		jbelimMa = new JButton("Eliminar");
		jbelimMa.addActionListener(this);
		jbelimMa.setFont(fo);
		jbelimMa.setToolTipText("Eliminar Materia seleccionada!");
		jbelimMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimMa, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableMat));

	}
	public void addScrollPane(JFrame frame){
		JScrollPane pane = new JScrollPane(lvmi);
		frame.add(pane, BorderLayout.CENTER);
	}
	public void reducir(){
	}
	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stubelse{
		
		////////ACCION BOTON DE AGREGAR///////
		
		if(e.getSource() == jbelimMa) {
			if(tableMat.getSelectedRowCount() == 1){
				if(bmateria.find((String)tableMat.getValueAt(tableMat.getSelectedRow(), 0))){
					if(bmateria.delete()){
						JOptionPane.showMessageDialog(null, "Materia eliminada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Materia no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 materia", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			
			////////ACCION BOTON DE ELIMINAR///////
			
			if(e.getSource() == jbinseMa) {
				lvmi = new LVMIngresar((JFrame)lvmi.getParent(), true, fo);
				lvmi.init();
				lvmi.setLocationRelativeTo(lvmi.getParent());
				lvmi.setVisible(true);
			}
			
			////////BOTON MODIFICAR//////////
			
			else{
				if(e.getSource() == jbmodifMa) {
					if(tableMat.getSelectedRowCount() == 1){
						if(bmateria.find((String)tableMat.getValueAt(tableMat.getSelectedRow(), 0))){
							lvmm = new LVMModificar((JFrame)lvmm.getParent(), true, fo);
							lvmm.init(bmateria);
							lvmm.setLocationRelativeTo(lvmm.getParent());
							lvmm.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Materia no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 materia", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			
			}
			
			
		this.removeAll();
		materias = new DefaultTableModel();
		tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);
	}


}
