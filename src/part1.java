import java.util.*;
import java.util.Scanner;

public class part1 {
    private static TreeSet<String> visited = new TreeSet<String>();
    private static TreeMap< Integer, Integer > ans = new TreeMap< Integer, Integer >();
    //private static TreeSet<String> q = new TreeSet<String>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Goal = in.nextInt();
        int MAX_SIZE = 3*Goal;
        ans.put(0, 0);
        //ans.put(20,12);
        //q.add(Integer.toString(0) + " " + Integer.toString(0) + " " +Integer.toString(1));
        int[][] qq;
        qq = new int[3][4000000];
        qq[0][0] = 0;
        qq[1][0] = 0;
        qq[2][0] = 1;
        int left = 0;
        int right = 1;
        visited.add(Integer.toString(0) + " " +Integer.toString(1));
        while (left != right){
            ans.put(5,7);
            int d = qq[0][left];
            int p = qq[1][left];
            int v = qq[2][left];
            left++;

            if ((Math.abs(p+v) <= MAX_SIZE) && (Math.abs(2*v)<=MAX_SIZE)){
                if (visited.add(Integer.toString(p+v) + " " +Integer.toString(2*v))) {
                    if ((ans.get(p + v) == null) || (ans.get(p + v) > d + 1)) {
                        ans.put(p + v, d + 1);
                    }
                    //q.add(Integer.toString(d + 1) + " " + Integer.toString(p + v) + " " + Integer.toString(2 * v));
                    right++;
                    qq[0][right] = d+1;
                    qq[1][right] = p+v;
                    qq[2][right] = 2*v;
                }
            }
            int dd = (v > 0 ? -1:1);
            if ((Math.abs(p+dd) <= MAX_SIZE)){
                if (visited.add(Integer.toString(p+dd) + " " +Integer.toString(2*dd))) {
                    if ((ans.get(p + dd) == null) || (ans.get(p + dd) > d + 2)) {
                        ans.put(p + dd, d + 2);
                    }
                    //q.add(Integer.toString(d + 2) + " " + Integer.toString(p + dd) + " " + Integer.toString(2 * dd));
                    right++;
                    qq[0][right] = d+2;
                    qq[1][right] = p+dd;
                    qq[2][right] = 2*dd;
                }
            }
            if ((Math.abs(p-dd) <= MAX_SIZE)){
                if (visited.add(Integer.toString(p-dd) + " " +Integer.toString(-2*dd))) {
                    if ((ans.get(p - dd) == null) || (ans.get(p - dd) > d + 3)) {
                        ans.put(p - dd, d + 3);
                    }
                    //q.add(Integer.toString(d + 3) + " " + Integer.toString(p - dd) + " " + Integer.toString(-2 * dd));
                    right++;
                    qq[0][right] = d+3;
                    qq[1][right] = p-dd;
                    qq[2][right] = -2*dd;
                }
            }
        }
        System.out.println(ans.get(Goal));
    }
}


