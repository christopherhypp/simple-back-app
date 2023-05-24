package org.personal.che;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SimpleCheControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/people/jean/dupuy")
          .then()
             .statusCode(200)
             .body(is("jean dupuy persisted"));
    }

}