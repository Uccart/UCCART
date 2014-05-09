package L_Vistas_Financiero;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.CuentasPorCobrar;
import model.Curso;
import model.Estudiante;
import model.Nota;
import beans.B_CuentasPorCobrar;
import beans.B_Estudiante;
import beans.B_FacturaEntrada;
import L_Vistas.FileChooser;
import model.FacturaEntrada;

public class LVConsultarFacturasCobrar extends JDialog implements MouseListener, ActionListener, ItemListener{
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JPanel jPanel2;
	    private JScrollPane jScrollPane1;
	    private JTable jTable1;
	   // private JButton jbCerrar;
	   // private JButton jbHistorial;
	    private JTextField jtfIDE;
	    private JTextField jtfNombreE;
	    private B_Estudiante bestudiante;
	    private Estudiante estudiante;
	    private DefaultTableModel factura; 
	    private int columnValue = -1;   
		private int columnNewValue = -1; 
		protected Font fo;
		protected Color ccolor;
		private boolean estado;
	
		private boolean bandera;
	
	    public LVConsultarFacturasCobrar(JFrame padre, Estudiante e){
	    	super(padre);
	    	estado = true;
	    	fo = new Font("Helvetica", 1, 13);
			ccolor = Color.BLACK;
	    	factura = new DefaultTableModel();
	    	jLabel1 = new javax.swing.JLabel();
	        jPanel2 = new javax.swing.JPanel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jtfIDE = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        bestudiante = new B_Estudiante();
	        estudiante = e;
	    }
	    
	    public void init(boolean ban){
	    	bandera = ban;
	    	factura = new DefaultTableModel();
	    	//cursos = new DefaultTableModel();
	    	jLabel1 = new javax.swing.JLabel();
	        jPanel2 = new javax.swing.JPanel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jtfIDE = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        this.jtfNombreE = new JTextField();
	    	jLabel1.setFont(fo);
	        jPanel2.setFont(fo);
	        jLabel2.setFont(fo);
	        jLabel3.setFont(fo);
	        jtfIDE.setFont(fo);
	        jScrollPane1.setFont(fo);
	        jTable1 =  new JTable(factura){public boolean isCellEditable(int rowIndex, int colIndex) {
	        	return false;}};
	        	if(bestudiante.find(estudiante.getEstId())){
	                 jtfNombreE.setText(estudiante.getEstNombre()+" "+ estudiante.getEstApellido1()+" "+estudiante.getEstApellido2()); 
	                 this.jtfIDE.setText(estudiante.getEstId());
	        	}
	        //	jbHistorial = new javax.swing.JButton();
	       // jbCerrar = new javax.swing.JButton();

	        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Facturas del Estudiante"));

	        jLabel2.setText("Nombre:");

	        jLabel3.setText("ID.:");

	        jtfIDE.setEditable(false);
          /*  
	        List<Nota> listNotas = bestudiante.getNotas(estudiante.getEstId()); 
	    	factura.addColumn("Código");
			factura.addColumn("Nombre");
			factura.addColumn("Aula");
			for(int i=0;i<listNotas.size();i++){
			    	
				
				String[] fila = {listNotas.get(i).getCurso().getCursoId(),listNotas.get(i).getCurso().getMateria().getMateriaNombre(), listNotas.get(i).getCurso().getMateria().getMateriaCreditos().toString()};
				factura.addRow(fila);
			}
			*/
			
			List<FacturaEntrada> listFacturas = bestudiante.getFacturaEntrada(estudiante.getEstId());
			factura.addColumn("Cuenta por Cobrar");
			factura.addColumn("Factura correspondiente");
			factura.addColumn("Identificacion");
			factura.addColumn("Nombre");
			factura.addColumn("Monto");
			
			B_CuentasPorCobrar bean= new B_CuentasPorCobrar();
       		List<CuentasPorCobrar> lista = bean.cuentasPorEstudiante(estudiante.getEstId());
			
           for(int i=0;i<lista.size();i++){        	   
				String[] fila = {
						lista.get(i).getCuentascobrar_id(),
						lista.get(i).getCuentascobrar_id_factura_entrada(),
						estudiante.getEstId(),
						estudiante.getEstNombre() + " " + estudiante.getEstApellido1(),
						String.valueOf(lista.get(i).getCuentascobrar_saldo())};
						
				factura.addRow(fila);
			}
			
			
			
	        jScrollPane1.setViewportView(jTable1);

	        jtfNombreE.setEditable(false);
	        jtfNombreE.addActionListener(this);

	        //jbHistorial.setText("Historial de Matrícula");
	       // jbHistorial.addActionListener(this);
	       // jbCerrar.setText("Cerrar");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(jLabel2)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jtfNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(38, 38, 38)
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jtfIDE)
	                        .addContainerGap())
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGap(10, 10, 10)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                //.addComponent(jbHistorial)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                //.addComponent(jbCerrar)
	                .addContainerGap())
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel3)
	                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jLabel2)
	                                .addComponent(jtfNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(13, 13, 13))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(jtfIDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(13, 13, 13)))
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    //.addComponent(jbHistorial)
	                    //.addComponent(jbCerrar)
	                		)
	                .addContainerGap(14, Short.MAX_VALUE))
	        );
	        JPanel panel = new JPanel();
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
	        panel.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGap(12, 12, 12))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(42, 42, 42)
	                .addComponent(jLabel1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
			
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	    
		public void buildTabla(DefaultTableModel model, final JTable table, final JTextField filterText){

	        table.setCellSelectionEnabled(false);
	        table.setRowSelectionAllowed(true);
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
			table.setRowSorter(sorter);


			filterText.getDocument().addDocumentListener(new DocumentListener() {

				public void changedUpdate(DocumentEvent e) {
				}

				public void removeUpdate(DocumentEvent e) {
					String text = filterText.getText();
					if (text.length() == 0) {
						sorter.setRowFilter(null);
					} else {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
					}
				}

				public void insertUpdate(DocumentEvent e) {
					String text = filterText.getText();
					if (text.length() == 0) {
						sorter.setRowFilter(null);
					} else {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
					}
				}
			});
			  
			  
			table.getColumnModel().addColumnModelListener(new TableColumnModelListener()   
			{   

				@Override
				public void columnAdded(TableColumnModelEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void columnMarginChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void columnMoved(TableColumnModelEvent e) {
					// TODO Auto-generated method stub
					if (columnValue == -1)   
			            columnValue = e.getFromIndex();   
			  
			        columnNewValue = e.getToIndex();   
				}

				@Override
				public void columnRemoved(TableColumnModelEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void columnSelectionChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					
				}   
			});   
			  
			table.getTableHeader().addMouseListener(new MouseAdapter()   
			{   
			    @Override   
			    public void mouseReleased(MouseEvent e)   
			    {   
			        if (columnValue != -1 && (columnValue == 0 || columnNewValue == 0))   
			        	table.moveColumn(columnNewValue, columnValue);   
			  
			        columnValue = -1;   
			        columnNewValue = -1;   
			    }   
			});  
		}
	    
		public boolean getEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

	
	
}
