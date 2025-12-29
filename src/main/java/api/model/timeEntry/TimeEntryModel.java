package api.model.timeEntry;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeEntryModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("projectId")
    private String projectId;

    @JsonProperty("timeInterval")
    private Object timeInterval;

    public TimeEntryModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}