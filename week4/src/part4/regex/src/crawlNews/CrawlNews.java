package crawlNews;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try{
            URL url = new URL(" http://dantri.com.vn/the-gioi.htm ");

            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("^<body>\\s\\b</body>");
//            String text = sc.next();
            while(sc.hasNext()){
                System.out.println(sc.next());
            }
            sc.close();

//            text = text.replaceAll("\\n", "&lt;");
//            Pattern pattern = Pattern.compile("&lt;");
//            Matcher matcher = pattern.matcher(text);
//            while(matcher.find()){
//                System.out.println(matcher.group());
//            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
