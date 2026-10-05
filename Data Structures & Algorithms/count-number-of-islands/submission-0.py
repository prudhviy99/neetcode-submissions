from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # Edge case: an empty grid contains no islands.
        if not grid or not grid[0]:
            return 0

        rows = len(grid)
        cols = len(grid[0])
        island_count = 0

        # Four-directional movement: up, down, left, right.
        directions = [
            (-1, 0),  # up
            (1, 0),   # down
            (0, -1),  # left
            (0, 1),   # right
        ]

        for row in range(rows):
            for col in range(cols):
                # Water or already visited land cannot start a new island.
                if grid[row][col] != "1":
                    continue

                # We found a new island.
                island_count += 1

                # Iterative DFS avoids Python recursion-depth problems.
                stack = [(row, col)]

                # Mark immediately when adding a cell to the stack.
                # This prevents the same cell from being added repeatedly.
                grid[row][col] = "0"

                while stack:
                    current_row, current_col = stack.pop()

                    for row_delta, col_delta in directions:
                        neighbor_row = current_row + row_delta
                        neighbor_col = current_col + col_delta

                        # Ignore neighbors outside the grid.
                        if not (0 <= neighbor_row < rows and
                                0 <= neighbor_col < cols):
                            continue

                        # Only visit unvisited land.
                        if grid[neighbor_row][neighbor_col] != "1":
                            continue

                        # Mark before pushing to avoid duplicate work.
                        grid[neighbor_row][neighbor_col] = "0"
                        stack.append((neighbor_row, neighbor_col))

        return island_count
