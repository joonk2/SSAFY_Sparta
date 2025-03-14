# --------------------- BruteForce -------------------------


def recur(month, total_cost):
    global min_answer
    if month > 12:
        min_answer = min(min_answer, total_cost)
        return

    # 1일 이용권으로 다 사는 경우
    recur(month + 1, total_cost + (days[month] * cost_day))

    # 1달 이용권 사는 경우
    recur(month + 1, total_cost + cost_month)

    # 3달 이용권 사는 경우
    recur(month + 3, total_cost + cost_month3)

    # 1년 이용권 사는 경우
    recur(month + 12, total_cost + cost_year)

T = int(input())
for tc in range(1, T+1):
    cost_day, cost_month, cost_month3, cost_year = map(int, input().split())

    # 12개월 이용 계획
    days = [0] + list(map(int, input().split()))
    min_answer = int(12e8)

    # 1월부터 시작
    recur(1, 0)
    print(f'#{tc} {min_answer}')
