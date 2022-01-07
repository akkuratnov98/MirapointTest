package Main.ApiSuite;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static  org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.math.BigDecimal;

//import io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestRestAssured {
    //get("/lotto").then().body("lotto.lottoId", equalTo(5));

    @Test
    public void firstTest() {
        get("/lotto").then().body("lotto.lottoId", equalTo(5));
        get("/lotto").then().body("lotto.winners.winnerId", hasItems(23, 54));

        given().
                config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
                when().
                get("/price").
                then().
                body("price", is(new BigDecimal(12.12)));

    }
}
