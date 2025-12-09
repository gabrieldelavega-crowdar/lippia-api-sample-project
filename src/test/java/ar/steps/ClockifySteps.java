package ar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import services.BaseService;
import services.WorkspaceService;

public class ClockifySteps {

    @Given("An account created in Clockify and x-api-key '(.*)' generated")
    public void defineApiKey(String apiKey) {
        BaseService.X_API_KEY.set(apiKey);
    }

    @And("I extract the workspace ID")
    public void saveWorkspaceId() {
        WorkspaceService.defineWorkspacesId();
    }
}