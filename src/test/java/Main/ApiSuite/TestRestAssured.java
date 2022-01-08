package Main.ApiSuite;

import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.application;
import static  org.hamcrest.Matchers.*;

import Main.Pojo.PojoClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    public void secondTest() {
        given().
                when().
                get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .header("content-type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test
    public void testPojo() throws JsonProcessingException {
        PojoClass pojoClass = new PojoClass("Ivan");
        pojoClass.setJob("tester");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(pojoClass);
        String s =
        given().
                headers("Content-Type", "application/json")
                .body(jsonString)
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .statusCode(201)
                .log().all()
                .extract()
                .body().asString();
        System.out.println(s);
    }
}
