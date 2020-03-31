package algorithms.myinter;

public class QuesTwo {
    public static void main(String[] args) {

        solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
    }

    public static String solution(int N, String S, String T) {
        int[][] matrix = new int[N][N];
        markHit(T.split(" "),matrix);
        int[] res = getShipPos(S.split(","),matrix);
        System.out.println(res[0]+","+res[1]);
        return res[0]+","+res[1];
    }

    public static void markHit(String[] originPos, int[][] matrix) {
        for (String pos : originPos) {
            char[] arr = pos.toCharArray();
            int[] xy = new int[2];
            xy[0] = Integer.parseInt(arr[0] + "") - 1;
            xy[1] = getPos(arr[1] + "");
            matrix[Integer.parseInt(arr[0] + "") - 1][getPos(arr[1] + "")] = -1;
        }
    }


    public static int[] getShipPos(String[] shipPos, int[][] matrix) {
        int[] result = new int[2];
        int i = 0;
        while( i <= shipPos.length-1) {
            String[] ship = shipPos[i].split(" ");
            char[] start = ship[0].toCharArray();
            char[] end = ship[1].toCharArray();
            int startX = Integer.parseInt(start[0] + "") - 1;
            int startY = getPos(start[1] + "");
            int endX = Integer.parseInt(end[0] + "") - 1;
            int endY = getPos(end[1] + "");
            boolean notHit = false;
            for (int j = startX; j <=endX ; j++) {
                for (int k = startY; k <=endY ; k++) {
                    if(matrix[j][k] != -1){
                        notHit = true;
                    }else if (notHit){
                        result[1] ++;
                    }
                }
            }
            if(!notHit){
                result[0]++;
            }
            i = i+1;
        }
        return result;
    }

    public static int getPos(String alpha) {
        switch (alpha) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
        }
        return 0;
    }

}
