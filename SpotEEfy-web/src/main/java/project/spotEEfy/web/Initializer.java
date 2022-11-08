package project.spotEEfy.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import project.spotEEfy.core.config.AppConfig;
import project.spotEEfy.core.config.DBConfig;
import project.spotEEfy.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, DBConfig.class, WebConfig.class};
        //TODO: WTF the webConf is not recognize
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/web/"};
    }
}
