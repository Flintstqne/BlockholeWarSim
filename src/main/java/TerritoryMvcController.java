public class TerritoryMvcController {

    private final TerritoryListModel territoryListModel;
    private final TerritoryMvcView territoryMvcView;
    private int currentIndex;

    public TerritoryMvcController() {
        territoryListModel = new TerritoryListModel();
        territoryMvcView = new TerritoryMvcView();
        currentIndex = 0;

        wireActions();
        showCurrentRecord();
        territoryMvcView.setVisible(true);
    }

    private void wireActions() {
        territoryMvcView.setPreviousAction(event -> movePrevious());
        territoryMvcView.setNextAction(event -> moveNext());
        territoryMvcView.setAddAction(event -> addRecord());
        territoryMvcView.setUpdateAction(event -> updateRecord());
        territoryMvcView.setClearAction(event -> clearForm());
        territoryMvcView.setDeleteAction(event -> deleteRecord());
        territoryMvcView.setExitAction(event -> exitApplication());
    }

    private void movePrevious() {
        if (territoryListModel.isEmpty()) {
            territoryMvcView.setStatus("Cannot move previous: no territories exist.");
            refreshButtons();
            return;
        }

        if (currentIndex == 0) {
            territoryMvcView.setStatus("Already at the first territory.");
            refreshButtons();
            return;
        }

        currentIndex--;
        showCurrentRecord();
    }

    private void moveNext() {
        if (territoryListModel.isEmpty()) {
            territoryMvcView.setStatus("Cannot move next: no territories exist.");
            refreshButtons();
            return;
        }

        if (currentIndex >= territoryListModel.size() - 1) {
            territoryMvcView.setStatus("Already at the last territory.");
            refreshButtons();
            return;
        }

        currentIndex++;
        showCurrentRecord();
    }

    private void addRecord() {
        Territory territoryFromForm = buildTerritoryFromForm();
        if (territoryFromForm == null) {
            return;
        }

        territoryListModel.add(territoryFromForm);
        currentIndex = territoryListModel.size() - 1;
        showCurrentRecord();
        territoryMvcView.setStatus("Added new territory at position " + (currentIndex + 1) + ".");
    }

    private void updateRecord() {
        if (territoryListModel.isEmpty()) {
            territoryMvcView.setStatus("Cannot update: the list is empty.");
            refreshButtons();
            return;
        }

        Territory territoryFromForm = buildTerritoryFromForm();
        if (territoryFromForm == null) {
            return;
        }

        territoryListModel.updateAt(currentIndex, territoryFromForm);
        showCurrentRecord();
        territoryMvcView.setStatus("Updated territory at position " + (currentIndex + 1) + ".");
    }

    private void clearForm() {
        territoryMvcView.clearForm();
        territoryMvcView.setStatus("Form cleared. Enter values to Add or Update.");
        refreshButtons();
    }

    private void deleteRecord() {
        if (territoryListModel.isEmpty()) {
            territoryMvcView.setStatus("Cannot delete: the list is empty.");
            refreshButtons();
            return;
        }

        territoryListModel.deleteAt(currentIndex);

        if (territoryListModel.isEmpty()) {
            currentIndex = 0;
            territoryMvcView.clearForm();
            territoryMvcView.setStatus("Deleted record. No territories remain.");
            refreshButtons();
            return;
        }

        if (currentIndex >= territoryListModel.size()) {
            currentIndex = territoryListModel.size() - 1;
        }

        showCurrentRecord();
        territoryMvcView.setStatus("Deleted record. Showing position " + (currentIndex + 1) + ".");
    }

    private Territory buildTerritoryFromForm() {
        String name = territoryMvcView.getNameInput();
        String xInput = territoryMvcView.getXInput();
        String yInput = territoryMvcView.getYInput();
        String terrainType = territoryMvcView.getTerrainTypeInput();
        String ownerTeam = territoryMvcView.getOwnerTeamInput();

        if (name.isEmpty() || xInput.isEmpty() || yInput.isEmpty() || terrainType.isEmpty() || ownerTeam.isEmpty()) {
            territoryMvcView.setStatus("All fields are required before Add/Update.");
            return null;
        }

        int xCoordinate;
        int yCoordinate;

        try {
            xCoordinate = Integer.parseInt(xInput);
            yCoordinate = Integer.parseInt(yInput);
        } catch (NumberFormatException ex) {
            territoryMvcView.setStatus("X and Y coordinates must be valid integers.");
            return null;
        }

        return new Territory(name, xCoordinate, yCoordinate, terrainType, ownerTeam);
    }

    private void showCurrentRecord() {
        if (territoryListModel.isEmpty()) {
            territoryMvcView.clearForm();
            territoryMvcView.setStatus("No territories to display.");
            refreshButtons();
            return;
        }

        Territory currentTerritory = territoryListModel.getAt(currentIndex);
        territoryMvcView.setFormData(currentTerritory);
        territoryMvcView.setStatus("Viewing territory " + (currentIndex + 1) + " of " + territoryListModel.size() + ".");
        refreshButtons();
    }

    private void refreshButtons() {
        boolean hasItems = !territoryListModel.isEmpty();
        boolean canMovePrevious = hasItems && currentIndex > 0;
        boolean canMoveNext = hasItems && currentIndex < territoryListModel.size() - 1;
        territoryMvcView.updateNavigationState(hasItems, canMovePrevious, canMoveNext);
    }

    private void exitApplication() {
        System.exit(0);
    }
}

