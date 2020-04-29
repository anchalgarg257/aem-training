package aem.training.core.models;

import aem.training.core.pojo.Author;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class)
public class ImageModel {

    @SlingObject
    private Resource resource;

    public String getPath() {
        ValueMap valueMap = resource.getValueMap();
       String linkURL = valueMap.get("linkURL", String.class);
       return linkURL;
    }

    public String getText() {
        ValueMap valueMap = resource.getValueMap();
        String text = valueMap.get("text", String.class);
        return text;
    }

    public List<String> getSingleMultifield() {
       Resource fieldresource = resource.getChild("field");
      Iterator<Resource> iterator = fieldresource.listChildren();

      List<String> list = new ArrayList();

      while (iterator.hasNext()) {
         Resource item = iterator.next();
         ValueMap valueMap = item.getValueMap();
        String field = valueMap.get("field", String.class);

        list.add(field);

      }
      return list;
    }
       public List<Author> getComposite() {
       Resource compositeresource = resource.getChild("composite");
         Iterator<Resource>  iterator = compositeresource.listChildren();
         List<Author> list = new ArrayList<>();
         while (iterator.hasNext()) {
           Resource items =  iterator.next();
          ValueMap valueMap = items.getValueMap();
          String author = valueMap.get("author", String.class);
          String designation = valueMap.get("designation", String.class);
          String description = valueMap.get("description", String.class);
          String fblink = valueMap.get("fblink", String.class);
          Author author1 = new Author(author, designation, description, fblink);
          list.add(author1);

         }
         return list;
       }
}
