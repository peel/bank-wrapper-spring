package demo;

import com.google.common.collect.ImmutableList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class ProductsController {

    @RequestMapping(value="/products", method= RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Product> getProducts(@RequestParam(value="customerId", required=true) String customerId){
        Product product = new Product(122345L, "lokatka", "lokatka na ktorej tylko stracisz");
        Product product1 = new Product(122346L, "kredycik", "i tu cię mamy.");
        Product product2 = new Product(122347L, "kredytówka", "wiadomo. płać dużo.");
        Product product3 = new Product(122348L, "rachuneczek", "rachunek z kartą debetową, żebyś wydawał dużo pieniędzy");
        Product product4 = new Product(122349L, "powiadomionka", "powiadomienia sms");
        Product product5 = new Product(122350L, "spamletter", "przesyłamy tony emaili które i taj natychmiast wyrzucasz");
        List<Product> products = ImmutableList.<Product>of(product, product1, product2, product3, product4, product5);
        Products p = new Products(products);
        p.add(linkTo(methodOn(ProductsController.class).getProducts(customerId)).withSelfRel());
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    @RequestMapping("/weather")
    public HttpEntity<String> gerWeather(@RequestParam(value="zip", required=false, defaultValue="94304") String zip){

        ProductsClient productsClient = new ProductsClient();

        String response = productsClient.getCityForecastByZip(zip).getGetCityForecastByZIPResult().getResponseText();
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

}
