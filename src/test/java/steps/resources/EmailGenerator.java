package steps.resources;
import java.util.Random;

public class EmailGenerator {

    private static String chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static Random random = new Random();

    private static StringBuilder generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb;
    }

    public static String generate(String suffix) {
        int c = random.nextInt(chars.length() / 2 + 1);
        return generateRandomString(c)
                .append(suffix)
                .toString();
    }
}
