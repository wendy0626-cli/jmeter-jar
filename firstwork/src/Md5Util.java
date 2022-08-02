import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    public static String charSet = "utf-8";
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public Md5Util() {
    }

    public static String encrypt(String text, String charSet) {
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var5) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }

        if (charSet != null) {
            try {
                msgDigest.update(text.getBytes(charSet));
            } catch (UnsupportedEncodingException var4) {
                throw new IllegalStateException("System doesn't support your  EncodingException.");
            }
        }

        byte[] bytes = msgDigest.digest();
        return new String(encodeHex(bytes));
    }

    public static String encrypt(String text) {
        return encrypt(text, (String)null);
    }

    public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for(int var4 = 0; i < l; ++i) {
            out[var4++] = DIGITS[(240 & data[i]) >>> 4];
            out[var4++] = DIGITS[15 & data[i]];
        }

        return out;
    }

    public static String encryptPassPort(String value) {
        return value == null ? null : DigestUtils.md5Hex(value);
    }
    public  static void main(String arg[])  {

    }
}
