package get_http_request.day06;

import base_url.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest13 extends GMIBankBaseUrl {
    //http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
    //    “firstName”: “Della”,
    //    “lastName”: “Heaney”,
    //    “mobilePhoneNumber”: “123-456-7893”,
    //    “address”: “75164 McClure Stream”,
    //    “country” : “USA”
    //    “state”: “New York43"
    //    “CREDIT_CARD”,hesabında 69700$ ,
    //    “CHECKING” hesabında 11190$

    @Test
    public void test13(){
        spec03.pathParams("bir","tp-customers","iki","114351");

        Response response = given()
                .spec(spec03)
                .header("Authorization","Bearer " + generateToken()).when().get("/{bir}/{iki}");

        response.prettyPrint();
        //Matchers class ile

        response.then().assertThat().body("firstName",equalTo("Della"),
                "lastName", equalTo("Heaney"),
                "mobilePhoneNumber", equalTo("123-456-7893"),
                "address", equalTo("75164 McClure Stream"),
                "country.name", equalTo("USA"),
                "state", equalTo("New York43"),
                "accounts.balance[0]", equalTo(69700),
                "accounts.balance[1]", equalTo(11190));

        //json path ile dogrula
        JsonPath json = response.jsonPath();
        Assert.assertEquals("Della", json.getString("firstName"));
        Assert.assertEquals("Heaney", json.getString("lastName"));
        Assert.assertEquals("123-456-7893", json.getString("mobilePhoneNumber"));
        Assert.assertEquals("75164 McClure Stream", json.getString("address"));
        Assert.assertEquals("USA", json.getString("country.name"));
        Assert.assertEquals("New York43", json.getString("state"));
        Assert.assertEquals(11190, json.getInt("accounts[0].balance"));
        Assert.assertEquals(69700, json.getInt("accounts[1].balance"));
    }
}
