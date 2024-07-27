package com.techacademy;

import java.sql.Date;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{paradate}")
    public String dispDayOfWeek(@PathVariable String paradate) {

        // 3：手順2で取得した変数から年・月・日に分割してそれぞれの変数へ格納する。
        String year = paradate.substring(0, 4);
        String month = paradate.substring(4, 6);
        String day = paradate.substring(6, 7);
        // 4：手順3で分けた年・月・日から「何曜日か？」を判定してreturn ○○;で返却する。
        Calendar cal = Calendar.getInstance();
        //文字列を数値(int型)に変換する
        int iYear = Integer.parseInt(year);
        int iMonth = Integer.parseInt(month)-1;
        int iDay = Integer.parseInt(day);

        cal.set(iYear, iMonth, iDay);

        // 日付から曜日を取得する
        // Calendar.DAY_OF_WEEK:7 実際の値です（余り意味はない）
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
        case Calendar.SUNDAY: // Calendar.SUNDAY:1 （値。意味はない）
            return"Sunday";
            //break;
        case Calendar.MONDAY: // Calendar.MONDAY:2
            return"Monday";
           // break;
        case Calendar.TUESDAY: // Calendar.TUESDAY:3
            return"Tuesday";
           // break;
        case Calendar.WEDNESDAY: // Calendar.WEDNESDAY:4
            return"Wednesday";
          //  break;
        case Calendar.THURSDAY: // Calendar.THURSDAY:5
            return"Thursday";
          //  break;
        case Calendar.FRIDAY: // Calendar.FRIDAY:6
            return"Friday";
          //  break;
        case Calendar.SATURDAY: // Calendar.SATURDAY:7
            return"Saturday";
           // break;
        }
        return paradate;

    }
    // String→Date
    // public Static void main(String[]args) throws PareseException{
    // String strDate="20191231";
    // SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
    // Date date=dateFormat.parse(strDate);

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果：" + res;

    }
}
