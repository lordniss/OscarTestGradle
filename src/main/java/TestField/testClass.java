package TestField;

public class testClass {
    static public void main(String[] args){
        for(int i=10-1;i>-1;i--){
            System.out.println(i);
        }

        String a =null;
        System.out.println((a==null)?"null":"notnull");
        String test = "\"stingfffff\"";
        System.out.println(test);
        test = test.substring(1,test.length()-2);
        System.out.println(test);
    }
}
