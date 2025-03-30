def battery_dfs(depth, cur_pos, cur_cost):
    global min_cost

    #1. if cur_cost is greater than or equals to min_cost then return
    if cur_cost >= min_cost:
        return
    
    #2. prunning
    # have to go back to each base
    # arr[cur_pos][0], arr[cur_pos][1], arr[cur_pos][2]
    if (depth == N-1):
        min_cost = min(min_cost, cur_cost + consume[cur_pos][0])
        return
    
    #3. visiting the place that we didn't go yet
    for next in range(1, N):
        if not visited[next]:
            visited[next] = True

            # going to next factory
            battery_dfs(depth+1, next, cur_cost + consume[cur_pos][next])

            # reset
            visited[next] = False




T = int(input())
for tc in range(1, T+1):
    N = int(input())
    consume = [list(map(int, input().split())) for _ in range(N)]
    visited = [False] * N
    min_cost = float('inf')
    
    visited[0] = True
    
    # depth, cur_pos, cur_cost
    battery_dfs(0, 0, 0)

    print(f"#{tc} {min_cost}")