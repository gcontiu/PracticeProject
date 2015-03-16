package hello;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * See http://spring.io/guides/gs/producing-web-service/ <p>

 Spring WS uses a different servlet type for handling SOAP messages:
 MessageDispatcherServlet. It is important to inject and set ApplicationContext to MessageDispatcherServlet.<br>
 Without that, Spring WS will not detect Spring beans automatically.<p>

 By naming this bean messageDispatcherServlet, it does not replace Spring Boot’s default DispatcherServlet bean.

 DefaultMethodEndpointAdapter configures annotation driven Spring WS programming model.<br>
 This makes it possible to use the various annotations like @Endpoint mentioned earlier.<p>

 DefaultWsdl11Definition exposes a standard WSDL 1.1 using XsdSchema <p>

 It’s important to notice that you need to specify bean names for MessageDispatcherServlet and DefaultWsdl11Definition.<br>
 Bean names determine the URL under which web service and the generated WSDL file is available.<br>
 In this case, the WSDL will be available under http://<host>:<port>/ws/countries.wsdl.

 */
@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /*  COUNTRIES */

    @Bean(name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/generated");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
    }

    /* CONTINENTS */

    @Bean(name = "continents")
    public DefaultWsdl11Definition continentsWsdlDefinition(XsdSchema continentsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ContinentsPort");
        wsdl11Definition.setLocationUri("/ws/continents");
        wsdl11Definition.setTargetNamespace("http://spring.io/generated");
        wsdl11Definition.setSchema(continentsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema continentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("continents.xsd"));
    }
}
