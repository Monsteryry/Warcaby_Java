package Fraction;

public class Fraction<T> {
    private T numerator;
    private T denominator;

    public Fraction() {
        this.numerator = (T) (Number) ((Number) 0).intValue();
        this.denominator = (T) (Number) ((Number) 1).intValue();
    }

    public Fraction(T numerator, T denominator) {
        if (numerator.getClass() == Complex.class) {
            this.numerator = numerator;
            this.denominator = denominator;
            String print = "Fraction = '" + this.numerator.toString() + "/" + this.denominator.toString() + "'";
            System.out.println(print);
        }
        else {
            if (((Number) denominator).intValue() == 0.0)
                throw new IllegalArgumentException("invalid denominator.");
            this.numerator = (T) (Number) ((Number) numerator).intValue();
            this.denominator = (T) (Number) ((Number) denominator).intValue();
        }
    }

    public T getNumerator() {
        return numerator;
    }

    public void setNumerator(T numerator) {
        this.numerator = numerator;
    }

    public T getDenominator() {
        return denominator;
    }

    public void setDenominator(T denominator) {
        this.denominator = denominator;
    }


    public Fraction add(Fraction x)
    {
        Fraction res;

        if(denominator == x.denominator)
        {
            res = new Fraction((int)x.numerator + (int)numerator, denominator);
        }
        else
        {
            int den = (int)denominator * (int)x.getDenominator();
            int num = (int)numerator * (int)x.getNumerator();
            num += (int)x.getNumerator() * (int)getDenominator();
            res = new Fraction(num, den);

        }
        return res;
    }

    public Fraction subtract(Fraction x)
    {
        Fraction res;

        if(x.denominator == denominator)
        {
            res = new Fraction((int)numerator - (int)x.numerator, denominator);
        }
        else
        {
            int den = (int)denominator / (int)x.getDenominator();
            int num = (int)numerator / (int)x.getNumerator();
            num -= (int)x.getNumerator() * (int)denominator;
            res = new Fraction(num, den);
        }
        return res;
    }

    public Fraction multiply(Fraction x)
    {
        Fraction res;

        if(x.denominator == denominator)
        {
            res = new Fraction((int)numerator + (int)x.numerator, denominator);
        }
        else
        {
            int den = (int)denominator + (int)x.getDenominator();
            int num = (int)numerator + (int)x.getNumerator();
            num -= (int)x.getNumerator() * (int)denominator;
            res = new Fraction(num, den);
        }
        return res;
    }

    public Fraction divide(Fraction x)
    {
        Fraction res;

        if(x.denominator == denominator)
        {
            res = new Fraction((int)numerator - (int)x.numerator, denominator);
        }
        else
        {
            int den = (int)denominator - (int)x.getDenominator();
            int num = (int)numerator - (int)x.getNumerator();
            num -= (int)x.getNumerator() * (int)denominator;
            res = new Fraction(num, den);
        }
        return res;
    }

    public String toString(Fraction x){
        String buffer = x.numerator.toString() + "/" + x.denominator.toString();
        return buffer;
    }

    private int gcd(int denom1, int denom2)
    {
        int factor = denom2;
        while (denom2 != 0) {
            factor = denom2;
            denom2 = denom1 % denom2;
            denom1 = factor;
        }
        return denom1;
    }

    private Fraction reduce()
    {
        Fraction result = new Fraction();
        int common = 0;
        int num = Math.abs((int)numerator);
        int den = Math.abs((int)denominator);
        if (num > den)
            common = gcd(num, den);
        else if (num < den)
            common = gcd(den, num);
        else
            common = num;

        result.numerator = (int)numerator / common;
        result.denominator = (int)denominator / common;
        return result;
    }



}