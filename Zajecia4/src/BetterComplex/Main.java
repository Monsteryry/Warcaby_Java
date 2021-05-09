package BetterComplex;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException {
        Complex<Integer> a = new Complex<Integer>(1, 2);
        Complex<Float> b = new Complex<Float>(3.0f, 4.5f);

        // Zabezpieczyliśmy się przed Complex'em, który przechowuje wartości pól w typie innym, niż pochodny od Number
        // Complex<String> c = new Complex<String>("1.0", "1.0");

        Complex res = ComplexMathSimple.add(a, b);

        System.out.println("Wartość zmiennej res: " + res.toString());
        System.out.println("Typ zmiennej res: " + res.getClass());
        System.out.println("Typ pól w zmiennej res: " + res.getReal().getClass());

        Complex c = ComplexMath.add(a, b);

        System.out.println("Wartość c: " + c.toString());
        System.out.println("Typ zmiennej c: " + c.getClass());
        System.out.println("Typ pól w zmiennej c: " + c.getReal().getClass());



    }
}