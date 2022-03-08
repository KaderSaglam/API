package get_http_request.day09;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest21TestData extends JsonPlaceHolderBaseUrl {
 /*
        https://jsonplaceholder.typicode.com/todos/2
        1) Status kodunun 200,
        2) respose body'de,
         "completed": değerinin false
         "title": değerinin "quis ut nam facilis et officia qui"
         "userId" sinin 1 ve
        header değerlerinden
         "via" değerinin "1.1 vegur" ve
         "Server" değerinin "cloudflare" olduğunu test edin…
*/

    @Test
    public  void test21(){
        //url olustur
        spec04.pathParams("1","todos","2",2);
        //2)expected data olustur
        JsonPlaceHolderTestData expectedDataObje =new JsonPlaceHolderTestData();
     HashMap<String, Object> expectedData = (HashMap<String, Object>) expectedDataObje.setupTestData();
        System.out.println("Test datanin icindeki Expected Data "+ expectedData);
        //Request ve Response
        Response response= given().spec(spec04).when().get("/{1}/{2}");
        response.prettyPrint();
        //Dogrulama

        //1.yol --- Matchers Class
        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode"));

        //Dogrulma 2) Json
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"), json.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"), json.getString("title"));
        Assert.assertEquals(expectedData.get("completed"), json.getBoolean("completed"));

        //Dogrulma 3) De-serialization
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("ACTUAL DATA: " + actualData);

        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));




    }
}
