"""
[idea]
back_tracking && DP
 
- bus starts to move after once of energy charging
 
 
[input & output]
3
5 2 3 1 1
10 2 1 3 2 2 5 4 2 1
10 1 1 2 1 2 2 1 2 1
 
#1 1
#2 2
#3 5
"""
 
 
def bus_way(idx, battery, cnt, memo):
    global min_cnt
 
    # 현재 충전횟수가 최소값보다 크면 중단
    if cnt >= min_cnt:
        return
 
    # dp 테이블 갱신
    memo[idx][battery] = cnt
 
    # 종점에 도착했을 때 최소 충전 횟수 갱신
    # 첫 정류장에서 충전을 했기에 min_cnt -1 을 진행한다
    if idx >= number_of_bus_stop-1:
        min_cnt = min(min_cnt, cnt)
        return
 
 
    # 먼 거리부터 탐색해 최적의 경로 찾자
    # 현재 위치에서 베터리 용량만큼 이동해본다 (처음 idx 0은 충전해줬으니 차감했다)
    for move in range(1, battery + 1):
        next_idx = idx + move
 
        if next_idx >= number_of_bus_stop:
            continue
            # min_cnt = min(min_cnt, cnt+1)
            # return
 
        # 충전 후 이동
        bus_way(next_idx, bus_line[next_idx], cnt+1, memo)
 
 
 
 
 
 
 
T = int(input())
for tc in range(1, T+1):
    bus_line = list(map(int, input().split()))
 
 
 
    # 버스 정류장 갯수
    number_of_bus_stop = bus_line.pop(0)
 
    # dp
    # DP 테이블 초기화
    dp = [[float('inf')] * (max(bus_line) + 1) for _ in range(number_of_bus_stop)]
 
    # 종착지엔 충전지가 없으니 arr 길이 맞춰준다
    # 0 추가해서 bus_line.length() == 버스 정류장 갯수
    bus_line += [0]
 
    min_cnt = float('inf')
 
    # 출발지에서 충전후 출발
    bus_way(0, bus_line[0], 0, dp)
 
 
 
    # ------------------- debug ------------------
 
    # 이미 처음 출발할 때 충전이 이루어졌기에 cnt-1
    print(f'#{tc} {min_cnt - 1}')
    # print(bus_line)
