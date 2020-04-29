package aem.training.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.List;

@Model(adaptables = Resource.class)
public class InternalAndExternalLink {

    @SlingObject
    private Resource resource;
    @SlingObject
    private ResourceResolver resourceResolver;

    public String getInternalLink() {
        ValueMap valueMap = resource.getValueMap();
        String linkURL = valueMap.get("linkURL", String.class);
             Resource internalresource =  resourceResolver.getResource(linkURL);
             if (internalresource==null) {
                 return linkURL;
             }
             else {
                 return linkURL+".html";
             }

    }
}
