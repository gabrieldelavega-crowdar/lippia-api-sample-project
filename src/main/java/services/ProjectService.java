package services;

// CORRECCIÓN AQUÍ: 'allProjects' con P mayúscula
import api.model.allProjects.getAllprojectsModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ProjectService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, getAllprojectsModel[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("x-api-key", X_API_KEY.get());

        if (WORKSPACE_ID.get() != null) {
            params.put("workspaceId", WORKSPACE_ID.get());
        }

        return params;
    }

    public static void defineProjectId() {
        getAllprojectsModel[] projects = (getAllprojectsModel[]) APIManager.getLastResponse().getResponse();

        if (projects != null && projects.length > 0) {
            PROJECT_ID.set(projects[0].id);
        }
    }
}