package L_Vistas_Financiero;

//public class LVAranceles 

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Inventario;
import beans.B_Inventario;
import L_Vistas.FileChooser;
import L_Vistas.LVPanel;


@SuppressWarnings("all")
public class LVInventario extends LVPanel implements ActionListener, ItemListener {
	private DefaultTableModel inventarios;
	private B_Inventario binventario;
	private JButton jbelimIn, jbrefreIn, jbmodifIn, jbinseIn;
	private JTable tableInv;
	private final JTextField filterTextAr;
	private LVInvIngresar lvei;
	private LVInModificar lvem;
	private JComboBox jcbalfab, jcbcarreras;
	private int selectal, selectcarr;
	private boolean bandera;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	public LVInventario(JFrame padre){
		super();
		lvei = new LVInvIngresar(padre, true, fo);
		lvem = new LVInModificar(padre, true, fo);
		inventarios = new DefaultTableModel();
		binventario = new B_Inventario();
		tableInv = new JTable(inventarios){public boolean isCellEditable(int rowIndex, int colIndex) {
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
		
		
		inventarios.addColumn("ID");
		inventarios.addColumn("Nombre");
		inventarios.addColumn("Marca");
		inventarios.addColumn("Modelo");
		inventarios.addColumn("Valor");
		inventarios.addColumn("Cantidad");
		inventarios.addColumn("Proveedor");
		
		List<Inventario> listInv = binventario.selectAll();
		
		if(listInv.size() != 0){
			listInv = binventario.selectXalfa(jcbalfab.getSelectedItem().toString());
		
		for(int i=0;i<listInv.size();i++){
			String[] fila = {listInv.get(i).getInventariolId().toString(), listInv.get(i).getInventarioNombre(), listInv.get(i).getInventarioMarca(), listInv.get(i).getinventarioModelo(), String.valueOf(listInv.get(i).getInventarioValor()), 
					String.valueOf(listInv.get(i).getInventarioCantidad()), listInv.get(i).getInventarioProveedor()};
			inventarios.addRow(fila);
		}
	}
		
		this.buildTabla(inventarios, tableInv, filterTextAr);
		///////////////////////////////////////////////////////////////
		
		filterTextAr.setAlignmentX(CENTER_ALIGNMENT);
		filterTextAr.setSize(10, 5);
		filterTextAr.setFont(fo);
		filterTextAr.setMaximumSize(filterTextAr.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreIn = new JButton(imagen);
		jbrefreIn.addActionListener(this);
		jbrefreIn.setToolTipText("Actualizar tabla!");
		jbrefreIn.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreIn, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Articulo en Inventario:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextAr, BorderLayout.CENTER);
		panel2.add(new JLabel("     "));
		
		jbinseIn = new JButton("Ingresar");
		jbinseIn.addActionListener(this);
		jbinseIn.setFont(fo);
		jbinseIn.setToolTipText("Ingresar un nuevo Articulo al Inventario!");
		jbinseIn.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseIn, BorderLayout.CENTER);
		
		jbmodifIn = new JButton("Modificar");
		jbmodifIn.addActionListener(this);
		jbmodifIn.setFont(fo);
		jbmodifIn.setToolTipText("Modificar Articulo seleccionado del Inventario!");
		jbmodifIn.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbmodifIn, BorderLayout.CENTER);

		jbelimIn = new JButton("Eliminar");
		jbelimIn.addActionListener(this);
		jbelimIn.setFont(fo);
		jbelimIn.setToolTipText("Eliminar Articulo seleccionado del Inventario!");
		jbelimIn.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimIn, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableInv));
	}
	public void reducir(){
		jbelimIn.setVisible(false);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/////////EVENTO PARA EL BOTON ELIMINAR////////////
		
				if(e.getSource() == jbelimIn) {
					if(tableInv.getSelectedRowCount() == 1){
						if(binventario.find(  (String)tableInv.getValueAt(tableInv.getSelectedRow(), 0))){
							if(binventario.delete()){
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
					if(e.getSource() == jbinseIn) {
						lvei = new LVInvIngresar((JFrame)lvei.getParent(), true, fo);
						lvei.init();
						lvei.setLocationRelativeTo(jbinseIn.getParent());
						lvei.setVisible(true);
						
						
					} 
					
					
/////////EVENTO PARA EL BOTON MODIFICAR////////////			
						
				else{
							if(e.getSource() == jbmodifIn) {
								if(tableInv.getSelectedRowCount() == 1){
									if(binventario.find((String)tableInv.getValueAt(tableInv.getSelectedRow(), 0))){
										lvem = new LVInModificar((JFrame)lvem.getParent(), true, fo);
										lvem.init(binventario);
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
				inventarios = new DefaultTableModel();
				tableInv = new JTable(inventarios){public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;}};
				this.init(bandera);
			}
	

	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			selectal = jcbalfab.getSelectedIndex();
			this.removeAll();
			inventarios = new DefaultTableModel();
	        tableInv = new JTable(inventarios){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
			this.init(bandera);
	    }
	}
}
