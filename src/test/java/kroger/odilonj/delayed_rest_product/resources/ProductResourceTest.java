package kroger.odilonj.delayed_rest_product.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ProductResourceTest {

    @Test
    public void shouldReturnNameAndPriceAboveZero() {
        given()
            .when()
                .get("/product/mug")
            .then()
                .statusCode(200)
                .body("name", is("mug"))
                .body("price", greaterThanOrEqualTo(0.01f));
    }

    @Test
    public void shouldReturnWithDelay() {
        given()
            .when()
                .get("/product/arabic-coffee/delayed/2")
            .then()
                .statusCode(200)
                .time(greaterThan(1999L));
    }

    @Test
    public void shouldReturnWithoutDelay() {
        given()
            .when()
                .get("/product/arabic-coffee")
            .then()
                .statusCode(200)
                .time(lessThan(200L));
    }

}
