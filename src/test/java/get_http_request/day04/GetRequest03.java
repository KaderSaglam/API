package get_http_request.day04;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequest03 {
    /*
  https://restful-booker.herokuapp.com/booking/7 url'ine
GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Mark"
ve lastname'in "Jackson"
ve checkin date'in  "2016-03-11",
ve checkout date'in "2020-02-29" oldugunu test edin
   */
    @Test
    public void test03(){
        String url="https://restful-booker.herokuapp.com/booking/7";

        Response response=given().when().get(url);
        response.prettyPrint();
     //   response.then().contentType(ContentType.JSON).statusCode(200); //Alttakiyle ayni
        response.then().contentType("application/json").statusCode(200);

        response.then().body("firstname", equalTo("Mark")
                , "lastname", equalTo("Jackson")
                , "bookingdates.checkin", equalTo("2016-03-11")
                , "bookingdates.checkout", equalTo("2020-02-29"));
    }


}
