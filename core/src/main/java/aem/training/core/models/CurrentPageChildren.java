package aem.training.core.models;


import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class)

public class CurrentPageChildren {


    @ScriptVariable(name="currentPage")
    Page page;

    @SlingObject
    private ResourceResolver resourceResolver;

    public List<Page> getCurrentPageChildren() {
       Iterator<Page> iterator = page.listChildren();

        List<Page> list = new ArrayList<>();

       while (iterator.hasNext()) {
          Page childpage = iterator.next();

          list.add(childpage);
       }
       return list;

    }
}
