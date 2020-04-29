package aem.training.core.models;

import aem.training.core.services.GenericService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = Resource.class)
public class TstModel {

    @OSGiService
    GenericService genericService;
    public String getName()
    {
       return genericService.getName();
    }

}
