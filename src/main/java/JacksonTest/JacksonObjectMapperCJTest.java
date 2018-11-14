package JacksonTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.URLEncoder;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ws.wamp.jawampa.WampSerialization.Json;

public class JacksonObjectMapperCJTest {
    private static String URL_CHAT_API_REST = "http://10.88.10.154/";
    private static final int HTTP_GET = 0;
    private static final int HTTP_POST = 1;

    public static void main (String [] args) throws UnsupportedEncodingException {
//        String url = URL_CHAT_API_REST+"api/chat-history-for-admin/"+2+"/";
        String url = URL_CHAT_API_REST+"api/chat-history-for-admin/";

        //Map<String, Object> list = convertJsonToMapFromUrl(url, HTTP_GET, true);
        //System.out.println(list);
        String target = "���ƿ�";
        try {
            detectCharset(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("utf-8 -> euc-kr        : " + new String(target.getBytes("utf-8"), "euc-kr"));
        System.out.println("euc-kr -> utf-8         : " + new String(target.getBytes("euc-kr"), "utf-8"));
        System.out.println("utf-8 -> euc-kr        : " + new String(target.getBytes("utf-8"), "euc-kr"));
        System.out.println("utf-8 -> ksc5601       : " + new String(target.getBytes("utf-8"), "ksc5601"));
        System.out.println("utf-8 -> x-windows-949 : " + new String(target.getBytes("utf-8"), "x-windows-949"));
        System.out.println("utf-8 -> iso-8859-1    : " + new String(target.getBytes("utf-8"), "iso-8859-1"));
        System.out.println("iso-8859-1 -> euc-kr        : " + new String(target.getBytes("iso-8859-1"), "euc-kr"));
        System.out.println("iso-8859-1 -> ksc5601       : " + new String(target.getBytes("iso-8859-1"), "ksc5601"));
        System.out.println("iso-8859-1 -> x-windows-949 : " + new String(target.getBytes("iso-8859-1"), "x-windows-949"));
        System.out.println("iso-8859-1 -> utf-8         : " + new String(target.getBytes("iso-8859-1"), "utf-8"));
        System.out.println("euc-kr -> utf-8         : " + new String(target.getBytes("euc-kr"), "utf-8"));
        System.out.println("euc-kr -> ksc5601       : " + new String(target.getBytes("euc-kr"), "ksc5601"));
        System.out.println("euc-kr -> x-windows-949 : " + new String(target.getBytes("euc-kr"), "x-windows-949"));
        System.out.println("euc-kr -> iso-8859-1    : " + new String(target.getBytes("euc-kr"), "iso-8859-1"));
        System.out.println("ksc5601 -> euc-kr        : " + new String(target.getBytes("ksc5601"), "euc-kr"));
        System.out.println("ksc5601 -> utf-8         : " + new String(target.getBytes("ksc5601"), "utf-8"));
        System.out.println("ksc5601 -> x-windows-949 : " + new String(target.getBytes("ksc5601"), "x-windows-949"));
        System.out.println("ksc5601 -> iso-8859-1    : " + new String(target.getBytes("ksc5601"), "iso-8859-1"));
        System.out.println("x-windows-949 -> euc-kr     : " + new String(target.getBytes("x-windows-949"), "euc-kr"));
        System.out.println("x-windows-949 -> utf-8      : " + new String(target.getBytes("x-windows-949"), "utf-8"));
        System.out.println("x-windows-949 -> ksc5601    : " + new String(target.getBytes("x-windows-949"), "ksc5601"));
        System.out.println("x-windows-949 -> iso-8859-1 : " + new String(target.getBytes("x-windows-949"), "iso-8859-1"));


        byte [] tt = target.getBytes("UTF-8");
        System.out.println(new String(tt,"UTF-8"));

        String helloString = "안녕하세요. ㄱㄴㄷㄹㅁㅂㅆㅢ 놟쐛씗쀍";
        System.out.println("Source : " + helloString);

// String 을 euc-kr 로 인코딩.
        byte[] euckrStringBuffer = helloString.getBytes(Charset.forName("euc-kr"));
        System.out.println();

        System.out.println("euc-kr - length : " + euckrStringBuffer.length);
        String decodedFromEucKr = new String(euckrStringBuffer, "euc-kr");
        System.out.println("String from euc-kr : " + decodedFromEucKr);

// String 을 utf-8 로 인코딩.

        byte[] utf8StringBuffer = decodedFromEucKr.getBytes("utf-8");

        System.out.println();
        System.out.println("utf-8 - length : " + utf8StringBuffer.length);
        String decodedFromUtf8 = new String(utf8StringBuffer, "utf-8");
        System.out.println("String from utf-8 : " + decodedFromUtf8);

    }

    @SuppressWarnings("deprecation")
    static private Map<String, Object> convertJsonToMapFromUrl (String url, int method, boolean isarray)
    {
        Map<String, Object> map = null;
        try {
            String result = null;
            URI uri = sanitizeUrl(url);
            HttpClient client = new DefaultHttpClient();
            ResponseHandler<String> rh = new BasicResponseHandler();
            HttpUriRequest req = null;
            ObjectMapper mapper = new ObjectMapper();
            switch (method)
            {
                case HTTP_GET :
                    req = new HttpGet(uri);
                    break;
                case HTTP_POST :
                    req = new HttpPost(uri);
                    break;
            }
            result = client.execute(req, rh);
            System.out.println(result);

            if (isarray) {
                // array 가 포함될 경우, 미리 data 구조를 분석한 JsonContainer 클래스로 array 를 받아왔습니다 김혜선@네오플랜즈
                ObjectMapper objectMapper = new ObjectMapper();
                JsonContainer jc = objectMapper.readValue(result, JsonContainer.class);
                System.out.println("Employee Object\n"+jc);
                List<HashMap<String, String>> dataList = jc.getData();
                for(int i=0;i<dataList.size();i++) {
                    result += dataList.get(i)+",";
                }
                result = "{"+result.substring(36,result.length()-1)+"}";
            }
            map = new HashMap<String, Object>();
            map = mapper.readValue(result, new TypeReference<Map<String, Object>>(){});
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    static private URI sanitizeUrl(String sanitizeURL) throws ProtocolException {

        URI uri = null;

        try {
            URL url = new URL(URLDecoder.decode(sanitizeURL, "UTF-8"));
            uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        } catch (URISyntaxException | MalformedURLException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return uri;
    }

    public static void detectCharset(String text) throws Exception {
        String encode = "";
        String [] charsets = {"UTF-8","EUC-KR","ISO-8859-1", "CP1251", "KSC5601"};

        for ( String charset: charsets ) {
            encode = URLEncoder.encode(text, charset);
            System.out.println("origin["+text+"], "+"encoded["+encode+"], charset["+charset+"]" );
        }

        String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};

        for (int i=0; i<charSet.length; i++) {
            for (int j=0; j<charSet.length; j++) {
                try {
                    System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " + new String(text.getBytes(charSet[i]), charSet[j]));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
