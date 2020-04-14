import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int i1 = 1, i2 = 2, i3 = 3;
        stack.add(i1);
        stack.add(i2);
        stack.add(i3);
        i3 = 1;
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
