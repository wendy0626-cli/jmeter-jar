public class Test0727 {
    public static void main (String[] args) {
        
        String parameter = "jack的SHA256加密jar包";

        String res = new SHA256().Encrypt(parameter,"");
        System.out.println(res);
        System.out.println("SHA256加密" + res);

        String parameter01 = "jack的HMACSHA256加密jar包";

        String res_01 = new HMACSHA256().sha256_HMAC(parameter01,"abc" );
        System.out.println(res_01);
        System.out.println("HMACSHA256加密" + res_01);
    
        }
}
