T = int(input())
for tc in range(1, T+1):
    N = int(input())
    work_hour = []
    for _ in range(N):
        start, end = map(int, input().split())
        work_hour.append( (start, end) )
    
    # work_hour asc, based on "end_time"
    work_hour.sort(key = lambda x : x[1])

    # cum_decrease
    # (start renew end)
    start = 0
    cnt = 0
    for w in work_hour:
        if (start <= w[0]):
            start = w[1]
            cnt += 1

    print(f"#{tc} {cnt}")
    # print(work_hour)