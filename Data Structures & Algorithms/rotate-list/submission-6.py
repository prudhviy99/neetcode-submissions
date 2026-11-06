# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:

        # first get the length on linked list in one pass
        # create a circular linked list by connecting tail to head
        # find kth position using n % k and traversing to that position, k = n % k
        # make head head = curr
        # curr.next = null

        curr = head
        n = 1

        if not head:
            return head
        
        while curr.next:
            curr = curr.next
            n += 1

        curr.next = head

        k = k % n

        for i in range(n - k):
            curr = curr.next

        head = curr.next
        curr.next = None
        
        return head