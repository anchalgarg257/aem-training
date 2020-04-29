package aem.training.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class)
public class ImageComponent {

    @SlingObject
    private Resource resource;

    @SlingObject
    private ResourceResolver resourceResolver;

    public List<Page> getPageList() {

    List<Page> actualList = new ArrayList<>();

        ValueMap valueMap = resource.getValueMap();
        String linkURL = valueMap.get("linkURL", String.class);

        if (linkURL!=null && !linkURL.equals("")) {
            Resource linkResource = resourceResolver.getResource(linkURL);
            Page page = linkResource.adaptTo(Page.class);
            Iterator<Page> iterator = page.listChildren();

            iterator.forEachRemaining(actualList::add);
        }
        return actualList;
    }
}
