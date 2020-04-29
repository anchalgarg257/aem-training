package aem.training.core.models;

import aem.training.core.pojo.Pojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Multi {

    @SlingObject
    private Resource foothermultilist;

    public List<Pojo> getMultifield() {

        Iterator<Resource> iterator = foothermultilist.listChildren();

        List<Pojo> list = new ArrayList();

        while (iterator.hasNext()) {
            Resource item = iterator.next();
            ValueMap valueMap = item.getValueMap();
            String image = valueMap.get("image", String.class);
            String title = valueMap.get("title", String.class);

            Pojo pojo = new Pojo(image, title);

            list.add(pojo);
        }
        return list;
    }
}