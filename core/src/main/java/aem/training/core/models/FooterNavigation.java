package aem.training.core.models;

import aem.training.core.pojo.Pojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class)
public class FooterNavigation {

//    @ValueMapValue
//    String image;
//
//    @ValueMapValue
//    String text;
//
//            public String getImage(){
//                return image;
//    }
//
//    public String getName(){
//
//        return "Shubam";
//    }

/*    @Inject
    private Resource foothermultilist;

        public List<Pojo> getMultifield() {

            Iterator<Resource> iterator = foothermultilist.listChildren();

            List<Pojo> list = new ArrayList();

            while (iterator.hasNext()) {
                Resource item = iterator.next();
                ValueMap valueMap = item.getValueMap();
                String image = valueMap.get("image", String.class);
                String titles = valueMap.get("titles", String.class);

                Pojo pojo = new Pojo(image, titles);

                list.add(pojo);

            }
            return list;
}*/
}
