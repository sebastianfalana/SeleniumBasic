package homework_SeleniumBasic;

import org.testng.annotations.Test;
import java.util.Random;

public class RandomString {

    public String generateString(int len) {
        String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        String name = new String();

        for (int i = 0; i < len; i++) {
            name = name + randomString.charAt(rnd.nextInt(randomString.length()));
        }
        return name;
    }
}
