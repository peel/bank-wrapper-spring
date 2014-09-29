package demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class Products extends ResourceSupport {
    private final ImmutableList<Product> products;

    @JsonCreator
    public Products(@JsonProperty List<Product> products) {
        this.products = ImmutableList.copyOf(products);
    }

    public List<Product> getProducts() {
        return products;
    }
}
