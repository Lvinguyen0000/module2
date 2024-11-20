package validateClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameExample {
    private Pattern pattern;
    private Matcher matcher;

    private final String CLASS_NAME = "[ABC]\\d{4}[GHIK]";

    public ClassNameExample(){
        pattern = Pattern.compile(CLASS_NAME);
    }

    public boolean validateClassName(String name){
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
