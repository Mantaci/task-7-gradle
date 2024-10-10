package assertions;

import io.restassured.common.mapper.TypeRef;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import schema.CartObj;
import schema.ProductObj;

import java.util.List;

public class CartAssert extends AbstractAssert<CartAssert, Response> {


    protected CartAssert(Response actual) {
        super(actual, CartAssert.class);
    }

    public static CartAssert assertThat(Response actual) {
        return new CartAssert(actual);
    }

    public CartAssert checkCartResponseBody() {

        actual.then().extract().body().as(CartObj.class);
        return this;
    }
}
