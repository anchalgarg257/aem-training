package aem.training.core.models;

import aem.training.core.pojo.NestedMultifield;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.*;

@Model(adaptables = Resource.class)
public class FooterModel {

    @SlingObject
    private Resource resource;

    public Map<String, List<NestedMultifield>> getFooterLinks() {

        Map<String, List<NestedMultifield>> map = new HashMap<>();

        Resource footerResource = resource.getChild("footermultilist");
        if (footerResource != null) {
            Iterator<Resource> iterator = footerResource.listChildren();

            while (iterator.hasNext()) {
                Resource childResource = iterator.next();
                String titles = childResource.getValueMap().get("titles", String.class);
                map.put(titles, getList(childResource));
            }
        }
        return map;
    }

    public List<NestedMultifield> getList(Resource childResource) {
        Resource footerNavigationResource = childResource.getChild("footernavigation");

        List<NestedMultifield> list = new ArrayList<>();

        if (footerNavigationResource != null) {
            Iterator<Resource> iterator = footerNavigationResource.listChildren();

            while (iterator.hasNext()) {
                Resource itemResource = iterator.next();
                ValueMap valueMap = itemResource.getValueMap();

                String path = valueMap.get("path", String.class);
                String title = valueMap.get("title", String.class);
                String innewtab = valueMap.get("innewtab", String.class);

                NestedMultifield nestedMultifield = new NestedMultifield(path, title, innewtab);

                list.add(nestedMultifield);
            }
        }
        return list;
    }
}