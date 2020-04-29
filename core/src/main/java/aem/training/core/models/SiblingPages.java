package aem.training.core.models;

        import com.day.cq.wcm.api.Page;
        import org.apache.sling.api.resource.Resource;
        import org.apache.sling.api.resource.ResourceResolver;
        import org.apache.sling.api.resource.ValueMap;
        import org.apache.sling.models.annotations.Model;
        import org.apache.sling.models.annotations.injectorspecific.SlingObject;
        import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

@Model(adaptables = Resource.class)

public class SiblingPages {
//    @SlingObject
//    private Resource resource;

    @ValueMapValue
    private String linkURL;

    @SlingObject
    private ResourceResolver resourceResolver;

    public List<Page> getSiblings() {

        List<Page> list = new ArrayList<>();

//        ValueMap valueMap = resource.getValueMap();
//        String linkURL = valueMap.get("linkURL", String.class);
        Resource linkURLresource = resourceResolver.getResource(linkURL);
        if (linkURLresource != null) {
            Page page = linkURLresource.adaptTo(Page.class);
            if (page != null) {
                Page parentpage = page.getParent();
                Iterator<Page> iterator = parentpage.listChildren();

                while (iterator.hasNext()) {
                    Page childpage = iterator.next();

                    if (!childpage.getPath().equals(page.getPath()))

                        list.add(childpage);
                }
            }
        }
        return list;
    }
}
