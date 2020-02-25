package salesforcemaintest;

import org.junit.Test;

import java.util.Calendar;

public class test {
    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int monthOfYear=cal.get(Calendar.MONTH);

        String dayOfMonthStr = String.valueOf(dayOfMonth);
        String monthOfYearStr = String.valueOf(monthOfYear+1);

        System.out.println(dayOfMonthStr);
        System.out.println(monthOfYearStr);
    }
}
