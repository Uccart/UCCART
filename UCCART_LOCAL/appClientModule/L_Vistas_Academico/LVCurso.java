package L_Vistas_Academico;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Curso;
import model.Periodo;

import beans.B_Carrera;
import beans.B_Curso;
import beans.B_Materia;
import beans.B_Periodo;

import L_Vistas.FileChooser;
import L_Vistas.LVPanel;


@SuppressWarnings("all")
public class LVCurso extends LVPanel implements MouseListener, ActionListener, ItemListener {
	private DefaultTableModel cursos; 
	private B_Carrera bcarrera;
	private B_Materia bmateria;
	private B_Curso bcurso;
	private B_Periodo bperiodo;
	private JComboBox jcbperiodos;
	private JButton jbelimCu, jbrefreCu, jbinseCu, jbmodifCu, jblist, jbnotas;
	private JTable tableCur;
	private final JTextField filterTextCur;
	private LVCIngresar lvci;
	private boolean bandera;
	private List<Periodo> listper;
	private int select;
	
	public LVCurso(JFrame padre){
		super();
		lvci = new LVCIngresar(padre, true, fo);
		bcarrera = new B_Carrera();
		bmateria = new B_Materia();
		bperiodo = new B_Periodo();
		cursos = new DefaultTableModel();
		bcurso = new B_Curso();
        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
		filterTextCur = new JTextField(20);
		select = 0;
	}
	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		JPanel panel3 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		jcbperiodos = new JComboBox<String>();
		jcbperiodos.setFont(fo);
		jcbperiodos.setToolTipText("Per�odos activos");
        listper = bperiodo.selectAll();
		for(int i=0;i<listper.size();i++){
	        String item = listper.get(i).getPerPeriodo();
	        jcbperiodos.addItem(item);
		}
		if(listper.size() != 0)
			jcbperiodos.setSelectedIndex(select);
		jcbperiodos.setMaximumSize(jcbperiodos.getPreferredSize() );
		panel2.add(jcbperiodos);
		jcbperiodos.addItemListener(this);
		
		cursos.addColumn("Código");
		cursos.addColumn("Nombre");
		cursos.addColumn("Aula");
		cursos.addColumn("Sede");
		cursos.addColumn("Cant Est");
		cursos.addColumn("Período");
		cursos.addColumn("Profesor");
		if(jcbperiodos.getSelectedItem() != null){
			List<Curso> listcur = bperiodo.getCursos((String)jcbperiodos.getSelectedItem());
			for(int i=0;i<listcur.size();i++){
				String[] fila = {listcur.get(i).getCursoId(), listcur.get(i).getMateria().getMateriaNombre(), listcur.get(i).getCursoAula(), listcur.get(i).getCursoSede(),
						listcur.get(i).getCursoCantactual().toString(), listcur.get(i).getPeriodo().getPerPeriodo(), listcur.get(i).getProfesor().getProfNombre()+", "+
								listcur.get(i).getProfesor().getProfApellido1()+" "+listcur.get(i).getProfesor().getProfApellido2()};
				cursos.addRow(fila);
			}
		}
		this.buildTabla(cursos, tableCur, filterTextCur);
		///////////////////////////////////////////////////////////////
		filterTextCur.setAlignmentX(CENTER_ALIGNMENT);
		filterTextCur.setSize(10, 5);
		filterTextCur.setFont(fo);
		filterTextCur.setMaximumSize(filterTextCur.getPreferredSize() );
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreCu = new JButton(imagen);
		jbrefreCu.addActionListener(this);
		jbrefreCu.setToolTipText("Actualizar tabla!");
		jbrefreCu.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbrefreCu, BorderLayout.CENTER);
        
		JLabel label = new JLabel(" Buscar Cursos:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextCur, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
		
		jbinseCu = new JButton("Ingresar");
		jbinseCu.addActionListener(this);
		jbinseCu.setFont(fo);
		jbinseCu.setToolTipText("Ingresar un nuevo Curso!");
		jbinseCu.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseCu, BorderLayout.CENTER);
		
		jbmodifCu = new JButton("Modificar");
		jbmodifCu.addActionListener(this);
		jbmodifCu.setFont(fo);
		jbmodifCu.setToolTipText("Modificar Curso seleccionado!");
		jbmodifCu.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifCu, BorderLayout.CENTER);
        
        jbelimCu = new JButton("Eliminar");
        jbelimCu.addActionListener(this);
        jbelimCu.setFont(fo);
        jbelimCu.setToolTipText("Eliminar Curso seleccionado!");
        jbelimCu.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbelimCu, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////
        
		this.add(panel2);
		this.add(new JScrollPane(tableCur));
		
		label = new JLabel(" Generar reportes:    ");
		label.setFont(fo);
		panel3.add(label);
		
		jblist = new JButton("Lista de estudiantes");
		jblist.addActionListener(this);
		jblist.setFont(fo);
		jblist.setToolTipText("Genera un documento con los estudiantes matriculados!");
		jblist.setAlignmentX(CENTER_ALIGNMENT);
		panel3.add(jblist, BorderLayout.CENTER);
        
        jbnotas = new JButton("Acta de notas");
        jbnotas.addActionListener(this);
        jbnotas.setFont(fo);
        jbnotas.setToolTipText("Genera un documento para asignar las notas de los estudiantes!");
        jbnotas.setAlignmentX(CENTER_ALIGNMENT);
        panel3.add(jbnotas, BorderLayout.CENTER);
		
        this.add(panel3);

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
		// TODO Auto-generated method stub
		if(e.getSource() == jbelimCu) {
			if(tableCur.getSelectedRowCount() == 1){
				if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
					if(bcurso.delete()){
						JOptionPane.showMessageDialog(null, "Curso eliminada con �xito", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbinseCu) {
				lvci = new LVCIngresar((JFrame)lvci.getParent(), true, fo);
				lvci.init();
				lvci.setLocationRelativeTo(lvci.getParent());
				lvci.setVisible(true);
			}else{
				if(e.getSource() == jblist) {
					if(tableCur.getSelectedRowCount() == 1){
						if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
							FileChooser fc = new FileChooser();
							fc.ListaClase(bcurso);
							JOptionPane.showMessageDialog(null, "Lista de clases generada con �xito en direcci�n", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}else{
					if(e.getSource() == jbnotas) {
						if(tableCur.getSelectedRowCount() == 1){
							if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
								FileChooser fc = new FileChooser();
								fc.ActaNotas(bcurso);
								JOptionPane.showMessageDialog(null, "Documento con acta de notas generado con �xito en direcci�n", "INFO", JOptionPane.INFORMATION_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
		this.removeAll();
		cursos = new DefaultTableModel();
        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
		this.init(bandera);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			select = jcbperiodos.getSelectedIndex();
			this.removeAll();
			cursos = new DefaultTableModel();
	        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}

}
