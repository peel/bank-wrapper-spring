package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ProductsConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("demo.wsdl");
        return marshaller;
    }

    @Bean
    public ProductsClient weatherClient(Jaxb2Marshaller marshaller) {
        ProductsClient client = new ProductsClient();
        client.setDefaultUri("http://wsf.cdyne.com/ProductsWS/Weather.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
