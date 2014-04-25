package L_Vistas_Academico;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Carrera;

import beans.B_Carrera;
import beans.B_Curso;
import beans.B_Materia;

import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVCarrera extends LVPanel implements MouseListener, ActionListener {
	private DefaultTableModel carreras;
	private B_Carrera bcarrera;
	private boolean bandera;
	private JButton jbelimCa, jbrefreCa, jbmodifCa, jbinseCa;
	private JTable tableCarr;
	private final JTextField filterTextCarr;
	private LVCaIngresar lvcai;

	public LVCarrera(JFrame padre){
		super();
		carreras = new DefaultTableModel();
		bcarrera = new B_Carrera();
		tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextCarr = new JTextField(20);
		lvcai = new LVCaIngresar(padre, true, fo);
	}
	public void init(boolean ban){
		bandera = ban;
		
		lvcai.init();

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		/*Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableCellListener tcl = (TableCellListener) e.getSource();
                System.out.println("Row   : " + tcl.getRow());
                System.out.println("Column: " + tcl.getColumn());
                System.out.println("Old   : " + tcl.getOldValue());
                System.out.println("New   : " + tcl.getNewValue());
                modelEditarTable.setValueAt(Boolean.TRUE, tcl.getRow(), 4);
                if (!filasEditarCambiaron.contains(Integer.valueOf(tcl.getRow()))) {
                    filasEditarCambiaron.add(Integer.valueOf(tcl.getRow()));
                }

            }
        };*/

		carreras.addColumn("Código");
		carreras.addColumn("Nombre");
		List<Carrera> listcarr = bcarrera.selectAll();
		for(int i=0;i<listcarr.size();i++){
			String[] fila = {listcarr.get(i).getCarrCod(),listcarr.get(i).getCarrNombre()};
			carreras.addRow(fila);
		}
		this.buildTabla(carreras, tableCarr, filterTextCarr);
		///////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		filterTextCarr.setAlignmentX(CENTER_ALIGNMENT);
		filterTextCarr.setSize(10, 5);
		filterTextCarr.setFont(fo);
		filterTextCarr.setMaximumSize(filterTextCarr.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreCa = new JButton(imagen);
		jbrefreCa.addActionListener(this);
		jbrefreCa.setToolTipText("Actualizar tabla!");
		jbrefreCa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreCa, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Carrera:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextCarr, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
		
		jbinseCa = new JButton("Ingresar");
		jbinseCa.addActionListener(this);
		jbinseCa.setFont(fo);
		jbinseCa.setToolTipText("Ingresar una nueva Carrera!");
		jbinseCa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseCa, BorderLayout.CENTER);
		
		jbmodifCa = new JButton("Modificar");
		jbmodifCa.addActionListener(this);
		jbmodifCa.setFont(fo);
		jbmodifCa.setToolTipText("Modificar Carrera seleccionada!");
		jbmodifCa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifCa, BorderLayout.CENTER);

		jbelimCa = new JButton("Eliminar");
		jbelimCa.addActionListener(this);
		jbelimCa.setFont(fo);
		jbelimCa.setToolTipText("Eliminar Carrera seleccionada!");
		jbelimCa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimCa, BorderLayout.CENTER);
		this.add(panel2);

		this.add(new JScrollPane(tableCarr));
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
		// TODO Auto-generated method stub
		if(e.getSource() == jbrefreCa){
			this.removeAll();
			carreras = new DefaultTableModel();
			tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
				this.init(bandera);
		}else{
			if(e.getSource() == jbelimCa) {
				if(tableCarr.getSelectedRowCount() == 1){
					if(bcarrera.find((String)tableCarr.getValueAt(tableCarr.getSelectedRow(), 0))){
						if(bcarrera.delete()){
							JOptionPane.showMessageDialog(null, "Carrera eliminada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else
							JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Carrera no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar 1 carrera", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				if(e.getSource() == jbinseCa) {
					lvcai = new LVCaIngresar((JFrame)lvcai.getParent(), true, fo);
					lvcai.init();
					lvcai.setLocationRelativeTo(lvcai.getParent());
					lvcai.setVisible(true);
				}
			}
			this.removeAll();
			carreras = new DefaultTableModel();
			tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
			this.init(bandera);
		}
	}

}
