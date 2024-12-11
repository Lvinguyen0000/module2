package utility.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidation extends Validation{
    private static DateValidation dateValidation = null;

    private DateValidation (){}

    public static DateValidation getInstance(){
        if (dateValidation == null){
            dateValidation = new DateValidation();
        }
        return dateValidation;
    }

    public boolean validate(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Set lenient to false to strictly parse dates
        try {
            Date date = sdf.parse(inputDate);
            return inputDate.equals(sdf.format(date)); // Check if date is formatted correctly
        } catch (ParseException e) {
            return false; // Invalid date
        }
    }
}
