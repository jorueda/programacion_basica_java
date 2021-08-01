// Casting o casteo
public class App {
    public static void main(String[] args) {
        
        int i = 100;
        long l = i;
        float f = l;

        System.out.println("Valor int " + i);
        System.out.println("Valor Long " + l);
        System.out.println("Valor float " + f);

        char ch = '@';
        int num = 8;
        num = ch;

        System.out.println("Valor " + num);

        double d = 100.678;

        long lo = (long)d;
        int j = (int)lo;

        System.out.println("Valor double " + d);
        System.out.println("Valor long " + lo);
        System.out.println("Valor int " + j);

        double d1 = 1000000;
        short s = (short)d1;

        System.out.println("Valor short " + s);

        byte b;
        int k = 128;
        double d2 = 323.142;

        b = (byte)k;
        System.out.println("Valor byte " + b);

        b = (byte)d2;
        System.out.println("Valor byte " + b);

    }
}
