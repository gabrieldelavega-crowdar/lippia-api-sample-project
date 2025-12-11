package ar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import services.BaseService;
import services.ProjectService;
import services.WorkspaceService;

public class ClockifySteps {

    @Given("An account created in Clockify and x-api-key '(.*)' generated")
    public void defineApiKey(String apiKey) {
        BaseService.X_API_KEY.set(apiKey);
    }

    @And("I extract the workspace ID")
    public void iExtractWorkspaceId() {
        WorkspaceService.defineWorkspacesId();
    }

    @And("I extract the project ID")
    public void iExtractTheProjectId() {
        ProjectService.defineProjectId();
    }
}