package aem.training.core.models;

import aem.training.core.services.TestService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Component;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class InternalandExternal {

    @ValueMapValue
    String path;

    @SlingObject
    ResourceResolver resourceResolver;
    @OSGiService
    TestService testService;

    public String getPath() {
        return testService.getPath(resourceResolver, path);
    }
}
