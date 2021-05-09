package ComplexSample;

public class ComplexInt
{
    private int re;
    private int im;

    public ComplexInt()
    {
        this.re = 0;
        this.im = 0;
    }

    public ComplexInt(int re, int im)
    {
        this.im = im;
        this.re = re;
    }

    /* settery i gettery */

    public void setRe(int re)
    {
        this.re = re;
    }

    public int getRe()
    {
        return this.re;
    }

    public void setIm(int im)
    {
        this.im = im;
    }

    public int getIm()
    {
        return this.im;
    }

    /* metody publiczne */

    public double module()
    {
        return Math.sqrt( re*re + im*im );
    }

    public void add( ComplexInt complex )
    {
        this.re = complex.getRe() + this.re;
        this.im = complex.getIm() + this.im;
    }

    public void subtract( ComplexInt complex )
    {
        this.re = this.re - complex.getRe();
        this.im = this.im - complex.getIm();
    }

    public void multiply( ComplexInt complex )
    {
        int im = this.im;
        int re = this.re;

        this.re = re*complex.re - im*complex.im;
        this.im = im*complex.re + re*complex.im;
    }

    public void divide( ComplexInt complex )
    {
        int re = this.re;
        int im = this.im;

        int mianownik = complex.re*complex.re + complex.im*complex.im;

        this.re = (re*complex.re + im*complex.im) / mianownik ; // wynikiem będzie całość z dzielenia!!!
        this.im = (this.im = im*complex.re - re*complex.im) / mianownik; //wynikiem będzie całość z dzielenia!!!
    }

    @Override
    public String toString()
    {
        if ( this.im >= 0 )
        {
            return this.re + " + " + this.im + "i";
        }
        else
        {
            return this.re + " - " + Math.abs(this.im) + "i";
        }
    }
}
