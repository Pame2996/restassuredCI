package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CsvProjectApi {
    @CsvFileSource(resources = "/csv/crear.csv", numLinesToSkip = 1)
    @ParameterizedTest
    void crear(String proyecto, int icono, int codigoRespuesta) {
        JSONObject payload = new JSONObject();
        payload.put("Content", proyecto);
        payload.put("Icon", icono);

        Response response =
                given()
                        .auth()
                        .preemptive()
                        .basic("pamela.neyra2996@gmail.com", "Todoly2026.")
                        .body(payload.toString())
                        .log()
                        .all()
                        .when()
                        .post("https://todo.ly/api/projects.json")
                        .then()
                        .log().ifValidationFails()
                        .statusCode(codigoRespuesta)
                        .body("Content", equalTo(proyecto))
                        .body("Icon", equalTo(icono))
                        .extract().response();

        int projectId = response.jsonPath().getInt("Id");
        System.out.println("Project ID: " + projectId);
    }
}
