package aem.training.core.models;

import aem.training.core.services.TestService;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ChildrenPages {
    @ValueMapValue
    String path;

    @SlingObject
    ResourceResolver resourceResolver;

    @OSGiService
    TestService testService;

    public List<Page> getChild() {
        List<Page> list = new ArrayList<>();
        if (path != null && path != "") {
            Resource resource = resourceResolver.getResource(path);
            if (resource != null && resource.isResourceType("cq:Page")) {
                Page page = resource.adaptTo(Page.class);
                list = testService.getPageList(page);
            }
        }
        return list;
    }
}
