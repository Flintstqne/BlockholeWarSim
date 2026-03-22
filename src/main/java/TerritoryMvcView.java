import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class TerritoryMvcView extends JFrame {

    private final JTextField nameField;
    private final JTextField xField;
    private final JTextField yField;
    private final JTextField terrainTypeField;
    private final JTextField ownerTeamField;

    private final JLabel statusLabel;

    private final JButton previousButton;
    private final JButton nextButton;
    private final JButton addButton;
    private final JButton updateButton;
    private final JButton clearButton;
    private final JButton deleteButton;
    private final JButton exitButton;

    public TerritoryMvcView() {
        setTitle("Blockhole War Simulator - Territory MVC");
        setSize(640, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 8, 8));

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

        JPanel buttonPanel = new JPanel(new GridLayout(1, 7, 6, 0));
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        clearButton = new JButton("Clear");
        deleteButton = new JButton("Delete");
        exitButton = new JButton("Exit");

        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);

        statusLabel = new JLabel("Ready", SwingConstants.CENTER);

        setLayout(new BorderLayout(8, 8));
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public void setPreviousAction(ActionListener actionListener) {
        previousButton.addActionListener(actionListener);
    }

    public void setNextAction(ActionListener actionListener) {
        nextButton.addActionListener(actionListener);
    }

    public void setAddAction(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void setUpdateAction(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void setClearAction(ActionListener actionListener) {
        clearButton.addActionListener(actionListener);
    }

    public void setDeleteAction(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void setExitAction(ActionListener actionListener) {
        exitButton.addActionListener(actionListener);
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
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }

    public void updateNavigationState(boolean hasItems, boolean canMovePrevious, boolean canMoveNext) {
        previousButton.setEnabled(canMovePrevious);
        nextButton.setEnabled(canMoveNext);
        updateButton.setEnabled(hasItems);
        deleteButton.setEnabled(hasItems);
    }
}

