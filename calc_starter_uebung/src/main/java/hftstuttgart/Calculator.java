package hftstuttgart;


public class Calculator {
    
    public int sum(int op1, int op2) {
        int sum = 0;
        sum += op1;
        sum += op2;
        return sum;
    }    

    public int prod(int op1, int op2) {
        int sum = 0;
        sum = op1*op2;
        return sum;
    }    
}