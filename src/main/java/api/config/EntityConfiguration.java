package api.config;

import services.*;

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
    },
    TIME_ENTRIES {
        @Override
        public Class<?> getEntityService() {
            return TimeEntryService.class;
        }
    };


    public abstract Class<?> getEntityService();
}