package by.bsu.lab5.entity;



import java.util.Arrays;

public class Polynom {
    private int degree;
    private double[] coefficients;
    public Polynom(int degree,double coef)
    {
        coefficients=new double[degree+1];
        coefficients[degree]=coef;
        degree=degree();

    }

    public Polynom(int degree, double[] coef) {
        this.degree = degree;
        coefficients = Arrays.copyOf(coef, degree + 1);
    }

    public Polynom() {
        this.degree = 0;
        coefficients = null;
    }

    public Polynom(Polynom second) {
        this.degree = second.degree;
        this.coefficients = Arrays.copyOf(second.coefficients, degree+1);
    }
    public int degree(){
        int d = 0;
        for( int i = 0; i < coefficients.length; i++ )
            if( coefficients[ i ] != 0 ) d = i;
        return d;
    }
    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        if (degree < 0)
            throw new IllegalArgumentException("Degree can't be negative");
        this.degree = degree;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double getCoefficientByIndex(int i)
    {
        if(i<0&&i>this.degree+1)
            throw new IllegalArgumentException("index must be in range");
        return coefficients[i];
    }
    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }
    public void setCoefficientByIndex(double coef, int i)
    {
        if(i<0&&i>this.degree+1)
            throw new IllegalArgumentException("index must be in range");
        this.coefficients[i]=coef;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==null&&obj==null)return true;
        if(this==obj)return true;
        if(obj==null||obj.getClass()!=this.getClass())return false;
        Polynom second=(Polynom)obj;
        if(Arrays.compare(this.coefficients,second.coefficients)==0&&this.degree==second.degree)return true;
        else return false;
    }
}
