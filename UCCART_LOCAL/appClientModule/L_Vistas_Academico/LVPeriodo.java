package L_Vistas_Academico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Periodo;

import beans.B_Periodo;


import L_Vistas.FileChooser;
import L_Vistas.LVPanel;
import L_Vistas_Usuario.LVUIngresar;

@SuppressWarnings("all")
public class LVPeriodo extends LVPanel implements ActionListener {
	private LVPIngresar lvpi;
	private LVPModificar lvpm;
	private DefaultTableModel periodos;
	private B_Periodo bperiodo;
	private JButton jbelimPe, jbrefrePe, jbmodifPe, jbinsePe, jbmatriz;
	private JTable tablePer;
	private final JTextField filterTextMPer;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	
	public LVPeriodo(JFrame padre){
		lvpi = new LVPIngresar(padre, true, fo);
		lvpm = new LVPModificar(padre, true, fo);
		periodos = new DefaultTableModel();
		bperiodo = new B_Periodo();
		tablePer = new JTable(periodos){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
			filterTextMPer = new JTextField(20);
	}
	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();

		periodos.addColumn("Nombre");
		periodos.addColumn("Fin de matrícula ordinaria");
		periodos.addColumn("Fin de matrícula extraordinaria");
		List<Periodo> listper = bperiodo.selectAll();
		for(int i=0;i<listper.size();i++){
			String[] fila = {listper.get(i).getPerPeriodo(), dateFormat.format(listper.get(i).getPerWeb()), dateFormat.format(listper.get(i).getPerLocal())};
			periodos.addRow(fila);
		}
		this.buildTabla(periodos, tablePer, filterTextMPer);
		///////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		filterTextMPer.setAlignmentX(CENTER_ALIGNMENT);
		filterTextMPer.setSize(10, 5);
		filterTextMPer.setFont(fo);
		filterTextMPer.setMaximumSize(filterTextMPer.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefrePe = new JButton(imagen);
		jbrefrePe.addActionListener(this);
		jbrefrePe.setToolTipText("Actualizar tabla!");
		jbrefrePe.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefrePe, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Períodos:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextMPer, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
		
		jbinsePe = new JButton("Ingresar");
		jbinsePe.addActionListener(this);
		jbinsePe.setFont(fo);
		jbinsePe.setToolTipText("Ingresar un nuevo Período!");
		jbinsePe.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinsePe, BorderLayout.CENTER);
		
		jbmodifPe = new JButton("Modificar");
		jbmodifPe.addActionListener(this);
		jbmodifPe.setFont(fo);
		jbmodifPe.setToolTipText("Modificar Período seleccionada!");
		jbmodifPe.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifPe, BorderLayout.CENTER);

		jbelimPe = new JButton("Eliminar");
		jbelimPe.addActionListener(this);
		jbelimPe.setFont(fo);
		jbelimPe.setToolTipText("Eliminar Período seleccionada!");
		jbelimPe.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimPe, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tablePer));
		
		JPanel panel3 = new JPanel();
		label = new JLabel(" Generar reportes:    ");
		label.setFont(fo);
		panel3.add(label);
		
		jbmatriz = new JButton("Matriz");
		jbmatriz.addActionListener(this);
		jbmatriz.setFont(fo);
		jbmatriz.setToolTipText("Genera un documento excel con la información de todos los estudiantes en un período!");
		jbmatriz.setAlignmentX(CENTER_ALIGNMENT);
		panel3.add(jbmatriz, BorderLayout.CENTER);
		
		this.add(panel3);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbelimPe) {
			if(tablePer.getSelectedRowCount() == 1){
				if(bperiodo.find((String)tablePer.getValueAt(tablePer.getSelectedRow(), 0))){
					if(bperiodo.delete()){
						JOptionPane.showMessageDialog(null, "Período eliminado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Período no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 período", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbinsePe) {
				lvpi = new LVPIngresar((JFrame)lvpi.getParent(), true, fo);
				lvpi.init();
				lvpi.setLocationRelativeTo(lvpi.getParent());
				lvpi.setVisible(true);
			}else{
				if(e.getSource() == jbmatriz) {
					if(tablePer.getSelectedRowCount() == 1){
						if(bperiodo.find((String)tablePer.getValueAt(tablePer.getSelectedRow(), 0))){
							FileChooser fc = new FileChooser();
							fc.ListaCreditos(bperiodo);
							JOptionPane.showMessageDialog(null, "Documento matriz de período generado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Período no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 período", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					if(e.getSource() == jbmodifPe) {
						if(tablePer.getSelectedRowCount() == 1){
							if(bperiodo.find((String)tablePer.getValueAt(tablePer.getSelectedRow(), 0))){
								lvpm = new LVPModificar((JFrame)lvpm.getParent(), true, fo);
								lvpm.init(bperiodo);
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
		}
		this.removeAll();
		periodos = new DefaultTableModel();
		tablePer = new JTable(periodos){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);
	}
}
