package L_Vistas_Financiero;

//public class LVAranceles 

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Arancel;
import beans.B_Arancel;
import L_Vistas.FileChooser;
import L_Vistas.LVPanel;


@SuppressWarnings("all")
public class LVAranceles extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel aranceles;
	private B_Arancel barancel;
	private JButton jbelimAr, jbrefreAr, jbmodifAr, jbinseAr;
	private JTable tableAran;
	private final JTextField filterTextAr;
	private LVAranIngresar lvei;
	private LVAranModificar lvem;
	private JComboBox jcbalfab, jcbcarreras;
	private int selectal, selectcarr;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVAranceles(JFrame padre){
		super();
		lvei = new LVAranIngresar(padre, true, fo);
		lvem = new LVAranModificar(padre, true, fo);
		aranceles = new DefaultTableModel();
		barancel = new B_Arancel();
		tableAran = new JTable(aranceles){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextAr = new JTextField(20);
		selectal = 0;
		selectcarr = 0;
	}

	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		
		jcbalfab = new JComboBox<String>();
		jcbalfab.setFont(fo);
		jcbalfab.setToolTipText("Lista de aranceles por orden alfabético");
		jcbalfab.setModel(new DefaultComboBoxModel(new String[] {  "Sin filtro", "A-d", "E-h", "I-k", "L-o",
				"P-s", "T-z" }));
		jcbalfab.setSelectedIndex(selectal);
		jcbalfab.setMaximumSize(jcbalfab.getPreferredSize() );
		panel2.add(jcbalfab);
		jcbalfab.addItemListener(this);
		
		panel2.add(new JLabel("  "));
		
		
		aranceles.addColumn("ID");
		aranceles.addColumn("Descripcion");
		aranceles.addColumn("Tipo");
		aranceles.addColumn("Precio");
		
		List<Arancel> listAra = barancel.selectAll();
		
		if(listAra.size() != 0){
		listAra = barancel.selectXalfa(jcbalfab.getSelectedItem().toString());
		
		for(int i=0;i<listAra.size();i++){
			String[] fila = {listAra.get(i).getArancelId().toString(), listAra.get(i).getArancelDescripcion(), listAra.get(i).getArancelTipo(), String.valueOf(listAra.get(i).getArancelPrecio())};
			aranceles.addRow(fila);
		}
	}
		
		this.buildTabla(aranceles, tableAran, filterTextAr);
		///////////////////////////////////////////////////////////////
		
		filterTextAr.setAlignmentX(CENTER_ALIGNMENT);
		filterTextAr.setSize(10, 5);
		filterTextAr.setFont(fo);
		filterTextAr.setMaximumSize(filterTextAr.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreAr = new JButton(imagen);
		jbrefreAr.addActionListener(this);
		jbrefreAr.setToolTipText("Actualizar tabla!");
		jbrefreAr.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreAr, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Arancel:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextAr, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		
		jbinseAr = new JButton("Ingresar");
		jbinseAr.addActionListener(this);
		jbinseAr.setFont(fo);
		jbinseAr.setToolTipText("Ingresar un nuevo Arancel!");
		jbinseAr.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseAr, BorderLayout.CENTER);
		
		jbmodifAr = new JButton("Modificar");
		jbmodifAr.addActionListener(this);
		jbmodifAr.setFont(fo);
		jbmodifAr.setToolTipText("Modificar Arancel seleccionado!");
		jbmodifAr.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifAr, BorderLayout.CENTER);

		jbelimAr = new JButton("Eliminar");
		jbelimAr.addActionListener(this);
		jbelimAr.setFont(fo);
		jbelimAr.setToolTipText("Eliminar Arancel seleccionado!");
		jbelimAr.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimAr, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableAran));
	}
	public void reducir(){
		jbelimAr.setVisible(false);
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/////////EVENTO PARA EL BOTON ELIMINAR////////////
		
				if(e.getSource() == jbelimAr) {
					if(tableAran.getSelectedRowCount() == 1){
						if(barancel.find(  (String)tableAran.getValueAt(tableAran.getSelectedRow(), 0))){
							if(barancel.delete()){
								JOptionPane.showMessageDialog(null, "Arancel eliminado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							}else
								JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Arancel no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 arancel", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
/////////EVENTO PARA EL BOTON INSERTAR////////////	
					
				}else{
					if(e.getSource() == jbinseAr) {
						lvei = new LVAranIngresar((JFrame)lvei.getParent(), true, fo);
						lvei.init();
						lvei.setLocationRelativeTo(jbinseAr.getParent());
						lvei.setVisible(true);
						
						
					} 
					
					
/////////EVENTO PARA EL BOTON MODIFICAR////////////			
						
				else{
							if(e.getSource() == jbmodifAr) {
								if(tableAran.getSelectedRowCount() == 1){
									if(barancel.find((String)tableAran.getValueAt(tableAran.getSelectedRow(), 0))){
										lvem = new LVAranModificar((JFrame)lvem.getParent(), true, fo);
										lvem.init(barancel);
										lvem.setLocationRelativeTo(lvem.getParent());
										lvem.setVisible(true);
									}else{
										JOptionPane.showMessageDialog(null, "Arancel no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}else{
									JOptionPane.showMessageDialog(null, "Debe seleccionar 1 arancel", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
				}
				
				
				this.removeAll();
				aranceles = new DefaultTableModel();
				tableAran = new JTable(aranceles){public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;}};
				this.init(bandera);
			}
	

	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectal = jcbalfab.getSelectedIndex();
			this.removeAll();
			aranceles = new DefaultTableModel();
	        tableAran = new JTable(aranceles){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
}
