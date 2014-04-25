package L_Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("all")
public class LVPanel extends JPanel {

	/**
	 * @param args
	 */
	protected Font fo;
	protected Color ccolor;
	protected JButton button;
	private int columnValue = -1;   
	private int columnNewValue = -1;   
	public LVPanel(){
		fo = new Font("Helvetica", 1, 13);
		ccolor = Color.BLACK;//new Color(42, 42, 42);
	}
	public void buildTabla(DefaultTableModel model, final JTable table, final JTextField filterText){

        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		//JScrollPane pane = new JScrollPane(table);
		/*button = new JButton("BUSCAR");
		button.setBounds(500, 100, 150, 20);
		button.addActionListener(
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String text = filterText.getText();
						if (text.length() == 0) {
							sorter.setRowFilter(null);
						} else {
							sorter.setRowFilter(RowFilter.regexFilter(text));
						}
					}
				});*/

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

}
