package aem.training.core.services.impl;


import aem.training.core.services.MySimpleService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;


@Component(service = MySimpleService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = MyServiceConfiguration.class)
public class MyServiceImp implements MySimpleService {


    @Override
    public String getSimpleValue() {
        return null;
    }

    @Override
    public boolean isAuthor() {
        return false;
    }
}