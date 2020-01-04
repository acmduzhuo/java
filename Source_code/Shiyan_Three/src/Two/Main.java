/**
 * 
 */
package Two;

/**
 * @author dell
 *
 */
import java.util.Scanner;

public class Main {
    private int numerator1;
    private int denominator1;
    private int numerator2;
    private int denominator2;
    private int numerator3;
    private int denominator3;

    void set(int numerator1, int denominator1, int numerator2, int denominator2) {
        this.denominator1 = denominator1;
        this.denominator2 = denominator2;
        this.numerator1 = numerator1;
        this.numerator2 = numerator2;
    }

    void multiply() {
        //�˷�����
        numerator3 = numerator1 * numerator2;
        denominator3 = denominator1 * denominator2;
        output(numerator1, denominator1, numerator2,
                denominator2, numerator3, denominator3, '*');
    }

    void divided() {
        //��������
        numerator3 = numerator1 * denominator2;
        denominator3 = denominator1 * numerator2;
        output(numerator1, denominator1, numerator2,
                denominator2, numerator3, denominator3, '/');
    }

    void plus() {
        int a, b, c;
        a = denominator1;
        b = denominator2;
        //ʹ������������Լ��
        if (a == b) {
            denominator3 = a;
            numerator3 = numerator1 + numerator2;
        } else {
            while (a != b) {
                if (a > b) a = a - b;
                else b = b - a;
            }
            int t;//��С������ = t
            t = (denominator1 * denominator2) / a;
            //��С������ =�� ��ĸ1 * ��ĸ2 ��/���Լ��
            denominator3 = t;//����ķ�ĸ = ��С������
            numerator3 = ((t / denominator1)*denominator1) + ((t / denominator2)*denominator2);
        }
        output(numerator1, denominator1, numerator2,
                denominator2, numerator3, denominator3, '+');
    }

    void minus() {
        int a, b, c;
        //ʹ������������Լ��
        double p, q;
        a = denominator1;
        b = denominator2;
        if (a == b) {
            a = denominator3;
            //����ĸ��ͬʱ�������Ӧ �� - С
            if (numerator1 > numerator2) {
                numerator3 = numerator1 - numerator2;
            } else {
                numerator3 = numerator2 - numerator1;
            }
        } else {
            while (a != b) {
                if (a > b) a = a - b;
                else b = b - a;
            }
            int t;//����С������ = t
            t = (denominator1 * denominator2) / a;
            //��С������ =�� ��ĸ1 * ��ĸ2 ��/���Լ��
            denominator3 = t;
            //����ķ�ĸ = ��С������
            p = (double) numerator1 / (double) denominator1;
            q = (double) numerator2 / (double) denominator2;
            if ( p > q) {
                numerator3 = ((t / denominator1)*numerator1)- ((t / denominator2)*numerator2);
                output(numerator1, denominator1, numerator2,
                        denominator2, numerator3, denominator3, '-');
            } else {
                numerator3 = ((t / denominator2)*numerator2)- ((t / denominator1)*numerator1);
                output(numerator1, denominator1, numerator2,
                        denominator2, numerator3, -denominator3, '-');
            }
        }
    }

    public static void main(String[] arges) {
        Main a = new Main();
        Scanner in = new Scanner(System.in);
        int x, y;
        int m, n;
        System.out.println("�������һ�����ķ��Ӻͷ�ĸ :");
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("������ڶ������ķ��Ӻͷ�ĸ :");
        m = in.nextInt();
        n = in.nextInt();
        a.set(x, y, m, n);
        a.multiply();
        a.divided();
        a.plus();
        a.minus();
    }

    void output(int a, int b, int c, int d, int e, int f, char name) {
        System.out.println(a + "/" + b + " " + name + " " + c + "/" + d + "=" + e + "/" + f);
        //    a   /   b     "+ - * /"    c   /   d    =    e   /   f
    }
};