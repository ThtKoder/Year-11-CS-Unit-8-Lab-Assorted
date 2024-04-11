import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Collections;

public class Assorted {

    /**
     * Challenge 1
     *
     * Takes a list of integer values represented as a mix of both
     * integer and string data types.
     * @param list a list of integer values represented as a mix of both
     *             integer and string data types. E.g. [12, "54", "78", 16]
     * @return the sum of the elements in the list as if all elements were
     *         integer data types.
     */

    public static int findSum(List<?> list) {
        int i = 0; //for list
        int sum = 0; //for sum

        while(i < list.size()){
            sum += Integer.parseInt(String.valueOf(list.get(i)));
            i++;
        }

        return sum;

    }

    /**
     * Challenge 2
     *
     * Takes a list of integers and strings and returns a new list containing
     * the integers only (filters the strings out).
     * @param list a list of integer and string values. E.g [1, 2, "a", 5]
     * @return a list containing integers only.
     */
    public static List<Integer> filterStrings(List<?> list) {
        int i = 0; //for list
        List<Integer> newList = new ArrayList<>();

        while(i < list.size()){
            if(list.get(i).getClass().getSimpleName().equals("Integer")){
                newList.add((Integer) list.get(i));
                i++;
            }
            else{
                i++;
            }
        }

        System.out.println(newList);

        return newList;
    }

    /**
     * Challenge 3
     *
     * Takes a list of strings and returns a new list that includes each element
     * prepended by the correct line number.
     * @param list a list of string values e.g. ["a", "b", "c"]
     * @return a list where each element is prepended by the correct line number
     *         e.g. ["1: a", "2: b", "3: c"]
     */
    public static List<String> lineNumbering(List<String> list) {
        int i = 0; //for list
        List<String> myList = new ArrayList<>();

        while(i < list.size()){
            myList.add(i+1 + ": " + list.get(i));
            i++;
        }

        return myList;
    }

    /**
     * Challenge 4
     *
     * There is a bus moving in the city which takes and drops some people at each
     * bus stop.
     *
     * You are provided with a list (or array) of integer pairs. Elements of each pair
     * represent the number of people that get on the bus (the first item) and the number
     * of people that get off the bus (the second item) at a bus stop.
     *
     * Your task is to return the number of people who are still on the bus after the last
     * bus stop (after the last array). Even though it is the last bus stop, the bus might
     * not be empty and some people might still be inside the bus, they are probably
     * sleeping there :D
     *
     * @param list a list of integer pairs.
     * @return the number of people who are still on the bus after the last stop.
     */
    public static int busStop(List<Integer[]> list) {
        int gottenOn = 0;
        int gottenOff = 0;

        for(Integer[] iterate: list){
            gottenOn += iterate[0];
            gottenOff += iterate[1];
        }

        return gottenOn - gottenOff;
    }

    /**
     * Challenge 5
     *
     * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
     * @param list a list of integer values. Each element is either a 0 or a 1.
     * @return the decimal value of the binary representation of the list.
     *         Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
     */
    public static int toBinary(List<Integer> list) {
        int[] reversedArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            reversedArray[i] = list.get(list.size()-i-1);
        }

        int value = 0;

        for(int k = 0; k < reversedArray.length; k++){
            if(k == 0) {
                value += reversedArray[k] * 1;
            }
            else if(k != 0){
                value += reversedArray[k] * Math.pow(2, k);
            }
        }

