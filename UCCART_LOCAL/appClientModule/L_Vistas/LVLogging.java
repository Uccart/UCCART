package L_Vistas;

import java.awt.*;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("all")
public class LVLogging extends LVPanel {
	private JButton iniciar;
	private JTextField usuario;
	private JPasswordField contrasena;
	 private JLabel jLabel5, jLabel6;

	public LVLogging(){
		super();
	}

	public void init(){
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/uccart2.png"));
		JLabel jLabel1 = new JLabel(imagen);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setFont(fo.deriveFont((float) 18));
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setFont(fo.deriveFont((float) 18));
		
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		
		usuario = new JTextField(20);
		usuario.setFont(fo.deriveFont((float) 18));
		
		contrasena = new JPasswordField(20);
		contrasena.setFont(fo.deriveFont((float) 18));
		
		JSeparator jSeparator1 = new JSeparator();
		JSeparator jSeparator2 = new JSeparator();
		
		iniciar = new JButton();
		iniciar.setFont(fo.deriveFont((float) 18));
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setFont(fo.deriveFont((float) 26));

		jLabel2.setText("Usuario:");

		jLabel3.setText("Contraseña:");

		iniciar.setText("Iniciar");

		jLabel4.setText("Sistema UCCART");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iniciar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jSeparator2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addComponent(jSeparator1)))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iniciar)
                .addContainerGap(260, Short.MAX_VALUE))
        );
		// </editor-fold>
		// Variables declaration - do not modify
	}

	public JButton getIniciar() {
		return iniciar;
	}

	public void setIniciar(JButton iniciar) {
		this.iniciar = iniciar;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JPasswordField getContrasena() {
		return contrasena;
	}

	public void setContrasena(JPasswordField contrasena) {
		this.contrasena = contrasena;
	}/*
	@Override
	public void paint(Graphics g) {
		ImageIcon imagen = new ImageIcon(getClass().getResource("/L_Imagenes/fondo.png"));
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),
				this);

		setOpaque(false);
		super.paint(g);
	}*/
}
