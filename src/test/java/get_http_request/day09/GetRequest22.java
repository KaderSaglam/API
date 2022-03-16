package get_http_request.day09;

import base_url.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest22 extends HerOkuAppBaseUrl {
       /*
   https://restful-booker.herokuapp.com/booking/47
          {
              "firstname": "Ali",
              "lastname": "Can",
              "totalprice": 500,
              "depositpaid": true,
              "bookingdates": {
                                "checkin": "2022-02-01",
                                    "checkout": "2022-02-11"
             }
          }
   1) JsonPhat
   2) De-Serialization
   */

    @Test
    public void test22(){
        //1) URL OLUSTUR
        spec05.pathParams("first", "booking", "second", 17);

        //2) EXPECTED DATA OLUSTUR
        HerOkuAppTestData expectedObje = new HerOkuAppTestData();

        HashMap<String , Object> expectedTestDataMap = expectedObje.setUpTestData();

        System.out.println("TEST DATA iCiNDEKi EXPECTED DATA: " + expectedTestDataMap);
        // {firstname=Ali,
        // bookingdates={
        //               checkin=2022-02-01,
        //               checkout=2022-02-11},
        // totalprice=500,
        // depositpaid=true,
        // lastname=Can}
//3)REQUEST VE RESPONSE
        Response response=given().spec(spec05).when().get("/{first}/{second}");
        response.prettyPrint();
        //4) DOGRULAMA
        //1. YOL De selialization
        HashMap<String, Object> actualData=response.as(HashMap.class);
        //Json  formatindaki datayi  HASHMAPe donusturur
        System.out.println("Actual Data"+actualData);
//{
//    "firstname": "Ali",
//    "lastname": "Can",
//    "totalprice": 500,
//    "depositpaid": true,
//    "bookingdates": {
//        "checkin": "2022-02-01",
//        "checkout": "2022-02-11"}

        Assert.assertEquals(expectedTestDataMap.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedTestDataMap.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedTestDataMap.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedTestDataMap.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkin")
               ,((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkout")
                ,((Map)actualData.get("bookingdates")).get("checkout"));

        //2. Yol  JSON PATH
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedTestDataMap.get("firstname"),jsonPath.getString("firstname"));
        Assert.assertEquals(expectedTestDataMap.get("lastname"),jsonPath.getString("lastname"));
        Assert.assertEquals(expectedTestDataMap.get("totalprice"),jsonPath.getInt("totalprice"));
        Assert.assertEquals(expectedTestDataMap.get("depositpaid"),jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals(  ((Map<?, ?>) expectedTestDataMap.get("bookingdates")).get("checkin")
                ,jsonPath.getString("bookingdates.checkin") );
        Assert.assertEquals(  ((Map<?, ?>) expectedTestDataMap.get("bookingdates")).get("checkout")
                ,jsonPath.getString("bookingdates.checkout") );
    }
}