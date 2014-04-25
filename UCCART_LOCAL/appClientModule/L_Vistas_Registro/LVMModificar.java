package L_Vistas_Registro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Curso;
import model.Nota;
import model.Periodo;

import L_Vistas.LVPanel;
import beans.B_Curso;
import beans.B_Estudiante;
import beans.B_Nota;
import beans.B_Periodo;



@SuppressWarnings("all")
public class LVMModificar extends JDialog implements ActionListener, ItemListener {
	private DefaultTableModel cursos, notas;
	private B_Curso bcurso;
	private B_Periodo bperiodo;
	private B_Nota bnota;
	private B_Estudiante bestudiante;
	private JButton jbrefreCur, jbinseCur, jbrefreNota, jbdesmatEs, jbaplicarNota;
	private JTable tableCur, tableNota;
	private final JTextField filterTextCur, filterTextNota;
	private JComboBox jcbperiodos;
	private List<Periodo> listper;
	private boolean bandera;
	private int select;
	private List<Curso> listcursos;
	private List<Nota> listnotas;
	private String idest;
	private Font fo;
	private JPanel principal;
	private boolean estado;
	public LVMModificar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		estado = true;
		fo = f;
		cursos = new DefaultTableModel();
		notas = new DefaultTableModel();
		bcurso = new B_Curso();
		bperiodo = new B_Periodo();
		bestudiante = new B_Estudiante();
		listcursos = new ArrayList<Curso>();
		listnotas = new ArrayList<Nota>();
		bnota = new B_Nota();
		tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		tableNota = new JTable(notas){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextCur = new JTextField(20);
		filterTextNota = new JTextField(20);
		principal = new JPanel();
		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        this.setSize(700, 400);
	}
	
