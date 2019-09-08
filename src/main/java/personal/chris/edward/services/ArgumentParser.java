package personal.chris.edward.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.chris.edward.Messages;

/***
 * Service for parsing arguments supplied to Edward and determining methods required
 */
@Service
public class ArgumentParser {

    private final Help help;
    private final Encoder encoder;
    private final Decoder decoder;


    @Autowired
    public ArgumentParser(Help help, Encoder encoder, Decoder decoder) {
        this.help = help;
        this.encoder = encoder;
        this.decoder = decoder;
    }

    /***
     * Parses the supplied arguments and acts as required.
     * @param args The arguments with which Edward was called
     */
    public void parseArgs(String[] args) {
        if (args == null || args.length == 0) { // Must supply at least 1 arg
            throw new IllegalArgumentException(Messages.NO_ARGS);
        }
        if (args[0].matches("help|-h|-H")) {
            help.getHelp();
            return;
        }
        if (args[0].equals("encode")) {
            validateEncode(args);
        } else if (args[0].equals("decode")) {
            validateDecode(args);
        } else { // First arg must be for help, encode or decode
            throw new IllegalArgumentException(Messages.INCORRECT_ARGS);
        }
    }

    private void validateEncode(String[] args) {
        if (args.length != 3 && args.length != 5) {
            throw new IllegalArgumentException(Messages.INCORRECT_ARGS);
        }
        if (!args[1].equals("-f")) {
            throw new IllegalArgumentException(Messages.MUST_SUPPLY_FILE_FOR_ENCODE);
        }
        if (args.length == 3) {
            // No output file specified, write out to input file less "edward"
            String writePath = args[2] + ".edward"; // Write out to example.png.edward
            encoder.encodeFileToFile(args[2], writePath);
        } else {
            validateEncodeWithFileSpecified(args);
        }
    }

    private void validateEncodeWithFileSpecified(String[] args) {
        if (!args[3].equals("-o")) {
            throw new IllegalArgumentException(Messages.INCORRECT_ARGS);
        }
        encoder.encodeFileToFile(args[2], args[4]);
    }

    private void validateDecode(String[] args) {
        if (args.length != 3 && args.length != 5) {
            throw new IllegalArgumentException(Messages.INCORRECT_ARGS);
        }
        if (!args[1].equals("-f")) {
            throw new IllegalArgumentException(Messages.MUST_SUPPLY_FILE_FOR_DECODE);
        }
        if (args.length == 3) {
            // No output file specified, write out to input file less "edward"
            String writePath = args[2].substring(0, (args[2].length()-7));
            decoder.decodeFileToFile(args[2], writePath);
        } else {
            validateDecodeWithFileSpecified(args);
        }
    }

    private void validateDecodeWithFileSpecified(String[] args) {
        if (!args[3].equals("-o")) {
            throw new IllegalArgumentException(Messages.INCORRECT_ARGS);
        }
        decoder.decodeFileToFile(args[2], args[4]);
    }

}
