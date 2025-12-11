package services;

import api.model.client.ClientModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ClientService extends BaseService {

    public static Response post(String jsonName) {
        return post(jsonName, ClientModel.class, setParams());
    }

    public static Response get(String jsonName) {
        return get(jsonName, ClientModel[].class, setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, ClientModel.class, setParams());
    }

    public static void defineClientId() {
        Object response = APIManager.getLastResponse().getResponse();
        String id = null;

        try {
            if (response.getClass().isArray()) {
                ClientModel[] clients = (ClientModel[]) response;
                if (clients.length > 0) {
                    id = clients[0].getId();
                }
            } else if (response instanceof ClientModel) {
                ClientModel client = (ClientModel) response;
                id = client.getId();
            }

            if (id != null) {
                System.setProperty("clientId", id);
            }

        } catch (Exception e) {
            System.out.println("Error extrayendo Client ID: " + e.getMessage());
            e.printStackTrace();
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

        String cId = System.getProperty("clientId");
        if (cId != null) {
            params.put("clientId", cId);
        }

        String uniqueClientName = "Lippia_Client_" + System.currentTimeMillis();
        params.put("clientName", uniqueClientName);

        return params;
    }
}