public class NextDayCalculator {

    public static String nextDay(int day, int month, int year){
        switch(month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (day < 31) return ++day + "/" + month + "/" + year;
                else {
                    if (month == 12){
                        month = 1;
                        year++;
                    }
                    else month++;
                    return "1/" + month + "/" + year;
                }
            case 4: case 6: case 9: case 11:
                if (day < 30) return ++day + "/" + month + "/" + year;
                else {
                    return "1/" + ++month + "/" + year;
                }
            case 2:
                if (day < 29 && isLeapYear(year) || day < 28) return ++day + "/" + month + "/" + year;
                else if (isLeapYear(year) && day == 29 || day == 28) {
                    month++;
                    return "1/" + month + "/" + year;
                }
        }
        return "Not valid date";
    }

    private static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
