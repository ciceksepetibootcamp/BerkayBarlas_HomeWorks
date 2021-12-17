import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class restAssuredTest {

    final static String loginData = "{\"email\":\"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
    @Test
    public void loginSuccessfully() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("token"),"QpwL5tke4Pnpja7X4");
    }

    final static String updateData = "{\"name\":\"UpdatedName\",\"job\": \"resident\"}";
    @Test
    public void putSuccessfully() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(updateData)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("name"),"UpdatedName");
        Assert.assertEquals(response.jsonPath().getString("job"),"resident");
    }

    @Test
    public void deleteSuccessfully() {
        Response response = given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(),204);
    }

    @Test
    public void singleResource() {
        when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .body("data.name",equalTo("fuchsia rose"));
    }

    @Test
    public void listResource() {
        when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .body("per_page", equalTo(6));
    }
}
