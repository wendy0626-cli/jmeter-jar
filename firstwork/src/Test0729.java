
public class Test0729 {

    public static void main(String[] args){

        new Md5Util();

        String result = Md5Util.encrypt("yyy的加密内容");

        System.out.println(result);

        String results = Md5Util.encryptPassPort("yyy的加密内容");
        System.out.println(results);

    }
    
}
