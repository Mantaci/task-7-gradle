package endpoints;

import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import utility.RestApiBuilder;
import utility.UIProps;

public class BasicApi {

    UIProps props = ConfigFactory.create(UIProps.class);

    protected String token;

    public BasicApi(String token) {this.token = token;}

    public RequestSpecification getBuilder() {
        return new RestApiBuilder(props.baseURI()).addAuth(token).build();
    }

    public RequestSpecification getBuilderWithoutAuth() {
        return new RestApiBuilder(props.baseURI()).build();
    }


}
