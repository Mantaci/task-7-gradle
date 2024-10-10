package assertions;

import io.restassured.common.mapper.TypeRef;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import schema.ProductObj;

import java.util.List;

public class ProductAssert extends AbstractAssert<ProductAssert, Response> {


    protected ProductAssert(Response actual) {
        super(actual, ProductAssert.class);
    }

    public static ProductAssert assertThat(Response actual) {
        return new ProductAssert(actual);
    }

    public ProductAssert checkProductResponseBody() {

        actual.then().extract().body().as(new TypeRef<List<ProductObj>>() {});
        return this;
    }
}
