package L_Vistas_Academico;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import beans.B_Profesor;

public class LVProfesorIngresar extends JDialog implements ActionListener  {
	
	private Font fo;
	
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton jbAgregar;
    private JLabel jlbEmail;
    private JLabel jlbID;
    private JLabel jlbNombre;
    private JLabel jlbTel;
    private JTextArea jtaGradoAcad;
    private JTextField jtfApellido2;
    private JTextField jtfApellidoI;
    private JTextField jtfEmail;
    private JTextField jtfID;
    private JTextField jtfNombre;
    private JTextField jtfTel;	
	private B_Profesor bprofesor;
	private boolean estado;
	
    
    public LVProfesorIngresar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		   jLabel1 = new JLabel();
	        jPanel1 = new JPanel();
	        jlbID = new JLabel();
	        jtfID = new JTextField(20);
	        jlbNombre = new JLabel();
	        jtfNombre = new JTextField(20);
	        jLabel2 = new JLabel();
	        jtfApellidoI = new JTextField(20);
	        jLabel3 = new JLabel();
	        jtfApellido2 = new JTextField(20);
	        jLabel4 = new JLabel();
	        jlbTel = new JLabel();
	        jtfTel = new JTextField(20);
	        jlbEmail = new JLabel();
	        jtfEmail = new JTextField(20);
	        jScrollPane1 = new JScrollPane();
	        jtaGradoAcad = new JTextArea();
	        jbAgregar = new JButton();
	        bprofesor = new B_Profesor();
          
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void init() {

    
    	jtfID.setFont(fo);
		jtfNombre.setFont(fo);
		jtfApellidoI.setFont(fo);
		jtfApellido2.setFont(fo);
        jtfTel.setFont(fo);
        jtfTel.addKeyListener(new KeyAdapter(){
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
        
        jtfEmail.setFont(fo);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Profesor"));

        jlbID.setFont(fo);
        jlbID.setText("ID:     ");

        jlbNombre.setFont(fo);
        jlbNombre.setText("Nombre:");

        jLabel2.setFont(fo);
        jLabel2.setText("1er Apellido:");

        jLabel3.setFont(fo);
        jLabel3.setText("2do Apellido: ");

        jLabel4.setFont(fo);
        jLabel4.setText("Grado Académico: ");

        jlbTel.setFont(fo);
        jlbTel.setText("Teléfono:");
        
        
        jlbEmail.setFont(fo);
        jlbEmail.setText("E-Mail:");
        jtaGradoAcad.setFont(fo);
        jtaGradoAcad.setColumns(20);
        jtaGradoAcad.setRows(5);
        jScrollPane1.setViewportView(jtaGradoAcad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbID)
                                .addGap(55, 55, 55)
                                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jlbTel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfApellidoI, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jtfTel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfApellido2)
                                    .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbID)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfApellidoI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTel)
                    .addComponent(jtfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jbAgregar.setFont(fo);
        jbAgregar.setText("Agregar");
        JPanel jPanel3 = new JPanel();

        GroupLayout layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbAgregar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregar)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        this.pack();
        
        this.jbAgregar.addActionListener(this);
    }





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.jbAgregar){
			if(!("".equals(this.jtfID.getText())) && !("".equals(this.jtfNombre.getText())) && !("".equals(this.jtfApellidoI.getText()))  &&  !("".equals(this.jtfApellido2.getText())) && !("".equals(this.jtfEmail.getText()))&& !("".equals(this.jtaGradoAcad.getText())) && !("".equals(this.jtfTel.getText()))){
				if(bprofesor.validapk(jtfID.getText())){
					
					bprofesor.setProfesor(jtfID.getText(), jtfNombre.getText(), this.jtfApellidoI.getText(), jtfApellido2.getText(), jtaGradoAcad.getText(), Integer.parseInt(jtfTel.getText()), jtfEmail.getText());
				
					if(bprofesor.insert()){
						
						jtfID.setText("");
						jtfNombre.setText("");
						jtfApellidoI.setText("");
						jtfApellido2.setText("");
						jtfTel.setText("");
						jtfEmail.setText("");
						jtaGradoAcad.setText("");
						this.dispose();
					JOptionPane.showMessageDialog(null, "Profesor "+ jtfID.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al agregar profesor", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en Profesor", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}else{
				
				if( ("".equals(this.jtfID.getText())) || ("".equals(this.jtfNombre.getText())) || ("".equals(this.jtfApellidoI.getText()))  ||  ("".equals(this.jtfApellido2.getText())) || ("".equals(this.jtaGradoAcad.getText())) ||("".equals(this.jtfTel.getText()))){
					JOptionPane.showMessageDialog(null, "Error al agregar el profesor, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else{
					bprofesor.setProfesor(jtfID.getText(), jtfNombre.getText(), this.jtfApellidoI.getText(), jtfApellido2.getText(), jtaGradoAcad.getText(), Integer.parseInt(jtfTel.getText()),"");
					
					if(bprofesor.insert()){
						jtfID.setText("");
						jtfNombre.setText("");
						jtfApellidoI.setText("");
						jtfApellido2.setText("");
						jtfTel.setText("");
						jtfEmail.setText("");
						jtaGradoAcad.setText("");
						this.dispose();
					JOptionPane.showMessageDialog(null, "Profesor "+ jtfID.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{
						
						JOptionPane.showMessageDialog(null, "Error al agregar profesor", "Error", JOptionPane.ERROR_MESSAGE);
					
					}
					
				}
			}
			
		}
		
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}    
	
    
    
    
	
	
}
