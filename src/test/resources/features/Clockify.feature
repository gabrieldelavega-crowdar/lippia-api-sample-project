@testGabo
Feature: Clockify


  @Workspace @Smoke
  Scenario Outline: Get all workspaces and save Workspace ID
    Given An account created in Clockify and x-api-key '<token>' generated
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the workspace ID

    Examples:
      | operation | entity    | jsonName           | statusCode | token                                            |
      | GET       | WORKSPACE | getAllMyWorkspaces | 200        | ODhiYWFiMzItNWNkZC00NWYzLWIxMmItZDcyNTQzYWU4N2Mw |


  @Project
  Scenario Outline: Create a new project
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the project ID

    Examples:
      | operation | entity   | jsonName      | statusCode |
      | POST      | PROJECTS | addNewProject | 201        |

  @Project
  Scenario Outline: Find the created project by ID
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName | statusCode |
      | GET       | PROJECTS | (empty)  | 200        |

  @Project
  Scenario Outline: Update the created project
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName      | statusCode |
      | PUT       | PROJECTS | updateProject | 200        |

  @Project @Sequential
  Scenario Outline: Delete the created project
    When I archive the project using 'PUT' operation to 'PROJECTS' with 'archiveProject'
    Then status code 200 is obtained
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity   | jsonName | statusCode |
      | DELETE    | PROJECTS | (empty)  | 200        |


  @Client
  Scenario Outline:Create a new client
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And I extract the client ID

    Examples:
      | operation | entity  | jsonName     | statusCode |
      | POST      | CLIENTS | addNewClient | 201        |

  @Client
  Scenario Outline: Update the created client
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity  | jsonName     | statusCode |
      | PUT       | CLIENTS | updateClient | 200        |

  @Client
  Scenario Outline: Delete the created client
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity  | jsonName | statusCode |
      | DELETE    | CLIENTS | (empty)  | 200        |