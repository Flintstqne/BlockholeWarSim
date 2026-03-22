/**
 * TerritoryListDetailController - Manages the list-detail pattern for territories.
 * This controller coordinates between the TerritoryListView, TerritoryDetailView, and TerritoryListModel.
 */
public class TerritoryListDetailController {

    private final TerritoryListModel territoryListModel;
    private final TerritoryListView listView;
    private int selectedIndex = -1;

    public TerritoryListDetailController() {
        territoryListModel = new TerritoryListModel();
        listView = new TerritoryListView();

        wireActions();
        initializeList();
        listView.setVisible(true);
    }

    private void wireActions() {
        listView.setViewAction(e -> viewDetails());
        listView.setAddAction(e -> addNewTerritory());
        listView.setEditAction(e -> editTerritory());
        listView.setDeleteAction(e -> deleteTerritory());
        listView.setExitAction(e -> exitApplication());
    }

    private void initializeList() {
        // Pre-populate with at least 6 territories
        territoryListModel.add(new Territory("Iron Ridge", 2, 3, "Mountain", "Red Legion"));
        territoryListModel.add(new Territory("River Watch", 8, 1, "Plains", "Blue Guard"));
        territoryListModel.add(new Territory("Ash Hollow", 5, 9, "Volcanic", "Green Alliance"));
        territoryListModel.add(new Territory("Shadow Marsh", 1, 6, "Swamp", "Purple Faction"));
        territoryListModel.add(new Territory("Crystal Peak", 9, 4, "Mountain", "Red Legion"));
        territoryListModel.add(new Territory("Emerald Forest", 3, 7, "Forest", "Blue Guard"));
        
        refreshListView();
        if (territoryListModel.size() > 0) {
            listView.selectRow(0);
            selectedIndex = 0;
            listView.setStatus("Loaded " + territoryListModel.size() + " territories. Select one to view details.");
        }
    }

    private void viewDetails() {
        int selectedRow = listView.getSelectedRow();
        if (selectedRow == -1) {
            listView.setStatus("Please select a territory to view details.");
            return;
        }

        Territory selected = territoryListModel.getAt(selectedRow);
        showDetailView(selected, "View Territory Details");
        refreshListView();
    }

    private void addNewTerritory() {
        TerritoryDetailView detailView = new TerritoryDetailView();
        detailView.clearForm();
        detailView.setSaveAction(e -> {
            Territory newTerritory = buildTerritoryFromDetailView(detailView);
            if (newTerritory != null) {
                territoryListModel.add(newTerritory);
                refreshListView();
                listView.selectRow(territoryListModel.size() - 1);
                listView.setStatus("Added new territory. Total territories: " + territoryListModel.size());
            }
        });
        detailView.setVisible(true);
    }

    private void editTerritory() {
        int selectedRow = listView.getSelectedRow();
        if (selectedRow == -1) {
            listView.setStatus("Please select a territory to edit.");
            return;
        }

        Territory selected = territoryListModel.getAt(selectedRow);
        TerritoryDetailView detailView = new TerritoryDetailView();
        detailView.setFormData(selected);
        detailView.setSaveAction(e -> {
            Territory updatedTerritory = buildTerritoryFromDetailView(detailView);
            if (updatedTerritory != null) {
                territoryListModel.updateAt(selectedRow, updatedTerritory);
                refreshListView();
                listView.selectRow(selectedRow);
                listView.setStatus("Updated territory at row " + (selectedRow + 1) + ".");
            }
        });
        detailView.setVisible(true);
    }

    private void deleteTerritory() {
        if (territoryListModel.isEmpty()) {
            listView.setStatus("Cannot delete: no territories exist.");
            return;
        }

        int selectedRow = listView.getSelectedRow();
        if (selectedRow == -1) {
            listView.setStatus("Please select a territory to delete.");
            return;
        }

        // Show confirmation dialog
        int result = javax.swing.JOptionPane.showConfirmDialog(
                listView,
                "Are you sure you want to delete this territory?",
                "Confirm Delete",
                javax.swing.JOptionPane.YES_NO_OPTION
        );

        if (result == javax.swing.JOptionPane.YES_OPTION) {
            territoryListModel.deleteAt(selectedRow);
            refreshListView();

            if (territoryListModel.isEmpty()) {
                listView.setStatus("Deleted territory. No territories remain.");
            } else {
                int newIndex = Math.min(selectedRow, territoryListModel.size() - 1);
                listView.selectRow(newIndex);
                listView.setStatus("Deleted territory. Remaining: " + territoryListModel.size() + ".");
            }
        }
    }

    private void showDetailView(Territory territory, String title) {
        TerritoryDetailView detailView = new TerritoryDetailView();
        detailView.setTitle(title);
        detailView.setFormData(territory);
        detailView.setVisible(true);
    }

    private Territory buildTerritoryFromDetailView(TerritoryDetailView detailView) {
        String name = detailView.getNameInput();
        String xInput = detailView.getXInput();
        String yInput = detailView.getYInput();
        String terrainType = detailView.getTerrainTypeInput();
        String ownerTeam = detailView.getOwnerTeamInput();

        try {
            int xCoordinate = Integer.parseInt(xInput);
            int yCoordinate = Integer.parseInt(yInput);
            return new Territory(name, xCoordinate, yCoordinate, terrainType, ownerTeam);
        } catch (NumberFormatException ex) {
            listView.setStatus("Error: Invalid coordinates.");
            return null;
        }
    }

    private void refreshListView() {
        listView.populateTerritories(territoryListModel.getTerritories());
        listView.refreshTable();
    }

    private void exitApplication() {
        System.exit(0);
    }
}

