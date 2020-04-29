package aem.training.core.services.impl;

import aem.training.core.services.GenericService;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;


@Component( service = GenericService.class,immediate = true, property = {
        "type=" + "Shivani"
} )
public class GenericServiceImpl implements GenericService {
    @Override
    public String getName()
    {
        return "Shivani";
    }
}
