package L_Vistas_Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import beans.B_Usuario;


@SuppressWarnings("all")
public class LVUIngresar extends JDialog implements ActionListener {
	private JButton jbagregar;
    private JTextField jtfid, jtfnombre;
    private JPasswordField jtfcontrasena, jtfrepcon;
    private JComboBox jcbtipo;
    private B_Usuario busuario;
    private Font fo;
	public LVUIngresar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		fo = f;
		busuario = new B_Usuario();
	}
	
	public void init(){
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Usuario"));
		
		JLabel jLabel2 = new JLabel("ID:");
		jLabel2.setFont(fo);
		JLabel jLabel3 = new JLabel("Contraseña:");
		jLabel3.setFont(fo);
		JLabel jLabel4 = new JLabel("Nombre:");
		jLabel4.setFont(fo);
		JLabel jLabel5 = new JLabel("Tipo:");
		jLabel5.setFont(fo);
		JLabel jLabel6 = new JLabel("Repetir Contraseña:");
		jLabel6.setFont(fo);
		
		jtfid = new JTextField(20);
		jtfid.setFont(fo);
		jtfnombre = new JTextField(20);
		jtfnombre.setFont(fo);
		jtfcontrasena = new JPasswordField(20);
		jtfcontrasena.setFont(fo);
		jtfrepcon = new JPasswordField(20);
		jtfrepcon.setFont(fo);
		
		jcbtipo = new JComboBox();
		jcbtipo.setModel(new DefaultComboBoxModel(new String[] { "SU-REGISTRO", "REGISTRO", "SU-ACADÉMICO", "ACADÉMICO", "SU-COBROS",
				"CONTADURÍA", "COBROS", "CAJA", "SU-RECTORÍA", "IT", "PROFESOR" }));
		
		jbagregar = new JButton("Agregar");
		jbagregar.addActionListener(this);
		jbagregar.setFont(fo);
		jbagregar.setToolTipText("Agregar nuevo usuario al sistema!");
		
		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(panel2);
		panel2.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfid, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfcontrasena)
                    .addComponent(jtfrepcon)
                    .addComponent(jtfnombre)
                    .addComponent(jcbtipo, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfrepcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jcbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(panel);
		panel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbagregar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jbagregar)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbagregar){
			if(!("".equals(jtfid.getText()) ) && !("".equals(jtfnombre.getText())&&!("".equals(jtfcontrasena.getText())))){
				if(busuario.validapk(jtfid.getText())){
					if(jtfrepcon.getText().equals(jtfcontrasena.getText())){
						busuario.setUsuario(jtfid.getText(), jtfcontrasena.getText(), jtfnombre.getText(), jcbtipo.getSelectedIndex());
						if(busuario.insert()){
							JOptionPane.showMessageDialog(null, "Usuario "+ jtfid.getText()+ " ingresado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							jtfid.setText("");
							jtfnombre.setText("");
							jtfcontrasena.setText("");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Error al agregar el usuario, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Contraseñas no coinciden ", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en usuarios", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
