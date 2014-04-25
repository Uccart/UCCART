package L_Vistas_Registro;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import beans.B_Carrera;
import beans.B_Padron;

import model.Carrera;

@SuppressWarnings("all")
public class LVPEliminar extends JDialog implements ActionListener{
	private JScrollPane jScrollPane1;
    private JButton jbcancelar, jbretirar;
    private JTable tableCarr;
    private DefaultTableModel carreras;
    private B_Carrera bcarrera;
    private B_Padron bpadron;
    private JLabel jlencabezado;
    private Font fo;
    private String encabezado, id;
    private List<Carrera> listcarr;
    
    public LVPEliminar(Frame padre, boolean modal, Font f, String i){
    	super(padre, modal);
    	fo = f;
    	id = i;
    	bcarrera = new B_Carrera();
    	bpadron = new B_Padron();
    	encabezado = "Carreras en las que el estudiante se encuentra actualmente inscrito. Seleccione uno y retire. ";
    	jlencabezado = new JLabel(encabezado);
    	jbretirar = new JButton("Retirar");
		jbcancelar = new JButton("Cancelar");
		carreras = new DefaultTableModel();
		tableCarr = new JTable(carreras){public boolean isCellEditable(int rowIndex, int colIndex) {
			return false;}};
		jScrollPane1 = new JScrollPane();
    }
    
    public void init(){
    	this.setTitle("Eliminar del Padrón");
    	JPanel jPanel1 = new JPanel();
    	JPanel jPanel2 = new JPanel();
    	
    	jPanel1.setBorder(BorderFactory.createTitledBorder("Padrón"));
    	
    	jlencabezado.setFont(fo);
    	jbretirar.setFont(fo);
    	jbretirar.setToolTipText("Retirar al estudiante del padrón de la carrera seleccionada!");
    	jbretirar.addActionListener(this);
    	jbcancelar.setFont(fo);
    	jbcancelar.setToolTipText("Cancelar y salir sin realizar ningún cambio!");
    	jbcancelar.addActionListener(this);
    	
    	carreras.addColumn("Código");
		carreras.addColumn("Nombre");
		listcarr = bpadron.getpadronXid(id);
		for(int i=0;i<listcarr.size();i++){
			String[] fila = {listcarr.get(i).getCarrCod(),listcarr.get(i).getCarrNombre()};
			carreras.addRow(fila);
		}
		tableCarr.setCellSelectionEnabled(false);
		tableCarr.setRowSelectionAllowed(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(carreras);
		tableCarr.setRowSorter(sorter);
		
		jScrollPane1.setViewportView(tableCarr);
		
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlencabezado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlencabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbretirar)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbretirar)
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
		if(e.getSource() == jbretirar){
			if(tableCarr.getSelectedRowCount() == 1){
				bpadron.find(bpadron.getId(id, (String)tableCarr.getValueAt(tableCarr.getSelectedRow(), 0)));
				if(bpadron.delete()){
					JOptionPane.showMessageDialog(null, "Estudiante "+ id+ " se ha retirado del padrón de la carrera "+ (String)tableCarr.getValueAt(tableCarr.getSelectedRow(), 1), "INFO", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Error al agregar el padrón, datos incorrectos ", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Debe seleccionar 1 carrera", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			if(e.getSource() == jbcancelar){
				this.dispose();
			}
		}
	}
}
