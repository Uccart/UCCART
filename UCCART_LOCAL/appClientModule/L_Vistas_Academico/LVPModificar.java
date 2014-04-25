package L_Vistas_Academico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

import beans.B_Periodo;

@SuppressWarnings("all")
public class LVPModificar extends JDialog implements ActionListener {
    private JButton jbcambiar;
    private JCalendarButton jcbext, jcbord;
    private JTextField jtfext, jtfnombre, jtford;
    private Font fo;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private int dord, meord, aord, dext, meext, aext;
	private B_Periodo bperiodo;
	
	public LVPModificar(Frame padre, boolean modal, Font f) {
		super(padre, modal);
		// TODO Auto-generated constructor stub
		bperiodo = new B_Periodo();
		fo = f;
		jtfnombre = new JTextField(20);
        jtford = new JTextField(8);
        jtfext = new JTextField(8);
	}


	public void init(B_Periodo per){
		bperiodo = per;
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JLabel jLabel1 = new JLabel("Nombre:");
		jLabel1.setFont(fo);
		JLabel jLabel2 = new JLabel("Fecha límite para matrícula ordinaria:");
		jLabel2.setFont(fo);
		JLabel jLabel3 = new JLabel("Fecha límite para matrícula extraordinaria:");
		jLabel3.setFont(fo);
        jcbord = new JCalendarButton();
        jcbext = new JCalendarButton();
        jbcambiar = new JButton("Cambiar");
        jbcambiar.setToolTipText("Realizar modificaciones al período!");
        jbcambiar.setFont(fo);
        jbcambiar.addActionListener(this);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Datos de Período"));
        
        jtfnombre.setFont(fo);
        jtfnombre.setText(bperiodo.getPeriodo().getPerPeriodo());
        jtfnombre.setEditable(false);
        
        jtford.setText(dateFormat.format(bperiodo.getPeriodo().getPerWeb()));
        jtford.setFont(fo);
        jcbord.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	if (evt.getNewValue() instanceof Date){
            		jtford.setText(dateFormat.format((Date)evt.getNewValue()));
            		dord = ((Date)evt.getNewValue()).getDate();
            		meord = ((Date)evt.getNewValue()).getMonth()+1;
            		aord = ((Date)evt.getNewValue()).getYear()+1900;
            	}
            }
        });
        jcbord.setTargetDate(bperiodo.getPeriodo().getPerWeb());
        jtfext.setText(dateFormat.format(bperiodo.getPeriodo().getPerLocal()));
        jtfext.setFont(fo);
        jcbext.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	if (evt.getNewValue() instanceof Date){
            		jtfext.setText(dateFormat.format((Date)evt.getNewValue()));
            		dext = ((Date)evt.getNewValue()).getDate();
            		meext = ((Date)evt.getNewValue()).getMonth()+1;
            		aext = ((Date)evt.getNewValue()).getYear()+1900;
            	}
            }
        });
        jcbext.setTargetDate(bperiodo.getPeriodo().getPerLocal());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtford, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtford, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    	.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbcambiar)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbcambiar)
                .addGap(5, 5, 5)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

	
	public boolean validarFecha(){
		if(aord <= aext){
			if(aord == aext){
				if(meord <= meext){
					if(meord == meext){
						if(dord <= dext){
							if(dord == dext){
								return false;
							}else{
								return true;
							}
						}else{
							return false;
						}
					}else{
						return true;
					}
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbcambiar){
			if(!("".equals(jtford.getText()) ) && !("".equals(jtfnombre.getText())&&!("".equals(jtfext.getText())))){
				if(bperiodo.getPeriodo().getPerPeriodo().equals(jtfnombre.getText())||bperiodo.validapk(jtfnombre.getText())){
					if(this.validarFecha()){ 
						//bperiodo.setPeriodo(jtfnombre.getText(), jcbord.getTargetDate(), jcbext.getTargetDate());
						if(bperiodo.update(jtfnombre.getText(), jcbord.getTargetDate(), jcbext.getTargetDate())){
							JOptionPane.showMessageDialog(null, "Período "+ jtfnombre.getText()+ " modificado con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
							jtford.setText("");
							jtfnombre.setText("");
							jtfext.setText("");
							this.dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Error al modificar el período, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Matrícula extraordinaria debe terminar luego de la ordinaria", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "No se permite duplicar el nombres en Períodos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
