import java.text.SimpleDateFormat;
import java.util.Arrays;
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

    private static char[] charArrayTest(char[] name, char change) {
        name[1] = change;
        return name;
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        ListIterator<Integer> iter2 = list.listIterator();
        while (iter2.hasNext()) {
            Integer cache = iter2.next();
            if (cache > 10) {
                break;
            }
            iter2.remove();
            iter2.add(cache + 5);
        }

        System.out.println(list);


        com.sonan.programmers.recentSongName.Solution sol3 = new com.sonan.programmers.recentSongName.Solution();
//        sol3.solution()


        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            System.out.println(timeFormat.parse("13:10").getTime() - timeFormat.parse("14:15").getTime());
        } catch (Exception e) {

        }



        com.sonan.programmers.skillChecks.level2.Solution sol2 = new com.sonan.programmers.skillChecks.level2.Solution();
        int result2_1 = sol2.solution("JEROEN");
        int result2_2 = sol2.solution("JAN");

        com.sonan.programmers.failPercent.Solution sol = new com.sonan.programmers.failPercent.Solution();
        int[] result = sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] result2 = sol.solution(4, new int[]{4,4,4,4,4});
        System.out.println("end");

        char[] testChar = "asdf".toCharArray();
        char[] testChar1 = charArrayTest(testChar, 'A');
        char[] testChar2 = charArrayTest(testChar, 'B');



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
