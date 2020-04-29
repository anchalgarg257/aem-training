package aem.training.core.models;

import aem.training.core.services.TestService;
import com.day.cq.tagging.Tag;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class)
public class ChildTags {
    @ValueMapValue
    String path;

    @SlingObject
    ResourceResolver resourceResolver;


    @OSGiService
    TestService testService;

    public List<Tag> getChildTags() {
        List<Tag> list = new ArrayList<>();
        if (path != null && path != "") {
            Resource resource = resourceResolver.getResource("path");
            if (resource != null && resource.isResourceType("cq:Tag")) {
                Tag tag = resource.adaptTo(Tag.class);
            }
        }
        return list;
    }
}
