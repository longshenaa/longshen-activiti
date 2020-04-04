package org.longshen.activiti.service;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.longshen.activiti.utils.ActivitiServiceUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActivitiOperateServiceImpl implements ActivitiOperateService {
    @Override
    public void startWorkflow(String id) {
        ProcessInstance instance = ActivitiServiceUtils.getRuntimeService().startProcessInstanceById(id);
//        ActivitiServiceUtils.getTaskService().complete(instance.getId());
    }

    @Override
    public void completeTask(String processId) {
        //todo 会有多个task的情况，之后进行优化，现在以简单为主
        Task task = ActivitiServiceUtils.getTaskService()
                .createTaskQuery().processInstanceId(processId).singleResult();
        if (task != null && StringUtils.isNotEmpty(task.getId())) {
            log.info("任务节点名称[{}]", task.getName());
            ActivitiServiceUtils.getTaskService().complete(task.getId());
        }
    }
}
