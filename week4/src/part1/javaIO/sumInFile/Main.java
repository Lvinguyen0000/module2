package part1.javaIO.sumInFile;

public class Main {
    public static void main(String[] args) {
        String path = "src\\part1\\javaIO\\sumInFile\\text.txt";
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
