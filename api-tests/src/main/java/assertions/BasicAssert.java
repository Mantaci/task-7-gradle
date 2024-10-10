    package assertions;

    import io.restassured.internal.common.assertion.Assertion;
    import io.restassured.response.Response;
    import org.assertj.core.api.AbstractAssert;
    import org.assertj.core.api.Assertions;

    public class BasicAssert extends AbstractAssert<BasicAssert, Response> {


        protected BasicAssert(Response actual) {
            super(actual, BasicAssert.class);
        }

        public static BasicAssert assertThat(Response actual) {
            return new BasicAssert(actual);
        }

        public BasicAssert isStatusEqual(int status) {
            Assertions.assertThat(actual.getStatusCode()).isEqualTo(status);

            return this;
        }

        public BasicAssert hasField(String path) {
            Assertions.assertThat(actual.jsonPath().getString(path))
                    .as("Поле" + path + "не найдено")
                    .isNotNull();
            return this;
        }

        public BasicAssert fieldIsEqualTo(String path, String value) {
            Assertions.assertThat(actual.jsonPath().getString(path))
                    .as("Поле" + path + "не равно" + value)
                    .isEqualTo(value);
            return this;
        }

        public BasicAssert fieldIsEqualTo(String path, int value) {
            Assertions.assertThat(actual.jsonPath().getString(path))
                    .as("Поле" + path + "не равно" + value)
                    .isEqualTo(value);
            return this;
        }




    }
