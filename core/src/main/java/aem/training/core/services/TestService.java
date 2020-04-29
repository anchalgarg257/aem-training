package aem.training.core.services;

import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.List;

public interface TestService {
    public List<Page> getPageList(Page page);

    public String getPath(ResourceResolver resourceResolver,String path);

    public List<Tag> getChildTags(Tag tag);
}
