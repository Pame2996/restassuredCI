package basicRestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class BasicRestAssured {
    @Test
    void crearProyecto(){
        given()
                .auth()
                .preemptive()
                .basic("pamela.neyra2996@gmail.com", "Todoly2026.")
                .body("""
                        {
                            "Content": "RestAssured",
                            "Icon": 5
                        }
                        """)
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/projects.json");
    }

    @Test
    void crearProyectoUsandoJsonObject() {
        JSONObject payload = new JSONObject();
        payload.put("Content", "RestAssuredJsonObject2");
        payload.put("Icon", 3);

        given()
                .auth()
                .preemptive()
                .basic("pamela.neyra2996@gmail.com", "Todoly2026.")
                .body(payload.toString())
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/projects.json");

    }

    @Test
    void crearProyectoUsandoJsonFile() {

        String rutaJsonFile = getClass()
                .getClassLoader()
                .getResource("projects.json")
                .getPath();

        System.out.println("ruta: " + rutaJsonFile);

        given()
                .auth()
                .preemptive()
                .basic("pamela.neyra2996@gmail.com", "Todoly2026.")
                .body(new File(rutaJsonFile))
                .log()
                .all()
                .when()
                .post("https://todo.ly/api/projects.json");
    }

    @Test
    void crearProyectoConVerificaciones() {
        JSONObject payload = new JSONObject();
        payload.put("Content", "RestAssuredV3");
        payload.put("Icon", 6);

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
                .log().all()
                .statusCode(200)
                .body("Content", equalTo("RestAssuredV3"))
                .body("Icon", equalTo(6));

    }

    @Test
    void crearProyectoConVerificaciones2() {
        JSONObject payload = new JSONObject();
        payload.put("Content", "RestAssuredV3");
        payload.put("Icon", 6);

        Response response =
                given()
                        .auth()
                        .preemptive()
                        .basic("api.rest.setiembre2026@jbgroup.com", "admin123")
                        .body(payload.toString())
                        .log()
                        .all()
                        .when()
                        .post("https://todo.ly/api/projects.json")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("Id",greaterThan(0))
                        .body("Content", equalTo("RestAssuredV3"))
                        .body("Icon", equalTo(6))
                        .time(lessThan(5000L))
                        .extract().response();

        int id = response.jsonPath().getInt("Id");
        String content = response.jsonPath().getString("Content");
        int icon = response.jsonPath().getInt("Icon");

        System.out.println("Id: " + id);
        System.out.println("Content: " + content);
        System.out.println("Icon: " + icon);
    }
}
