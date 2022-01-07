package Main.ApiSuite;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

//import io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestRestAssured {
    //get("/lotto").then().body("lotto.lottoId", equalTo(5));

    @Test
    public void firstTest() {
        get("/lotto").then().body("lotto.lottoId", equalTo(5));

        given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("/price").
                then().
                body("price", is(new BigDecimal(12.12));

    }
}
