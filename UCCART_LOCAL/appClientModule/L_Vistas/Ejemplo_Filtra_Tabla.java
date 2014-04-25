/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package L_Vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Ejemplo_Filtra_Tabla {

    public static void main(String args[]) {
        JFrame frame = new JFrame("BUSCAR EN UN JTABLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*Object rows[][] = {{"A", "About", 44.36}, {"B", "Boy", 44.84}, {"C", "Cat", 463.63},
            {"D", "Day", 27.14}, {"E", "Eat", 44.57}, {"F", "Fail", 23.15},
            {"G", "Good", 4.40}, {"H", "Hot", 24.96}, {"I", "Ivey", 5.45},
            {"J", "Jack", 49.54}, {"K", "Kids", 280.00}};
        String columns[] = {"NOMBRE", "DESCRIPCION", "PRECIO"};
        TableModel model =
                new DefaultTableModel(rows, columns) {

                    public Class getColumnClass(int column) {
                        Class returnValue;
                        if ((column >= 0) && (column < getColumnCount())) {
                            returnValue = getValueAt(0, column).getClass();
                        } else {
                            returnValue = Object.class;
                        }
                        return returnValue;
                    }
                };*/

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Curso");
        model.addColumn("Horario");
        String[] fila = {"12","Dibujo 1","L:5-7 J:5-7","Artes Plásticas"};
        model.addRow(fila);
        final JTable table = new JTable(model);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("REGISTRO");
        panel.add(label, BorderLayout.WEST);
        final JTextField filterText = new JTextField("Registro a Buscar");
        panel.add(filterText, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        JButton button = new JButton("BUSCAR");
        button.setBounds(500, 100, 150, 20);

        filterText.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                System.out.println("Hola1");
            }

            public void removeUpdate(DocumentEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
                System.out.println("Hola2");
            }

            public void insertUpdate(DocumentEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
                System.out.println("Hola3");
            }
        });

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
                });
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}
