T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    workHour = []

    for _ in range(N):
        s, e = list(map(int, input().split()))
        workHour.append((s, e))

    # 업무시간을 끝나는 시간으로 오름차순 정렬
    workHour.sort(key=lambda x: x[1])

    # ----- 비교 -----
    # start가 시작시간보다 작으면 start를 끝내는 시간으로 최신화
    start = 0;
    cnt = 0;
    for w in workHour:
        if start <= w[0]:
            start = w[1]
            cnt += 1

    print(f'#{tc} {cnt}')