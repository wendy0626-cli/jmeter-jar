// package JACK.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Jackmd5 {
    //创建一个类LMFMD5

    public String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 生成一个MD5加密计算摘要
            md.update(sourceStr.getBytes());
            // 使用指定的byte数组更新摘要
            byte b[] = md.digest();
            // 把密文转换成十六进制的字符串形式
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                i += 256;
                if (i < 16)
                buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) =" + result);
            //
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8,24));
            // 注释的是md5的16位取值
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}