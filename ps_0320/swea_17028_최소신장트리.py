# 대장 찾기
def find_set(x):
    if x == parents[x]:
        return x

    # 경로 압축
    parents[x] = find_set(parents[x])
    return parents[x]


# 인수합병
def union(x, y):
    ref_x = find_set(x)
    ref_y = find_set(y)

    # 대장이 같다면 그냥 패스
    if ref_x == ref_y:
        return

    # 보통은 속국이 대국에 흡수되는게 맞지만, 우리가 구하는건 최소값이니 반대로 작성한다
    if ref_x < ref_y:
        parents[ref_y] = ref_x
    elif ref_x > ref_y:
        parents[ref_x] = ref_y




T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())
    edges = []
    for _ in range(E):
        n1, n2, w = list(map(int, input().split()))

        # 간선에 대한 정보들을 저장하겠다
        edges.append( (n1, n2, w) )

    # 가중치 기준으로 asc
    edges.sort(key = lambda x : x[2])

    # make_set (정점을 기준으로 만들어진다)
    parents = [i for i in range(V+1)]

    # 현재까지 선택한 간선의 수
    E_cnt = 0
    # MST 가중치의 합
    cumSum_weight = 0

    for u, v, w in edges:
        # u와 v가 연결이 안되어있으면 선택
        # == 다른 집합이라면
        if find_set(u) != find_set(v):
            union(u, v)
            E_cnt += 1
            cumSum_weight += w

            # 모든 노드 번호까지 다 돌았으면 그만 나아가고 종료해뻐리
            if E_cnt == V:
                break

    print(f'#{tc} {cumSum_weight}')