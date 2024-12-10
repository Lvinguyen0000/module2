package part2.structuralDesignPattern.fileAdapter;

import java.io.File;

public class FileCalculatorAdapter implements FileCalculator {

    @Override
    public long calculateSize(String path) {
        File file = new File(path);
        return file.length();
    }
}
