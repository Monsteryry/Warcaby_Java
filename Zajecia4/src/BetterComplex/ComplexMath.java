package BetterComplex;

public class ComplexMath
{
    private ComplexMath() {}

    public static Complex add(Complex<? extends Number> c1, Complex<? extends Number> c2)
    {
       var real1 = c1.getReal();
       var real2 = c2.getReal();
       var imag1 = c1.getImaginary();
       var imag2 = c2.getImaginary();

       if ( real1 instanceof Double || real2 instanceof Double )
       {
           return new Complex<Double>(real1.doubleValue() + real2.doubleValue(),imag1.doubleValue() + imag2.doubleValue());
       }
       else if ( real1 instanceof Float || real2 instanceof Float )
       {
            return new Complex<Float>(real1.floatValue() + real2.floatValue(),imag1.floatValue() + imag2.floatValue());
        }
       else if ( real1 instanceof Long  || real2 instanceof Long )
       {
           return new Complex<Long>(real1.longValue() + real2.longValue(),imag1.longValue() + imag2.longValue());
       }
       else
       {
           return new Complex<Integer>(real1.intValue() + real2.intValue(), imag1.intValue() + imag2.intValue());
       }

       // A dlaczego bez shorta i byte'a?
        /*
        short x = 1;
        short y = 2;
        short z = x + y;  // błąd! - operator + zwraca int'a

        byte m = 1;
        byte n = 2;
        byte o = m + n;  // błąd! - operator + zwraca int'a
        */
    }

}
