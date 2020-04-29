package aem.training.core.WorkFlow;


import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.service.component.annotations.Component;

@Component(service = WorkflowProcess.class, property = {"process.label = AEM Tutorial"})

public class TestWorkFlow implements WorkflowProcess {

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {

        final WorkflowData workflowData = workItem.getWorkflowData();
        final String path =  workflowData.getPayload().toString();
    }
}
