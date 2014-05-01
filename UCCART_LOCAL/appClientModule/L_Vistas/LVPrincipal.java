package L_Vistas;

import javax.swing.*;

import L_Vistas_Academico.LVAcademico;
import L_Vistas_Academico.LVProfTabs;
import L_Vistas_Academico.LVProfesor;
import L_Vistas_Academico.LVRector;
import L_Vistas_Financiero.LVContador;
import L_Vistas_Financiero.LVCajero;
import L_Vistas_Registro.LVRegistro;
import L_Vistas_Usuario.LVTabs;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.awt.*;
import java.awt.event.*;

import beans.B_Usuario;

@SuppressWarnings("all")
public class LVPrincipal extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * @param args
	 */
	private LVRegistro lvr;
	private LVProfTabs lvp;
	private LVAcademico lva;
	private LVTabs lvt;
	private LVRector lvre;
	private LVContador contador;
	private LVCajero cajero;
	//private JComboBox<String> tipo;
	private JFrame log;
	private JPanel jpencabezado;
	private LVLogging logging;
	private JLabel sesion,JLusuario;
	private Font fo;
	private Color ccolor;
	private B_Usuario usuarioBean;
	private LVFondo lvfondo;
	private JMenuBar Jmb;
	private JMenuItem jmisesion;
	
	public LVPrincipal(){
		super();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/UCCART_image1.png"));
		this.setIconImage(imagen.getImage());
		usuarioBean = new B_Usuario();
		log = new JFrame();
		fo = new Font("Helvetica", 1, 13);
		lvr = new LVRegistro(this);
		lvp = new LVProfTabs(this);
		contador = new LVContador(this);
		cajero = new LVCajero(this);
		lva = new LVAcademico(this);
		lvt = new LVTabs(this);
		lvre = new LVRector(this);
		ccolor = new Color(42, 42, 42);
		logging = new LVLogging();
		lvfondo = new LVFondo();
	}
	public void init(){
		this.logging();
		this.Ventana();
		this.JMenuBarInit();
	}
	private void logging(){
		this.setLayout(new BorderLayout());
		lvfondo.setLayout(new BorderLayout());
		logging.init();
		logging.setOpaque(false);
		lvfondo.add(logging);
		logging.getUsuario().addKeyListener(this);
		logging.getContrasena().addKeyListener(this);
		logging.getIniciar().addKeyListener(this);
		logging.getIniciar().addActionListener(this);
	}
	private void Ventana(){
		this.add(lvfondo);
		this.setFont(fo);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setTitle("Uccart");
        //this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void VentanaTipo(int tipo){
		this.VentanaTipoAux();
		JLusuario.setText("      Sesión: "+usuarioBean.getUsuario().getUsNombre());
        switch(tipo){
        case 0:{
        	setTitle("SU-REGISTRO SECAU");
        	lvr = new LVRegistro(this);
        	lvr.init(false, logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(lvr);
			lvr.setVisible(true);
        }
        break;
        case 1:{
        	setTitle("REGISTRO SECAU");
        	lvr = new LVRegistro(this);
        	lvr.init(true, logging.getUsuario().getText(), JLusuario);
        	lvr.reducir();
        	lvfondo.add(lvr);
			lvr.setVisible(true);
        }
        break;
        case 2:{
        	setTitle("SU-ACADÉMICO SECAU");
        	lva = new LVAcademico(this);
        	lva.init(false, logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(lva);
			lva.setVisible(true);
			//lva.getLvc().addScrollPane(this);
        }
        break;
        case 3:{
        	setTitle("ACADÉMICO SECAU");
        	lva = new LVAcademico(this);
        	lva.init(true,logging.getUsuario().getText(), JLusuario);
        	lva.getLvc().reducir();
        	lvfondo.add(lva);
			lva.setVisible(true);
        }
        break;
        case 4:{
        	setTitle("CONTADOR");
        	contador = new LVContador(this);
        	contador.init(logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(contador);
			lvre.setVisible(true);
        }
        break;
        case 5:{
        	setTitle("CONTADURÍA SECAU");
        	
        }
        break;
        case 6:{
        	setTitle("COBROS SECAU");
        	
        }
        break;
        case 7:{
        	setTitle("CAJA SECAU");
        	cajero = new LVCajero(this);
        	cajero.init(logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(cajero);
			lvre.setVisible(true);
        	
        }
        break;
        case 8:{
        	setTitle("SU-RECTORÍA SECAU");
        	lvre = new LVRector(this);
        	lvre.init(logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(lvre);
			lvre.setVisible(true);
        }
        break;
        case 9:{
        	setTitle("IT SECAU");
        	lvt = new LVTabs(this);
        	lvt.init(logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(lvt);
			lvt.setVisible(true);
        }
        break;
        case 10:{
        	setTitle("PROFESOR SECAU");
        	lvp = new LVProfTabs(this);
        	lvp.init(logging.getUsuario().getText(), JLusuario);
        	lvfondo.add(lvp);
			lvp.setVisible(true);
        }
        break;
		}
	}
	private void VentanaTipoAux(){
		
		jpencabezado = new JPanel();
		GroupLayout layout = new GroupLayout(jpencabezado);
		jpencabezado.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
        jpencabezado.setOpaque(false);
		
        Font fo = new Font("Helvetica", 1, 20);
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/UCCART_image1.png"));
        JLusuario = new JLabel(imagen);
        JLusuario.setForeground(ccolor);
        JLusuario.setFont(fo);
        JLusuario.setAlignmentX(CENTER_ALIGNMENT);
        
        fo = new Font("Helvetica", 1, 15);
        
        sesion = new JLabel("Cerrar Sesión");
        sesion.setFont(fo.deriveFont((float)16));
        sesion.setForeground(ccolor);
        sesion.setAlignmentX(CENTER_ALIGNMENT);
        sesion.addMouseListener(this);
        
        jmisesion.setEnabled(true);
		
        layout.setHorizontalGroup(
        		   layout.createSequentialGroup()
        		      .addComponent(JLusuario)
        		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        		    	   .addGroup(layout.createSequentialGroup()
        		    	   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		           .addComponent(sesion)))
        		);
        		layout.setVerticalGroup(
        		   layout.createSequentialGroup()
        		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		           .addComponent(sesion)
        		           .addComponent(JLusuario))
        		);
        lvfondo.add(jpencabezado, BorderLayout.NORTH);
		
	}
	private int comfirmaUsuario(){
		int tipo;
		if((usuarioBean.find(this.logging.getUsuario().getText())== true) && this.logging.getContrasena().getText().equals(usuarioBean.getUsuario().getUsPw())== true){
			return tipo = usuarioBean.getUsuario().getUsTipo();
			
		}else{
			
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "Usuario o contraseña incorrecta ", "Error", JOptionPane.ERROR_MESSAGE);
			
			return tipo = -1;
		}
		
		
	}

	
	private void JMenuBarInit(){
		Jmb = new JMenuBar();
		JMenu jmmenu = new JMenu("Menú");
		JMenu jm2 = new JMenu("Ayuda");
		JMenu jm3 = new JMenu("Acerca de");
		
		jmisesion = new JMenuItem("Cerrar Sesión");
		jmisesion.addMouseListener(this);
		jmisesion.setEnabled(false);
		JMenuItem jmi2 = new JMenuItem("Manual");
		JMenuItem jmi3 = new JMenuItem("Desarrollado por G22 UNA");
		this.setJMenuBar(Jmb);
		
		jmmenu.add(jmisesion);
		jm2.add(jmi2);
		jm3.add(jmi3);
		
		Jmb.add(jmmenu);
		Jmb.add(jm2);
		Jmb.add(jm3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error en el look and feel", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		EventQueue.invokeLater(new Runnable() {

            public void run() {
            	LVPrincipal lvp = new LVPrincipal();
        		lvp.init();
            }
        });
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logging.getIniciar()){
			log.dispose();
			int tipo = this.comfirmaUsuario();
			if(!(tipo==-1)){
				logging.setVisible(false);
				this.VentanaTipo(tipo);
			}else{
				log.setVisible(true);
				
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == sesion){
			sesion.setForeground(Color.decode("#fed428"));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == sesion){
			sesion.setForeground(ccolor);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == sesion || e.getSource() == jmisesion && jmisesion.isEnabled()){
			sesion.setForeground(ccolor);
			jmisesion.setEnabled(false);
			lvr.setVisible(false);
			lvp.setVisible(false);
			//lvc.setVisible(false);
			lva.setVisible(false);
			lvt.setVisible(false);
			lvre.setVisible(false);
			contador.setVisible(false);
			jpencabezado.setVisible(false);
			logging.setVisible(true);
			logging.getUsuario().requestFocus();
			this.setTitle("SISTEM v1.0");
			//contrasena.setText("");
		} 
		
	}
	
	/*
	log = new JFrame();
	fo = new Font("Helvetica", 1, 13);
	lvr = new LVRegistro(this);
	lvp = new LVProfTabs(this);
	contador = new LVContador(this);
	cajero = new LVCajero(this);
	lva = new LVAcademico(this);
	lvt = new LVTabs(this);
	lvre = new LVRector(this);
	ccolor = new Color(42, 42, 42);
	logging = new LVLogging();
	lvfondo = new LVFondo();
	
	*/
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == logging.getContrasena() || e.getSource() == logging.getIniciar() || e.getSource() == logging.getUsuario()){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				logging.getIniciar().doClick();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
