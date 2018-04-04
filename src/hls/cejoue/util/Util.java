package hls.cejoue.util;

/**
 * Created by hossiel on 07/03/2017.
 */
import hls.cejoue.service.MyMtokenDetailsService;
import hls.cejoue.service.MyUserDetailsService;

import javax.servlet.http.Cookie;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Util{
    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) formatter.parse(str_date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    public static Map<String,String> CookiestoMap(Cookie[] cookies) {
        Map<String,String> map = null ;

        if(cookies!=null){
            map = new HashMap<String,String>();
            for(Cookie cookie : cookies){
                map.put(cookie.getName(),cookie.getValue());
            }
        }

        return map;
    }

    public static boolean cookieIsValid(Cookie[] cookies,MyMtokenDetailsService myMtokenDetailsService,MyUserDetailsService userService) {
        boolean result = true;
        Map<String, String> mappedCookies = Util.CookiestoMap(cookies);
        if (mappedCookies == null) {
            return false;
        } else if (!mappedCookies.containsKey("MTOKENID")) {
            return false;
        } else if (myMtokenDetailsService.findById(mappedCookies.get("MTOKENID")) == null) {
            return false;
        } else if ((myMtokenDetailsService.findById(mappedCookies.get("MTOKENID"))).isExpired()) {
            return false;
        } else if (userService.findByUserName(myMtokenDetailsService.findById(mappedCookies.get("MTOKENID")).getUsername()) == null) {
            return false;
        } else {
            return true;

        }
    }

}