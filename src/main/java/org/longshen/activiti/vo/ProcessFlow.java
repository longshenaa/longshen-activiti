package org.longshen.activiti.vo;

import lombok.Data;

import java.util.List;

/**
 * 流程模板
 */
@Data
public class ProcessFlow {
    //流程id
    private String id;
    //流程名称
    private String name;
    //用户任务
    private List<TaskEvent> userTasks;
    //连线
    private List<LineEvent> lineEvents;
}
