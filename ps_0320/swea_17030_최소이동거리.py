"""
[사용한 알고리즘]
dijkstra

3
2 3
0 1 1
0 2 6
1 2 1
4 7
0 1 9
0 2 3
0 3 7
1 4 2
2 3 8
2 4 1
3 4 8
4 6
0 1 10
0 2 7
1 4 2
2 3 10
2 4 3
3 4 10
"""




def dijikstra(start_node):
    # (누적거리, 노드번호)
    pq = [(0, start_node)]

    # 각 정점까지의 최단거리를 저장할 lst
    dists = [int(21e8)] * (N+1)

    # 시작노드 최단거리는 0
    dists[start_node] = 0

    while pq:
        cur_dist, cur_node = heapq.heappop(pq)

        # 이미 더 작은 경로로 온 적이 있다면 지나친다
        if cur_dist < dists[cur_node]:
            continue

        for next_info in graph[cur_node]:
            # 다음 노드로 가기 위한 가중치
            next_dist = next_info[0]
            # 다음 노드 번호
            next_node = next_info[1]

            # 다음 노드로 가기 위한 누적 거리
            new_dist = cur_dist + next_dist

            # 이미 같은 가중치거나, 더 작은 가중치로 온 적이 있다면 지나친다
            if dists[next_node] <= new_dist:
                continue

            # next_node까지 도착하는데 비용은 new_dist
            dists[next_node] = new_dist
            heapq.heappush(pq, (new_dist, next_node))

    return dists[N]






from heap import heappop, heappush
T = int(input())
for tc in range(1, T+1):
    # 마지막 연결지점 번호(노드 수)
    # 도로의 갯수 (간선 수)
    N, E = list(map(int, input().split()))
    start_node = 0

    # adj_lst
    graph = [ [] for _ in range(N+1) ]

    for _ in range(E):
        s, e, w = list(map(int, input().split()))
        graph[s].append( (w, e) )

    short_cut = dijikstra(0)
    print(f'#{tc} {short_cut}')