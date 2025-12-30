package services;

import api.model.timeEntry.TimeEntryModel;
import com.crowdar.api.rest.APIManager;
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

    public static Response put(String jsonName) {
        return put(jsonName, TimeEntryModel.class, setParams());
    }
    public static Response delete(String jsonName) {
        return delete(jsonName, null, setParams());
    }

    public static void defineTimeEntryId() {
        Object response = APIManager.getLastResponse().getResponse();
        String id = null;
        String originalStart = null;

        try {
            if (response instanceof TimeEntryModel[]) {
                TimeEntryModel[] timeEntries = (TimeEntryModel[]) response;
                if (timeEntries.length > 0) {
                    id = timeEntries[0].getId();

                    if (timeEntries[0].getTimeInterval() != null) {
                        originalStart = timeEntries[0].getTimeInterval().getStart();
                    }
                }
            } else if (response instanceof TimeEntryModel) {
                TimeEntryModel timeEntry = (TimeEntryModel) response;
                id = timeEntry.getId();
                if (timeEntry.getTimeInterval() != null) {
                    originalStart = timeEntry.getTimeInterval().getStart();
                }
            }

            if (id != null) {
                System.setProperty("timeEntryId", id);
                System.out.println("ID guardado: " + id);
            }

            if (originalStart != null) {
                System.setProperty("timeEntryStart", originalStart);
                System.out.println("Start time original guardado: " + originalStart);
            }

        } catch (Exception e) {
            System.out.println("Error extrayendo datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();

        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        if (X_API_KEY.get() != null) params.put("x-api-key", X_API_KEY.get());
        if (WORKSPACE_ID.get() != null) params.put("workspaceId", WORKSPACE_ID.get());

        String uId = System.getProperty("userId");
        if (uId != null) params.put("userId", uId);

        String pId = System.getProperty("projectId");
        if (pId != null) params.put("projectId", pId);

        String tId = System.getProperty("timeEntryId");
        if (tId != null) params.put("timeEntryId", tId);


        String savedStart = System.getProperty("timeEntryStart");
        Instant startInstant;

        if (savedStart != null) {
            startInstant = Instant.parse(savedStart);
        } else {
            startInstant = Instant.now();
        }

        String startTime = startInstant.toString();
        String endTime4h = startInstant.plus(4, ChronoUnit.HOURS).toString();

        params.put("start", startTime);
        params.put("end_4h", endTime4h);
        params.put("dateDescription", startTime);

        return params;
    }
}