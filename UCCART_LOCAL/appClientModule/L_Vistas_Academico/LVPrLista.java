package L_Vistas_Academico;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Nota;
import L_Vistas.LVPanel;
import beans.B_Curso;
import beans.B_Nota;
import beans.B_Profesor;

@SuppressWarnings("all")
public class LVPrLista extends JDialog implements ActionListener {
	private JButton jbcerrar;
	private JTable tableNotas;
	private DefaultTableModel notas;
	private B_Nota bnota;
	private B_Profesor bprofesor;
	private B_Curso bcurso;
	private Font fo;
	private int columnValue = -1;   
	private int columnNewValue = -1; 
	List<Nota> listnota;
	
	public LVPrLista(Frame padre, boolean modal, Font f){
		super(padre, modal);
		// TODO Auto-generated constructor stub
		fo = f;
		bnota = new B_Nota();
		bprofesor = new B_Profesor(); 
		bcurso = new B_Curso();
		notas = new DefaultTableModel();
		tableNotas = new JTable(notas){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
	}

	public void init(String idcurso){
		this.setTitle("Asignar Notas");
		bcurso.find(idcurso);
		
		JPanel panel = new JPanel();
		LVPanel jPanel1 = new LVPanel();
		JScrollPane jScrollPane1 = new JScrollPane();
		jbcerrar = new JButton();
   
		jbcerrar.setText("Cerrar");
		jbcerrar.setFont(fo);
		jbcerrar.setToolTipText("Cerrar ventana");
		jbcerrar.addActionListener(this);
        
        JLabel jLabel1 = new JLabel("*Si necesita de una lista impresa, solicítela en la secretaría");
        jLabel1.setFont(fo);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Notas"));
        
        notas.addColumn("ID");
        notas.addColumn("Nombre");
        notas.addColumn("Carrera");
        listnota = bcurso.getNotas();
		for(int i=0;i<listnota.size();i++){
			String carreras = "";
			for(int j = 0; j < listnota.get(i).getEstudiante().getPadrons().size();j++){
				carreras = carreras+listnota.get(i).getEstudiante().getPadrons().get(j).getCarrera().getCarrNombre();
				if(j+1 != listnota.get(i).getEstudiante().getPadrons().size())
					carreras = carreras + ", ";
			}
			String[] fila = {listnota.get(i).getEstudiante().getEstId(),listnota.get(i).getEstudiante().getEstApellido1()+" "+listnota.get(i).getEstudiante().getEstApellido2()+
					", "+listnota.get(i).getEstudiante().getEstNombre(),carreras};
			notas.addRow(fila);
		}
		this.buildTabla(notas, tableNotas);
		tableNotas.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableNotas.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableNotas.getColumnModel().getColumn(2).setPreferredWidth(100);

        
        jScrollPane1.setViewportView(tableNotas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbcerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbcerrar)
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
	
	public void buildTabla(DefaultTableModel model, final JTable table){
		table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbcerrar)
			this.dispose();
	} 
}