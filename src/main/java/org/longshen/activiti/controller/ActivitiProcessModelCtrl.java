package org.longshen.activiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 流程模板
 */
@Controller
public class ActivitiProcessModelCtrl {
    /**
     * 获取流程列表
     * @return
     */
    @PostMapping(value = "/getProcessList")
    public Object getProcessList(){
//        ActivitiServiceUtils.getRepositoryService()
        return null;
    }
}
