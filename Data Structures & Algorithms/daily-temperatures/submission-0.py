class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # brute force is to have a nested loop and check every temp with other temperaturs
        # optimal is to use a stack
        # use a stack with element as hashmap temp, index
        # for every temp, check if stack is empty or current temp is greater that top element in stack 
        # if true, update result array by popping top element from stack
        # add temp and index to stack
        # basically, in the stack we keep track of smaller temperature we have seen until now
        # and update the result array until top of the stack is not less the seen temperature


        res = [0] * len(temperatures)
        stack = [] 

        for i, t in enumerate(temperatures):
            while stack and t > stack[-1][0]:
                stackT, stackIdx = stack.pop()
                res[stackIdx] = i - stackIdx
            stack.append((t, i))
        return res