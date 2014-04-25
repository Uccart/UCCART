package L_Vistas_Financiero;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import beans.B_Arancel;

@SuppressWarnings("all")
public class LVAranIngresar extends JDialog implements ActionListener {
	private JButton jbagregar;
    private JTextField jtfid, jtfdescripcion, jtfprecio;
    private JComboBox jcbtipo;
    private B_Arancel barancel;
    private Font fo;
    
	public LVAranIngresar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		fo = f;
		barancel = new B_Arancel();
	}
	
	public void init(){
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Arancel"));
		
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
		
		
		jtfdescripcion = new JTextField(20);
		jtfdescripcion.setFont(fo);
		
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
		
		jcbtipo = new JComboBox();
		jcbtipo.setModel(new DefaultComboBoxModel(new String[] { "ENTRADA", "SALIDA" }));
		
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
		
		if(e.getSource() == this.jbagregar){
			if(!("".equals(jtfid.getText())) && !("".equals(jtfdescripcion.getText())) && !("".equals(jcbtipo.getSelectedItem())) && !("".equals(jtfprecio.getText()))){
				if(barancel.validapk(jtfid.getText())){
					barancel.setArancel(jtfid.getText(), jtfdescripcion.getText(), jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()));
				
					if(barancel.insert()){
						
						jtfid.setText("");
						jtfdescripcion.setText("");
						jcbtipo.setSelectedItem("");
						jtfprecio.setText("");
						
						this.dispose();
					JOptionPane.showMessageDialog(null, "Arancel "+ jtfid.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al agregar Arancel", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en Arancel", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}else{
				
				if(!("".equals(jtfid.getText())) && !("".equals(jtfdescripcion.getText())) && !("".equals(jcbtipo.getSelectedItem())) && !("".equals(jtfprecio.getText()))){
					JOptionPane.showMessageDialog(null, "Error al agregar el arancel, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{
					barancel.setArancel(jtfid.getText(), jtfdescripcion.getText() , jcbtipo.getSelectedItem().toString(), Integer.parseInt(jtfprecio.getText()));
					
					if(barancel.insert()){
						jtfid.setText("");
						jtfdescripcion.setText("");
						jcbtipo.setSelectedItem("");
						jtfprecio.setText("");
						
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