        return value;

    }

    /**
     * Challenge 6
     *
     * Your goal is to implement a method which subtracts one list
     * from another and returns the result.
     *
     * It should remove all values from listA, which are present in listB keeping their order.
     * If a value is present in listB, all of its occurrences must be removed from listA.
     *
     * @param listA a list of integer values.
     * @param listB a list of integer values.
     * @return a list that contains the difference between listB and listA.
     *         e.g. subtractList([1,2], [1]) returns [2]
     *              subtractList([1,2,2,2,3], [2]) returns [1,3]
     */
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {

        listA.removeIf(listB::contains);
        //courtesy of intellij

        return new ArrayList<>(listA);
    }

    /**
     * Challenge 7
     *
     * Your goal is to implement a method which takes a list of integers and sorts the odd
     * numbers in ascending order while leaving the even numbers in their original positions.
     *
     * @param list a list of integers.
     * @return a list where the odd integers have been sorted in ascending order and the even
     *         integers remain in their original position.
     */
    public static List<Integer> sortOdd(List<Integer> list) {
        List<Integer> oddInAscendingOrder = new ArrayList<>();

        for(Integer a: list){
            if(a%2 != 0){
                oddInAscendingOrder.add(a);
            }
        }

        Collections.sort(oddInAscendingOrder);

        List<Integer> everythingAscendingOrder = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < list.size()){
            if(list.get(i)%2 != 0){
                everythingAscendingOrder.add(oddInAscendingOrder.get(j));
                j++;
            }
            if(list.get(i)%2 == 0){
                everythingAscendingOrder.add(list.get(i));
            }
            i++;
        }

        return everythingAscendingOrder;
    }

    /**
     * Challenge 8
     *
     * Your goal is to implement a method which takes two values (a lower bound and an upper
     * bound) and returns a list of numbers that are between the lower bound and upper bound
     * (inclusive) that have a certain property.
     *
     * The property is as follows:
     *
     * The number 89 is the first integer with more than one digit whose individual digits
     * can sum to the value 89 by raising each digit to the power of the place or column of
     * which it resides. For example, 89 = 8^1 + 9^2. The next number having this property is
     * 135. 135 = 1^1 + 3^2 + 5^3.
     *
     * @param lowerBound an integer representing the lower bound.
     * @param upperBound an integer representing the upper bound.
     * @return a list containing all the numbers between lowerBound and upperBound (inclusive)
     *         that meet the property mentioned above.
     *         e.g. uniqueNumber(1,10) returns [1,2,3,4,5,6,7,8,9]
     *              uniqueNumber(1,100) returns [1,2,3,4,5,6,7,8,9,89]
     */
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        List<Integer> totalNumbers = new ArrayList<>();

        for(int i = 0; i < lowerBound + upperBound; i++){
            totalNumbers.add(i);
        }

        List<Integer> placePoweredList = new ArrayList<>();
        List<Integer> uniqueNumberList = new ArrayList<>();

        // 89 = 8^1 + 9^2 or 2^1
        // 8^1
        // 9^2
        for(int p = 1; p < 10; p++) {
            for (int o = 1; o < 10; o++) {
                placePoweredList.add(o^p);
            }
        }

        System.out.println(placePoweredList);

        /*for(int k : totalNumbers){
            if(k / 10 % 10 = ){
                k++;
            }
            else{
                totalNumbers.remove(k);
            }
        }*/

        //System.out.println(upperBound%100);
        //System.out.println(upperBound%10);
        //System.out.println(upperBound%1);

        for(int j = 0; j < lowerBound+upperBound; j++) {
            if (placePoweredList.contains(j)) {
                placePoweredList.add(j);
            }
        }

        System.out.println(uniqueNumberList);

        /*for(int iterate : uniqueNumberList){
            for(iterate%10)
        }*/

        //check for
        //System.out.println(uniqueNumberList);

        return uniqueNumberList;
    }

    /**
     * Challenge 9
     *
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've
     * been, and now they want to show Charlie their entire collection. However, Charlie doesn't
     * like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times.
     *
     * He tells them that he will only sit for the session if they show the same motif at most N
     * times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them
     * to remove numbers such that their list contains each number only up to N times, without
     * changing the order?
     *
     * @param list a list of motifs.
     * @param n the maximum number of occurrences of a specific motif that is allowed.
     * @return a list containing each motif at most n times.
     *         e.g. filterNTimes([1,2,3,1,2,1,2,3], 2) returns [1,2,3,1,2,3]
     *              filterNTimes([20,37,20,21], 1) returns [20,37,21]
     */
    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        List<Integer> arrayList = new ArrayList<>();

        int highestValue = 0;

        for(int element: list){
            if(element>highestValue){
                highestValue = element;
            }
        }

        int[][] valueCount = new int[highestValue+1][2];

        for(int j = 1; j < list.size(); j++){
            if(valueCount[list.get(j-1)][1] > n){
                valueCount[list.get(j-1)][1] += 1;
            }
        }

        System.out.println(Arrays.toString(valueCount));

        for(int i = 0; i<list.size(); i++){
            if(valueCount[list.get(i)][1] > n){
                arrayList.remove(i);
            }
        }

        return arrayList;

        //
    }

    /**
     *
     * Challenge 10
     *
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were
     * "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST"
     * and "EAST" too.
     *
     * Going to one direction and coming back the opposite direction right away is a needless
     * effort. Since this is the wild west, with dreadful weather and not much water, it's
     * important to save yourself some energy, otherwise you might die of thirst!
     *
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following:
     *
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     *
     * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable,
     * better stay to the same place! So the task is to give to the man a simplified version
     * of the plan. A better plan in this case is simply:
     *
     * ["WEST"]
     *
     * Your task is to write a method which will take a list of strings and returns a list
     * of strings with the needless directions removed.
     *
     * @param directions a list of directions.
     * @return a list with the needless directions removed.
     *         e.g. wildWest(["NORTH", "SOUTH", "EAST", "WEST"]) returns []
     *              wildWest(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"]) returns
     *              ["WEST", "WEST"]
     */
    public static List<String> wildWest(List<String> directions) {
        List<String> simplifiedDirections = new ArrayList<>();

        int northMentionsInt = 0;
        int southMentionsInt = 0;
        int eastMentionsInt = 0;
        int westMentionsInt = 0;

        for(String bearings: directions){
            if(bearings.equalsIgnoreCase("NORTH")){
                northMentionsInt++;
            }
            if(bearings.equalsIgnoreCase("SOUTH")){
                southMentionsInt++;
            }
            if(bearings.equalsIgnoreCase("EAST")){
                eastMentionsInt++;
            }
            if(bearings.equalsIgnoreCase("WEST")){
                westMentionsInt++;
            }
        }

        if(northMentionsInt == southMentionsInt && eastMentionsInt == westMentionsInt){
            return simplifiedDirections;
        }

        if(northMentionsInt == southMentionsInt + 1 && eastMentionsInt == westMentionsInt){
            simplifiedDirections.add("NORTH");
            return simplifiedDirections;
        }
        if(southMentionsInt == northMentionsInt + 1 && eastMentionsInt == westMentionsInt){
            simplifiedDirections.add("SOUTH");
            return simplifiedDirections;
        }
        if(eastMentionsInt == westMentionsInt + 1 && northMentionsInt == southMentionsInt){
            simplifiedDirections.add("EAST");
            return simplifiedDirections;
        }
        if(westMentionsInt == eastMentionsInt + 1 && northMentionsInt == southMentionsInt){
            simplifiedDirections.add("WEST");
            return simplifiedDirections;
        }

        int[][] northMentions = new int[1][northMentionsInt];
        int[][] southMentions = new int[1][southMentionsInt];
        int[][] eastMentions = new int[1][eastMentionsInt];
        int[][] westMentions = new int[1][westMentionsInt];

        //[instances][positions]

        int northTotal = northMentionsInt-southMentionsInt;
        int southTotal = southMentionsInt-northMentionsInt;
        int eastTotal = eastMentionsInt-westMentionsInt;
        int westTotal = westMentionsInt-eastMentionsInt;

        while(northTotal > southTotal){
            southTotal++;
            simplifiedDirections.add("NORTH");
        }
        while(southTotal > northTotal){
            northTotal++;
            simplifiedDirections.add("SOUTH");
        }
        while(eastTotal > westTotal){
            westTotal++;
            simplifiedDirections.add("EAST");
        }
        while(westTotal > eastTotal){
            eastTotal++;
            simplifiedDirections.add("WEST");
        }

        System.out.println(simplifiedDirections);
        return simplifiedDirections;
    }

    /**
     * Challenge 11
     *
     * There is a queue for the self-checkout tills at the supermarket. Your task is to write a
     * method to calculate the total time required for all the customers to check out!
     *
     * There is only queue serving many tills.
     * The order of the queue never changes.
     * The front person in the queue (the first element in queue) proceeds to a till as soon
     * as it becomes free.
     *
     * @param queue a list of queue times. Each element represents a customer and how long
     *                  in minutes it will take them to check out.
     * @param tillsOpen the number of tills currently available for customers to use.
     * @return an integer that represents how long it will take for all the customers to check
     *         out.
     *         e.g. queueTime([5,3,4], 1) returns 12
     *              queueTime([10,2,3,3], 2) returns 10
     *              queueTime([2,3,10], 2) returns 12
     */
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        /**
         * if one customer need 10 mins, then others can go to other tills
         */

        int[] tillsOpenArr = new int[tillsOpen];

        int totalQueue = 0;

        //total queues
        //iterate through customers?
        //

        //for(int iterate : tillsOpenArr[])

        for (int inLine : queue) {
            totalQueue += inLine;
        }

        //get the largest customer number, and then add up the other

        System.out.println(totalQueue);
        System.out.println(totalQueue/tillsOpen);
        return totalQueue / tillsOpen;

    }
}
