
import heapq
from typing import List

class Solution:
    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        available = [(w, i) for i, w in enumerate(servers)]
        heapq.heapify(available)

        busy = []
        ans = []
        time = 0

        for i, task in enumerate(tasks):
            time = max(time, i)

            # Move completed servers back to available
            while busy and busy[0][0] <= time:
                free, weight, idx = heapq.heappop(busy)
                heapq.heappush(available, (weight, idx))

            # Wait if all servers are busy
            if not available:
                time = busy[0][0]

                while busy and busy[0][0] <= time:
                    free, weight, idx = heapq.heappop(busy)
                    heapq.heappush(available, (weight, idx))

            # Select the best server
            weight, idx = heapq.heappop(available)
            ans.append(idx)

            # Update its finishing time
            heapq.heappush(busy, (time + task, weight, idx))

        return ans
