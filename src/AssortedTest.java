import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssortedTest {

    List findSumList;
    List findSumList2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        findSumList = new ArrayList<>();
        findSumList.add(12);
        findSumList.add("54");
        findSumList.add("78");
        findSumList.add(16);

        findSumList2 = new ArrayList<>();
        findSumList2.add(120);
        findSumList2.add("54");
        findSumList2.add("16");
        findSumList2.add(38);
        findSumList2.add(89);
        findSumList2.add("23");
        findSumList2.add("11");
        findSumList2.add(39);


    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        findSumList = null;
        findSumList2 = null;
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void findSum() {

        assertTrue(Assorted.findSum(findSumList) == 160, "Your findSum method, bruh.");
        assertTrue(Assorted.findSum(findSumList2) == 390, "Your findSum method, bruh.");

    }

    @org.junit.jupiter.api.Test
    void filterStrings() {

        assertTrue(Assorted.filterStrings(findSumList).size() == 2, "Your filterStrings method, bruh.");
        assertTrue(Assorted.filterStrings(findSumList2).size() == 4, "Your filterStrings method, bruh.");

    }

    @org.junit.jupiter.api.Test
    void lineNumbering() {
        List<String> result = Assorted.lineNumbering(Arrays.asList("12", "13", "14", "15", "16", "17"));
        int index = 1;
        for (String element: result) {
            assertTrue(Integer.parseInt(""+element.charAt(0)) == index++);
            assertTrue(element.charAt(1) == ':');
            assertTrue(element.charAt(2) == ' ');
        }
    }

    @org.junit.jupiter.api.Test
    void busStop() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[] {10,0});
        list.add(new Integer[] {3,5});
        list.add(new Integer[] {2,5});
        assertEquals(5, Assorted.busStop(list));

        List<Integer[]> list2 = new ArrayList<>();
        list2.add(new Integer[] {10,0});
        list2.add(new Integer[] {3,5});
        list2.add(new Integer[] {2,5});
        list2.add(new Integer[] {12,5});
        list2.add(new Integer[] {3,8});
        assertEquals(7, Assorted.busStop(list2));
    }

    @org.junit.jupiter.api.Test
    void toBinary() {

        List<Integer> listOne = new ArrayList(Arrays.asList(0,0,0,1));
        int result = Assorted.toBinary(listOne);
        assertTrue(result == 1, "Your toBinary method, bratishka.");

        List<Integer> listTwo = new ArrayList(Arrays.asList(0,1,0,1));
        int result2 = Assorted.toBinary(listTwo);
        assertTrue(result2 == 5, "Your toBinary method, bratishka.");

        List<Integer> listThree = new ArrayList(Arrays.asList(1,1,0,1,0,1,1,0));
        int result3 = Assorted.toBinary(listThree);
        assertTrue(result3 == 214, "Your toBinary method, bratishka.");

    }

    @org.junit.jupiter.api.Test
    void subtractList() {
        List<Integer> listOne = new ArrayList(Arrays.asList(1,2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1));

        List<Integer> result = Assorted.subtractList(listOne, listTwo);

        assertTrue(result.size() == 1);
        assertTrue(result.get(0) == 2);

        List<Integer> listThree = new ArrayList(Arrays.asList(1,2,2,2,3));
        List<Integer> listFour = new ArrayList<>(Arrays.asList(2));

        List<Integer> result2 = Assorted.subtractList(listThree, listFour);

        assertTrue(result2.size() == 2);
        assertTrue(result2.get(0) == 1);
        assertTrue(result2.get(1) == 3);

    }

    @org.junit.jupiter.api.Test
    void sortOdd() {
        List<Integer> list = new ArrayList(Arrays.asList(12,11,3,4,16,21,22,3,1,67,8,9));
        List<Integer> listSortedOdd = Assorted.sortOdd(list);

        assertTrue(listSortedOdd.get(0) == 12);
        assertTrue(listSortedOdd.get(1) == 1);
        assertTrue(listSortedOdd.get(2) == 3);
        assertTrue(listSortedOdd.get(3) == 4);
        assertTrue(listSortedOdd.get(listSortedOdd.size()-1) == 67);

        for (int i = 0; i < list.size(); i ++) {

            if (list.get(i)%2 == 0) {
                assertTrue(list.get(i) == listSortedOdd.get(i));
            }
        }


    }

    @org.junit.jupiter.api.Test
    void uniqueNumber() {
        List<Integer> result = Assorted.uniqueNumber(1,10);
        List<Integer> result2 = Assorted.uniqueNumber(1,100);
        List<Integer> result3 = Assorted.uniqueNumber(1,200);

        assertTrue(result.size() == 9);
        assertTrue(result.get(result.size()-1) == 9);

        assertTrue(result2.size() == 10);
        assertTrue(result2.get(result2.size()-1) == 89);

        assertTrue(result3.size() == 12);
        assertTrue(result3.get(result3.size()-2) == 135);
        assertTrue(result3.get(result3.size()-1) == 175);

    }

    @org.junit.jupiter.api.Test
    void filterNTimes() {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,2,1,2,3));
        List<Integer> result = Assorted.filterNTimes(list, 2); // returns [1,2,3,1,2,3]
        assertTrue(result.size() == 6);
        assertTrue(result.get(0) == 1);
        assertTrue(result.get(result.size()-1) == 3);
        assertTrue(result.get(result.size()-2) == 2);
        assertTrue(result.get(result.size()-3) == 1);
        assertTrue(result.get(result.size()-4) == 3);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(20,37,20,21));
        List<Integer> result2 = Assorted.filterNTimes(list2,1); // returns [20,37,21]

        assertTrue(result2.size() == 3);
        assertTrue(result2.get(0) == 20);
        assertTrue(result2.get(1) == 37);
        assertTrue(result2.get(2) == 21);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(20,37,20,21,26,25,28,29,31,31,2,32,21,22,24));
        List<Integer> result3 = Assorted.filterNTimes(list3,1); // returns [20,37,21,26,25,28,29,31,2,32,22,24]
        assertTrue(result3.size() == 12);
        assertTrue(result3.get(0) == 20);
        assertTrue(result3.get(1) == 37);
        assertTrue(result3.get(2) == 21);
        assertTrue(result3.get(result3.size()-1) == 24);
        assertTrue(result3.get(result3.size()-2) == 22);
        assertTrue(result3.get(result3.size()-3) == 32);

    }

    @org.junit.jupiter.api.Test
    void wildWest() {

        List<String> list = new ArrayList(Arrays.asList("NORTH", "SOUTH", "EAST", "WEST")); //0
        List<String> list2 = new ArrayList(Arrays.asList("NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST")); //
        List<String> list3 = new ArrayList(Arrays.asList("NORTH", "NORTH", "EAST", "EAST", "NORTH", "WEST", "SOUTH", "WEST", "WEST"));
        List<String> list4 = new ArrayList(Arrays.asList("NORTH", "NORTH", "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"));

        List<String> result = Assorted.wildWest(list);
        List<String> result2 = Assorted.wildWest(list2);
        List<String> result3 = Assorted.wildWest(list3);
        List<String> result4 = Assorted.wildWest(list4);

        assertTrue(result.size() == 0);

        assertTrue(result2.size() == 2);
        assertTrue(result2.get(0).equals("WEST"));
        assertTrue(result2.get(1).equals("WEST"));

        assertTrue(result3.size() == 9);
        assertTrue(result3.get(0).equals("NORTH"));
        assertTrue(result3.get(1).equals("NORTH"));
        assertTrue(result3.get(2).equals("EAST"));
        assertTrue(result3.get(3).equals("EAST"));
        assertTrue(result3.get(result3.size()-1).equals("WEST"));
        assertTrue(result3.get(result3.size()-2).equals("WEST"));
        assertTrue(result3.get(result3.size()-3).equals("SOUTH"));

        assertTrue(result4.size() == 2);
        assertTrue(result4.get(0).equals("WEST"));
        assertTrue(result4.get(1).equals("WEST"));

    }

    @org.junit.jupiter.api.Test
    void queueTime() {

        List<Integer> supermarket = new ArrayList(Arrays.asList(5,3,4));
        List<Integer> supermarket2 = new ArrayList(Arrays.asList(10,2,3,3));
        List<Integer> supermarket3 = new ArrayList(Arrays.asList(2,3,10));
        List<Integer> supermarket4 = new ArrayList(Arrays.asList(2,3,10,2,3,10,8,7,4,12,4,6));

        int result = Assorted.queueTime(supermarket, 1);
        int result2 = Assorted.queueTime(supermarket2, 2);
        int result3 = Assorted.queueTime(supermarket3, 2);
        int result4 = Assorted.queueTime(supermarket4, 3);



        assertTrue(result == 12);
        assertTrue(result2 == 10);
        assertTrue(result3 == 12);
        assertTrue(result4 == 26);

    }

}
