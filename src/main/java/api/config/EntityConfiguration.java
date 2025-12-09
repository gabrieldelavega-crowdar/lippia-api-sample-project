package api.config;

import services.UserService;
import services.WorkspaceService;

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
    };


    public abstract Class<?> getEntityService();
}



