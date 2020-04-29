package aem.training.core.models;

        import aem.training.core.pojo.ListBean;
        import org.apache.sling.api.resource.Resource;
        import org.apache.sling.api.resource.ValueMap;
        import org.apache.sling.models.annotations.Model;
        import org.apache.sling.models.annotations.injectorspecific.SlingObject;

        import javax.annotation.Resource;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

@Model(adaptables = Resource.class)

public class Multifield {
    @SlingObject
    private Resource resource;

    public List<ListBean> getMulti() {
        Resource resource1 = resource.getChild("multifield");
        List<ListBean> list = new ArrayList<>();
        if (resource1 != null) {
            Iterator<Resource> resources = resource1.listChildren();

            while (resources.hasNext()) {
                Resource child = resources.next();
                ValueMap valueMap = child.getValueMap();
                String author = valueMap.get("author", String.class);
                String dateofbirth = valueMap.get("dateofbirth", String.class);
                String description = valueMap.get("description", String.class);
                String fblink = valueMap.get("fblink", String.class);
                ListBean listBean = new ListBean(author, dateofbirth, description, fblink);
                list.add(listBean);
            }
        }

        return list;
    }
}