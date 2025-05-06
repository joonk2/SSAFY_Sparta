T = int(input())
for tc in range(1, T + 1):
    N, E = map(int, input().split())

    # 인접행렬 초기화
    g = [[0] * (N + 1) for _ in range(N + 1)]
    for _ in range(E):
        s, e, w = map(int, input().split())
        g[s][e] = w

    # 거리와 방문 배열 초기화
    INF = float('inf')
    v = [False] * (N + 1)
    dist = [INF] * (N + 1)

    # 시작점은 0번
    dist[0] = 0

    # 아직 방문하지 않은 노드 중에서 최소 거리 노드 선택
    for _ in range(N + 1):
        min_val = INF
        min_idx = -1
        for i in range(N + 1):
            if not v[i] and dist[i] < min_val:
                min_val = dist[i]
                min_idx = i

        # 방문 다 했으면 볼 필요 없으니 당연히 min_idx는 값 변경이 없을 것이고,
        # 이에 전체 반복문 종료
        if min_idx == -1:
            break

        # 최소 거리 찾았으면 방문 처리
        v[min_idx] = True

        # 선택된 노드에 인접한 노드들의 거리 갱신
        # (문제에는 간선 조건이 1 <= w <= 10)
        for i in range(N + 1):
            if not v[i] and g[min_idx][i] >= 1:
                new_dist = dist[min_idx] + g[min_idx][i]
                if (dist[i] > new_dist):
                    dist[i] = new_dist
    # print(g)
    print(f"#{tc} {dist[N]}")