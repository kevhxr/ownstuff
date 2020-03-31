package algorithms;

public class toBinary {

    public static void main(String[] args) {
        //toBin(21);
        solution("1001");



    }

    public static void toBin(int a) {
        int mark = 1;
        int count = 0;
        while (mark != 0) {
            if ((a & mark) != 0) {
                count++;
            }
            mark = mark << 1;
            System.out.println(mark);
        }
        System.out.println(count);
    }

    public static int solution(String s){
        if(s.equals("0")){
            return 0;
        }
        if(s.equals("1")){
            return 1;
        }
        int len = s.length();
        int sum = 0;
        while(s.length()>1 && Integer.parseInt(s)!=1){
            if(Integer.parseInt(s.substring(len-1)) ==0){
                len --;
                s = s.substring(0,len);
            }else{
                s= s.substring(0,len-1)+"0";
            }
            sum++;
        }
        System.out.println(sum+1);
        return sum+1;
    }
}
