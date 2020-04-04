package org.longshen.activiti;

import org.activiti.engine.RepositoryService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.longshen.activiti.service.ActivitiOperateService;
import org.longshen.activiti.utils.ActivitiServiceUtils;
import org.longshen.activiti.utils.CommonUtils;
import org.longshen.activiti.utils.WorkflowCreateUtils;
import org.longshen.activiti.vo.LineEvent;
import org.longshen.activiti.vo.ProcessFlow;
import org.longshen.activiti.vo.TaskEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LongshenActivitiApplicationTests {
    @Autowired
    private ActivitiOperateService activitiService;

    @Test
    void contextLoads() {
        ProcessFlow processFlow = new ProcessFlow();
        processFlow.setId(CommonUtils.getUuid());
        processFlow.setName("请假流程");


        TaskEvent taskEvent = new TaskEvent();
        taskEvent.setId(CommonUtils.getUuid());
        taskEvent.setName("第一层审批");
        List<String> users = new ArrayList<>();
        users.add("tom");
        users.add("jackson");
        taskEvent.setUsers(users);

        LineEvent lineEvent = new LineEvent();
        lineEvent.setStartId("startEvent");
        lineEvent.setEndId(taskEvent.getId());


        TaskEvent taskEvent2 = new TaskEvent();
        taskEvent2.setId(CommonUtils.getUuid());
        taskEvent2.setName("第二层审批");
        taskEvent2.setUsers(users);

        LineEvent lineEvent2 = new LineEvent();
        lineEvent2.setStartId(taskEvent.getId());
        lineEvent2.setEndId(taskEvent2.getId());

        LineEvent lineEvent3 = new LineEvent();
        lineEvent3.setStartId(taskEvent2.getId());
        lineEvent3.setEndId("endEvent");

        List<TaskEvent> taskEvents = new ArrayList<>();
        taskEvents.add(taskEvent);
        taskEvents.add(taskEvent2);

        List<LineEvent> lineEvents = new ArrayList<>();
        lineEvents.add(lineEvent);
        lineEvents.add(lineEvent2);
        lineEvents.add(lineEvent3);

        processFlow.setLineEvents(lineEvents);
        processFlow.setUserTasks(taskEvents);
        WorkflowCreateUtils.addActivitiProcessFlow(processFlow);

    }

    @Test
    public void startWorkFlow(){
        activitiService.startWorkflow("USER_DEFINED_a0ec6c73aba3b4a87a67601ae28da1ad4:1:22504");
    }
    @Test
    public void viewImage() throws IOException {
        // 创建仓库服务对对象
        RepositoryService repositoryService = ActivitiServiceUtils.getRepositoryService();
        // 从仓库中找需要展示的文件
        String deploymentId = "22501";
        List<String> names = repositoryService.getDeploymentResourceNames(deploymentId);
        String imageName = null;
        for (String name : names) {
            if(name.indexOf(".png")>=0){
                imageName = name;
            }
        }
        if(imageName!=null) {
            File f = new File("E:/" + imageName);
            // 通过部署ID和文件名称得到文件的输入流
            InputStream in = repositoryService.getResourceAsStream(deploymentId, imageName);
            FileUtils.copyInputStreamToFile(in, f);
        }
    }
}
