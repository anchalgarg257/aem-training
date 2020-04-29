//package aem.training.core.models;
//
//
//import aem.training.core.pojo.Bean;
//import aem.training.core.pojo.ListBean;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ValueMap;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.SlingObject;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Model(adaptables= Resource.class)
//
//public class Component {
//    @SlingObject
//    private Resource resource;
//
//    public List<Bean> getResource() {
//        Resource resource1 = resource.getChild("field");
//
//        Iterator<Resource> resources = resource1.listChildren();
//        List<Bean> list = new ArrayList<>();
//        while (resources.hasNext()) {
//            Resource child = resources.next();
//            ValueMap valueMap = child.getValueMap();
//            String field = valueMap.get("field", String.class);
//            Bean bean = new Bean(field);
//            list.add(bean);
//        }
//        return list;
//    }
//
////    public List<ListBean> getComposite() {
////        Resource resource1 = resource.getChild("composite");
////
////        Iterator<Resource> resources = resource1.listChildren();
////        List<ListBean> list = new ArrayList<>();
////        while (resources.hasNext()) {
////           Resource child =  resources.next();
////           ValueMap valueMap = child.getValueMap();
////         String author =  valueMap.get("author", String.class);
////          String designation =  valueMap.get("designation", String.class);
////
////            ListBean listBean = new ListBean(author, designation);
////
////            list.add(listBean);
////    }
////             return list;
////    }
//
//}
