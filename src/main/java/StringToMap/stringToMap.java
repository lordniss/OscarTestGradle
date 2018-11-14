/**
 * https://www.mkyong.com/java/how-to-convert-java-map-to-from-json-jackson/
 */
package StringToMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stringToMap {
    public static void main(String[] agrs) throws IOException {
        String param = "{\"channel\":\"11111\",\"info\":\"someInfo\",\"name\":\"anormaly\"}";
        try {


            String json =param;

            Map<String, Object> map = new HashMap<String, Object>();

            // convert JSON string to Map
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

            map.put("channel","new");
            System.out.println(map);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {///test
            e.printStackTrace();
        } catch (IOException e) {//
            e.printStackTrace();
        }
    }

}
