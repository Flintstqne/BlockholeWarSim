# Project Title:  'Blockhole War Simulator'

* Student:  Brayden Umberger
* Instructor:  Ken Smith
* Class:  IST261 - App Development Studio I
* Semester:  Spring '26

Project Description:  A Java-based territory war simulation application that models teams, players, territories, and war phases to analyze and manage a persistent conflict inspired by multiplayer sandbox games.


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
    
   * No additional configuration is required. Running Main.java will instantiate one object of each model class and output their initialized data to the console using the toString() methods.
