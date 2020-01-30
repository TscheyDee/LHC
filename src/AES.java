import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES extends CryptogrpahyManagement {

    private static SecretKeySpec secretKey;

    public AES() {
    }

    public static void setKey(String inputKey) {
        try {
            byte[] key = inputKey.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception var4) {
            System.out.println("error: " + var4.getMessage());
        }

    }

    public String encrypt(String string, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(string.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception var3) {
            System.out.println("error: " + var3.getMessage());
            return null;
        }
    }

    public String decrypt(String string, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(2, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(string)));
        } catch (Exception var3) {
            System.out.println("error: " + var3.getMessage());
            return null;
        }
    }
}
