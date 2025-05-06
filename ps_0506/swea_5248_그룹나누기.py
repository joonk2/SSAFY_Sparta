def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def union(x,y):
    boss_x = find(x)
    boss_y = find(y)
    if boss_x != boss_y:
        parents[boss_y] = boss_x



T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    data = list(map(int, input().split()))
    
    # parents = []
    # for i in range(1, N+1):
    #     parents.append(i)
    parents = [i for i in range(N+1)]
    # print(parents)

    for i in range(0, M*2, 2):
        a = data[i]
        b = data[i+1]
        union(a,b)

    group = set()
    for i in range(1, N+1):
        group.add(find(i))

    print(f"#{tc} {len(group)}")