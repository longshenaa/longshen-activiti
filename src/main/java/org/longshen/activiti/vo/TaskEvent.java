package org.longshen.activiti.vo;

import lombok.Data;

import java.util.List;

/**
 * 节点
 */
@Data
public class TaskEvent {
    //节点id
    private String id;
    //节点名称
    private String name;
    //节点审批涉及到的人
    private List<String> users;
}
