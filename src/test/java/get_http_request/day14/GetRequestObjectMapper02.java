package get_http_request.day14;

import base_url.HerOkuAppBaseUrl;
import org.junit.Test;

public class GetRequestObjectMapper02 extends HerOkuAppBaseUrl {
    /*https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
 status kodun 200 ve response body’nin
{
“firstname”: “Ali”,
“lastname”: “Can”,
“totalprice”: 500,
“depositpaid”: true,
“bookingdates”: {
“checkin”: “2022-03-01”,
“checkout”: “2022-03-11”
},
“additionalneeds”: “Breakfast”
}
Olduğunu Object Mapper kullanarak test edin

ERKAN ARI  10:15 PM*/
    @Test
    public  void test(){

        //1)url olustur
        spec05.pathParams("param1","booking","param2",40);
        //EXPECTED DATA  OLUSTUR
        String jsonData="{\n" +
                "“firstname”: “Ali”,\n" +
                "“lastname”: “Can”,\n" +
                "“totalprice”: 500,\n" +
                "“depositpaid”: true,\n" +
                "“bookingdates”: {\n" +
                "“checkin”: “2022-03-01”,\n" +
                "“checkout”: “2022-03-11”\n" +
                "},\n" +
                "“additionalneeds”: “Breakfast”\n" +
                "}";
    }
}
