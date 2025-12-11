Feature: Clockify

  @Workspace @Smoke
  Scenario Outline: Get all my Workspaces
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the workspace ID

    Examples:
      | operation | entity    | jsonName           | statusCode | token                                            |
      | GET       | WORKSPACE | getAllMyWorkspaces | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project @GetAllProjects
  Scenario Outline: Get all projects on workspace
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName       | statusCode | token                                            |
      | GET       | PROJECTS | getAllProjects | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project @AddProject
  Scenario Outline: Add a new project
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the project ID

    Examples:
      | operation | entity   | jsonName      | statusCode | token                                            |
      | POST      | PROJECTS | addNewProject | 201        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project @FindProject
  Scenario Outline: Find project by ID
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a 'POST' to 'PROJECTS' endpoint with the 'addNewProject' and ''
    And I extract the project ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName       | statusCode | token                                            |
      | GET       | PROJECTS | getProjectById | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project @UpdateProject
  Scenario Outline: PUT Project
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a 'POST' to 'PROJECTS' endpoint with the 'addNewProject' and ''
    And I extract the project ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName      | statusCode | token                                            |
      | PUT       | PROJECTS | updateProject | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project @DeleteProject @testGabo
  Scenario Outline: Delete project from workspace
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a 'POST' to 'PROJECTS' endpoint with the 'addNewProject' and ''
    And I extract the project ID
    Then status code 201 is obtained
    When I perform a 'PUT' to 'PROJECTS' endpoint with the 'archiveProject' and ''
    Then status code 200 is obtained
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName      | statusCode | token                                            |
      | DELETE    | PROJECTS | deleteProject | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |

  @Client @AddClient
  Scenario Outline: Add a new client
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the client ID

    Examples:
      | operation | entity  | jsonName     | statusCode | token                                            |
      | POST      | CLIENTS | addNewClient | 201        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Client @FindClient
  Scenario Outline: Find clients on workspace
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity  | jsonName   | statusCode | token                                            |
      | GET       | CLIENTS | allClients | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Client @DeleteClient
  Scenario Outline: DELETE Client
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And I extract the workspace ID
    When I perform a 'POST' to 'CLIENTS' endpoint with the 'addNewClient' and ''
    And I extract the client ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity  | jsonName | statusCode | token                                            |
      | DELETE    | CLIENTS | (empty)  | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |