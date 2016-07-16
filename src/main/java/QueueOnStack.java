import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Stack;

public class QueueOnStack {

    private static class Queue extends AbstractQueue<Integer> {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackHelper = new Stack<>();

        @Override
        public boolean add(Integer integer) {
            stack.add(integer);

            stackHelper = new Stack<>();

            Iterator<Integer> it = stack.iterator();

            while (it.hasNext()) {
                stackHelper.add(it.next());
            }

            return true;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean offer(Integer integer) {
            return false;
        }

        @Override
        public Integer poll() {
            Integer poll = stackHelper.pop();

            stack = new Stack<>();

            Iterator<Integer> it = stackHelper.iterator();

            while (it.hasNext()){
                stack.add(it.next());
            }

            return poll;
        }

        @Override
        public Integer peek() {
            return stackHelper.peek();
        }

        public Stack<Integer> getStack() {
            return stack;
        }

        @Override
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }


    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        System.out.println(queue.getStack());

        System.out.print("[");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.print("]");
    }

}
