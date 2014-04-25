package L_Vistas_Academico;

import javax.swing.*;
import javax.swing.table.*;

import beans.B_Curso;
import beans.B_Periodo;
import beans.B_Profesor;

import model.Curso;
import model.Periodo;

import L_Vistas.LVPanel;
import L_Vistas_Usuario.LVUIngresar;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class LVProfesor extends LVPanel implements ActionListener, ItemListener {
	private B_Periodo bperiodo;
	private B_Profesor bprofesor;
	private B_Curso bcurso;
	private JButton jbnotas, jblista, jbrefre;
	private DefaultTableModel tmodelo;
	private JComboBox jcbperiodos;
	private final JTextField filterTextCur;
	private JTable tableCur;
	private DefaultTableModel cursos; 
	private List<Periodo> listper;
	private int select;
	private String profid;
	private LVPrNotas lvprn;
	private LVPrLista lvprl;
	
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVProfesor(JFrame padre){
		super();
		lvprn = new LVPrNotas(padre, true, fo);
		lvprl = new LVPrLista(padre, true, fo);
		
		bprofesor = new B_Profesor();
		bperiodo = new B_Periodo();
		bcurso = new B_Curso();
		cursos = new DefaultTableModel();
        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
		filterTextCur = new JTextField(20);
	}
	public void init(String p){
		setLayout(new BorderLayout());
		
		profid = p;
		
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
		if(jcbperiodos.getSelectedItem() != null){
			List<Curso> listcur = bprofesor.getCursosXperiodo(profid, (String)jcbperiodos.getSelectedItem());
			for(int i=0;i<listcur.size();i++){
				String[] fila = {listcur.get(i).getCursoId(), listcur.get(i).getMateria().getMateriaNombre(), listcur.get(i).getCursoAula(), listcur.get(i).getCursoSede(),
						listcur.get(i).getCursoCantactual().toString()};
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
		jbrefre = new JButton(imagen);
		jbrefre.addActionListener(this);
		jbrefre.setToolTipText("Actualizar tabla!");
		jbrefre.setAlignmentX(CENTER_ALIGNMENT);
        panel2.add(jbrefre, BorderLayout.CENTER);
        
		JLabel label = new JLabel(" Buscar Cursos:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextCur, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));
		
		this.add(panel2);
		this.add(new JScrollPane(tableCur));
        
        /////////////////////////////////////////////////////////////////////////////////////////
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        
        jbnotas = new JButton("Asignar notas");
        jbnotas.addActionListener(this);
        jbnotas.setFont(fo);
        jbnotas.setToolTipText("Asignar notas a los estudiantes del curso seleccionado!");
        jbnotas.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(jbnotas);
        
        jblista = new JButton("Estudiantes matriculados");
        jblista.addActionListener(this);
        jblista.setFont(fo);
        jblista.setToolTipText("Ver lista de estudiantes matriculados en el curso seleccionado!");
        jblista.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(jblista);
        
        this.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbnotas) {
			if(tableCur.getSelectedRowCount() == 1){
				if(bcurso.find((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0))){
					Calendar c = Calendar.getInstance();
					c.setTime(bcurso.getCurso().getPeriodo().getPerWeb());
					Date actual =bperiodo.getFechaServidor();
					c.add(Calendar.MONTH, 3);
					Date c1 = c.getTime();
					Calendar fin = c;
					fin.add(Calendar.MONTH, 2);
					if(c1.getTime()<=actual.getTime()){
						if(fin.getTime().getTime()>=actual.getTime()){
							lvprn = new LVPrNotas((JFrame)lvprn.getParent(), true, fo);
							lvprn.init(bcurso.getCurso().getCursoId());
							lvprn.setLocationRelativeTo(lvprn.getParent());
							lvprn.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Se sobrepasó el tiempo para subir notas, contacte con Departamento de Registro", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Aún no se puede asignar notas, permitido del "+dateFormat.format(c1)+" al "+dateFormat.format(fin.getTime()), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Curso no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jblista) {
				if(tableCur.getSelectedRowCount() == 1){
					lvprl = new LVPrLista((JFrame)lvprl.getParent(), true, fo);
					lvprl.init((String)tableCur.getValueAt(tableCur.getSelectedRow(), 0));
					lvprl.setLocationRelativeTo(lvprl.getParent());
					lvprl.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar 1 curso", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		this.removeAll();
		cursos = new DefaultTableModel();
        tableCur = new JTable(cursos){public boolean isCellEditable(int rowIndex, int colIndex) {
        	return false;}};
		this.init(profid);
		this.setVisible(false);
		this.setVisible(true);
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
			this.init(profid);
			this.setVisible(false);
			this.setVisible(true);
	    }
	}

}
