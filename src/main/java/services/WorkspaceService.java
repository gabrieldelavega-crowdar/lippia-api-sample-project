package services;

import api.model.workspaces.WorkspacesResponse;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class WorkspaceService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, WorkspacesResponse[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("x-api-key", X_API_KEY.get());
        return params;
    }

    public static void defineWorkspacesId(){
        WorkspacesResponse[] workspacesResponses = (WorkspacesResponse[]) APIManager.getLastResponse().getResponse();
        WORKSPACE_ID.set(workspacesResponses[0].getId());
    }
}