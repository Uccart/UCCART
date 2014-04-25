package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import beans.B_Inventario;



@SuppressWarnings("all")
public class LVInModificar extends JDialog implements ActionListener {
	private JButton jbModificar;
    private JTextField jtfid, jtfnombre, jtfvalor, jtfmarca, jtfmodelo, jtfcantidad, jtfproveedor;
    private B_Inventario binventario;
    private Font fo;
    
	public LVInModificar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		fo = f;
		binventario = new B_Inventario();
	}
	
	public void init(B_Inventario best){
		binventario = best;
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Articulo al Inventario"));
		
		JLabel jLabelId = new JLabel("ID:");
		jLabelId.setFont(fo);
		JLabel jLabelNom = new JLabel("Nombre:");
		jLabelNom.setFont(fo);
		JLabel jLabelMarca = new JLabel("Marca:");
		jLabelMarca.setFont(fo);
		JLabel jLabelValor = new JLabel("Precio:");
		jLabelValor.setFont(fo);
		JLabel jLabelModelo = new JLabel("Modelo:");
		jLabelModelo.setFont(fo);
		JLabel jLabelCantidad = new JLabel("Cantidad:");
		jLabelCantidad.setFont(fo);
		JLabel jLabelProveedor = new JLabel("Proveedor:");
		jLabelProveedor.setFont(fo);
		
		jtfid = new JTextField(20);
		jtfid.setFont(fo);
		jtfid.setText(binventario.getInventario().getInventariolId().toString());
		jtfid.setEditable(false);
		
		jtfnombre = new JTextField(20);
		jtfnombre.setFont(fo);
		
		jtfnombre = new JTextField(20);
		jtfnombre.setFont(fo);
		
		jtfvalor = new JTextField(20);
		jtfvalor.setFont(fo);
		jtfvalor.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                // Verificar si la tecla pulsada no es un digito
                if(((caracter < '0') ||
                        (caracter > '9')) &&
                        (caracter != '\b' /*corresponde a BACK_SPACE*/)){
                        e.consume();  // ignorar el evento de teclado
                    }
            }
        });
		jtfmarca = new JTextField(20);
		jtfmarca.setFont(fo);
		
		jtfmodelo = new JTextField(20);
		jtfmodelo.setFont(fo);
		
		jtfcantidad = new JTextField(20);
		jtfcantidad.setFont(fo);
		jtfcantidad.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                // Verificar si la tecla pulsada no es un digito
                if(((caracter < '0') ||
                        (caracter > '9')) &&
                        (caracter != '\b' /*corresponde a BACK_SPACE*/)){
                        e.consume();  // ignorar el evento de teclado
                    }
            }
        });
		
		jtfproveedor = new JTextField(20);
		jtfproveedor.setFont(fo);
		
		
		jbModificar = new JButton("Modificar");
		jbModificar.addActionListener(this);
		jbModificar.setFont(fo);
		jbModificar.setToolTipText("Modificar articulo del inventario!");
		
		
		
		
//////////////JLABEL////////////
		
	javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(panel2);
	panel2.setLayout(jPanel7Layout);
  jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
          .addContainerGap()
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelId)
              .addComponent(jLabelNom)
              .addComponent(jLabelValor)
              .addComponent(jLabelMarca)
              .addComponent(jLabelModelo)
              .addComponent(jLabelCantidad)
              .addComponent(jLabelProveedor)
              )
          .addGap(28, 28, 28)
          
          
          
 ////////////TEXTOS///////////
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jtfid, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
              .addComponent(jtfnombre)
              .addComponent(jtfvalor)
              .addComponent(jtfmarca)
              .addComponent(jtfmodelo)
              .addComponent(jtfcantidad)
              .addComponent(jtfproveedor, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addContainerGap())
  );
  
  ////////////TEXTOS///////////
  
  
  jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
          .addContainerGap()
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabelId)
              .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabelNom)
              .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelValor)
              .addComponent(jtfvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelMarca)
              .addComponent(jtfmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelModelo)
              .addComponent(jtfmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          //.addContainerGap()
      	.addGap(18, 18, 18)	
      	
      	.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelCantidad)
              .addComponent(jtfcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          
          .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelProveedor)
              .addComponent(jtfproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
      		
  )
  );
  
  ////////////////BOTON AGREGAR//////////////
  
  
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
                  .addComponent(jbModificar)))
          .addContainerGap())
  );
  jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          //////////////////////////////////////EL NUMERO DE ABAJO AJUSTA EL TAMANO DE N A S///////////////
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
          .addComponent(jbModificar)
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
		
		if(e.getSource() == this.jbModificar){
			if(!("".equals(jtfid.getText())) && !("".equals(jtfnombre.getText())) && !("".equals(jtfmarca.getText())) && !("".equals(jtfvalor.getText()))  && !("".equals(jtfcantidad.getText()))  && !("".equals(jtfproveedor.getText()))){
				
				
				if(jtfid.getText() != " "){
					binventario.setInventario(jtfid.getText(), jtfnombre.getText(), jtfmarca.getText(), jtfmodelo.getText(), Integer.parseInt(jtfvalor.getText()) , Integer.parseInt(jtfcantidad.getText()) , jtfproveedor.getText());
				
					if(binventario.update(jtfid.getText(), jtfnombre.getText(), jtfmarca.getText(), jtfmodelo.getText(), Integer.parseInt(jtfvalor.getText()) , Integer.parseInt(jtfcantidad.getText()) , jtfproveedor.getText())){
						
						jtfid.setText("");
						jtfnombre.setText("");
						jtfmarca.setText("");
						jtfmodelo.setText("");
						jtfvalor.setText("");
						jtfcantidad.setText("");
						jtfproveedor.setText("");
						
						this.dispose();
					JOptionPane.showMessageDialog(null, "Arancel "+ jtfid.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al agregar Arancel", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en Arancel", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}else{
				
				if(!("".equals(jtfid.getText())) && !("".equals(jtfnombre.getText())) && !("".equals(jtfmarca.getText())) && !("".equals(jtfvalor.getText()))  && !("".equals(jtfcantidad.getText()))  && !("".equals(jtfproveedor.getText()))){
					JOptionPane.showMessageDialog(null, "Error al agregar el arancel, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{
					binventario.setInventario(jtfid.getText(), jtfnombre.getText(), jtfmarca.getText(), jtfmodelo.getText(), Integer.parseInt(jtfvalor.getText()) , Integer.parseInt(jtfcantidad.getText()) , jtfproveedor.getText());
					
					if(binventario.update(jtfid.getText(), jtfnombre.getText(), jtfmarca.getText(), jtfmodelo.getText(), Integer.parseInt(jtfvalor.getText()) , Integer.parseInt(jtfcantidad.getText()) , jtfproveedor.getText())){
						
						jtfid.setText("");
						jtfnombre.setText("");
						jtfmarca.setText("");
						jtfmodelo.setText("");
						jtfvalor.setText("");
						jtfcantidad.setText("");
						jtfproveedor.setText("");
						
						
						this.dispose();
					JOptionPane.showMessageDialog(null, "Arancel "+ jtfid.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al agregar Arancel", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}
			}
			
		}
		
	}

}
