from collections import deque



def bfs(cnt, target):
    q = deque()

    # (현재 위치, 이동 횟수)
    q.append((cnt, 0))

    # 시작점 방문 처리
    visited[cnt] = 1

    while q:
        cur, steps = q.popleft()

        # 목표 도달시 step 반환
        if cur == target:
            return steps


        for d in dr:
            if d == 2:
                nr = cur * 2
            else:
                nr = cur + d


            # 범위를 체크하고 방문여부를 확인해보자
            if 0 < nr <= 1000000 and visited[nr] == 0:
                q.append((nr, steps + 1))
                visited[nr] = 1

    return 404



T = int(input())
for tc in range(1, T + 1):
    dr = [1, -1, 2, -10]
    visited = [0] * 1000001

    N, M = list(map(int, input().split()))
    res = bfs(N, M)

    print(f'#{tc} {res}')