package get_http_request.day13;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends HerOkuAppBaseUrl {
    /*
 https://restful-booker.herokuapp.com/booking
 request body
 { "firstname": "Ali",
            "lastname": "Can",
            "totalprice": 500,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2022-03-01",
                "checkout": "2022-03-11"
             }
 }}
Status code is 200
 response body
 {
    "bookingid": 11,
       "booking": {
         "firstname": "Ali",
         "lastname": "Can",
         "totalprice": 500,
         "depositpaid": true,
         "bookingdates": {
            "checkin": "2022-03-01",
            "checkout": "2022-03-11"
                             }
                         }
                     }
  */

    @Test
    public void test(){

        spec05.pathParams("1","booking");

        BookingDatesPojo bookingdates = new BookingDatesPojo("2022-03-01","2022-03-11");

        BookingPojo booking = new BookingPojo("Ali","Can",500,true,bookingdates);

        // BookingResponsePojo bookingResponse= new BookingResponsePojo(11, booking);

        Response rs = given().contentType(ContentType.JSON).spec(spec05).auth().basic("admin","password123")
                .body(booking).when().post("/{1}");
        rs.prettyPeek();
    }

}
