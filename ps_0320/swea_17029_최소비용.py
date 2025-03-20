"""
ddijikstra

boolean[] visted를 사용하지 않았다
"""





import heapq

def dijkstra():
    dr = [-1,1,0,0]
    dc = [0,0,-1,1]

    # (r,c,cur_consume)
    pq = [(0,0,0)]

    # N*N격자 최대값으로 초기화 why? --> min_val을 구할 것이니까까
    dist = [[float('inf')] * N for _ in range(N)]


    # 탐색 시작하겠다 dist[r][c] = 0
    dist[0][0] = 0

    while pq:
        cur_r, cur_c, cur_consume = heapq.heappop(pq)

        # 도착지에 반환시 비용 반환
        if cur_r == N-1 and cur_c == N-1:
            return cur_consume



        for d in range(4):
            nr = cur_r + dr[d]
            nc = cur_c + dc[d]

            # 범위를 벗어나지 않았고, 미방문이라면
            if (nr >= 0 and nr < N and nc >= 0 and nc < N):

                # 높이 차이에 따른 비용을 계산해보자
                height_diff =  max(0, height[nr][nc] - height[cur_r][cur_c])

                # 1칸 이동시 연료++
                total_consume = cur_consume + 1 + height_diff

                # 만약에 새로운 연료 소비량이 더 비싸면 이전의 것으로 바꾸자
                if total_consume < dist[nr][nc]:
                    dist[nr][nc] = total_consume
                    heapq.heappush(pq, (nr, nc, total_consume))













T = int(input())
for tc in range(1, T+1):
    N = int(input())
    height = [list(map(int, input().split())) for _ in range(N)]
    min_consume = dijkstra()
    # print(matrix)
    print(f'#{tc} {min_consume}')