package org.longshen.activiti.service;

/**
 * 流程操作相关service
 */
public interface ActivitiOperateService {
    /**
     * 开启流程
     * @param id
     */
    void startWorkflow(String id);

    /**
     * 完成任务
     */
    void completeTask(String processId);
}
