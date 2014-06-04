package L_Vistas_Academico;

import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;

import model.Materia;
import model.Periodo;
import model.Profesor;

import org.jbundle.thin.base.screen.jcalendarbutton.*;

import beans.B_Curso;
import beans.B_Materia;
import beans.B_Periodo;
import beans.B_Profesor;
import L_Vistas.LVPanel;

@SuppressWarnings("all")
public final class LVCIngresar extends JDialog implements ActionListener {
    private JTextField jtfsigla, jtfmaximo, jtfaula, jtfinicio, jtfminimo, jtffinal, jtffinicio, jtfffinal;
    private int hini, hfin, mini, mfin, dini, dfin, meini, mefin, aini, afin;
    private JTimeButton jtbinicio, jtbfinal;
    private JCalendarButton jcbinicio, jcbfinal;
	private JComboBox<String> materias, profesores, periodos, dias, sedes;
	private JButton enviar;
	private DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private B_Curso bcurso;
	private B_Periodo bperiodo;
	private B_Profesor bprofesor;
	private B_Materia bmateria;
	private Font fo;
	private List<Materia> listmat;
	private List<Profesor> listpro;
	private List<Periodo> listper;
	
	
public LVCIngresar(JFrame padre, boolean modal, Font f){
		super(padre, modal);
		fo = f;
		bcurso = new B_Curso();
		bperiodo = new B_Periodo();
		bprofesor = new B_Profesor();
		bmateria = new B_Materia();
	}
	public void init(){
		this.setTitle("Ingresar Curso");
        
        materias = new JComboBox<String>();
        materias.setFont(fo);
        materias.setToolTipText("Materias existentes");
        listmat = bmateria.selectAll();
		for(int i=0;i<listmat.size();i++){
	        String item = listmat.get(i).getMateriaId()+" "+listmat.get(i).getMateriaNombre();
	        materias.addItem(item);
		}
        
        profesores = new JComboBox<String>();
        profesores.setFont(fo);
        profesores.setToolTipText("Profesores activos");
        listpro = bprofesor.selectAll();
		for(int i=0;i<listpro.size();i++){
	        String item = listpro.get(i).getProfNombre()+", "+listpro.get(i).getProfApellido1()+" "+ listpro.get(i).getProfApellido2()+ " ("+ listpro.get(i).getProfId()+")";
	        profesores.addItem(item);
		}
        
        jtfmaximo = new JTextField(3);
        jtfmaximo.setFont(fo);
        jtfmaximo.addKeyListener(new KeyAdapter(){
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
        
        jtfminimo = new JTextField(3);
        jtfminimo.setFont(fo);
        jtfminimo.addKeyListener(new KeyAdapter(){
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
        
        periodos = new JComboBox<String>();
        periodos.setFont(fo);
        periodos.setToolTipText("Períodos activos");
        listper = bperiodo.selectAll();
		for(int i=0;i<listper.size();i++){
	        String item = listper.get(i).getPerPeriodo();
	        periodos.addItem(item);
		}
        
        
        enviar = new JButton("Agregar");
        enviar.addActionListener(this);
        enviar.setFont(fo);
        enviar.setToolTipText("Agregar nuevo curso al sistema!");
        
        JSeparator jSeparator1 = new JSeparator();
        
        JPanel panel = new JPanel();
      //<editor-fold defaultstate="collapsed" desc=" Layout ">
        JLabel jLabel1 = new JLabel("Datos:");
        jLabel1.setFont(fo.deriveFont((float)16));
        JLabel jLabel2 = new JLabel("Capacidad Máxima:");
        jLabel2.setFont(fo);
        JLabel jLabel3 = new JLabel("Materia:");
        jLabel3.setFont(fo);
        JLabel jLabel4 = new JLabel("Sede:");
        jLabel4.setFont(fo);
        JLabel jLabel5 = new JLabel("Sigla:");
        jLabel5.setFont(fo);
        JLabel jLabel6 = new JLabel("Aula:");
        jLabel6.setFont(fo);
        JLabel jLabel7 = new JLabel("Capacidad Mínima:");
        jLabel7.setFont(fo);
        JLabel jLabel8 = new JLabel("Periodo:");
        jLabel8.setFont(fo);
        JLabel jLabel9 = new JLabel("Profesor:");
        jLabel9.setFont(fo);
        JLabel jLabel10 = new JLabel("Horario:");
        jLabel10.setFont(fo);
        JLabel jLabel11 = new JLabel("Día:");
        jLabel11.setFont(fo);
        JLabel jLabel12 = new JLabel("Hora de inicio:");
        jLabel12.setFont(fo);
        JLabel jLabel13 = new JLabel("Hora de finalización:");
        jLabel13.setFont(fo);
        JLabel jLabel14 = new JLabel("Fecha de inicio:");
        jLabel14.setFont(fo);
        JLabel jLabel15 = new JLabel("Fecha de finalización:");
        jLabel15.setFont(fo);
        jtfsigla = new JTextField(20);
        jtfsigla.setFont(fo);
        sedes = new JComboBox();
        sedes.setFont(fo);
        jtfaula = new JTextField(8);
        jtfaula.setFont(fo);
        jtffinal = new JTextField(3);
        jtffinal.setFont(fo);
        jtfffinal = new JTextField(8);
        jtfffinal.setFont(fo);
        dias = new JComboBox();
        dias.setFont(fo);
        jcbinicio = new JCalendarButton();
        jcbinicio.setFont(fo);
        jcbfinal = new JCalendarButton();
        jcbfinal.setFont(fo);
        jtbinicio = new JTimeButton();
        jtbinicio.setFont(fo);
        jtbfinal = new JTimeButton();
        jtbfinal.setFont(fo);
        jtfinicio = new JTextField(3);
        jtfinicio.setFont(fo);
        jtffinicio = new JTextField(8);
        jtffinicio.setFont(fo);
        
        jcbinicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	if (evt.getNewValue() instanceof Date){
            		jtffinicio.setText(dateFormat.format((Date)evt.getNewValue()));
            		dini = ((Date)evt.getNewValue()).getDate();
            		meini = ((Date)evt.getNewValue()).getMonth()+1;
            		aini = ((Date)evt.getNewValue()).getYear()+1900;
            	}
            }
        });
        
        jcbfinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
            	if (evt.getNewValue() instanceof Date){
            		jtfffinal.setText(dateFormat.format((Date)evt.getNewValue()));
            		dfin = ((Date)evt.getNewValue()).getDate();
            		mefin = ((Date)evt.getNewValue()).getMonth()+1;
            		afin = ((Date)evt.getNewValue()).getYear()+1900;
            	}
            }
        });
        
        jtbinicio= new JTimeButton();
		jtbinicio.setMaximumSize(jtbinicio.getPreferredSize() );
		jtbinicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if (evt.getNewValue() instanceof Date){
                	jtfinicio.setText(timeFormat.format(((Date)evt.getNewValue())));//String.valueOf(((Date)evt.getNewValue()).getHours())+":"+String.valueOf(((Date)evt.getNewValue()).getMinutes()));
                	hini = ((Date)evt.getNewValue()).getHours();
                	mini = ((Date)evt.getNewValue()).getMinutes();
                }
            }
        });
		
		jtbfinal= new JTimeButton();
		jtbfinal.setMaximumSize(jtbfinal.getPreferredSize() );
		jtbfinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if (evt.getNewValue() instanceof Date){
                	jtffinal.setText(timeFormat.format(((Date)evt.getNewValue())));//String.valueOf(((Date)evt.getNewValue()).getHours())+":"+String.valueOf(((Date)evt.getNewValue()).getMinutes()));
                	hfin = ((Date)evt.getNewValue()).getHours();
                	mfin = ((Date)evt.getNewValue()).getMinutes();
                }
            }
        });

        dias.setModel(new DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        sedes.setModel(new DefaultComboBoxModel(new String[] { "San José", "Pérez Zeledón", "San Ramón", "San Pedro", "Cañas"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel14)
                                        .addComponent(enviar)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(jLabel5)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfaula, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(materias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfsigla, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(sedes))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel2))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(periodos, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtfminimo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtfmaximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE))
                                        .addComponent(profesores, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfinicio, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtbinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtffinal, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtbfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtffinicio, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfffinal, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(39, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfsigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel9)
                        .addComponent(profesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(materias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jtfminimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfmaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfaula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(periodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtbinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGap(15, 15, 15)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtffinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGap(31, 31, 31)
                            .addComponent(enviar))
                        .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel13)
	                            .addComponent(jtffinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jtbfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(31, 31, 31)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jLabel15)
	                                .addComponent(jtfffinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jcbfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(138, Short.MAX_VALUE))
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
      //</editor-fold>
	}
	
	public boolean validarFecha(){
		if(aini <= afin){
			if(aini == afin){
				if(meini <= mefin){
					if(meini == mefin){
						if(dini <= dfin){
							if(dini == dfin){
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
		if(e.getSource().getClass() == JCheckBox.class){
			JCheckBox aux = (JCheckBox) e.getSource();
			boolean aux2 = aux.isSelected();
			if(aux2 == true){
			}else{
	        this.setVisible(false);
	        this.setVisible(true);
			}
			
		}else{
			if(e.getSource()== enviar){
				if(!("".equals(jtfsigla.getText()) ) && !("".equals(jtfmaximo.getText()))&& !("".equals(jtfminimo.getText()))){
					if(bcurso.validapk(jtfsigla.getText())){
						if(Integer.parseInt(jtfminimo.getText())<=Integer.parseInt(jtfmaximo.getText())&& hini<hfin&& this.validarFecha()){
							bcurso.setCurso(jtfsigla.getText(), jtfaula.getText(), sedes.getSelectedItem().toString(), listmat.get(materias.getSelectedIndex()).getMateriaId(), 
									listper.get(periodos.getSelectedIndex()).getPerPeriodo(), listpro.get(profesores.getSelectedIndex()).getProfId(),
									Integer.parseInt(jtfmaximo.getText()), Integer.parseInt(jtfminimo.getText()),new Date(), new Date(), dias.getSelectedIndex(), new Time(hini, mini, 00), 
									new Time(hfin, mfin, 00), 0, new Time(0,0,0), new Time(0,0,0));
							if(bcurso.insert()){
								JOptionPane.showMessageDialog(null, "Curso "+ jtfsigla.getText()+ " ingresada con éxito", "INFO", JOptionPane.INFORMATION_MESSAGE);
								jtfsigla.setText("");
								jtfaula.setText("");
								//jtfsede.setText("");
								jtfminimo.setText("");
								jtfminimo.setText("");
								hini = 0;
								hfin = 0;
								mini = 0;
								mfin = 0;
								this.dispose();
							}else{
								JOptionPane.showMessageDialog(null, "Error al agregar la carrera, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(null, "Datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(null, "No se permite duplicar la sigla en los Cursos ", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Datos faltantes ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
	
}
