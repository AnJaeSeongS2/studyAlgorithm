import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * fortest
 *
 * Created by Jaeseong on 2020/08/08
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Main {
    public static void main(String[] args) {
        com.sonan.programmers.failPercent.Solution sol = new com.sonan.programmers.failPercent.Solution();
        int[] result = sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result2 = sol.solution(4, new int[]{4,4,4,4,4});
        System.out.println("end");

        List<Integer> test = new LinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(6);
        test.add(7);
        ListIterator<Integer> iter = test.listIterator();
        Integer newMember = 4;
        while (iter.hasNext()) {
            Integer next = iter.next();
            if (next > newMember) {
                iter.previous();
                iter.add(newMember);
                iter.next();
            }
        }
    }
}
