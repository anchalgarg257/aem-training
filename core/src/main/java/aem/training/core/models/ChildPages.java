package aem.training.core.models;

import aem.training.core.services.GenericService;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChildPages {

//    @SlingObject
//    private Resource resource;

    @ValueMapValue (name="linkURL")
    private String pageURL;

    @SlingObject
    private ResourceResolver resourceResolver;

    @OSGiService(filter = "(type=Shivani)")
    GenericService genericService;

    public String getName() {
        return genericService.getName();
    }

    public List<Page> getChild() {
        List<Page> list = new ArrayList<>();

//        ValueMap valueMap = resource.getValueMap();
//        String linkURL = valueMap.get("linkURL", String.class);

        if (pageURL != null) {
            Resource linkURLresource = resourceResolver.getResource(pageURL);
            if (linkURLresource != null) {
                Page page = linkURLresource.adaptTo(Page.class);
                if (page != null) {
                    Iterator<Page> iterator = page.listChildren();

                    while (iterator.hasNext()) {
                        Page childpage = iterator.next();

                        list.add(childpage);
                    }
                }
            }
        }
        return list;
    }
}
