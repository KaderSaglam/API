package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String, Object> setupTestData(){



     HashMap<String, Object> expectedData= new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("completed", false);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("via","1.1 vegur");
        expectedData.put("userId",1);
        expectedData.put("Server","cloudflare");


        return expectedData;
    }
}
