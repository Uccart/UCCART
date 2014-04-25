package L_Vistas_Academico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Carrera;
import model.Curso;
import model.Materia;
import model.Plan;
import beans.B_Carrera;
import beans.B_Materia;
import beans.B_Plan;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVPlan extends LVPanel implements MouseListener, ActionListener, ItemListener {
	private DefaultTableModel materias, planes;
	private B_Materia bmateria;
	private B_Carrera bcarrera;
	private B_Plan bplan;
	private JButton jbrefreMa, jbinseMa, jbrefrePlan, jbelimPlan, jbaplicarPlan;
	private JTable tableMat, tablePlan;
	private final JTextField filterTextMat, filterTextPlan;
	private JComboBox jcbcarreras;
	private List<Carrera> listcarr;
	private boolean bandera;
	private int select;
	private List<Materia> listnueva;
	private List<Plan> listplan;
	
	
	public LVPlan(){
		super();
		materias = new DefaultTableModel();
		planes = new DefaultTableModel();
		bmateria = new B_Materia();
		bcarrera = new B_Carrera();
		listnueva = new ArrayList<Materia>();
		bplan = new B_Plan();
		tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		tablePlan = new JTable(planes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextMat = new JTextField(20);
		filterTextPlan = new JTextField(20);
		select = 0;
	}
	
	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		materias.addColumn("Código");
		materias.addColumn("Nombre");
		materias.addColumn("Área");
		materias.addColumn("Laboratorio");
		materias.addColumn("Créditos");
		String lab;
		List<Materia> listmat = bmateria.selectAll();
		for(int i=0;i<listmat.size();i++){
			lab = "No";
			if(listmat.get(i).getMateriaLab() == 0)
				lab = "Si";
			String[] fila = {listmat.get(i).getMateriaId(),listmat.get(i).getMateriaNombre(), listmat.get(i).getMateriaArea(), 
					lab, listmat.get(i).getMateriaCreditos().toString()};
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
		jbrefreMa.setToolTipText("Actualizar tabla de materias!");
		jbrefreMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreMa, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Materias:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextMat, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));

		jbinseMa = new JButton("Agregar");
		jbinseMa.addActionListener(this);
		jbinseMa.setFont(fo);
		jbinseMa.setToolTipText("Se agregar� la materia al plan de la carrera seleccionada!");
		jbinseMa.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseMa, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableMat));

		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));

		jcbcarreras = new JComboBox<String>();
		jcbcarreras.setFont(fo);
		jcbcarreras.setToolTipText("Carreras existentes");
		listcarr = bcarrera.selectAll();
		for(int i=0;i<listcarr.size();i++){
			String item = listcarr.get(i).getCarrCod()+" "+listcarr.get(i).getCarrNombre();
			jcbcarreras.addItem(item);
		}
		if(listcarr.size()<=select)
			select = 0;
		if(listcarr.size() != 0)
			jcbcarreras.setSelectedIndex(select);
		jcbcarreras.setMaximumSize(jcbcarreras.getPreferredSize() );
		panel2.add(jcbcarreras);
		jcbcarreras.addItemListener(this);

		planes.addColumn("Código");
		planes.addColumn("Nombre");
		planes.addColumn("Área");
		planes.addColumn("Laboratorio");
		planes.addColumn("Créditos");
		planes.addColumn("Período");
		if(listcarr.size() != 0){
			listplan = bplan.getPlanesXcarrera(listcarr.get(select).getCarrCod());
			for(int i=0;i<listplan.size();i++){
				lab = "No";
				if(listplan.get(i).getMateria().getMateriaLab() == 0)
					lab = "Si";
				String[] fila = {listplan.get(i).getMateria().getMateriaId(), listplan.get(i).getMateria().getMateriaNombre(), listplan.get(i).getMateria().getMateriaArea(),
						lab, String.valueOf(listplan.get(i).getMateria().getMateriaCreditos()), String.valueOf(listplan.get(i).getPlanCiclo())};
				planes.addRow(fila);
			}
		}
		for(int i=0;i<listnueva.size();i++){
			lab = "No";
			if(listnueva.get(i).getMateriaLab() == 0)
				lab = "Si";
			String[] fila = {listnueva.get(i).getMateriaId(),listnueva.get(i).getMateriaNombre(), listnueva.get(i).getMateriaArea(), 
					lab, listnueva.get(i).getMateriaCreditos().toString(), ""};
			planes.addRow(fila);
		}
		this.buildTabla(planes, tablePlan, filterTextPlan);
		///////////////////////////////////////////////////////////////
		filterTextPlan.setAlignmentX(CENTER_ALIGNMENT);
		filterTextPlan.setSize(10, 5);
		filterTextPlan.setFont(fo);
		filterTextPlan.setMaximumSize(filterTextPlan.getPreferredSize() );

		imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefrePlan = new JButton(imagen);
		jbrefrePlan.addActionListener(this);
		jbrefrePlan.setToolTipText("Actualizar tabla de plan de estudios!");
		jbrefrePlan.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefrePlan, BorderLayout.CENTER);

		label = new JLabel(" Buscar Cursos:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextPlan, BorderLayout.CENTER);
		panel2.add(new JLabel("                       "));
		
		jbaplicarPlan = new JButton("Aplicar Cambios");
		jbaplicarPlan.addActionListener(this);
		jbaplicarPlan.setFont(fo);
		jbaplicarPlan.setToolTipText("Aplicar cambios hechos al plan de estudios!");
		jbaplicarPlan.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbaplicarPlan, BorderLayout.CENTER);

		jbelimPlan = new JButton("Excluir");
		jbelimPlan.addActionListener(this);
		jbelimPlan.setFont(fo);
		jbelimPlan.setToolTipText("Excluir materia seleccionada del plan de estudios!");
		jbelimPlan.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimPlan, BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////

		this.add(panel2);
		this.add(new JScrollPane(tablePlan));

	}
	
	
	public boolean validarRepetidos(String buscar){
		for(int i=0;i<listplan.size();i++){
			if(listplan.get(i).getMateria().getMateriaId().equals(buscar))
				return false;
		}
		for(int i=0;i<listnueva.size();i++){
			if(listnueva.get(i).getMateriaId().equals(buscar))
				return false;
		}
		return true;
	}
	public boolean eliminar(String buscar){
		for(int i=0;i<listplan.size();i++){
			if(listplan.get(i).getMateria().getMateriaId().equals(buscar)){
				if(bplan.find(listplan.get(i).getPlanCod())){
					if(bcarrera.find(listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod())){
						if(bplan.delete(listplan.get(i).getPlanCod())){
							JOptionPane.showMessageDialog(null, "Se removió la materia del plan de estudio con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else
							JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Carrera no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Plan no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				return true;
			}
		}
		for(int i=0;i<listnueva.size();i++){
			if(listnueva.get(i).getMateriaId().equals(buscar)){
				listnueva.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean ingresarNuevos(){
		for(int i=0;i<listnueva.size();i++){
			if(bmateria.find(listnueva.get(i).getMateriaId())){
				if(bcarrera.find(listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod())){
					bplan.setPlan(listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod(), listnueva.get(i).getMateriaId(), 0);
					if(!bplan.insert()){
						JOptionPane.showMessageDialog(null, "Error al ingresar materia: "+listnueva.get(i).getMateriaId()+" al plan de: "+listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod() , "Error", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Carrera no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else{
				JOptionPane.showMessageDialog(null, "Materia no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
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
		if(e.getSource() == jbinseMa) {
			if(tableMat.getSelectedRowCount() == 1){
				if(bmateria.find((String)tableMat.getValueAt(tableMat.getSelectedRow(), 0))){
					if(this.validarRepetidos((String)tableMat.getValueAt(tableMat.getSelectedRow(), 0))){
						listnueva.add(bmateria.getMateria());
					}else{
						JOptionPane.showMessageDialog(null, "Materia ya está incluida en plan actual", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Materia no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 materia", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbaplicarPlan){
				if(this.ingresarNuevos()){
					listnueva = new ArrayList<Materia>();
					JOptionPane.showMessageDialog(null, "Se modificó el plan de estudio con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				if(e.getSource() == jbelimPlan){
					if(tablePlan.getSelectedRowCount() == 1){
						this.eliminar((String)tablePlan.getValueAt(tablePlan.getSelectedRow(), 0));
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
		planes = new DefaultTableModel();
		tablePlan = new JTable(planes){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(bandera);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			select = jcbcarreras.getSelectedIndex();
			this.removeAll();
			listnueva = new ArrayList<Materia>();
			materias = new DefaultTableModel();
			tableMat = new JTable(materias){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
			planes = new DefaultTableModel();
			tablePlan = new JTable(planes){public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;}};
			this.init(bandera);
		}
	}
}
