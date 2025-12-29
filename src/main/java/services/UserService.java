package services;

import api.model.user.UserModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class UserService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, UserModel.class, setParams());
    }

    public static void defineUserId() {
        Object response = APIManager.getLastResponse().getResponse();
        String id = null;

        try {
            if (response instanceof UserModel) {
                UserModel user = (UserModel) response;
                id = user.getId();
            }

            if (id != null) {
                System.setProperty("userId", id);
                System.out.println("DEBUG - User ID guardado: " + id);
            } else {
                System.out.println("DEBUG - No se pudo extraer User ID");
            }

        } catch (Exception e) {
            System.out.println("Error extrayendo User ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();

        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        if (X_API_KEY.get() != null) {
            params.put("x-api-key", X_API_KEY.get());
        }

        return params;
    }
}