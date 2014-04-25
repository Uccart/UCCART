package L_Vistas_Registro;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVBeca extends LVPanel implements MouseListener{
	private JLabel jlingresar, jleliminar, jlmodificar;
	private JInternalFrame isubframe;
	private LVBIngresar lvbi;
	private LVBModificar lvbm;
	private LVBEliminar lvbe;
	private boolean bandera;
	private Color ccolor;
	
	public LVBeca(){
		super();
		isubframe = new JInternalFrame();
		lvbi = new LVBIngresar();
		lvbm = new LVBModificar();
		lvbe = new LVBEliminar();
	}
	public void init(boolean ban){
		setLayout(new BorderLayout());
		bandera = ban;
		this.initIsubframe();
		
		jlingresar.setForeground(Color.BLUE);
		
		lvbi.init();
		this.add(new JScrollPane(lvbi), BorderLayout.CENTER);

	}
	public void addScrollPane(JFrame frame){
		JScrollPane pane = new JScrollPane(lvbi);
        frame.add(pane, BorderLayout.CENTER);
	}
	public void initIsubframe(){
		isubframe.setLayout(new GridLayout(4,1));
		isubframe.setFont(fo);
        isubframe.setTitle("Opciones");
        isubframe.setPreferredSize(new Dimension(100, 100));
        isubframe.setVisible(true);
        isubframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jlingresar = new JLabel("     Agregar");
		jlingresar.setFont(fo);
		jlingresar.setToolTipText("Ingresar nuevo curos al sistema");
		jlingresar.addMouseListener(this);
        jlingresar.setAlignmentX(CENTER_ALIGNMENT);
        isubframe.add(jlingresar, BorderLayout.CENTER);
        
        jlmodificar = new JLabel("   Modificar");
        jlmodificar.setFont(fo);
        jlmodificar.setToolTipText("Modificar uno de los cursos");
        jlmodificar.addMouseListener(this);
        jlmodificar.setAlignmentX(CENTER_ALIGNMENT);
        isubframe.add(jlmodificar, BorderLayout.CENTER);
        
        jleliminar = new JLabel("     Eliminar");
        jleliminar.setFont(fo);
        jleliminar.setToolTipText("Eliminar un curso del sistema");
        jleliminar.addMouseListener(this);
        jleliminar.setAlignmentX(CENTER_ALIGNMENT);
        isubframe.add(jleliminar, BorderLayout.CENTER);
        
        if(bandera){
        	reducir();
        }
        isubframe.setVisible(true);
        this.add(isubframe, BorderLayout.WEST);
	}
	public void reducir(){
		jleliminar.hide();
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
		if(e.getSource() == jlingresar){
			this.removeAll();
			isubframe = new JInternalFrame();
			this.initIsubframe();
			lvbi = new LVBIngresar();
			lvbi.init();
			jlingresar.setForeground(Color.BLUE);
			jlmodificar.setForeground(ccolor);
			jleliminar.setForeground(ccolor);
			this.add(lvbi, BorderLayout.CENTER);
		}else{
			if(e.getSource() == jlmodificar){
				this.removeAll();
				isubframe = new JInternalFrame();
				this.initIsubframe();
				lvbm = new LVBModificar();
				lvbm.init();
				jlmodificar.setForeground(Color.BLUE);
				jlingresar.setForeground(ccolor);
				jleliminar.setForeground(ccolor);
				this.add(lvbm, BorderLayout.CENTER);
			}else{
				if(e.getSource() == jleliminar){
					this.removeAll();
					isubframe = new JInternalFrame();
					this.initIsubframe();
					lvbe = new LVBEliminar();
					lvbe.init();
					jleliminar.setForeground(Color.BLUE);
					jlmodificar.setForeground(ccolor);
					jlingresar.setForeground(ccolor);
					this.add(lvbe, BorderLayout.CENTER);
				}
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
