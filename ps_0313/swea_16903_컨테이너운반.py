"""
[idea]
-1. two options (weight, capacity of truck)
-2. make arr desc
-3. let's say there's 5kg of items and 8kgs of capacity
-4. it should be like this --> [1,1,1,1,1, , , ,]
-5. based on this way to calculate, we get to the solution of maximum weight that we can handle
"""

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    weight = list(map(int, input().split()))
    capacity_of_truck = list(map(int, input().split()))

    weight.sort(reverse=True)
    capacity_of_truck.sort(reverse=True)

    idx = 0
    max_weight = 0
    for w in weight:
        if (idx < M and w <= capacity_of_truck[idx]):
            max_weight += w
            idx += 1
        
    print(f"#{tc} {max_weight}")