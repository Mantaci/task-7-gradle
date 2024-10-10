package endpoints;

import io.restassured.response.Response;
import schema.ProductObj;

public class ProductsApi extends BasicApi {

    public ProductsApi(String token) {super(token);}

    public Response getProducts() {
        return getBuilder()
                .get(Urls.PRODUCTS);
    }

    public Response getProductWithoutAuth() {
        return getBuilderWithoutAuth().
                get(Urls.PRODUCTS);
    }

    public Response addProduct(String productName, String category, double price, double discount ) {
        return getBuilder().body(new ProductObj(productName, category, price, discount)).post(Urls.PRODUCTS);
    }

    public Response addProductWithoutAuth(String productName, String category, double price, double discount ) {
        return getBuilderWithoutAuth().body(new ProductObj(productName, category, price, discount)).post(Urls.PRODUCTS);
    }



}
