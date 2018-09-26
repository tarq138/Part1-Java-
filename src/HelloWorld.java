import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Goal = in.nextInt();
        long u = 1;
        long x = 0;
        long[] nums = new long[10];
        int lenArr = 0;
        String Ans = "";
        while (u <= Math.abs(Goal)) {
            nums[lenArr] = u;
            u *= 2;
            lenArr++;
        }
        u = 1;
        boolean In = false;
        long Sum = 0;
        while (x != Goal) {
            if (x < Goal) {
                In = false;
                for (int i = 0; i <= lenArr; i++) {
                    if ((Sum == Math.abs(Goal - x)) && (Sum > Math.round(Math.abs(Goal) / 2))) {
                        if (Ans != "") {
                            Ans = Ans + 'R' + 'R';
                        }
                        for (int j = 1; j < (i + 1); j++) {
                            Ans = Ans + 'A';
                        }
                        x += Sum;
                        In = true;
                        Sum = 0;
                        break;
                    } else if (Sum > Math.abs(Goal - x)) {
                        Sum = 0;
                        break;
                    } else {
                        Sum += nums[i];
                    }
                }
                if (((x + u) > Goal) && (!In)) {
                    if ((x + u - Goal) > (Goal - x)) {
                        Ans = Ans + 'R' + 'R';
                        u = 1;
                    } else {
                        Ans = Ans + 'A' + 'R';
                        x += u;
                        u = -1;
                    }
                } else if (!In) {
                    x += u;
                    Ans = Ans + 'A';
                    u *= 2;
                }
            }
            if ((x > Goal) && (u > 0)) {
                Ans = Ans + 'R';
                u = -1;
            }
            if (x > Goal) {
                In = false;
                for (int i = 0; i <= lenArr; i++) {
                    if ((Sum == Math.abs(Goal - x)) && (Sum > Math.round(Math.abs(Goal) / 2))) {
                        if ((Ans != "") && (Ans.charAt(Ans.length() - 1) != 'R')) {
                            Ans = Ans + 'R' + 'R';
                        }
                        for (int j = 1; j < (i + 1); j++) {
                            Ans = Ans + 'A';
                        }
                        x -= Sum;
                        In = true;
                        Sum = 0;
                        break;
                    } else if (Sum > Math.abs(Goal - x)) {
                        Sum = 0;
                        break;
                    } else {
                        Sum += nums[i];
                    }
                }
                if (((x + u) < Goal) && (!In)) {
                    if ((x + u - Goal) < (Goal - x)) {
                        Ans = Ans + 'R' + 'R';
                        u = -1;
                    } else {
                        Ans = Ans + ('A' + 'R');
                        x += u;
                        u = 1;
                    }
                } else if (!In) {
                    x += u;
                    Ans = Ans + 'A';
                    u *= 2;
                }
            }
        }
        System.out.println(Ans.length());
    }
}
