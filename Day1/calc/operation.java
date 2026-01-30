package Day1.calc;

public class operation {
    int operand1;
    int operand2;

    String op;

    double result;

    public operation(int operand1, int operand2, String op, double result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.op = op;
        this.result = result;
    }

    @Override
    public String toString() {
        return operand1 + " " + op + " " + operand2 + " = " + result;  
    }
}
