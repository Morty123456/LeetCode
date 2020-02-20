package BroadView;
public class ex5_replaceBlank {
    public static void main(String[] args){
        String s = "we are friend";
//        String[] array = s.split(" ");
//        String  result = "";
//        for (String str : array)
//            result = result + str + "%20";
////        result = result.substring(0, result.length()-3);
//        System.out.println(result);
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch==' ')
                result.append("%20");
            else{
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
}
