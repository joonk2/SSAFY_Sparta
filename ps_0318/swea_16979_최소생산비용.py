def find_min_cost(row, cur_cost):
    global min_cost
 
    # 현재 비용이 최소합보다 크면 끝
    if cur_cost >= min_cost:
        return
 
    # 다 선택했다면 비교하고 종료
    if row == N:
        min_cost = min(min_cost, cur_cost)
        return
 
    # 각 행마다 3가지 선택방안
    # 방문 안했으면 최소비용선택 + 추가비용(재귀 호출) 그리고 방문 초기화
    for i in range(N):
        if selected[i] == True:
            continue
        elif not selected[i]:
            selected[i] = True
            find_min_cost(row + 1, cur_cost + cost[row][i])
            selected[i] = False
 
 
 
 
 
 
 
 
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    cost = [list(map(int, input().split())) for _ in range(N)]
    min_cost = float('inf')
    selected = [0]*N
    find_min_cost(0, 0)
    print(f'#{tc} {min_cost}')