package app.streamAPI;

public class StaticTests {

    private static String privateStaticString;
    public static String publicStaticString;
    public static String publicStaticStringValue = "static string";
    public String publicStringValue = "non static string";
    public String publicNonStaticString;

    public StaticTests() {
    }

    public void nonStaticMethod(String s){
        System.out.println("niestatyczny param: "+ s);
        System.out.println("niestatyczny privateStaticString: "+privateStaticString);
        System.out.println("niestatyczny publicStaticString: "+publicStaticString);
        System.out.println("niestatyczny publicStaticStringValue: "+publicStaticStringValue);
    }

    public static void staticMethod(String s){
        System.out.println("statyczny param: "+ s);
        System.out.println("statyczny privateStaticString: "+privateStaticString);
        System.out.println("statyczny publicStaticString: "+publicStaticString);
        System.out.println("statyczny publicStaticStringValue: "+publicStaticStringValue);
    }

    public String getPrivateStaticStringByNonStatic() {
        return privateStaticString;
    }

    public void setPrivateStaticStringByNonStatic(String privateStaticString) {
        StaticTests.privateStaticString = privateStaticString;
    }

    public static String getPrivateStaticString() {
        return privateStaticString;
    }

    public static void setPrivateStaticString(String privateStaticString) {
        StaticTests.privateStaticString = privateStaticString;
    }

    public static String getPublicStaticString() {
        return publicStaticString;
    }

    public static void setPublicStaticString(String publicStaticString) {
        StaticTests.publicStaticString = publicStaticString;
    }

    public static String getPublicStaticStringValue() {
        return publicStaticStringValue;
    }

    public static void setPublicStaticStringValue(String publicStaticStringValue) {
        StaticTests.publicStaticStringValue = publicStaticStringValue;
    }

    public String getPublicStringValue() {
        return publicStringValue;
    }

    public void setPublicStringValue(String publicStringValue) {
        this.publicStringValue = publicStringValue;
    }

    public String getPublicNonStaticString() {
        return publicNonStaticString;
    }

    public void setPublicNonStaticString(String publicNonStaticString) {
        this.publicNonStaticString = publicNonStaticString;
    }
}
