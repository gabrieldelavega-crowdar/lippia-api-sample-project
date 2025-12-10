package api.config;

import services.UserService;
import services.WorkspaceService;
import services.ProjectService;
import services.ClientService;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },

    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },


    PROJECTS {
        @Override
        public Class<?> getEntityService() {
            return ProjectService.class;
        }
    },


    CLIENTS {
        @Override
        public Class<?> getEntityService() {
            return ClientService.class;
        }
    };


    public abstract Class<?> getEntityService();
}