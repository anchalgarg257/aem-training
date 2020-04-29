//package aem.training.core.services.impl;
//
//import org.osgi.service.component.annotations.Component;
//
//import javax.jcr.Node;
//import javax.jcr.Session;
//@Component(service = NodeUtilsService.class)
//public class NodeUtilsImpl implements NodeUtilsService {
//    @Override
//    public Node createNode(Node parentNode, Session session, String nodeName, String nodeType) {
//        Node newNode = null;
//        try{
//            newNode = parentNode.addNode(nodeName, nodeType);
//            session.save();
//        }
//        catch (Exception e) {
//
//        }
//
//        return newNode;
//    }
//
//    @Override
//    public void setPropertyToNode(Node node, Session session, String propertyName, String value) {
//
//        try {
//            node.setProperty(propertyName, value);
//            session.save();
//        } catch (Exception e) {
//
//        }
//    }
//}
