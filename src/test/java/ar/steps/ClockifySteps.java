package ar.steps;

import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import services.*;

public class ClockifySteps {

    @Given("An account created in Clockify and x-api-key '(.*)' generated")
    public void defineApiKey(String keyVariable) {
        String token = PropertyManager.getProperty(keyVariable);

        if (token == null) {
            token = keyVariable;
        }
        BaseService.X_API_KEY.set(token);
    }

    @And("I extract the workspace ID")
    public void iExtractWorkspaceId() {
        WorkspaceService.defineWorkspacesId();
    }

    @And("I extract the project ID")
    public void iExtractTheProjectId() {
        ProjectService.defineProjectId();
    }

    @And("I extract the client ID")
    public void iExtractTheClientId() {
        ClientService.defineClientId();
    }

    @And("I extract the user ID")
    public void iExtractTheUserId() {
        UserService.defineUserId();
    }
    @And("I extract the time entry ID")
    public void iExtractTheTimeEntryId() {
        TimeEntryService.defineTimeEntryId();
    }
}