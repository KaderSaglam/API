package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    protected RequestSpecification spec02; //interface oldugu icin dogrudan obje olusturamiyouz
    @Before
    public void setUp(){

        spec02 =new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();

    }
}
