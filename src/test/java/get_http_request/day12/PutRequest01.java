package get_http_request.day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import pojos.test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderBaseUrl {
    /*
https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde

{
"userId": 22,
"title": "Wash the dishes",
"completed": false
}
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"userId": 22, //21 di gicikligina 22 yaptim
"title": "Wash the dishes",
"completed": false,
"id": 198
}
*/

    @Test
    public  void test(){
       // 1)url olustur
        spec04.pathParams("bir","todos","iki","198");
        //2)expected data
        JsonPlaceHolderTestData testObje=new JsonPlaceHolderTestData();
        JSONObject expectedRequest=testObje.setUpPutData();
        System.out.println("expectedRequest"+expectedRequest);
        //3) request response
        Response response=given().contentType(ContentType.JSON).spec(spec04).body(expectedRequest.toString())
                .when().put("/{bir}/{iki}");
        response.prettyPrint();
        //Dogrulama

        //1)JSON PATH
        JsonPath json= response.jsonPath();
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedRequest.getInt("userId"), json.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"),json.getString("Wash the dishes"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"),json.getBoolean("completed"));

        //de serialization
        HashMap<String, Object> actuaalData = response.as(HashMap.class);

        Assert.assertEquals(expectedRequest.get("completed"), actuaalData.get("completed"));
        Assert.assertEquals(expectedRequest.get("title"), actuaalData.get("title"));
        Assert.assertEquals(expectedRequest.get("userId"), actuaalData.get("userId"));
        //MATCHERS CLASS

    }
}
