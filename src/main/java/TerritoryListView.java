import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * TerritoryListView - Displays territories in a JTable with CRUD operations.
 * This is the list-view component of the list-detail pattern.
 */
public class TerritoryListView extends JFrame {

    private final JTable territoryTable;
    private final TerritoryTableModel tableModel;
    private final JLabel statusLabel;
    private final JButton viewButton;
    private final JButton addButton;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JButton exitButton;

    public TerritoryListView() {
        setTitle("Blockhole War Simulator - Territory List");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table model and table
        tableModel = new TerritoryTableModel();
        territoryTable = new JTable(tableModel);
        territoryTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        territoryTable.setDefaultEditor(Object.class, null);  // Make table read-only
        
        // Set column widths
        territoryTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        territoryTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        territoryTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        territoryTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        territoryTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(territoryTable);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 6, 0));
        viewButton = new JButton("View");
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        exitButton = new JButton("Exit");

        buttonPanel.add(viewButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        // Status label
        statusLabel = new JLabel("Ready", SwingConstants.CENTER);

        // Layout
        setLayout(new BorderLayout(8, 8));
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void setViewAction(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void setAddAction(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void setEditAction(ActionListener actionListener) {
        editButton.addActionListener(actionListener);
    }

    public void setDeleteAction(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void setExitAction(ActionListener actionListener) {
        exitButton.addActionListener(actionListener);
    }

    public int getSelectedRow() {
        return territoryTable.getSelectedRow();
    }

    public void populateTerritories(ArrayList<Territory> territories) {
        tableModel.setTerritories(territories);
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }

    public void refreshTable() {
        tableModel.fireTableDataChanged();
    }

    public void selectRow(int index) {
        if (index >= 0 && index < tableModel.getRowCount()) {
            territoryTable.setRowSelectionInterval(index, index);
        }
    }

    /**
     * TerritoryTableModel - Custom table model for displaying territories.
     */
    private static class TerritoryTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Name", "X", "Y", "Terrain Type", "Owner Team"};
        private ArrayList<Territory> territories;

        public TerritoryTableModel() {
            this.territories = new ArrayList<>();
        }

        public void setTerritories(ArrayList<Territory> territories) {
            this.territories = territories;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return territories.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (row < 0 || row >= territories.size()) {
                return null;
            }

            Territory territory = territories.get(row);
            switch (col) {
                case 0:
                    return territory.getName();
                case 1:
                    return territory.getXCoordinate();
                case 2:
                    return territory.getYCoordinate();
                case 3:
                    return territory.getTerrainType();
                case 4:
                    return territory.getOwnerTeam();
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }
}

