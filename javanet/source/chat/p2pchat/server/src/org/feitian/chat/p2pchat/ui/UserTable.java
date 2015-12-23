package org.feitian.chat.p2pchat.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

//The TableModel controls all the data:
class DataModel extends AbstractTableModel {

    Object[][] data = { { "one", "two", "three", "four", "three", "four" },
            { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" },
            { "one", "two", "three", "four", "three", "four" }, { "five", "six", "seven", "eight", "six", "seven" },
            { "nine", "ten", "eleven", "twelve", "eleven", "twelve" }, };

    // Prints data when table changes:
    class TML implements TableModelListener {

        public void tableChanged(TableModelEvent e) {

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++)
                    System.out.print(data[i][j] + " ");
                System.out.println();
            }
        }
    }

    DataModel() {

        addTableModelListener(new TML());
    }

    public int getColumnCount() {

        return data[0].length;
    }

    public int getRowCount() {

        return data.length;
    }

    public Object getValueAt(int row, int col) {

        return data[row][col];
    }

    public void setValueAt(Object val, int row, int col) {

        data[row][col] = val;
        // Indicate the change has happened:
        fireTableDataChanged();
    }

    public boolean isCellEditable(int row, int col) {

        return true;
    }
};

public class UserTable extends JPanel {

    public UserTable() {

        setLayout(new BorderLayout());
        JTable table = new JTable(new DataModel());
        table.setShowVerticalLines(true);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollpane = JTable.createScrollPaneForTable(table);
        add(scrollpane, BorderLayout.CENTER);
    }

} // /:~
