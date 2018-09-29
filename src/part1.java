import java.util.*;
import java.util.Scanner;

public class part1 {
    private static TreeSet<String> visited = new TreeSet<String>();
    private static TreeMap< Integer, Integer > ans = new TreeMap< Integer, Integer >();
    private static TreeSet<String> q = new TreeSet<String>();
    public static void main(String[] args) {
        int MAX_SIZE = 1000;
        ans.put(0, 0);
        q.add(Integer.toString(0) + " " + Integer.toString(0) + " " +Integer.toString(1));
        visited.add(Integer.toString(0) + " " +Integer.toString(1));
        while (!q.isEmpty()){
            String[] qq = q.first().split(" ");
            int d = Integer.parseInt(qq[0]);
            int p = Integer.parseInt(qq[1]);
            int v = Integer.parseInt(qq[2]);
            q.remove(q.first());

            if ((Math.abs(p+v) <= MAX_SIZE) && (Math.abs(2*v)<=MAX_SIZE)){
                if (visited.add(Integer.toString(p+v) + " " +Integer.toString(2*v))) {
                    if ((ans.get(p + v) == null) || (ans.get(p + v) > d + 1)) {
                        ans.put(p + v, d + 1);
                    }
                    q.add(Integer.toString(d + 1) + " " + Integer.toString(p + v) + " " + Integer.toString(2 * v));
                }
            }
            int dd = (v > 0 ? -1:1);
            if ((Math.abs(p+dd) <= MAX_SIZE)){
                if (visited.add(Integer.toString(p+dd) + " " +Integer.toString(2*dd))) {
                    if ((ans.get(p + dd) == null) || (ans.get(p + dd) > d + 2)) {
                        ans.put(p + dd, d + 2);
                    }
                    q.add(Integer.toString(d + 2) + " " + Integer.toString(p + dd) + " " + Integer.toString(2 * dd));
                }
            }
            if ((Math.abs(p-dd) <= MAX_SIZE)){
                if (visited.add(Integer.toString(p-dd) + " " +Integer.toString(-2*dd))) {
                    if ((ans.get(p - dd) == null) || (ans.get(p - dd) > d + 3)) {
                        ans.put(p - dd, d + 3);
                    }
                    q.add(Integer.toString(d + 3) + " " + Integer.toString(p - dd) + " " + Integer.toString(-2 * dd));
                }
            }
        }
        Scanner in = new Scanner(System.in);
        int Goal = in.nextInt();
        System.out.println(ans.get(Goal));
    }
}


