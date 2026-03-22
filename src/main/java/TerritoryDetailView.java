import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/**
 * TerritoryDetailView - Displays and allows editing of a single territory's details.
 * This is the detail-view component of the list-detail pattern.
 * Used for both adding new territories and editing existing ones.
 */
public class TerritoryDetailView extends JDialog {

    private final JTextField nameField;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField terrainTypeField;
    private final JTextField ownerTeamField;

    private final JLabel statusLabel;

    private final JButton saveButton;
    private final JButton cancelButton;

    private boolean savePressed = false;

    public TerritoryDetailView() {
        setTitle("Territory Details");
        setSize(400, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("X Coordinate:"));
        xField = new JTextField();
        formPanel.add(xField);

        formPanel.add(new JLabel("Y Coordinate:"));
        yField = new JTextField();
        formPanel.add(yField);

        formPanel.add(new JLabel("Terrain Type:"));
        terrainTypeField = new JTextField();
        formPanel.add(terrainTypeField);

        formPanel.add(new JLabel("Owner Team:"));
        ownerTeamField = new JTextField();
        formPanel.add(ownerTeamField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 6, 0));
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        statusLabel = new JLabel("Enter territory details", SwingConstants.CENTER);

        setLayout(new BorderLayout(8, 8));
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> {
            savePressed = false;
            dispose();
        });
    }

    public void setSaveAction(ActionListener actionListener) {
        saveButton.addActionListener(e -> {
            // Validate form before calling the action listener
            String name = nameField.getText().trim();
            String xInput = xField.getText().trim();
            String yInput = yField.getText().trim();
            String terrainType = terrainTypeField.getText().trim();
            String ownerTeam = ownerTeamField.getText().trim();

            if (name.isEmpty() || xInput.isEmpty() || yInput.isEmpty() || terrainType.isEmpty() || ownerTeam.isEmpty()) {
                statusLabel.setText("All fields are required.");
                return;
            }

            try {
                Integer.parseInt(xInput);
                Integer.parseInt(yInput);
            } catch (NumberFormatException ex) {
                statusLabel.setText("X and Y must be valid integers.");
                return;
            }

            savePressed = true;
            actionListener.actionPerformed(e);
            dispose();
        });
    }

    public String getNameInput() {
        return nameField.getText().trim();
    }

    public String getXInput() {
        return xField.getText().trim();
    }

    public String getYInput() {
        return yField.getText().trim();
    }

    public String getTerrainTypeInput() {
        return terrainTypeField.getText().trim();
    }

    public String getOwnerTeamInput() {
        return ownerTeamField.getText().trim();
    }

    public void setFormData(Territory territory) {
        nameField.setText(territory.getName());
        xField.setText(String.valueOf(territory.getXCoordinate()));
        yField.setText(String.valueOf(territory.getYCoordinate()));
        terrainTypeField.setText(territory.getTerrainType());
        ownerTeamField.setText(territory.getOwnerTeam());
    }

    public void clearForm() {
        nameField.setText("");
        xField.setText("");
        yField.setText("");
        terrainTypeField.setText("");
        ownerTeamField.setText("");
        savePressed = false;
    }

    public boolean wasSavePressed() {
        return savePressed;
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }
}

