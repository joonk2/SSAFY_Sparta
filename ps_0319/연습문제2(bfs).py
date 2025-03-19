"""
[input]
7 8
1 2
1 3
2 4
2 5
4 6
5 6
6 7
3 7

[output]
1 3 7 6 5 2 4
"""



def bfs(start_node):
    # q에 들어가는 노드들의 의미 : 다음에 방문해야 할 노드들(대기열)
    q = [start_node]


    while q:
    # 1. 가장 앞에 있는 노드를 넣는다
    # 2. 해당 노드에서 갈 수 있는 노드들을 queue에 넣는다

        now = q.pop(0)
        print(now, end = ' ')

        # 인접한 노드들을 확인하면서
        for next_node in graph[now]:
            # 방문했으면 pass
            if visited[next_node]:
                continue
            elif visited[next_node] == False:
                visited[next_node] = True
                q.append(next_node)



N, M = list(map(int, input().split()))
graph = [ [] for _ in range(N+1) ]
visited = [0] * (N+1)

for _ in range(M):
    s,e = list(map(int, input().split()))
    graph[s].append(e)
    graph[e].append(s)