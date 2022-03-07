package get_http_request.day05;

import base_url.RegresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest07 extends RegresinBaseUrl {
    /*
https://reqres.in/api/users URL request olustur.
body icerisindeki idsi 5 olan datayi
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/
  @Test
    public void test07(){
      spec01.pathParams("paremetre1","api","paremetre2","users");


     // https://reqres.in
      Response response=given().spec(spec01).when().get("/{paremetre1}/{paremetre2}");
      // "/{parametre1}/{parametre2}" -> /api/users


      //matchers class
      response.prettyPrint();
      response.then().assertThat().body("data[4].email", equalTo("charles.morris@reqres.in")
      ,"data[4].first_name",equalTo("Charles")
              ,"data[4].last_name",equalTo("Morris")
              ,"data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg")
      );


      //JsonPath
      JsonPath json = response.jsonPath();
      System.out.println(json.getList("data.email"));
      System.out.println(json.getString("data.first_name"));
      System.out.println(json.getString("data.last_name"));

      assertEquals("charles.morris@reqres.in", json.getString("data[4].email"));
      assertEquals("Charles", json.getString("data[4].first_name"));
      assertEquals("Morris", json.getString("data[4].last_name"));

  }
}
