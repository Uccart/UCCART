package L_Vistas_Academico;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import beans.B_Carrera;

import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVCaModificar extends JDialog implements ActionListener{
	private JButton jbagregar;
    private JTextField jtcodigo, jtnombre, jtcredmax;
    private B_Carrera bcarrera;
    private Font fo;
    
	public LVCaModificar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		bcarrera = new B_Carrera();
	}
	
	public void init(){

		this.setTitle("Ingresar Carrera");
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("Código:");
		label1.setFont(fo);
		
		JLabel label2 = new JLabel("Nombre:");
		label2.setFont(fo);
		
		JLabel label3 = new JLabel("Créditos máximos:");
		label3.setFont(fo);
		
		jtcodigo = new JTextField(20);
		jtcodigo.setFont(fo);
		
        jtnombre = new JTextField(20);
        jtnombre.setFont(fo);
        
        jtcredmax = new JTextField(3);
        jtcredmax.setFont(fo);
        jtcredmax.addKeyListener(new KeyAdapter(){
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
        
        jbagregar = new JButton();
        jbagregar.setFont(fo);
        jbagregar.setText("Agregar");
        jbagregar.addActionListener(this);
        
        JPanel jPanel1 = new JPanel();
        jPanel1.setFont(fo);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtcredmax, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2)
                            .addComponent(label1))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1)
                    .addComponent(jtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2)
                    .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(jtcredmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbagregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbagregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
			if(!("".equals(jtcodigo.getText()) ) && !("".equals(jtnombre.getText()))){
				if(bcarrera.validapk(jtcodigo.getText())){
					bcarrera.setCarrera(jtcodigo.getText(), jtnombre.getText(), Integer.parseInt(this.jtcredmax.getText()));
					if(bcarrera.insert()){
						JOptionPane.showMessageDialog(null, "Carrera "+ jtcodigo.getText()+ " ingresada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						jtcodigo.setText("");
						jtnombre.setText("");
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Error al agregar la carrera, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "No se permite duplicar código en las Carreras ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
