dr = [-1,1,0,0]
dc = [0,0,-1,1]




def recur(r, c, number):
    # 7자리가 되면 종료
    if len(number) == 7:
        res.add(number)
        return

    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]

        # 범위 밖이면 continue
        if nr < 0 or nr >= 4 or nc < 0 or nc >= 4:
            continue

        # 다음 위치를 추가하며 진행
        recur(nr, nc, number + matrix[nr][nc])






T = int(input())
for tc in range(1, T+1):

    # 4x4 격자판
    matrix = [input().split() for _ in range(4)]
    res = set()

    for y in range(4):
        for x in range(4):
            recur(y, x, matrix[y][x])

    print(f'#{tc} {len(res)}')