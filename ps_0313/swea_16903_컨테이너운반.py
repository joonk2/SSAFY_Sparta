"""
[PS]
swea - 16903 (컨테이너 운반)

[what are we supposed to get?]
- maxWeight

[idea]
1. make all the list desc to compare from the max_val
2. if weight is included in capacity[i], then sum += (weight[i])
"""

T = int(input())
for tc in range(1, T+1):
    N,M = list(map(int, input().split()))

    weight = list(map(int, input().split()))
    capacity_of_truck = list(map(int, input().split()))

    # compare from the max_val
    weight.sort(reverse=True)
    capacity_of_truck.sort(reverse=True)

    idx = 0
    maxWeight = 0
    for w in weight:
        if (idx < M and w <= capacity_of_truck[idx]):
            maxWeight += w
            idx += 1

    print(f'#{tc} {maxWeight}')