package mathmethods;

import java.math.BigInteger;
import java.lang.UnsupportedOperationException;
public class MathMethods extends java.lang.Object {
    
    public static void main(String[] args){
        switch(args[0]){
            case "factorial": 
                System.out.println(factorial(Integer.parseInt(args[1])));
                break;
        }
        switch(args[0]){
            case "fibonacci": 
                System.out.println(fibonacci(Integer.parseInt(args[1])));
                break;
        }
        switch(args[0]){
            case "gcd": 
                System.out.println(gcd(Long.parseLong(args[1]), Long.parseLong(args[2])));
                break;
        }
        switch(args[0]){
            case "lcm": 
                System.out.println(lcm(Long.parseLong(args[1]), Long.parseLong(args[2])));
                break;
        }
        switch(args[0]){
            case "poly": 
                double[] coeff= new double[args.length-2];
                for(int i=0; i< args.length-2;i++){
                    coeff[i]=Double.parseDouble(args[i+2]);
                System.out.println(coeff[i]);
                }
                System.out.println(poly(Double.parseDouble(args[1]), coeff));
                break;
        }
        switch(args[0]){
            case "sqrt": 
                System.out.println(sqrt(Double.parseDouble(args[1]), Double.parseDouble(args[2])));
                break;
        }
        switch(args[0]){
            case "root": 
                System.out.println(root(Integer.parseInt(args[1]),Double.parseDouble(args[2]), Double.parseDouble(args[3])));
                break;
        }
        switch(args[0]){
            case "power": 
                System.out.println(power(Double.parseDouble(args[1]),Integer.parseInt(args[2])));
                break;
        }
    }
    
    static java.math.BigInteger fibonacci(int n) {
        final BigInteger ZERO = new BigInteger("0");
        final BigInteger ONE = new BigInteger("1");
        BigInteger j= new BigInteger("0");
        BigInteger k= new BigInteger("1");
        BigInteger l= new BigInteger("0");
/***/   if(n<0){
/***/       throw new IllegalArgumentException();
/***/   }
        if(n==0){
            return ZERO;
        }
        else if(n==1){
            return ONE;
        }
        for(int i=0;i<n-1;i++){
            l=k;
            k=k.add(j);
            j=l;
        }
        return k;
    }
    
    static java.math.BigInteger factorial(int n) {
        BigInteger j= new BigInteger("1");
        BigInteger k;
/***/   if(n<0){
/***/       throw new IllegalArgumentException();
/***/   }

        for(int i=1; i<=n;i++){
            k=new BigInteger(Integer.toString(i));
            j=j.multiply(k);
        }
        return j;
    }
    
    static long gcd(long m, long n){
    if(n<0 || m<0){
        throw new IllegalArgumentException();
    }
        if(m%n==0){
            return n;
        }
        return gcd(n, m%n);
    }
    
    static long lcm(long m, long n){
        if(n<0){
            throw new IllegalArgumentException();
        }
        return m*n/gcd(m,n);
    }
    
    static double poly(double x, double[] coeff){
        double y = coeff[coeff.length-1];
        for(int i=coeff.length-1; i>0; i--){
                y*=x;
                y+=coeff[i-1];
        }
        return y;
    }
    
    static double power(double x, int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            double y=power(x, n/2);
            return y*y;
            
        }
        else{
            double y= power(x, n/2);
            return y*y*x;
        }
        
    }
    
    static double sqrt(double x, double epsilon){
        
        double low = 0;
        double high = x;
        if(x==1){
            return 1;
        }
        while(high-low>epsilon){
            if(power((high-low)/2+low,2)==x){
                return (high-low)/2+low;
            }
            if(power((high-low)/2+low,2) > x){
                high=(high-low)/2+low;
            }
            if(power((high-low)/2+low,2) < x){
                low=(high-low)/2+low;
            }
        }
        return (high-low)/2+low;
    }
    
    static double root(int n, double x, double epsilon){
        double low = 0;
        double high = x;
        if(x==1){
            return 1;
        }
        while(high-low>epsilon){
            if(power((high-low)/2+low,n)==x){
                return (high-low)/2+low;
            }
            if(power((high-low)/2+low,n) > x){
                high=(high-low)/2+low;
            }
            if(power((high-low)/2+low,n) < x){
                low=(high-low)/2+low;
            }
        }
        return (high-low)/2+low;
    }
    
}
