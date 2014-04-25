package L_Vistas_Academico;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import beans.B_Carrera;
import beans.B_Curso;
import beans.B_Materia;
import model.Carrera;
import model.Curso;
import model.Materia;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVInicio extends LVPanel implements ActionListener{
	private DefaultTableModel carreras, materias, cursos; 
	private B_Carrera bcarrera;
	private B_Materia bmateria;
	private B_Curso bcurso;
	private JButton jbelimCa, jbelimMa, jbelimCu, jbrefreCa, jbrefreMa, jbrefreCu;
	private JTable tableCarr, tableMat, tableCur;
	private final JTextField filterTextCarr, filterTextMat, filterTextCur;

	public LVInicio(){
		super();
		carreras = new DefaultTableModel();
		materias = new DefaultTableModel();
		cursos = new DefaultTableModel();
		bcarrera = new B_Carrera();
		bmateria = new B_Materia();
		bcurso = new B_Curso();
		tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
        tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
		filterTextCarr = new JTextField(20);
		filterTextMat = new JTextField(20);
		filterTextCur = new JTextField(20);
	}
	public void init(){
		this.setLayout(new GridLayout(3,1));
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(this.buildCarreras());
		panel.add(new JScrollPane(tableCarr));
		
		this.add(panel);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(this.buildMaterias());
		panel.add(new JScrollPane(tableMat));
		
		this.add(panel);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(this.buildCursos());
		panel.add(new JScrollPane(tableCur));
		
		this.add(panel);
	}
	
	public JPanel buildCarreras(){
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
		jbrefreCa.setToolTipText("Modificar Carrera seleccionada!");
		jbrefreCa.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbrefreCa, BorderLayout.CENTER);
        
		JLabel label = new JLabel(" Buscar Carrera:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextCarr, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
        
        jbelimCa = new JButton("Eliminar");
        jbelimCa.addActionListener(this);
        jbelimCa.setFont(fo);
        jbelimCa.setToolTipText("Eliminar Carrera seleccionada!");
        jbelimCa.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbelimCa, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////
		return panel2;
	}	
	public JPanel buildMaterias(){
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
		jbrefreMa.setToolTipText("Modificar Carrera seleccionada!");
		jbrefreMa.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbrefreMa, BorderLayout.CENTER);
        
		JLabel label = new JLabel(" Buscar Materias:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextMat, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
        
        jbelimMa = new JButton("Eliminar");
        jbelimMa.addActionListener(this);
        jbelimMa.setFont(fo);
        jbelimMa.setToolTipText("Eliminar Carrera seleccionada!");
        jbelimMa.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbelimMa, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////
		return panel2;
	}
	public JPanel buildCursos(){
		cursos.addColumn("Código");
		cursos.addColumn("Nombre");
		cursos.addColumn("Aula");
		cursos.addColumn("Sede");
		cursos.addColumn("Cant Est");
		cursos.addColumn("Período");
		cursos.addColumn("Profesor");
		List<Curso> listcarr = bcurso.selectAll();
		for(int i=0;i<listcarr.size();i++){
	        String[] fila = {listcarr.get(i).getCursoId(), listcarr.get(i).getMateria().getMateriaNombre(), listcarr.get(i).getCursoAula(), listcarr.get(i).getCursoSede(),
	        		listcarr.get(i).getCursoCantactual().toString(), listcarr.get(i).getPeriodo().getPerPeriodo(), listcarr.get(i).getProfesor().getProfNombre()+", "+
	        		listcarr.get(i).getProfesor().getProfApellido1()+" "+listcarr.get(i).getProfesor().getProfApellido2()};
	        cursos.addRow(fila);
		}
		this.buildTabla(cursos, tableCur, filterTextCur);
		///////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		filterTextCur.setAlignmentX(CENTER_ALIGNMENT);
		filterTextCur.setSize(10, 5);
		filterTextCur.setFont(fo);
		filterTextCur.setMaximumSize(filterTextCur.getPreferredSize() );
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreCu = new JButton(imagen);
		jbrefreCu.addActionListener(this);
		jbrefreCu.setToolTipText("Modificar Carrera seleccionada!");
		jbrefreCu.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbrefreCu, BorderLayout.CENTER);
        
		JLabel label = new JLabel(" Buscar Cursos:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextCur, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
        
        jbelimCu = new JButton("Eliminar");
        jbelimCu.addActionListener(this);
        jbelimCu.setFont(fo);
        jbelimCu.setToolTipText("Eliminar Carrera seleccionada!");
        jbelimCu.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbelimCu, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////
		return panel2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if((e.getSource() == jbrefreCa)||(e.getSource() == jbrefreMa)||(e.getSource() == jbrefreCu)){
			this.removeAll();
			carreras = new DefaultTableModel();
			materias = new DefaultTableModel();
			cursos = new DefaultTableModel();
			tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
	        tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
	        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init();
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
				if(e.getSource() == jbelimCu) {
					if(tableCur.getSelectedRowCount() == 1){
						if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
							if(bcurso.delete()){
								JOptionPane.showMessageDialog(null, "Curso eliminada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							}else
								JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
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
						
					}
				}
			}
			this.removeAll();
			carreras = new DefaultTableModel();
			materias = new DefaultTableModel();
			cursos = new DefaultTableModel();
			tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
	        tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
	        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init();
		}
	}
}
