// There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

public class NSteps{
    public static void main(String[] args){
        int stairs = 2;
        System.out.println(nsteps(stairs));
    }

    public static int nsteps(int n){
        
        if(n==0) return 1;
        else if(n<0) return 0;
        return nsteps(n-1)+nsteps(n-2);
    }
}

// starting from largest case to smallest takes one parameter 
    // nsteps(int n)
 // rather than smallest to largest which takes additional one parameter.    
