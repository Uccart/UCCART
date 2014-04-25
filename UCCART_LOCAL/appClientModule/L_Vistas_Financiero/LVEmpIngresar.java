

package L_Vistas_Financiero;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


import javax.swing.*;

import model.Carrera;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;


import beans.B_Empleado;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVEmpIngresar extends JDialog implements ActionListener {
	private Font fo;
	private JButton jbagregar;
	private JComboBox jcbgenero;
	private JCalendarButton jcbnacimiento;
	private JTextField jtfapellido1, jtfapellido2, jtfcelular, jtfemail, jtfid, jtfnacionalidad, jtfSalario,
	jtfnombre, jtftelefono, jtfpuesto, jtffecnac;
	private B_Empleado bempleado;
	private JTextArea jtadireccion;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private boolean estado;

	public LVEmpIngresar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		estado = true;
		bempleado = new B_Empleado();
		jtfid = new JTextField(20);
		jtfnombre = new JTextField(20);
		jtfapellido1 = new JTextField(20);
		jtfapellido2 = new JTextField(20);
		jtfcelular = new JTextField(20);
		jtftelefono = new JTextField(20);
		jtfemail = new JTextField(20);
		jtfnacionalidad = new JTextField(20);
		jtfpuesto = new JTextField(20);
		jtfSalario = new JTextField(20);
		jtffecnac = new JTextField(20);
		jtadireccion = new JTextArea();
	}

	public void init(){
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();

		jtfid.setFont(fo);
		jtfnombre.setFont(fo);
		jtfapellido1.setFont(fo);
		jtfapellido2.setFont(fo);
		jtfcelular.setFont(fo);
		jtfcelular.addKeyListener(new KeyAdapter(){
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
		jtftelefono.setFont(fo);
		jtftelefono.addKeyListener(new KeyAdapter(){
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
		jtfemail.setFont(fo);
		jtfnacionalidad.setFont(fo);
		jtfpuesto.setFont(fo);
		jtfSalario.setFont(fo);
		jtfSalario.addKeyListener(new KeyAdapter(){
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

		jtffecnac.setFont(fo);

		JLabel jLabelId = new JLabel("Identificacion:");
		jLabelId.setFont(fo);
		JLabel jLabelNom = new JLabel("Nombre:");
		jLabelNom.setFont(fo);
		JLabel jLabelAp1 = new JLabel("1er Apellido:");
		jLabelAp1.setFont(fo);
		JLabel jLabelApe2 = new JLabel("2do Apellido:");
		jLabelApe2.setFont(fo);
		JLabel jLabelCel = new JLabel("Celular:");
		jLabelCel.setFont(fo);
		JLabel jLabelTel = new JLabel("Teléfono:");
		jLabelTel.setFont(fo);
		JLabel jLabelEmail = new JLabel("E-mail:");
		jLabelEmail.setFont(fo);
		JLabel jLabelSalario = new JLabel("Salario Bruto:");
		jLabelSalario.setFont(fo);
		JLabel jLabelGenero = new JLabel("Género:");
		jLabelGenero.setFont(fo);
		JLabel jLabelNac = new JLabel("Nacionalidad:");
		jLabelNac.setFont(fo);
		JLabel jLabelFecha = new JLabel("Fecha de nacimiento:");
		jLabelFecha.setFont(fo);
		JLabel jLabelPuesto = new JLabel("Puesto:");
		jLabelPuesto.setFont(fo);
		JLabel jLabelDire = new JLabel("Dirección:");
		jLabelDire.setFont(fo);


		jcbgenero = new JComboBox();
		jcbgenero.setFont(fo);
		jcbnacimiento = new JCalendarButton();
		jcbnacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				if (evt.getNewValue() instanceof Date){
					jtffecnac.setText(dateFormat.format((Date)evt.getNewValue()));

				}
			}
		});
		jbagregar = new JButton("Agregar");
		jbagregar.setFont(fo);
		jbagregar.setToolTipText("Agregar nuevo empleado!");
		jbagregar.addActionListener(this);


		JScrollPane jScrollPane1;
		jScrollPane1 = new JScrollPane();
		jtadireccion.setColumns(20);
		jtadireccion.setRows(5);
		jtadireccion.setFont(fo);
		jScrollPane1.setViewportView(jtadireccion);

		jPanel1.setBorder(BorderFactory.createTitledBorder("Datos del Empleado:"));

		jcbgenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
		jcbgenero.setToolTipText("Género del empleado");



		//////////////////////////LABELS y TEXTO A LA IZQUIERDA/////////////////////////

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabelApe2)

																.addComponent(jLabelCel)
																.addComponent(jLabelId)
																.addComponent(jLabelNom)
																.addComponent(jLabelAp1)
																.addComponent(jLabelTel)
																.addComponent(jLabelEmail)
																.addComponent(jLabelSalario))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		//.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)//)
																				.addComponent(jtfapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtfapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
																				.addGap(30, 30, 30)
																				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(jLabelGenero)
																										.addComponent(jLabelNac)
																										.addComponent(jLabelFecha)
																										.addComponent(jLabelPuesto)
																										.addComponent(jLabelSalario))
																										.addGap(30, 30, 30)


																										//////////////////////////LABELS y TEXTO A LA DERECHA/////////////////////////
																										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)	
																												.addComponent(jtfpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(jtfnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addComponent(jcbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addGroup(jPanel1Layout.createSequentialGroup()
																														.addComponent(jtffecnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																														.addComponent(jcbnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
																														.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																														.addGap(14, 14, 14))
																														.addGroup(jPanel1Layout.createSequentialGroup()
																																.addComponent(jLabelDire)
																																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addGap(26, 26, 26)
																																.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				);


		//////////////////////////LABELS y TEXTO A LA IZQUIERDA/////////////////////////

		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelId)
										.addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelGenero))
										.addComponent(jcbgenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabelNom)
														.addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabelNac)
																.addComponent(jtfnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(jPanel1Layout.createSequentialGroup()
																				.addGap(9, 9, 9)
																				.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(jLabelAp1)
																						.addComponent(jtfapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))

																						.addGroup(jPanel1Layout.createSequentialGroup()
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(jcbnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(jLabelFecha)
																												.addComponent(jtffecnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
																												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

																												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																																.addComponent(jLabelApe2)
																																.addComponent(jtfapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addComponent(jLabelPuesto))
																																.addComponent(jtfpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																		.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)))
																																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																				.addGroup(jPanel1Layout.createSequentialGroup()
																																						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																																								.addComponent(jLabelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
																																								.addComponent(jtfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																																										.addComponent(jLabelTel)
																																										.addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																										.addGap(9, 9, 9)
																																										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																																												.addComponent(jLabelEmail)
																																												.addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																												.addGap(6, 6, 6)
																																												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																																														.addComponent(jLabelSalario)
																																														.addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
																																														.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																																														.addGap(18, 18, 18)
																																														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																																.addComponent(jLabelDire)
																																																.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
																																																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);



		//////////////////Boton DE AGREGAR/////////////////


		jbagregar.setText("Agregar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addGap(41, 41, 41)
								.addComponent(jbagregar)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jbagregar)
						.addGap(30, 30, 30))
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
	}

	public boolean getEstado(){
		return this.estado;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		if(e.getSource() == this.jbagregar){
			if(!("".equals(jtfid.getText())) && !("".equals(jtfnombre.getText())) && !("".equals(jtfapellido1.getText())) && !("".equals(jtfapellido2.getText()))  
					&& !("".equals(jcbnacimiento.getTargetDate()))  && !("".equals(jtftelefono.getText())) && !("".equals(jtfcelular.getText())) && !("".equals(jtadireccion.getText()))
					&& !("".equals(jcbgenero.getSelectedIndex()))  && !("".equals(jtfnacionalidad.getText()))  && !("".equals(jtfemail.getText())) 
					&& !("".equals(jtfSalario.getText())) && !("".equals(jtfpuesto.getText())) ){
				if(bempleado.validapk(jtfid.getText())){
					bempleado.setEmpleado(jtfid.getText(), jtfnombre.getText(), jtfapellido1.getText(), jtfapellido2.getText(), jcbnacimiento.getTargetDate(), 
							jtftelefono.getText() , jtfcelular.getText() , jtadireccion.getText() , jcbgenero.getSelectedItem().toString() , jtfnacionalidad.getText(), 
							jtfemail.getText(), Integer.parseInt(jtfSalario.getText()) , jtfpuesto.getText());

					if(bempleado.insert()){

						jtfid.setText("");
						jtfnombre.setText("");
						jtfapellido1.setText("");
						jtfapellido2.setText("");
						jtffecnac.setText("");
						jtftelefono.setText("");
						jtfcelular.setText("");
						jcbgenero.setSelectedItem("");
						jtfnacionalidad.setText("");
						jtfemail.setText("");
						jtfSalario.setText("");
						jtfpuesto.setText("");

						this.dispose();
						JOptionPane.showMessageDialog(null, "Empleado "+ jtfid.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
					}else{

						JOptionPane.showMessageDialog(null, "Error al agregar Empleado", "Error", JOptionPane.ERROR_MESSAGE);

					}

				}else{

					JOptionPane.showMessageDialog(null, "No se permite duplicar el ID en Empleado", "Error", JOptionPane.ERROR_MESSAGE);
				}



			}else{

				if(!("".equals(jtfid.getText())) && !("".equals(jtfnombre.getText())) && !("".equals(jtfapellido1.getText())) && !("".equals(jtfapellido2.getText()))  
						&& !("".equals(jcbnacimiento.getTargetDate()))  && !("".equals(jtftelefono.getText())) && !("".equals(jtfcelular.getText())) && !("".equals(jtadireccion.getText()))
						&& !("".equals(jcbgenero.getSelectedIndex()))  && !("".equals(jtfnacionalidad.getText()))  && !("".equals(jtfemail.getText())) 
						&& !("".equals(jtfSalario.getText())) && !("".equals(jtfpuesto.getText())) ){

					JOptionPane.showMessageDialog(null, "Error al agregar el Empleado, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					if(bempleado.validapk(jtfid.getText())){
						bempleado.setEmpleado(jtfid.getText(), jtfnombre.getText(), jtfapellido1.getText(), jtfapellido2.getText(), jcbnacimiento.getTargetDate(), 
								jtftelefono.getText() , jtfcelular.getText() , jtadireccion.getText() , jcbgenero.getSelectedItem().toString() , jtfnacionalidad.getText(), 
								jtfemail.getText(), Integer.parseInt(jtfSalario.getText()) , jtfpuesto.getText());

						if(bempleado.insert()){

							jtfid.setText("");
							jtfnombre.setText("");
							jtfapellido1.setText("");
							jtfapellido2.setText("");
							jtffecnac.setText("");
							jtftelefono.setText("");
							jtfcelular.setText("");
							jcbgenero.setSelectedItem("");
							jtfnacionalidad.setText("");
							jtfemail.setText("");
							jtfSalario.setText("");
							jtfpuesto.setText("");


							this.dispose();
							JOptionPane.showMessageDialog(null, "Empleado "+ jtfid.getText()+ " ingresado con éxito ", "INFO", JOptionPane.INFORMATION_MESSAGE);
						}else{

							JOptionPane.showMessageDialog(null, "Error al agregar Empleado", "Error", JOptionPane.ERROR_MESSAGE);

						}

					}
				}

			}

		}

	}
}
