package org.longshen.activiti.service;

import org.activiti.engine.runtime.ProcessInstance;
import org.longshen.activiti.utils.ActivitiServiceUtils;
import org.springframework.stereotype.Service;

@Service
public class ActivitiOperateServiceImpl implements ActivitiOperateService {
    @Override
    public void startWorkflow(String id) {
        ProcessInstance instance = ActivitiServiceUtils.getRuntimeService().startProcessInstanceById(id);
//        ActivitiServiceUtils.getTaskService().complete(instance.getId());
    }

    @Override
    public void completeTask() {

    }
}
