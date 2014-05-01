package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import beans.B_Arancel;
import beans.B_Estudiante;
import beans.B_Periodo;


@SuppressWarnings("all")
public class LVAranModificar extends JDialog implements ActionListener {
	private JButton jbModificar;
    private JTextField jtfid, jtfdescripcion, jtfprecio;
    private JComboBox jcbtipo;
    private B_Arancel barancel;
    private Font fo;
    
	public LVAranModificar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		fo = f;
		barancel = new B_Arancel();
	}
	
	public void init(B_Arancel best){
		barancel = best;
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Arancel"));
		
		JLabel jLabelId = new JLabel("ID:");
		jLabelId.setFont(fo);
		
		JLabel jLabelDes = new JLabel("Descripcion:");
		jLabelDes.setFont(fo);
		JLabel jLabelTipo = new JLabel("Tipo:");
		jLabelTipo.setFont(fo);
		JLabel jLabelPrecio = new JLabel("Precio:");
		jLabelPrecio.setFont(fo);
		
		jtfid = new JTextField(20);
		jtfid.setFont(fo);
		jtfid.setText(barancel.getArancel().getArancelId().toString());
		jtfid.setEditable(false);
		
		
		jtfdescripcion = new JTextField(20);
		jtfdescripcion.setFont(fo);
		jtfdescripcion.setText(barancel.getArancel().getArancelDescripcion());
		
		jtfprecio = new JTextField(20);
		jtfprecio.setFont(fo);
		jtfprecio.addKeyListener(new KeyAdapter(){
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
		
		
		
		jtfprecio.setText(String.valueOf(barancel.getArancel().getArancelPrecio()));
		
		
		jcbtipo = new JComboBox();
		jcbtipo.setModel(new DefaultComboBoxModel(new String[] { "ENTRADA", "SALIDA" }));
		jcbtipo.setSelectedItem(barancel.getArancel().getArancelTipo());
		
		jbModificar = new JButton("Modificar");
		jbModificar.addActionListener(this);
		jbModificar.setFont(fo);
		jbModificar.setToolTipText("Modificar Arancel Seleccionado!");
		
		
		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(panel2);
		panel2.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelId)
                    .addComponent(jLabelDes)
                    .addComponent(jLabelPrecio)
                    .addComponent(jLabelTipo))
                .addGap(28, 28, 28)
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfid, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfdescripcion)
                    .addComponent(jtfprecio)
                    .addComponent(jcbtipo, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        
        
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDes)
                    .addComponent(jtfdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrecio)
                    .addComponent(jtfprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipo)
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
                        .addComponent(jbModificar)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
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
		
		if(e.getSource() == this.jbModificar){
			if(!("".equals(jtfid.getText())) && !("".equals(jtfdescripcion.getText())) && !("".equals(jcbtipo.getSelectedItem())) && !("".equals(jtfprecio.getText()))){
				if(jtfid.getText() != " "){
					
					//barancel.setArancel(jtfid.getText(), jtfdescripcion.getText(), jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()));
				
					if(barancel.update(jtfdescripcion.getText(), jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()))){
						
						//jtfid.setText("");
						jtfdescripcion.setText("");
						
						jcbtipo.setSelectedItem("");
						jtfprecio.setText("");
						
						this.dispose();
					JOptionPane.showMessageDialog(null, "Arancel "+ jtfid.getText()+ " Modificado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al Modificar Arancel", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en Arancel", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}else{
				
				if(!("".equals(jtfid.getText())) && !("".equals(jtfdescripcion.getText())) && !("".equals(jcbtipo.getSelectedItem())) && !("".equals(jtfprecio.getText()))){
					JOptionPane.showMessageDialog(null, "Error al modificar el arancel, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{
					//barancel.setArancel(jtfid.getText(), jtfdescripcion.getText() , jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()));
					
					if(barancel.update(jtfdescripcion.getText(), jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()))){
						//jtfid.setText("");
						jtfdescripcion.setText("");
						jcbtipo.setSelectedItem("");
						jtfprecio.setText("");
						
						this.dispose();
					JOptionPane.showMessageDialog(null, "Arancel "+ jtfid.getText()+ " Modificado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al modificar Arancel", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}
			}
			
		}
	}

}
