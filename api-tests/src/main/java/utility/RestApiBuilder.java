package utility;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class RestApiBuilder {
    private final RequestSpecification spec;

    public RestApiBuilder(String baseUrl) {
        spec = given().baseUri(baseUrl)
                .config(RestAssured
                        .config()
                        .httpClient(HttpClientConfig
                                .httpClientConfig()
                                .setParam("http.connection.timeout", 3000)
                        )
                )
                .contentType("application/json")
                .accept("application/json")
                .relaxedHTTPSValidation()
                .filters(new ResponseLoggingFilter(System.out), new RequestLoggingFilter(System.out));

    }

    public RequestSpecification build() {return spec;}

    public RestApiBuilder addAuth (String token)
    {
        spec.header("Authorization", "Bearer " + token);
        return this;
    }

    public RestApiBuilder AddHeader (String key, String value){
        spec.header(key, value);
        return this;
    }

}
