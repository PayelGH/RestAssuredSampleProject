import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AllTestCases {
    @Test
    public void TC001(){
        baseURI= "http://localhost:8080/";

       given()
               .get("app/videogames").
       then()
               .statusCode(200)
               .log().all();
    }
    @Test
    public void TC002(){

        JSONObject obj1= new JSONObject();
        obj1.put("id", "12");
        obj1.put("name", "BAZOOKA");
        obj1.put("releaseDate", "2021-06-30T02:27:13.470Z");
        obj1.put("reviewScore", "08");
        obj1.put("category", "Monopoly");
        obj1.put("rating", "Universal");

        baseURI= "http://localhost:8080/";

        given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj1.toJSONString()).
        when()
                .post("app/videogames").
        then()
                .statusCode(200)  //normally this should be 201
                .log().all(); //click on TC001 to check if the record is created
    }
    @Test
    public void TC003(){
        baseURI= "http://localhost:8080/";

        given()
                .get("app/videogames/3").
                then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TC004(){
        JSONObject obj2= new JSONObject();
        obj2.put("id", "14");
        obj2.put("name", "Mummy Run");
        obj2.put("releaseDate", "2021-06-12T02:27:13.470Z");
        obj2.put("reviewScore", 10);
        obj2.put("category", "Scavenger Hunt");
        obj2.put("rating", "PG 13");

        baseURI= "http://localhost:8080/";
        given()
                .header("content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj2.toJSONString()).
        when()
                .post("app/videogames").
        then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TC005(){
        JSONObject obj3= new JSONObject();
        obj3.put("id", "15");
        obj3.put("name", "A Quiet Place");
        obj3.put("releaseDate", "2021-06-15T02:27:13.470Z");
        obj3.put("reviewScore", 5);
        obj3.put("category", "Zombie Escape");
        obj3.put("rating", "PG 13");

        baseURI= "http://localhost:8080/";
        given()
                .header("content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj3.toJSONString()).
        when()
                .post("app/videogames").
        then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TC006(){
        JSONObject obj4 = new JSONObject();
        obj4.put("id", "15");
        obj4.put("name", "Caravan");
        obj4.put("releaseDate", "2021-06-15T02:27:13.470Z");
        obj4.put("reviewScore", 7);
        obj4.put("category", "Zombie Escape");
        obj4.put("rating", "PG 13");

        baseURI="http://localhost:8080/";
        given()
                .header("content-type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj4.toJSONString()).
        when()
                .put("app/videogames/15").
        then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void TC007(){
        baseURI= "http://localhost:8080/";
       given().
        when().delete("app/videogames/4").
        then()
               .statusCode(200)
               .log().all();
    }
    @Test
    public void TC008(){
        baseURI= "http://localhost:8080/";

        given()
                .get("app/vidogames").
        then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TC009(){
        JSONObject obj5= new JSONObject();
        obj5.put("id", "Jackal");
        obj5.put("name", 166);
        obj5.put("releaseDate", "2021-06-15T02:27:13.470Z");
        obj5.put("reviewScore", 5);
        obj5.put("category", "Zombie Escape");
        obj5.put("rating", "PG 13");

        baseURI= "http://localhost:8080/";
        given()
                .header("content-type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(obj5.toJSONString()).
       when()
                .post("app/videogames").
      then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void TC010(){
        baseURI= "http://localhost:8080/";
        given().
                when().delete("app/videogames/55554567890456789034567890-4567890-").
         then()
                .statusCode(200)
                .log().all();
    }
}

