package org.longshen.activiti.utils;

import org.activiti.engine.*;

/**
 * 获取流程的各个service
 */
public class ActivitiServiceUtils {
    public static ProcessEngine getProcessEngine() {
        return ProcessEngines.getDefaultProcessEngine();
    }

    public static RepositoryService getRepositoryService() {
        return getProcessEngine().getRepositoryService();
    }

    public static TaskService getTaskService() {
        return getProcessEngine().getTaskService();
    }

    public static RuntimeService getRuntimeService() {
        return getProcessEngine().getRuntimeService();
    }

    public static HistoryService getHistoryService() {
        return getProcessEngine().getHistoryService();
    }

    public static IdentityService getIdentityService() {
        return getProcessEngine().getIdentityService();
    }
}
