# def dfs(depth, max_depth):
#     global res
#     cur = int(''.join(map(str, num_lst)))
#     # print(type(cur))

#     if (cur, depth) in visited:
#         return
#     visited.add( (cur, depth) )

#     if depth == max_depth:
#         res = max(res, cur)
#         return

#     for i in range(len(num_lst)):
#         for j in range(i+1, len(num_lst)):
#             num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
#             dfs(depth+1, max_depth)
#             num_lst[i], num_lst[j] = num_lst[j], num_lst[i]




# T = int(input())
# for tc in range(1, T+1):
#     String_num, String_cnt = input().split()
#     cnt = int(String_cnt)
#     num_lst = list(String_num)

#     # print(cnt)
#     # print(num_lst)

#     res = 0
#     visited = set()
#     dfs(0, cnt)
#     print(f"#{tc} {res}")











# 백트랙킹


def change(cnt, num):
    # 전역 선언 --> 최댓값
    global maxN

    # 중복 방지 lst
    if num in lst[cnt]:
        return
    lst[cnt].append("".join(numbers))

    # 최대 깊이 도달 ( maxN vs int(num) )
    if cnt == C:
        maxN = max(maxN, int(num))
        return

    # 2중 반복문
    for i in range(N-1):
        for j in range(i+1, N):
            numbers[i], numbers[j] = numbers[j], numbers[i]
            change(cnt+1, "".join(numbers))
            numbers[i], numbers[j] = numbers[j], numbers[i]




# test case
T = int(input())
for tc in range(1, T+1):

    # 문자열
    num, C = input().split()
    C = int(C)
    numbers = list(num)
    N = len(num)

    # 최대값
    maxN = 0

    # 중복 방지용 lst
    lst = [ [] for _ in range(C+1) ]

    # 교환횟수 0부터 시작
    change(0, "".join(numbers))

    # 출력
    print(f"#{tc} {maxN}")