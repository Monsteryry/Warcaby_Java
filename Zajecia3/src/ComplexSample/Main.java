package ComplexSample;

public class Main
{
    public static void main(String[] args)
    {
        ComplexInt a = new ComplexInt(1, 2);
        ComplexInt b = new ComplexInt(3,  4);

        System.out.println(a.toString());

        a.add(b);
        System.out.println(a.toString());
        a.subtract(b);
        System.out.println(a.toString());
        a.multiply(b);
        System.out.println(a.toString());
        a.divide(b);
        System.out.println(a.toString());

        System.out.println();

        Complex<Integer> x = new Complex<Integer>(1, 2);
        Complex<Float> y = new Complex<Float>(3.0f, 4.0f);

        System.out.println( "x -> " + x.printTypes() );
        System.out.println( "y -> " + y.printTypes() );
        x.add(y);
        System.out.println(x.toString());
        System.out.println("x -> " + x.printTypes() );

        Complex<String> z = new Complex<String>(); //Chyba tego nie chcemy...

        ComplexInteger q = new ComplexInteger(1,2);
        ComplexFloat w = new ComplexFloat(3.0f, 4.0f);

        System.out.println();

        System.out.println( "q -> " + q.printTypes() );
        System.out.println( "w -> " + w.printTypes() );
        q.add(w);
        System.out.println(q.toString());
        System.out.println("q -> " + q.printTypes() );


    }
}
