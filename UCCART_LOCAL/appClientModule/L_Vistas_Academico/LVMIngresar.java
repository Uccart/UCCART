package L_Vistas_Academico;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import L_Vistas.LVPanel;
import javax.swing.*;

import beans.B_Carrera;
import beans.B_Materia;

import model.Carrera;


@SuppressWarnings("all")
public class LVMIngresar extends JDialog implements ActionListener {
	private JButton jbagregar;
    private JRadioButton jrbsi, jrbno;
    private JTextField jtfcodigo, jtfnombre, jtfarea, jtfcreditos;
    private B_Carrera bcarrera;
    private B_Materia bmateria;
    private Font fo;
    private List<Carrera> listmat;
    
	public LVMIngresar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		jtfcodigo = new JTextField(20);
		jtfnombre = new JTextField(20);
        jtfarea = new JTextField(20);
        jtfcreditos = new JTextField(20);
        jrbsi = new JRadioButton();
        jrbno = new JRadioButton();
        jbagregar = new JButton();
        bcarrera = new B_Carrera();
        bmateria = new B_Materia();
	}
	public void init(){
		this.setTitle("Ingresar Materia");
		
		JPanel panel = new JPanel();
		
		JLabel jLabel1 = new JLabel("Datos:");
		jLabel1.setFont(fo.deriveFont((float) 16));
        JLabel jLabel2 = new JLabel("Código:"); 
        jLabel2.setFont(fo);
        JLabel jLabel3 = new JLabel("Nombre:");
        jLabel3.setFont(fo);
        JLabel jLabel5 = new JLabel("Área:");
        jLabel5.setFont(fo);
        JLabel jLabel6 = new JLabel("Créditos:");
        jLabel6.setFont(fo);
        JLabel jLabel7 = new JLabel("Laboratorio:");
        jLabel7.setFont(fo);
        
        jtfcodigo.setFont(fo);
        jtfnombre.setFont(fo);
        jtfarea.setFont(fo);
        jtfcreditos.setFont(fo);
        jtfcreditos.addKeyListener(new KeyAdapter(){
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

		jrbsi.setText("Si");
		jrbsi.setFont(fo);
		jrbsi.addActionListener(this);

		jrbno.setText("No");
		jrbno.setSelected(true);
		jrbno.setFont(fo);
		jrbno.addActionListener(this);

        jbagregar.setText("Agregar");
        jbagregar.setFont(fo);
        jbagregar.addActionListener(this);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfcodigo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jrbsi)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                            .addComponent(jrbno))
                                        .addComponent(jtfcreditos, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfarea, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addComponent(jbagregar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfcreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jrbsi)
                    .addComponent(jrbno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jbagregar)
                .addGap(28, 28, 28))
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
		if(e.getSource().getClass()== JRadioButton.class){
			jrbno.setSelected(true);
			jrbsi.setSelected(true);
			if(e.getSource()== jrbsi)
				jrbno.setSelected(false);
			else
				jrbsi.setSelected(false);
		}
		
		if(e.getSource() == jbagregar){
			if(!("".equals(jtfcodigo.getText()) ) && !("".equals(jtfnombre.getText()))&& !("".equals(jtfarea.getText()))&& !("".equals(jtfcreditos.getText()))){
				if(bmateria.validapk(jtfcodigo.getText())){
					int lab = 1;
					if(jrbsi.isSelected())
						lab = 0;
					bmateria.setMateria(jtfcodigo.getText(), jtfnombre.getText(),
							lab, Integer.parseInt(jtfcreditos.getText()), jtfarea.getText());
					if(bmateria.insert()){
						JOptionPane.showMessageDialog(null, "Materia "+ jtfcodigo.getText()+ " ingresada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
						jtfcodigo.setText("");
						jtfnombre.setText("");
						jtfarea.setText("");
						jtfcreditos.setText("");
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Error al agregar la materia, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "No se permite duplicar el código en las Materias", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
