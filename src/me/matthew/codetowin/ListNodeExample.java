package me.matthew.codetowin;

import java.util.ArrayList;
import java.util.List;

public class ListNodeExample {

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode first1 = new ListNode(4);
        ListNode first2 = new ListNode(3);

        first.next = first1;
        first1.next = first2;

        ListNode second = new ListNode(5);
        ListNode second1 = new ListNode(6);
        ListNode second2 = new ListNode(4);

        second.next = second1;
        second1.next = second2;

        ListNode product = addListNodes(first, second);
        printListNode(product);
    }

    /**
     * Adds all of the values of a list node together, adding any carried value to the next
     * node. Returns a new {@link ListNode} object with the output.
     *
     * @param first  the first list
     * @param second the second list
     * @return a new list with all values in the first and second list added together
     */
    public static ListNode addListNodes(ListNode first, ListNode second) {
        ListNode finalProduct = null;

        ListNode currentFinalNode = null;
        ListNode currentFirstNode = first;
        ListNode currentSecondNode = second;

        int carryFromPrevious = 0;

        while (currentFirstNode != null || currentSecondNode != null) {
            ListNode newValueNode;
            if (finalProduct == null) {
                finalProduct = new ListNode();
                currentFinalNode = finalProduct;
                newValueNode = finalProduct;
            } else {
                newValueNode = new ListNode();
            }

            int firstVal = currentFirstNode.val;
            int secondVal = currentSecondNode.val;

            newValueNode.val = firstVal + secondVal + carryFromPrevious;
            carryFromPrevious = 0;

            if (newValueNode.val > 9) {
                carryFromPrevious = newValueNode.val / 10; // Set the carry for the next iteration
                newValueNode.val = newValueNode.val - 10; // Just keep it as 10 for now, can deal with > 19 later
            }

            currentFinalNode.next = newValueNode;
            currentFinalNode = newValueNode;

            currentFirstNode = currentFirstNode.next;
            currentSecondNode = currentSecondNode.next;
        }

        return finalProduct;
    }

    /**
     * Prints a {@link ListNode} to console
     *
     * @param node the list
     */
    public static void printListNode(ListNode node) {
        List<Integer> values = new ArrayList<>();
        ListNode curr = node;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        System.out.println(values);
    }
}
