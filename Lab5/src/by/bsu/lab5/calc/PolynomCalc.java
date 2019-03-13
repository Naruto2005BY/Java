package by.bsu.lab5.calc;

import by.bsu.lab5.entity.Polynom;

public class PolynomCalc {
    public Polynom add(Polynom first, Polynom second)
    {
        Polynom result=new Polynom(first.getDegree(),new double[first.getCoefficients().length]);
        if(first.getCoefficients().length>second.getCoefficients().length)
        {
        for(int i=0;i<second.getCoefficients().length;i++)
            result.setCoefficientByIndex(first.getCoefficientByIndex(i)+second.getCoefficientByIndex(i),i);
        for(int i=second.getCoefficients().length;i<first.getCoefficients().length;i++)
        result.setCoefficientByIndex(first.getCoefficientByIndex(i),i);
        }
        else
        {
            for(int i=0;i<first.getCoefficients().length;i++)
                result.setCoefficientByIndex(second.getCoefficientByIndex(i)+first.getCoefficientByIndex(i),i);
            for(int i=first.getCoefficients().length;i<second.getCoefficients().length;i++)
                result.setCoefficientByIndex(second.getCoefficientByIndex(i),i);
        }
        return result;
    }
    public Polynom subtract(Polynom first, Polynom second)
    {
        Polynom result=new Polynom(first.getDegree(),new double[first.getCoefficients().length]);
        if(first.getCoefficients().length>second.getCoefficients().length)
        {
            for(int i=0;i<second.getCoefficients().length;i++)
                result.setCoefficientByIndex(first.getCoefficientByIndex(i)-second.getCoefficientByIndex(i),i);
            for(int i=second.getCoefficients().length;i<first.getCoefficients().length;i++)
                result.setCoefficientByIndex(first.getCoefficientByIndex(i),i);
        }
        else
        {
            for(int i=0;i<first.getCoefficients().length;i++)
                result.setCoefficientByIndex(second.getCoefficientByIndex(i)-first.getCoefficientByIndex(i),i);
            for(int i=first.getCoefficients().length;i<second.getCoefficients().length;i++)
                result.setCoefficientByIndex(second.getCoefficientByIndex(i),i);
        }
        return result;
    }
Polynom multiply(Polynom first, Polynom second)
{
    Polynom result= new Polynom(first.getDegree()+second.getDegree(), new double[first.getCoefficients().length+second.getCoefficients().length+1]);
    for (int i=0; i<first.getCoefficients().length;i++)
        for(int j=0; j<second.getCoefficients().length;j++)
        {
            result.setCoefficientByIndex(result.getCoefficientByIndex(i+j)+first.getCoefficientByIndex(i)*second.getCoefficientByIndex(j),i+j);
        }
    return result;
}
Polynom[] divide(Polynom first, Polynom second)
{
    if(second.getDegree()==0&&second.getCoefficientByIndex(0)==0)
        throw new IllegalArgumentException("Trying to divide by zero");
    Polynom q=new Polynom(0,new double[]{0});
    Polynom copy=new Polynom(first);
    while(!isZero(copy)&&copy.getDegree()>=second.getDegree()) {
        double coef = copy.getCoefficientByIndex(copy.getDegree()) / second.getCoefficientByIndex(second.getDegree());
        int deg = copy.getDegree() - second.getDegree();
        Polynom t = new Polynom(deg, coef);
        q = add(q, t);
        copy = subtract(copy, multiply(t, second));
    }
    return new Polynom[]{q,copy};
    }

}
    public boolean isZero(Polynom a){
        for( double i : a.getCoefficients()) {
            if (i != 0) return false;
        }
        return true;
    }

}
