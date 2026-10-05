from collections import defaultdict
from typing import DefaultDict, List, Tuple


class TimeMap:
    def __init__(self):
        # Each key maps to a list of (timestamp, value) pairs.
        # The timestamps are sorted because set() timestamps are strictly increasing.
        self.store: DefaultDict[str, List[Tuple[int, str]]] = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        # Because timestamps for set() are strictly increasing,
        # appending keeps this list sorted automatically.
        self.store[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        # If the key does not exist, no value can be returned.
        if key not in self.store:
            return ""

        history = self.store[key]

        # Binary search for the rightmost timestamp <= requested timestamp.
        left, right = 0, len(history) - 1
        answer = ""

        while left <= right:
            middle = (left + right) // 2
            stored_timestamp, stored_value = history[middle]

            if stored_timestamp <= timestamp:
                # This value is valid. Save it and search right
                # for a potentially newer valid timestamp.
                answer = stored_value
                left = middle + 1
            else:
                # This timestamp is too large, so search the left half.
                right = middle - 1

        return answer
