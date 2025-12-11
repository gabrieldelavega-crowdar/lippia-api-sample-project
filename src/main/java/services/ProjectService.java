package services;

import api.model.addProject.AddProjectModel;
import api.model.allProjects.getAllprojectsModel;
import api.model.deleteProjects.DeleteprojectsModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ProjectService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, getAllprojectsModel.class, setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, AddProjectModel.class, setParams());
    }

    public static Response put(String jsonName) {
        return put(jsonName, DeleteprojectsModel.class, setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, DeleteprojectsModel.class, setParams());
    }

    public static void defineProjectId() {
        Object response = APIManager.getLastResponse().getResponse();
        String id = null;

        try {
            if (response.getClass().isArray()) {
                Object[] projects = (Object[]) response;
                if (projects.length > 0) {
                    getAllprojectsModel proj = (getAllprojectsModel) projects[0];
                    id = proj.getId();
                }
            } else if (response instanceof getAllprojectsModel) {
                getAllprojectsModel proj = (getAllprojectsModel) response;
                id = proj.getId();
            } else if (response instanceof AddProjectModel) {
                AddProjectModel proj = (AddProjectModel) response;
                id = proj.getId();
            }

            if (id != null) {
                System.setProperty("projectId", id);
            }

        } catch (Exception e) {
            System.out.println("Error extrayendo ID: " + e.getMessage());
        }
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));


        if (X_API_KEY.get() != null) {
            params.put("x-api-key", X_API_KEY.get());
        }

        if (WORKSPACE_ID.get() != null) {
            params.put("workspaceId", WORKSPACE_ID.get());
        }

        String projId = System.getProperty("projectId");
        if (projId != null) {
            params.put("projectId", projId);
        }

        String uniqueProjectName = "Lippia_TP_" + System.currentTimeMillis();
        params.put("projectName", uniqueProjectName);

        return params;
    }
}