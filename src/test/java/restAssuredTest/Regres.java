package restAssuredTest;


import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.path.json.JsonPath;
import org.asynchttpclient.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Regres {


    /*
    given() --(precondition)
    when() --Action
    then()

    Q/A -- What is Serialization?
    Converting Java object into Json obect. we use Jackson-Databind dependency to convert java to json

    What is Deserialization?
    Converting Json Response to Java Object


     */



    @Test
    public void listUsers(){
      given()  // pre-condition
                .baseUri("https://reqres.in")
                .queryParam("page",2)
                .when()
                .get("/api/users")
                .then()
       //           .log()
       //             .all()
                .assertThat()
                .statusCode(200)
                .extract().response();

      /*
      We have to parse the data after extracting...
      For data parsing tool(break the code) i use is called JsonPath. JsonPath is a class from restassured
       */

        JsonPath js = res.jsonPath(); //JsonPAth will break/parse the response

        String number = js.getString("page");
        //Assert.assertEquals(2,number );
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(number, 2);

        String total = js.getString("total");
        soft.assertEquals(total, 11);

        System.out.println("Ending of soft assert");
        //soft.assertAll();

    }


    @Test
    public void createUsingJsonFile(){
        given()      // pre-condition
                .baseUri("https://reqres.in")
                .when()
            .body(new File("/Users/sumaiar122/IdeaProjects/Selenium_Batch-6-cucumber/src/main/resources/reqresPayload.json"))
                .post("/api/users") ///Action means ( I am hitting send button and getting response)
                .then()
                .log().body()
                .assertThat()
                .statusCode(201);
    }

    public void createUsingHashMap(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "morpheus");
        user.put("job", "leader");



        given()      // pre-condition
                .baseUri("https://reqres.in")
                .when()
                .body(user)
              //  .body(new File("/Users/sumaiar122/IdeaProjects/Selenium_Batch-6-cucumber/src/main/resources/reqresPayload.json"))
                .post("/api/users") ///Action means ( I am hitting send button and getting response)
                .then()
                .log().body()
                .assertThat()
                .statusCode(201);
    }

}
