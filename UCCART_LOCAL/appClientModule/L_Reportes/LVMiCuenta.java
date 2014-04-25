package L_Reportes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import beans.B_Usuario;

import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVMiCuenta extends LVPanel implements ActionListener {
    private JButton jbenviar;
    private JPanel jpdatos;
    private JTextField jtfnombre;
    private JPasswordField jtfcontnew, jtfcontrep, jtfcontactual;
    private B_Usuario busuario;
    private String actual;
    private JLabel jlnombreusu;
    
    public LVMiCuenta(){
    	jpdatos = new JPanel();
    	jtfnombre = new JTextField(20);
    	jtfcontactual = new JPasswordField(20);
    	jtfcontnew = new JPasswordField(20);
    	jtfcontrep = new JPasswordField(20);
    	jbenviar = new JButton();
    	busuario = new B_Usuario();
    }
    public void init(String usuario, JLabel jlnu){
    	jlnombreusu = jlnu;
    	actual = usuario;
    	jpdatos.setFont(fo.deriveFont((float)16));
        JLabel jLabel1 = new JLabel("Nombre:");
        jLabel1.setFont(fo);
        JLabel jLabel2 = new JLabel("Contraseña actual:");
        jLabel2.setFont(fo);
        JLabel jLabel3 = new JLabel("Nueva contraseña:");
        jLabel3.setFont(fo);
        JLabel jLabel4 = new JLabel("Repetir:");
        jLabel4.setFont(fo);
        
        jtfnombre.setFont(fo);
    	jtfcontactual.setFont(fo);
    	jtfcontnew.setFont(fo);
    	jtfcontrep.setFont(fo);
       
        jbenviar.setFont(fo);
        jbenviar.addActionListener(this);

        jpdatos.setBorder(BorderFactory.createTitledBorder("Datos Personales"));

        javax.swing.GroupLayout jpdatosLayout = new javax.swing.GroupLayout(jpdatos);
        jpdatos.setLayout(jpdatosLayout);
        jpdatosLayout.setHorizontalGroup(
            jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfcontnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfcontactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfcontrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jpdatosLayout.setVerticalGroup(
            jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpdatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfcontactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfcontnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfcontrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jbenviar.setText("Enviar Cambios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbenviar))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jpdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jbenviar))
        );
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbenviar){
			if(!("".equals(jtfcontnew.getText()) ) && !("".equals(jtfnombre.getText())&&("".equals(jtfcontactual.getText()))&&("".equals(jtfcontrep.getText())))){
				busuario.find(actual);
				if(busuario.getUsuario().getUsPw().equals(jtfcontactual.getText())){
					if(jtfcontrep.getText().equals(jtfcontnew.getText())){
						if(busuario.update(actual,  jtfcontnew.getText(), jtfnombre.getText(), busuario.getUsuario().getUsTipo())){
							JOptionPane.showMessageDialog(null, "Usuario "+jtfnombre.getText() + " modificado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							jlnombreusu.setText("      Sesión: "+jtfnombre.getText());
							jtfcontnew.setText("");
							jtfnombre.setText("");
							jtfcontactual.setText("");
							jtfcontrep.setText("");
						}else{
							JOptionPane.showMessageDialog(null, "Error al modificar usuario ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Nuevas contraseñas no coinciden ", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
