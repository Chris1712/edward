package personal.chris.edward;

import org.springframework.stereotype.Service;

@Service
public class Help {

    public void getHelp() {
        System.out.println("Edward is a tool for encoding and decoding files to base64 strings");
        System.out.println("To encode a file use 'edward encode -f myFile");
        System.out.println("To decode a file try 'edward decode -f myFile.edward");
        System.exit(0);
    }
}
