package co.com.sofka.util.functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    private final String USER_DIR = System.getProperty("user.dir");
    private final String TEST_PATH = "\\src\\test";

    private String pathFromContentRoot;

    public FileReader(String pathFromContentRoot) {
        this.pathFromContentRoot = pathFromContentRoot;
    }

    public String readContent() throws IOException {

        String content = new String(
                Files.readAllBytes(
                        Paths.get(USER_DIR + TEST_PATH + pathFromContentRoot)));
        return content;
    }
}
