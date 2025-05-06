def dfs(depth, max_depth):
    global res
    cur = int(''.join(map(str, num_lst)))
    # print(type(cur))

    if (cur, depth) in visited:
        return
    visited.add( (cur, depth) )

    if depth == max_depth:
        res = max(res, cur)
        return

    for i in range(len(num_lst)):
        for j in range(i+1, len(num_lst)):
            num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
            dfs(depth+1, max_depth)
            num_lst[i], num_lst[j] = num_lst[j], num_lst[i]




T = int(input())
for tc in range(1, T+1):
    String_num, String_cnt = input().split()
    cnt = int(String_cnt)
    num_lst = list(String_num)

    # print(cnt)
    # print(num_lst)

    res = 0
    visited = set()
    dfs(0, cnt)
    print(f"#{tc} {res}")