	public void init(boolean ban, String id){
		bandera = ban;
		
		idest = id;
		
		LVPanel panel2 = new LVPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		jcbperiodos = new JComboBox<String>();
		jcbperiodos.setFont(fo);
		jcbperiodos.setToolTipText("Per�odos activos");
        listper = bperiodo.selectAll();
		for(int i=0;i<listper.size();i++){
	        String item = listper.get(i).getPerPeriodo();
	        jcbperiodos.addItem(item);
		}
		if(listper.size() == 0){
			JOptionPane.showMessageDialog(null, "Deben crearse períodos antes de poder matricular", "Error", JOptionPane.ERROR_MESSAGE);
			this.dispose();
			estado = false;
		}else{
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
			List<Curso> listcur = bperiodo.getCursos((String)jcbperiodos.getSelectedItem());
			for(int i=0;i<listcur.size();i++){
				String[] fila = {listcur.get(i).getCursoId(), listcur.get(i).getMateria().getMateriaNombre(), listcur.get(i).getCursoAula(), listcur.get(i).getCursoSede(),
						listcur.get(i).getCursoCantactual().toString(), listcur.get(i).getPeriodo().getPerPeriodo(), listcur.get(i).getProfesor().getProfNombre()+", "+
								listcur.get(i).getProfesor().getProfApellido1()+" "+listcur.get(i).getProfesor().getProfApellido2()};
				cursos.addRow(fila);
			}
			panel2.buildTabla(cursos, tableCur, filterTextCur);
			///////////////////////////////////////////////////////////////
			filterTextCur.setAlignmentX(CENTER_ALIGNMENT);
			filterTextCur.setSize(10, 5);
			filterTextCur.setFont(fo);
			filterTextCur.setMaximumSize(filterTextCur.getPreferredSize() );
	
			ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
			jbrefreCur = new JButton(imagen);
			jbrefreCur.addActionListener(this);
			jbrefreCur.setToolTipText("Actualizar tabla de materias!");
			jbrefreCur.setAlignmentX(CENTER_ALIGNMENT);
			panel2.add(jbrefreCur, BorderLayout.CENTER);
	
			JLabel label = new JLabel(" Buscar Materias:    ");
			label.setFont(fo);
			panel2.add(label);
			panel2.add(filterTextCur, BorderLayout.CENTER);
			panel2.add(new JLabel("                                                        "));
	
			jbinseCur = new JButton("Agregar");
			jbinseCur.addActionListener(this);
			jbinseCur.setFont(fo);
			jbinseCur.setToolTipText("Se agregar� la materia al plan de la carrera seleccionada!");
			jbinseCur.setAlignmentX(CENTER_ALIGNMENT);
			panel2.add(jbinseCur, BorderLayout.CENTER);
	
			principal.setLayout(new BoxLayout(principal, BoxLayout.PAGE_AXIS));
			principal.add(panel2);
			principal.add(new JScrollPane(tableCur));
	
			panel2 = new LVPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
	
			notas.addColumn("Código");
			notas.addColumn("Nombre");
			notas.addColumn("Aula");
			notas.addColumn("Sede");
			notas.addColumn("Cant Est");
			notas.addColumn("Período");
			notas.addColumn("Profesor");
			listnotas = bestudiante.getNotas(idest);
			if(listnotas.size() != 0){
				for(int i=0;i<listnotas.size();i++){
					//System.out.println(listnotas.get(i).getNotaCondicion());
					//System.out.println(listnotas.get(i).getCurso().getCursoId());
					String[] fila = {listnotas.get(i).getCurso().getCursoId(), listnotas.get(i).getCurso().getMateria().getMateriaNombre(), listnotas.get(i).getCurso().getCursoAula(), listnotas.get(i).getCurso().getCursoSede(),
							listnotas.get(i).getCurso().getCursoCantactual().toString(), listnotas.get(i).getCurso().getPeriodo().getPerPeriodo(), listnotas.get(i).getCurso().getProfesor().getProfNombre()+", "+
							listnotas.get(i).getCurso().getProfesor().getProfApellido1()+" "+listnotas.get(i).getCurso().getProfesor().getProfApellido2()};
					notas.addRow(fila);
					
				}
			}
			for(int i=0;i<listcursos.size();i++){
				String[] fila = {listcursos.get(i).getCursoId(), listcursos.get(i).getMateria().getMateriaNombre(), listcursos.get(i).getCursoAula(), listcursos.get(i).getCursoSede(),
						listcursos.get(i).getCursoCantactual().toString(), listcursos.get(i).getPeriodo().getPerPeriodo(), listcursos.get(i).getProfesor().getProfNombre()+", "+
						listcursos.get(i).getProfesor().getProfApellido1()+" "+listcursos.get(i).getProfesor().getProfApellido2()};
				notas.addRow(fila);
			}
			panel2.buildTabla(notas, tableNota, filterTextNota);
			///////////////////////////////////////////////////////////////
			filterTextNota.setAlignmentX(CENTER_ALIGNMENT);
			filterTextNota.setSize(10, 5);
			filterTextNota.setFont(fo);
			filterTextNota.setMaximumSize(filterTextNota.getPreferredSize() );
	
			imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
			jbrefreNota = new JButton(imagen);
			jbrefreNota.addActionListener(this);
			jbrefreNota.setToolTipText("Actualizar tabla de plan de estudios!");
			jbrefreNota.setAlignmentX(CENTER_ALIGNMENT);
			panel2.add(jbrefreNota, BorderLayout.CENTER);
	
			label = new JLabel(" Buscar Cursos:    ");
			label.setFont(fo);
			panel2.add(label);
			panel2.add(filterTextNota, BorderLayout.CENTER);
			panel2.add(new JLabel("                       "));
			
			jbaplicarNota = new JButton("Aplicar Cambios");
			jbaplicarNota.addActionListener(this);
			jbaplicarNota.setFont(fo);
			jbaplicarNota.setToolTipText("Aplicar cambios hechos a la matrícula!");
			jbaplicarNota.setAlignmentX(CENTER_ALIGNMENT);
			panel2.add(jbaplicarNota, BorderLayout.CENTER);
			
			jbdesmatEs = new JButton("Desmatricular");
			jbdesmatEs.addActionListener(this);
			jbdesmatEs.setFont(fo);
			jbdesmatEs.setToolTipText("Desmatricular a un estudiante de uno de sus cursos!");
			jbdesmatEs.setAlignmentX(CENTER_ALIGNMENT);
			panel2.add(jbdesmatEs, BorderLayout.CENTER);
			//////////////////////////////////////////////////////////////
	
			principal.add(panel2);
			principal.add(new JScrollPane(tableNota));
		}
	}
	public boolean getEstado(){
		return this.estado;
	}
	public boolean validarRepetidos(String buscar){
		for(int i=0;i<listnotas.size();i++){
			if(listnotas.get(i).getCurso().getCursoId().equals(buscar))
				return false;
		}
		for(int i=0;i<listcursos.size();i++){
			if(listcursos.get(i).getCursoId().equals(buscar))
				return false;
		}
		return true;
	}
	public boolean eliminar(String buscar){
		for(int i=0;i<listnotas.size();i++){
			if(listnotas.get(i).getCurso().getCursoId().equals(buscar)){
				if(bnota.find(listnotas.get(i).getId())){
					if(bperiodo.find(listper.get(jcbperiodos.getSelectedIndex()).getPerPeriodo())){
						if(bnota.delete()){
							JOptionPane.showMessageDialog(null, "Se removió el curso de la matrícula del estudiante "+ idest+" con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else
							JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Período no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				return true;
			}
		}
		for(int i=0;i<listcursos.size();i++){
			if(listcursos.get(i).getCursoId().equals(buscar)){
				listcursos.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean ingresarNuevos(){
		for(int i=0;i<listcursos.size();i++){
			if(bcurso.find(listcursos.get(i).getCursoId())){
				if(bperiodo.find(listper.get(jcbperiodos.getSelectedIndex()).getPerPeriodo())){
					bnota.setNota(idest, listcursos.get(i).getCursoId(), 0, 0);
					if(bnota.insert()){
					}else{
						JOptionPane.showMessageDialog(null, "Error al ingresar curso: "+listcursos.get(i).getCursoId()+" a la matrícula del estudiante: "+idest , "Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Período no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else{
				JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbinseCur) {
			if(tableCur.getSelectedRowCount() == 1){
				if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
					if(this.validarRepetidos((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
						listcursos.add(bcurso.getCurso());
					}else{
						JOptionPane.showMessageDialog(null, "Curso ya está matriculado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbaplicarNota){
				if(this.ingresarNuevos()){
					listcursos = new ArrayList<Curso>();
					JOptionPane.showMessageDialog(null, "Se modificó la matrícula del estudiante "+idest+" con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				if(e.getSource() == jbdesmatEs){
					if(tableNota.getSelectedRowCount() == 1){
						this.eliminar((String)tableNota.getValueAt(tableNota.getSelectedRow(), 0));
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		}
		//bestudiante.setNotas(idest);
		principal.removeAll();
		cursos = new DefaultTableModel();
		tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		notas = new DefaultTableModel();
		tableNota = new JTable(notas){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera, idest);
		if(estado){
			principal.setVisible(false);
			principal.setVisible(true);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			select = jcbperiodos.getSelectedIndex();
			principal.removeAll();
			listcursos = new ArrayList<Curso>();
			cursos = new DefaultTableModel();
			tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
			notas = new DefaultTableModel();
			tableNota = new JTable(notas){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
			this.init(bandera, idest);
			if(estado){
				principal.setVisible(false);
				principal.setVisible(true);
			}
		}
	}
}