from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # graph[pre] stores courses that become available after taking `pre`.
        graph = [[] for _ in range(numCourses)]

        # indegree[course] is the number of prerequisites still required
        # before that course can be taken.
        indegree = [0] * numCourses

        # Convert [course, prerequisite] into prerequisite -> course.
        for course, prerequisite in prerequisites:
            graph[prerequisite].append(course)
            indegree[course] += 1

        # Courses with no prerequisites can be taken first.
        ready_courses = deque()
        for course in range(numCourses):
            if indegree[course] == 0:
                ready_courses.append(course)

        # Count how many courses can be completed in a valid order.
        completed_count = 0

        while ready_courses:
            # Take one currently available course.
            completed_course = ready_courses.popleft()
            completed_count += 1

            # Completing this course removes one prerequisite from each
            # dependent course.
            for next_course in graph[completed_course]:
                indegree[next_course] -= 1

                # This dependent course is now eligible to be taken.
                if indegree[next_course] == 0:
                    ready_courses.append(next_course)

        # If a cycle exists, every course in that cycle keeps indegree > 0,
        # so it can never enter the queue.
        return completed_count == numCourses
