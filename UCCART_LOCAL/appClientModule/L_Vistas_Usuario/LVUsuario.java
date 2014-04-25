package L_Vistas_Usuario;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Usuario;

import beans.B_Usuario;
import L_Vistas.LVPanel;
import L_Vistas_Academico.LVAcademico;
import L_Vistas_Academico.LVMIngresar;
import L_Vistas_Academico.LVProfesor;
import L_Vistas_Financiero.LVContador;
import L_Vistas_Registro.LVRegistro;

@SuppressWarnings("all")
public class LVUsuario extends LVPanel implements MouseListener, ActionListener {
	private LVUIngresar lvui;
	private DefaultTableModel usuarios;
	private B_Usuario busuario;
	private JButton jbelimUs, jbrefreUs, jbinseUs, jbpassUs;
	private JTable tableUsu;
	private final JTextField filterTextUsu;
	private String actual;
	public LVUsuario(JFrame padre){
		super();
		lvui = new LVUIngresar(padre, true, fo);
		usuarios = new DefaultTableModel();
		busuario = new B_Usuario();
		tableUsu = new JTable(usuarios){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		filterTextUsu = new JTextField(20);
	}
	public void init( String usuario){
		actual = usuario;
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();

		usuarios.addColumn("ID");
		usuarios.addColumn("Nombre");
		usuarios.addColumn("Tipo");
		String tipo;
		List<Usuario> listusu = busuario.selectAll();
		for(int i=0;i<listusu.size();i++){
			switch(listusu.get(i).getUsTipo()){
			case 0:{
				tipo = "SU-REGISTRO";
			}
			break;
			case 1:{
				tipo = "REGISTRO";
			}
			break;
			case 2:{
				tipo = "SU-ACADÉMICO";
			}
			break;
			case 3:{
				tipo = "ACADÉMICO";
			}
			break;
			case 4:{
				tipo = "SU-COBROS";
			}
			break;
			case 5:{
				tipo = "CONTADURÍA";
			}
			break;
			case 6:{
				tipo = "COBROS";
			}
			break;
			case 7:{
				tipo = "CAJA";
			}
			break;
			case 8:{
				tipo = "SU-RECTORÍA";
			}
			break;
			case 9:{
				tipo = "IT";
			}
			break;
			case 10:{
				tipo = "PROFESOR";
			}
			break;
			case 11:{
				tipo = "CONTADOR";
			}
			break;
			default:{
				tipo = "Sin asignar";
			}
			}
			if(!actual.equals(listusu.get(i).getUsId())){
				String[] fila = {listusu.get(i).getUsId(), listusu.get(i).getUsNombre(), tipo};
				usuarios.addRow(fila);
			}
		}
		this.buildTabla(usuarios, tableUsu, filterTextUsu);
		///////////////////////////////////////////////////////////////
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
		filterTextUsu.setAlignmentX(CENTER_ALIGNMENT);
		filterTextUsu.setSize(10, 5);
		filterTextUsu.setFont(fo);
		filterTextUsu.setMaximumSize(filterTextUsu.getPreferredSize() );

		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/reload.png"));
		jbrefreUs = new JButton(imagen);
		jbrefreUs.addActionListener(this);
		jbrefreUs.setToolTipText("Modificar Usuario seleccionado!");
		jbrefreUs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbrefreUs, BorderLayout.CENTER);

		JLabel label = new JLabel(" Buscar Usuarios:    ");
		label.setFont(fo);
		panel2.add(label);
		panel2.add(filterTextUsu, BorderLayout.CENTER);
		panel2.add(new JLabel("                                                        "));

		jbpassUs = new JButton("Ver Contraseña");
		jbpassUs.addActionListener(this);
		jbpassUs.setFont(fo);
		jbpassUs.setToolTipText("Visualizar contraseña de usuario seleccionado!");
		jbpassUs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbpassUs, BorderLayout.CENTER);

		jbinseUs = new JButton("Ingresar");
		jbinseUs.addActionListener(this);
		jbinseUs.setFont(fo);
		jbinseUs.setToolTipText("Ingresar un nuevo Usuario!");
		jbinseUs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbinseUs, BorderLayout.CENTER);

		jbelimUs = new JButton("Eliminar");
		jbelimUs.addActionListener(this);
		jbelimUs.setFont(fo);
		jbelimUs.setToolTipText("Eliminar Usuario seleccionado!");
		jbelimUs.setAlignmentX(CENTER_ALIGNMENT);
		panel2.add(jbelimUs, BorderLayout.CENTER);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel2);
		this.add(new JScrollPane(tableUsu));

	}
	public void addScrollPane(JFrame frame){
		JScrollPane pane = new JScrollPane(lvui);
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
		// TODO Auto-generated method stubelse
		if(e.getSource() == jbelimUs) {
			if(tableUsu.getSelectedRowCount() == 1){
				if(busuario.find((String)tableUsu.getValueAt(tableUsu.getSelectedRow(), 0))){
					if(busuario.delete()){
						JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null, "No se pudo eliminar, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Usuario no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 usuario", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbinseUs) {
				lvui = new LVUIngresar((JFrame)lvui.getParent(), true, fo);
				lvui.init();
				lvui.setLocationRelativeTo(lvui.getParent());
				lvui.setVisible(true);
			}else{
				if(e.getSource() == jbpassUs){
					if(tableUsu.getSelectedRowCount() == 1){
						if(busuario.find((String)tableUsu.getValueAt(tableUsu.getSelectedRow(), 0))){
							JOptionPane.showMessageDialog(null, "Usuario: "+busuario.getUsuario().getUsNombre()+"    Contraseña: "+busuario.getUsuario().getUsPw()+"       ", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "Usuario no existe, refresque el programa", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar 1 usuario", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		this.removeAll();
		usuarios = new DefaultTableModel();
		tableUsu = new JTable(usuarios){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		this.init(actual);
	}


}
