# Project Title:  'Blockhole War Simulator'

* Student:  Brayden Umberger
* Instructor:  Ken Smith
* Class:  IST261 - App Development Studio I
* Semester:  Spring '26

Project Description:  A Java-based territory war simulation application that models teams, players, territories, and war phases to analyze and manage a persistent conflict inspired by multiplayer sandbox games.

## Current Assignment Name:   'M06-A01: Implementing List-Detail Pattern with CRUD Operations'

## Assignment Accomplishments - (Description)
For this assignment, I implemented the list-detail pattern as part of the application's user interface design, allowing users to view a list of territories and manage them through full CRUD (Create, Read, Update, Delete) functionality.

* **Application / Entry Point:**
  - `Main` launches the list-detail pattern flow by creating the `TerritoryListDetailController` on the dispatch thread.

* **Model Classes (MVC):**
  - `Territory` is the core model object displayed in both list and detail views.
  - `TerritoryListModel` owns an `ArrayList<Territory>` with methods for add, update, delete, and list access.

* **View Classes (MVC):**
  - **`TerritoryListView` (List-View):** Displays territories in a scrollable `JTable` with 5 attribute columns (Name, X, Y, Terrain Type, Owner Team). Pre-populated with 6 territory records on application startup. Provides buttons for View, Add, Edit, Delete, and Exit operations.
  - **`TerritoryDetailView` (Detail-View):** A modal dialog for viewing and editing territory details. Used for both adding new territories and editing existing ones. Includes form validation for required fields and numeric coordinates.

* **Controller Class (MVC):**
  - `TerritoryListDetailController` mediates all behavior between the views and model.
  - Handles all CRUD operations: Create (Add), Read (View), Update (Edit), and Delete with confirmation.
  - Enforces business rules: prevents deletion on empty list, requires row selection for Edit/Delete/View, and syncs data between views.
  - Manages view lifecycle and data synchronization when the list regains focus.

* **Key Features Implemented:**
  - Scrollable table displaying at least 6 territories with 4+ attributes per row.
  - Full CRUD functionality accessible from the list-view.
  - Detail-view form for adding and editing territories with validation.
  - Confirmation dialog for delete operations.
  - Model object quantities sync between list and detail views.
  - Exit application only available from the list-view.
  - Form validation (required fields, integer coordinates).

This assignment demonstrates the list-detail design pattern with proper separation of concerns, full CRUD functionality, and synchronized data management across multiple UI components.


## Previous Assignment Name:   'M05-A01: Implementing Model-View-Controller (MVC)'

## Assignment Accomplishments - (Description)
For this assignment, I implemented an MVC-based feature that allows users to navigate and manage a list of territories.

* **Application / Entry Point:**
  - `Main` now launches the MVC flow by creating the controller on the dispatch thread.

* **Model Classes (MVC):**
  - `Territory` is the core model object displayed and edited in the UI.
  - `TerritoryListModel` is the list model that owns an `ArrayList<Territory>` and provides add, update, delete, and index-based access methods.

* **Controller Class (MVC):**
  - `TerritoryMvcController` mediates all behavior between the view and model.
  - It handles button actions for Previous, Next, Add, Update, Clear, Delete, and Exit.
  - It enforces boundary and empty-list checks (first/last navigation limits, no update/delete on empty list).
  - It validates form inputs before Add/Update (required fields and integer coordinate parsing).

* **View Class (MVC):**
  - `TerritoryMvcView` uses `JLabel` + `JTextField` components for territory data and provides all required buttons.
  - The view only communicates with the controller through action bindings and helper getter/setter methods.
  - On launch, the first territory in the list is displayed.

This assignment demonstrates separation of concerns with MVC while supporting list navigation and CRUD functionality through a desktop UI.


## Current Assignment Name:   'M04-A01: Implementing Inheritance and Interfaces'

## Assignment Accomplishments - (Description)
For this assignment, I implemented inheritance and interfaces in my Blockhole War Simulator project:

* **Class Hierarchy (Inheritance):**
  - Created a new super-class `Unit` representing a general game unit.
  - Developed two sub-classes: `Soldier` (with unique `weaponType`) and `Medic` (with unique `medkits`), each overriding two methods from `Unit` (`getRoleDescription()` and `performSpecialAction()`) with unique implementations.
  - Each sub-class provides different attributes and behaviors, demonstrating polymorphism.

