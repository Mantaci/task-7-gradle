package endpoints;

import io.restassured.response.Response;
import schema.AddProductInCartObj;

public class CartApi extends BasicApi {


    public CartApi(String token) {
        super(token);
    }

    public Response getProductCart() {
        return getBuilder().get(Urls.CART);
    }

    public Response getProductCartWithoutAuth() {
        return getBuilderWithoutAuth().get(Urls.CART);
    }

    public Response addProductToCart(int id, int quantity) {
        return getBuilder().body(new AddProductInCartObj(id, quantity)).post(Urls.CART);
    }

    public Response addProductToCartWithoutAuth(int id, int quantity) {
        return getBuilderWithoutAuth().body(new AddProductInCartObj(id, quantity)).post(Urls.CART);
    }

    public Response deleteProductFromCart(int id) {
        return getBuilder().delete(Urls.CART + "/" + String.valueOf(id));
    }
    public Response deleteProductFromCartWithoutAuth(int id) {
        return getBuilderWithoutAuth().delete(Urls.CART + "/" + String.valueOf(id));
    }

}
