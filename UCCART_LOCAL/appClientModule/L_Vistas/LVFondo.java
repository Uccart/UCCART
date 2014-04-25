package L_Vistas;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("all")
public class LVFondo extends JPanel {
	public LVFondo(){
		super();
	}
	@Override
	public void paint(Graphics g) {
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/fondo.png"));
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),
				this);

		setOpaque(false);
		super.paint(g);
	}
}