* **Interface Implementation:**
  - Defined a new interface `Actionable` with the abstract method `performAction()`.
  - Implemented `Actionable` in two unrelated classes: `Player` and `Territory`, each with a unique implementation of `performAction()`.

* **Testing:**
  - Created a `TestInheritInterface` class in `src/test/java` with two methods:
    - `testClassHierarchy()`: Instantiates and tests the class hierarchy, adding multiple `Soldier` and `Medic` objects to an `ArrayList<Unit>`, then iterating and calling overridden methods to print unique messages.
    - `testInterface()`: Instantiates and tests the interface, adding `Player` and `Territory` objects to an `ArrayList<Actionable>`, then iterating and calling `performAction()` to print unique messages.
  - Both tests are run from the `main()` method, and output is printed to the console for verification.

This assignment demonstrates the use of inheritance, method overriding, interfaces, and polymorphism in Java, as well as proper testing and documentation practices.


## Current Assignment Name:   'M03_A01: Writing Model Unit Tests'

## Assignment Accomplishments - (Description)
For this assignment, I implemented both manual and automated unit tests for the model classes in my Blockhole War Simulator project:

* Manual Unit Tests:
  - Created a TestHarness class in src/test/java that manually tests all methods (constructors, getters, setters, toString) for the Player and Team classes. The TestHarness class includes a main() method and prints results to the console for verification.

* JUnit Automated Tests:
  - Developed JUnit 5 test classes for Territory and WarPhase in src/test/java. These tests cover constructors, getters, setters, and toString methods, and were verified to pass using Maven.
  - Updated pom.xml to use Java 17 and JUnit Jupiter (JUnit 5) for compatibility and modern testing support.

All tests were run and passed successfully, demonstrating correct implementation and behavior of the model classes. This assignment fulfills the requirements for writing and verifying model unit tests using both manual and automated approaches.


## Current Assignment Name:   'M02-A01: Identifying and Creating SW Model Classes'


## Assignment Accomplishments - (Description)
For this assignment, I created the initial Java model layer for my semester project, Blockhole Territory War Simulator, using noun–verb analysis to identify appropriate classes and attributes. All code can be found in the src/main/java directory of the project.

The following model classes were created by me:

* Player.java
This class represents an individual participant in the war. It includes fields for name, role, contributionPoints, level, and active status. A parameterized constructor initializes all fields, and full getters and setters are provided to encapsulate the data. The toString() method is overridden to return all instance data.

* Team.java
This class represents a faction competing in the war. It includes fields for name, playerCount, territoryCount, factionColor, and atWar status. The class includes a parameterized constructor, accessors and mutators for all fields, and an overridden toString() method.

* Territory.java
This class models a single territory on the map. It contains fields for name, xCoordinate, yCoordinate, terrainType, and ownerTeam. All fields are initialized through a parameterized constructor, fully encapsulated with getters and setters, and included in the overridden toString() output.

* WarPhase.java
This class represents the current phase of the war. It includes fields for phaseNumber, phaseName, description, weaponsUnlocked, and vehiclesUnlocked. The class includes a parameterized constructor, full accessors and mutators, and an overridden toString() method.

* GameWorld.java
This class represents the overall simulation state. It includes fields for worldName, mapSize, totalTeams, totalTerritories, and climateTheme. All fields are initialized via a parameterized constructor, encapsulated with getters and setters, and included in the toString() method.

In addition, a Main.java file was created to demonstrate that the assignment requirements were met. In the main method, one instance of each model class is instantiated using its parameterized constructor with valid dummy data. Each object’s toString() method is then called and printed to the console to verify proper initialization and output.

This assignment demonstrates identification of model classes, proper encapsulation, constructor usage, and object instantiation as required by the M02 rubric.



## Running the Project

These are instructions on how to run the project once loaded into IntelliJ.


### Steps

1. Navigate to the src/main/java directory.

2. Locate the file named Main.java.

3. Run the Main class.

Any other specifics (if needed):
    
   * No additional configuration is required. Running `Main.java` opens the MVC  interface for navigating and managing territory records.
