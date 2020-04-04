package org.longshen.activiti.utils;

import org.activiti.bpmn.model.*;

import java.util.List;

/**
 * 节点创建
 */
public class ActivitiCreateUtils {
    /**
     * 创建task节点
     * @param id 节点id
     * @param name 节点名称
     * @param assignee 节点审核人
     * @return
     */
    public static UserTask createUsersTask(String id, String name, List<String> assignee){
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setCandidateUsers(assignee);
        return userTask;
    }
    /**
     * 创建连线
     * @param from 从节点
     * @param to 流向节点
     * @return
     */
    public static SequenceFlow createSequenceFlow(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }
    /**
     * 开始节点
     * @return
     */
    public static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        startEvent.setName("开始节点");
        return startEvent;
    }

    /**
     * 结束节点
     * @return
     */
    public static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        endEvent.setName("结束节点");
        return endEvent;
    }
}
