package services;

import api.model.timeEntry.TimeEntryModel;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class TimeEntryService extends BaseService {


    public static Response get(String jsonName) {
        return get(jsonName, TimeEntryModel[].class, setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, TimeEntryModel.class, setParams());
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

        String uId = System.getProperty("userId");
        if (uId != null) {
            params.put("userId", uId);
        }

        String pId = System.getProperty("projectId");
        if (pId != null) {
            params.put("projectId", pId);
        }

        String startTime = Instant.now().toString();
        String endTime = Instant.now().plus(1, ChronoUnit.HOURS).toString();

        params.put("start", startTime);
        params.put("end", endTime);
        params.put("dateDescription", startTime);

        return params;
    }
}