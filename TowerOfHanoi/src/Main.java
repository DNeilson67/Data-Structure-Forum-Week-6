import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TowerOfHanoi TOH = new TowerOfHanoi();
        System.out.println("Recursion mode:");
        TOH.solveRecursion(3, 'a','c','b');

        Stack<Integer> pole1 = new Stack<>();
        Stack<Integer> pole2 = new Stack<>();
        Stack<Integer> pole3 = new Stack<>();

        for (int i = 3; i >= 1; i--) {
            pole1.push(i);
        }

        System.out.println("Iteration mode:");
        TOH.solveIteration(3, pole1, pole2, pole3);

    }
}