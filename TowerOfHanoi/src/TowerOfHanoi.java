import java.util.Objects;
import java.util.Stack;

public class TowerOfHanoi {
    public static void solveRecursion(int disks, char fromRod, char toRod, char middleRod) {
        if (disks == 1) {
            System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveRecursion(disks - 1, fromRod, middleRod, toRod);
        System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
        // Move disk from Rod B to Rod C
        solveRecursion(disks - 1, middleRod, toRod, fromRod);
    }


    public static void solveIteration(int n, Stack<Integer> s, Stack<Integer> a, Stack<Integer> d) {

        int moves = (int) Math.pow(2, n) - 1;


        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                if (!s.isEmpty() && (d.isEmpty() || s.peek() < d.peek())) {
                    movement(s, d, 'A', 'C');
                }
                else if (!d.isEmpty() && (s.isEmpty() || d.peek() < s.peek())) {
                    movement(d, s, 'C', 'A');
                }
            }
            else if (i % 3 == 2) {
                if(!s.isEmpty() && (a.isEmpty() || s.peek() < a.peek())){
                    movement(s, a, 'A', 'B');
                }
                else if(!a.isEmpty() && (s.isEmpty() || a.peek() < s.peek())){
                    movement(a, s, 'B', 'A');
                }
            } else {
                if (!a.isEmpty() && (d.isEmpty() || a.peek() < d.peek())) {
                    movement(a, d, 'B', 'C');
                } else if (!d.isEmpty() && (a.isEmpty() || d.peek() < a.peek())) {
                    movement(d, a, 'C', 'B');
                }
            }
        }
    }
    public static void movement(Stack<Integer> sourceStack, Stack<Integer> destinationStack,char source, char dest) {
        int disk = sourceStack.pop();
        destinationStack.push(disk);
        System.out.println("Move disk " + disk + " from rod " + source + " to rod " + dest);
    }

}




