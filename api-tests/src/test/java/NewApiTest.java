import assertions.BasicAssert;
import assertions.CartAssert;
import assertions.ProductAssert;
import endpoints.AuthApi;
import endpoints.CartApi;
import endpoints.ProductsApi;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import schema.ProductObj;

import java.util.List;

public class NewApiTest {

    ProductsApi productsApi;
    CartApi cartApi;

    @BeforeEach
    public void setUp() {
        String token = AuthApi.getToken("NewUser", "123123");
        System.out.println(token);
        productsApi = new ProductsApi(token);
        cartApi = new CartApi(token);
    }

    @Test
    public void loginTest() {
        Response response = AuthApi.logUser("NewUser", "123123");
        BasicAssert.assertThat(response)
                .isStatusEqual(200);
    }

    @Test
    public void wrongLoginTest() {
        Response response = AuthApi.logUser("WrongUser", "123123");
        BasicAssert.assertThat(response)
                .isStatusEqual(401);
    }

    @Test
    public void getProductsTest() {
        Response response = productsApi.getProducts();
        BasicAssert.assertThat(response)
                .isStatusEqual(200);
        ProductAssert.assertThat(response)
                .checkProductResponseBody();
    }

    @Test
    public void getCartTest() {
        //cartApi.addProductToCart(1, 10);
        Response response = cartApi.getProductCart();
        BasicAssert.assertThat(response)
                .isStatusEqual(200);
        CartAssert.assertThat(response)
                .checkCartResponseBody();
    }
}
