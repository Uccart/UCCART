package L_Vistas_Registro;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import beans.B_Carrera;
import beans.B_Padron;

import model.Carrera;

@SuppressWarnings("all")
public class LVPIngresar extends JDialog implements ActionListener{
    private JButton jbagregar;
    private JButton jbcancelar;
    private JLabel jlencabezado;
	private JComboBox jcbcarreras;
	private List<Carrera> listcarr;
	private B_Carrera bcarrera;
	private B_Padron bpadron;
	private Font fo;
	private String encabezado, nombre, id;
	
	public LVPIngresar(Frame padre, boolean modal, Font f, String n, String i){
		super(padre, modal);
		bcarrera = new B_Carrera();
		bpadron = new B_Padron();
		fo = f;
		nombre = n;
		id = i;
		encabezado = "Incluir una nueva carrera al estudiante ";
		jlencabezado = new JLabel(encabezado + nombre);
		jbagregar = new JButton();
		jbcancelar = new JButton();
	}
	public void init(){
		
		this.setTitle("Incluir en padrón");
		
		JLabel jLabel2 = new JLabel("Carrera:");
		jLabel2.setFont(fo);
		jlencabezado.setFont(fo);
	    JPanel jPanel1 = new JPanel();
	    JPanel jPanel2 = new JPanel();
	    
	    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Padr�n"));
	    
		jcbcarreras = new JComboBox<String>();
		jcbcarreras.setFont(fo);
		jcbcarreras.setToolTipText("Lista de estudiantes por orden de carrera");
        listcarr = bcarrera.selectAll();
		for(int i=0;i<listcarr.size();i++){
	        String item = listcarr.get(i).getCarrNombre();
	        jcbcarreras.addItem(item);
		}
		jcbcarreras.setMaximumSize(jcbcarreras.getPreferredSize() );
		
		jbagregar.setFont(fo);
		jbagregar.addActionListener(this);
		
		jbcancelar.setFont(fo);
		
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlencabezado)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbagregar.setText("Agregar");

        jbcancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbagregar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbcancelar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbagregar)
                        .addComponent(jbcancelar))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbagregar){
			if(bpadron.valida(id, listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod())){
				bpadron.setPadron(id, listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod());
				if(bpadron.insert()){
					JOptionPane.showMessageDialog(null, "Estudiante "+ nombre+ " ingresado al padrón de la carrera "+ jcbcarreras.getSelectedItem().toString(), "INFO", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Error al agregar el padrón, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Error al agregar el padrón, estudiante ya está incluido en el padrón seleccionado ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbcancelar){
				this.dispose();
			}
		}
	}

}
