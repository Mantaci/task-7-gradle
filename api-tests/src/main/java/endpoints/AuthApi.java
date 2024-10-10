package endpoints;

import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import schema.RegLogUserObj;
import utility.RestApiBuilder;
import utility.UIProps;

public class AuthApi {

    static UIProps props = ConfigFactory.create(UIProps.class);

    public static Response regUser(String login, String password){
        return new RestApiBuilder(props.baseURI()).build().body(new RegLogUserObj(login, password)).post(Urls.REGISTER);
    }
    public static Response logUser(String login, String password){
     return new RestApiBuilder(props.baseURI()).build().body(new RegLogUserObj(login, password)).post(Urls.LOGIN);
    }

    public static String getToken(String login, String password){
        return logUser(login, password).then().extract().body().jsonPath().getString("access_token");
    }
}
