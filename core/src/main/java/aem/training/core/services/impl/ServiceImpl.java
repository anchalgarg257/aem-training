package aem.training.core.services.impl;

import aem.training.core.services.GenericService;
import org.osgi.service.component.annotations.Component;

@Component( service = GenericService.class,immediate = true, property = {
        "type=" + "Anchal"} )

public class ServiceImpl implements GenericService {
    @Override
    public String getName()
    {
        return "Anchal";
    }
}
