package aem.training.core.services.impl;

import aem.training.core.services.TestService;
import com.day.cq.tagging.Tag;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component( service = TestService.class, immediate = true)
public class TestServiceImpl implements TestService {

    public List<Page> getPageList(Page page) {
        List<Page> list = new ArrayList<>();

        if (page != null) {
            Iterator<Page> iterator = page.listChildren();
            while (iterator.hasNext()) {
                Page childPage = iterator.next();
                list.add(childPage);
            }
        }
        return list;
    }

    public String getPath(ResourceResolver resourceResolver, String path) {
        Resource internalResource = resourceResolver.getResource(path);
        if (internalResource != null && internalResource.isResourceType("cq:Page")) {
            return path + ".html";
        } else {
            return path;
        }
    }

    public List<Tag> getChildTags(Tag tag) {
        List<Tag> list = new ArrayList<>();
        if (tag != null) {
            Iterator<Tag> iterator = tag.listChildren();
            while (iterator.hasNext()) {
                Tag childTag = iterator.next();
                list.add(childTag);
            }
        }
        return list;
    }
}
