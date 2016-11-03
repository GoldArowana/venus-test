package cn.com.mx.simpletest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GMTtime {
	
	public static void testDayTime(TimeZone timeZone){
        
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
        System.out.println("Time Zone is " + timeZone.getDisplayName() + " " + timeZone.getID());
       
        Calendar start = Calendar.getInstance(timeZone);
        start.setTime(new Date(0));//UTC 1970-01-01
       
        System.out.println("start=" + fmt.format(start.getTime()));
       
        long end = Calendar.getInstance(timeZone).getTimeInMillis();//current time
       
        boolean find = false;
        for(long i = start.getTimeInMillis(); i < end; i= start.getTimeInMillis() ){
             start.add(Calendar.DATE, 1); //add one day
            
             if((start.getTimeInMillis() - i)%(24*3600*1000L) != 0){
                 find = true;
                  System.out.println("from " + fmt.format(new Date(i)) +
                            "to " + fmt.format(start.getTime()) +
                            " has " + (start.getTimeInMillis() - i) + "ms" +
                            "[" + (start.getTimeInMillis() - i)/(3600*1000L) + "hours]");
             }
        }
        if(!find){
            System.out.println("Every day is ok.");
        }
   }
  
   public static void main(String argv[] ) throws Exception{
       
        TimeZone timeZone1 = TimeZone.getDefault();
        GMTtime.testDayTime(timeZone1);
        
        System.out.println("----------------------------------------------------------------");
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+08"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT+08");
        //System.err.println(timeZone.toString());
        GMTtime.testDayTime(timeZone);
       
        System.out.println("----------------------------------------------------------------");
       
        
        timeZone = TimeZone.getTimeZone("GMT");
       // System.err.println(timeZone.toString());
        GMTtime.testDayTime(timeZone);
   }

}
