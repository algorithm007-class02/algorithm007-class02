/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let newList = new ListNode();
    if(l1 === null && l2 === null) {
        return null;
    } else {
        let tempList = newList;
        while (l1 !== null && l2 !== null) {
            if (l1.val < l2.val) {
                tempList = tempList.next = l1;
                l1 = l1.next;
            } else {
                tempList = tempList.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 === null) {
            tempList.next = l2;
        } else {
            tempList.next = l1;
        }
        return newList.next;
    } 
  };