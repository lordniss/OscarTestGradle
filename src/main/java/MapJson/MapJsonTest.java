package MapJson;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapJsonTest {
    public static void main(String[] args){
        Map<String, Object> ss = new HashMap<>();
        ss.put("1","11");
        ss.put("1","112");
        ss.put("1","113");
        ss.put("10","null");
        ss.put("11",null);
        ss.put("12","");
        System.out.println(ss+"\n"+ss.getClass());

        //create LinkedHashMap object
        LinkedHashMap lHashMap = new LinkedHashMap();

        //add key value pairs to LinkedHashMap
        lHashMap.put("1","One");
        lHashMap.put("2","Two");
        lHashMap.put("3","Three");
        lHashMap.put("2","Tw1o");
        //lHashMap.remove("2");
        System.out.println(lHashMap);


    }
}
