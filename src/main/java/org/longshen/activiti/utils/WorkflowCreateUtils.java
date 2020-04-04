package org.longshen.activiti.utils;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.repository.Deployment;
import org.longshen.activiti.vo.ProcessFlow;

public class WorkflowCreateUtils {
    public static boolean addActivitiProcessFlow(ProcessFlow processFlow){
        BpmnModel model = new BpmnModel();
        Process process = new Process();
        process.setId("USER_DEFINED_" + processFlow.getId());
        process.setName(processFlow.getName());
        model.addProcess(process);

        //进行流程图创建
        //1.织入开始事件
        process.addFlowElement(ActivitiCreateUtils.createStartEvent());
        //2.织入线
        if (processFlow.getLineEvents() != null && processFlow.getLineEvents().size() > 0) {
            processFlow.getLineEvents().stream().forEach(e -> process.addFlowElement(ActivitiCreateUtils.createSequenceFlow(e.getStartId(), e.getEndId())));
        }
        if (processFlow.getUserTasks() != null && processFlow.getUserTasks().size() > 0) {
            processFlow.getUserTasks().stream().forEach(e -> process.addFlowElement(ActivitiCreateUtils.createUsersTask(e.getId(), e.getName(), e.getUsers())));
        }
        //3.织入结束事件
        process.addFlowElement(ActivitiCreateUtils.createEndEvent());
        //4.生成图形信息
        new BpmnAutoLayout(model).execute();
        //将流程部署到引擎
        Deployment deployment = ActivitiServiceUtils.getRepositoryService().createDeployment()
                .addBpmnModel("p" + process.getId() + ".bpmn", model).name(processFlow.getName())
                .deploy();
        return true;
    }
}
