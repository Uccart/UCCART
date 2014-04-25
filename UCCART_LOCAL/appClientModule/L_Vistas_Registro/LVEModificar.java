package L_Vistas_Registro;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import model.Carrera;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

import beans.B_Carrera;
import beans.B_Estudiante;
import beans.B_Padron;
import beans.B_Titulo;

import L_Vistas.LVPanel;

@SuppressWarnings("all")
public class LVEModificar extends JDialog implements ActionListener {
	private Font fo;
    private JButton jbcambiar;
    private JComboBox jcbgenero, jcbstatus, jcbcarreras;
    private JCalendarButton jcbnacimiento;
    private JTextField jtfapellido1, jtfapellido2,jtfasiento, jtfcelular, jtfemail, jtffolio, jtfid, jtfnacionalidad,
    jtfnombre, jtftelefono, jtftomo, jtftrabajo, jtffecnac;
	private B_Estudiante bestudiante;
	private B_Titulo btitulo;
	private B_Padron bpadron;
    private JTextArea jtadireccion;
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    private List<Carrera> listcarr;
	private B_Carrera bcarrera;
	private boolean estado;
    
    public LVEModificar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		estado = true;
		bestudiante = new B_Estudiante();
		btitulo = new B_Titulo();
		bcarrera = new B_Carrera();
		bpadron = new B_Padron();
		jtfid = new JTextField(20);
		jtfnombre = new JTextField(20);
		jtfapellido1 = new JTextField(20);
		jtfapellido2 = new JTextField(20);
		jtfcelular = new JTextField(20);
		jtftelefono = new JTextField(20);
		jtfemail = new JTextField(20);
		jtfnacionalidad = new JTextField(20);
		jtftrabajo = new JTextField(20);
		jtftomo = new JTextField(20);
		jtffolio = new JTextField(20);
		jtfasiento = new JTextField(20);
		jtffecnac = new JTextField(8);
		jtadireccion = new JTextArea();
	}
	
	public void init(B_Estudiante best){
		bestudiante = best;
		JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();

		jtfid.setFont(fo);
		jtfid.setText(bestudiante.getEstudiante().getEstId());
		jtfid.setEditable(false);
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
		jtftrabajo.setFont(fo);
		jtftomo.setFont(fo);
		jtftomo.addKeyListener(new KeyAdapter(){
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
		jtffolio.setFont(fo);
		jtffolio.addKeyListener(new KeyAdapter(){
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
		jtfasiento.setFont(fo);
		jtfasiento.addKeyListener(new KeyAdapter(){
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
		
		JLabel jLabel1 = new JLabel("ID:");
		jLabel1.setFont(fo);
		JLabel jLabel2 = new JLabel("Nombre:");
		jLabel2.setFont(fo);
		JLabel jLabel3 = new JLabel("1er Apellido:");
		jLabel3.setFont(fo);
		JLabel jLabel4 = new JLabel("2do Apellido:");
		jLabel4.setFont(fo);
		JLabel jLabel5 = new JLabel("Celular:");
		jLabel5.setFont(fo);
		JLabel jLabel6 = new JLabel("Tel�fono:");
		jLabel6.setFont(fo);
		JLabel jLabel7 = new JLabel("E-mail:");
		jLabel7.setFont(fo);
		JLabel jLabel8 = new JLabel("Estado:");
		jLabel8.setFont(fo);
        JLabel jLabel9 = new JLabel("Género:");
        jLabel9.setFont(fo);
        JLabel jLabel10 = new JLabel("Nacionalidad:");
        jLabel10.setFont(fo);
        JLabel jLabel11 = new JLabel("Fecha de nacimiento:");
        jLabel11.setFont(fo);
        JLabel jLabel13 = new JLabel("Ocupación:");
        jLabel13.setFont(fo);
        JLabel jLabel12 = new JLabel("Tomo:");
        jLabel12.setFont(fo);
        JLabel jLabel14 = new JLabel("Folio:");
        jLabel14.setFont(fo);
        JLabel jLabel15 = new JLabel("Asiento:");
        jLabel15.setFont(fo);
        JLabel jLabel16 = new JLabel("Dirección:");
        jLabel16.setFont(fo);
        JLabel jLabel17 = new JLabel("Carrera:");
        jLabel17.setFont(fo);
        jcbstatus = new JComboBox();
        jcbstatus.setFont(fo);
        jcbcarreras = new JComboBox();
        jcbcarreras.setFont(fo);
        jcbgenero = new JComboBox();
        jcbgenero.setFont(fo);
        jcbnacimiento = new JCalendarButton();
        jcbnacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	if (evt.getNewValue() instanceof Date){
            		jtffecnac.setText(dateFormat.format((Date)evt.getNewValue()));
            		/*dfin = ((Date)evt.getNewValue()).getDate();
            		mefin = ((Date)evt.getNewValue()).getMonth()+1;
            		afin = ((Date)evt.getNewValue()).getYear()+1900;*/
            	}
            }
        });
        jbcambiar = new JButton("Cambiar");
        jbcambiar.setFont(fo);
        jbcambiar.setToolTipText("Modificar estudiante seleccionado!");
        jbcambiar.addActionListener(this);
        

        JScrollPane jScrollPane1;
        jScrollPane1 = new JScrollPane();
        jtadireccion.setColumns(20);
        jtadireccion.setRows(5);
        jtadireccion.setFont(fo);
        jScrollPane1.setViewportView(jtadireccion);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Datos de Estudiante"));
        
        jcbcarreras = new JComboBox<String>();
		jcbcarreras.setFont(fo);
		jcbcarreras.setToolTipText("Seleccione carrera a la cual será empadronado el estudiante");
        listcarr = bcarrera.selectAll();
		for(int i=0;i<listcarr.size();i++){
	        String item = listcarr.get(i).getCarrNombre();
	        jcbcarreras.addItem(item);
		}
		jcbcarreras.setMaximumSize(jcbcarreras.getPreferredSize() );

        jcbstatus.setModel(new DefaultComboBoxModel(new String[] { "Primer Ingreso", "Regular", "Egresado"}));
        jcbstatus.setToolTipText("Estado actual del estudiante");

        jcbgenero.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        jcbgenero.setToolTipText("Género del estudiante");

        jPanel2.setBorder(BorderFactory.createTitledBorder("Título"));
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtffolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtftomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfasiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtftomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtffolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtfasiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    //.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)//)
                                    .addComponent(jtfapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addGap(30, 30, 30)//.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtftrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbgenero, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtffecnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jcbgenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jtfnacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jtffecnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jtfapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(jtftrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jcbcarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtftelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


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
                .addComponent(jbcambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbcambiar)
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
		if(e.getSource() == jbcambiar){
			if(!("".equals(jtfid.getText()) ) && !("".equals(jtfnombre.getText())&&!("".equals(jtfapellido1.getText()))&&!("".equals(jtfnacionalidad.getText()))
					&&!("".equals(jtffecnac.getText()))&&!("".equals(jtftomo.getText()))&&!("".equals(jtffolio.getText()))&&!("".equals(jtfasiento.getText())))){
				
				btitulo.setTitulo(Integer.parseInt(jtftomo.getText()), Integer.parseInt(jtffolio.getText()), Integer.parseInt(jtfasiento.getText()));
				
				if(btitulo.insert()){
					
					if(bpadron.valida(jtfid.getText(), listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod())){
						bestudiante.setEstudiante(jtfid.getText(), jtfnombre.getText(), jtfapellido1.getText(), jtfapellido2.getText(), Integer.parseInt(jtfcelular.getText()),
								Integer.parseInt(jtftelefono.getText()),jtfemail.getText(), jcbstatus.getSelectedIndex(), false, jtadireccion.getText(), 
								jtfnacionalidad.getText(), jcbgenero.getSelectedIndex() == 0,jcbnacimiento.getTargetDate(), btitulo.getTitulo().getTitCodigo(), jtftrabajo.getText());
						
						if(bestudiante.update(jtfnombre.getText(), jtfapellido1.getText(), jtfapellido2.getText(), Integer.parseInt(jtfcelular.getText()),
								Integer.parseInt(jtftelefono.getText()),jtfemail.getText(), jcbstatus.getSelectedIndex(), false, jtadireccion.getText(), 
								jtfnacionalidad.getText(), jcbgenero.getSelectedIndex() == 0,jcbnacimiento.getTargetDate(), btitulo.getTitulo().getTitCodigo(), jtftrabajo.getText())){
							bpadron.setPadron(jtfid.getText(), listcarr.get(jcbcarreras.getSelectedIndex()).getCarrCod());
							jtfid.setText("");
							jtfnombre.setText("");
							jtfapellido1.setText("");
							jtfnacionalidad.setText("");
							jtffecnac.setText("");
							jtftomo.setText("");
							jtffolio.setText("");
							jtfasiento.setText("");
							jtfapellido2.setText("");
							jtfcelular.setText("");
							jtftelefono.setText("");
							jtfemail.setText("");
							jtftrabajo.setText("");
							jtadireccion.setText("");
							this.dispose();
							if(bpadron.insert())
								JOptionPane.showMessageDialog(null, "Estudiante "+ jtfid.getText()+ " ingresado con éxito e incluido en el padron de " + jcbcarreras.getSelectedItem(), "INFO", JOptionPane.INFORMATION_MESSAGE);
							else{
								JOptionPane.showMessageDialog(null, "Estudiante "+ jtfid.getText()+ " ingresado con éxito, con error al ingresarlo al padrón de " + jcbcarreras.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
							}
							
						}else{
							JOptionPane.showMessageDialog(null, "Error al agregar el estudiante, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Error al agregar el padrón, estudiante ya está incluido en el padrón seleccionado ", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Error al agregar el título, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	

}
