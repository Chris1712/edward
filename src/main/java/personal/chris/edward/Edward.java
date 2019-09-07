package personal.chris.edward;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Configuration
@ComponentScan
public class Edward {

//    public static void main(String[] args) throws IOException {
//        ArgumentParser argumentParser = new ArgumentParser();
//        argumentParser.parseArgs(args);
//
//
//        Path readPath = Paths.get(args[1]);
//
//        if (args[0].equals("-e")) {
//            byte[] fileBytes = Files.readAllBytes(readPath);
//            String fileString = Base64.getEncoder().encodeToString(fileBytes);
//            String writePath = args[1] + ".edward"; // Write out to example.png.edward
//            BufferedWriter writer = new BufferedWriter(new FileWriter(writePath));
//            writer.write(fileString);
//            writer.close();
//        } else if (args[0].equals("-d")) {
//            String writePath = args[1].substring(0, args[1].length()-7);
//            String fileContent = new String(Files.readAllBytes(readPath));
//            byte[] fileBytes = Base64.getDecoder().decode(fileContent);
//            try (FileOutputStream stream = new FileOutputStream(writePath)) {
//                stream.write(fileBytes);
//            }
//        }
//    }

    public static void main(String[] args) {
        // todo - catch exceptions and report message
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Edward.class);
        ArgumentParser parser = applicationContext.getBean(ArgumentParser.class);
        parser.parseArgs(args);
    }


}
