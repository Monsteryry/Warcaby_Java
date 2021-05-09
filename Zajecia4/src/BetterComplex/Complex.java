package BetterComplex;

public class Complex<T extends Number> extends Number
{
    private T real;
    private T imaginary;

    public Complex()
    {
        this.real = (T) Integer.valueOf(0);
        this.imaginary = (T) Integer.valueOf(0);
    }

    public Complex(T real, T imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    // SETTERY I GETTERY
    public void setImaginary(T imaginary)
    {
        this.imaginary = imaginary;
    }

    public Number getImaginary()
    {
        return imaginary;
    }

    public void setReal(T real)
    {
        this.real = real;
    }

    public Number getReal()
    {
        return real;
    }

    // Nadpisane METODY z klasy bazowej
    @Override
    public int intValue()
    {
        return this.real.intValue();
    }

    @Override
    public long longValue()
    {
        return this.real.longValue();
    }

    @Override
    public float floatValue()
    {
        return this.real.floatValue();
    }

    @Override
    public double doubleValue()
    {
        return this.real.doubleValue();
    }

    public String toString()
    {
        return this.real.toString() + "+" + this.imaginary.toString() + "i";
    }

    public void add(Complex compVal)
    {
        // DODANIE DO ZMIENNEJ
    }
}
