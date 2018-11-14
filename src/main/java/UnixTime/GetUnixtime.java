package UnixTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetUnixtime {
    public static void main(String[] args) {

        String time = "201811011234";
      //  System.out.println(timeConversion("20181101235959"));

        time = "20181101235959";
        System.out.println(timeConversion(time));
        convertUnixToDate(timeConversion(time)/1000);
        convertUnixToDate(Long.parseLong(time));
//        convertUnixToDate(1540825200);
 //       convertUnixToDate(1541438340);
  //      convertUnixToDate(1541438340);

    }

    static public long timeConversion(String time) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
        long unixTime = 0;
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); //Specify your timezone
        try {
            unixTime = dateFormat.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    static public void convertUnixToDate(long unix_time){
        long unix_seconds = 1372339860;
        unix_seconds = unix_time;
        //convert seconds to milliseconds
        Date date = new Date(unix_seconds*1000L);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        jdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String java_date = jdf.format(date);
        System.out.println(java_date);
    }
}

