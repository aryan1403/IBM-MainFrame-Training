package Day1.calc;

import java.util.ArrayList;
import java.util.List;

public class logs {
    List<String> operations = new ArrayList<>();
    public void addOperation(int a, int b, String stuff, double res) {
        operation op = new operation(a, b, stuff, res);
        operations.add(op.toString());
    }

    public void showLogs() {
        System.out.println("Operation History:");
        for (String log : operations) {
            System.out.println(log);
        }
    }
}
