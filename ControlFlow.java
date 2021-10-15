public class ControlFlow {
    public static void main(String[] args) {
        PlantCalendar pc = new PlantCalendar(5);
        // System.out.println(pc.isBusinessHours(5, 19));
        // System.out.println(pc.getDayNumber(288-1));
        //Fri
        System.out.println(pc.isBusinessHoursForAYearDay(288-1,9) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288-1,8) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288-1,17) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288-1,18) == false);
        //Sat
        System.out.println(pc.isBusinessHoursForAYearDay(288,9) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288,8) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288,17) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288,18) == false);
        //Sun
        System.out.println(pc.isBusinessHoursForAYearDay(288+1,9) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288+1,8) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288+1,17) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288+1,18) == false);
        //Mon
        System.out.println(pc.isBusinessHoursForAYearDay(288+2,9) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288+2,8) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288+2,17) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288+2,18) == false);
        //Wed
        System.out.println(pc.isBusinessHoursForAYearDay(288+4,9) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288+4,8) == false);
        System.out.println(pc.isBusinessHoursForAYearDay(288+4,17) == true);
        System.out.println(pc.isBusinessHoursForAYearDay(288+4,18) == false);

    }
}


// Mon to Sun is Day1 to Day7
class PlantCalendar {

    int janFirstDayNum;
    final int MON = 1;
    final int FRI = 5;
    final int START_HOUR = 9;
    final int END_HOUR = 17; //End time is 17:59

    public PlantCalendar(int janFirstDayNum) {
        this.janFirstDayNum = janFirstDayNum;
    }

    public boolean isBusinessHours (int dayNum, int hourNum) {
        if(dayNum >= MON && dayNum <= FRI && hourNum >= START_HOUR && hourNum <= END_HOUR)
            return true;
        return false;
    }

    public int getDayNumber (int yearDaynum) {
        return (yearDaynum % 7 + this.janFirstDayNum) % 7;
    }

    public boolean isBusinessHoursForAYearDay (int yearDayNum, int hourNum) {
        int dayNum = getDayNumber(yearDayNum);
        return isBusinessHours(dayNum, hourNum);
    }
}