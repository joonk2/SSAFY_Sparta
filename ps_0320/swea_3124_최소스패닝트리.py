"""
[내가 했던 실수]
-> x가 대국(parents)일때 x를 반환해야했는데
x == find_set(x)라고 했기에 오류가 냈었던 거임
"""


# 대장 찾기
def find_set(x):
    if x == parents[x]:
        return x

    # 경로 압축
    parents[x] = find_set(parents[x])
    return parents[x]



# 인수 합병
def union(x, y):
    boss_x = find_set(x)
    boss_y = find_set(y)

    # 대장이 같다면 패스
    if boss_x == boss_y:
        return

    # 원래 속국이 대국에 흡수되야하는게 맞지만 여기서는 최솟값을 구해야하니
    # 반대로 적어보자
    if boss_x < boss_y:
        parents[boss_y] = boss_x
    elif boss_x > boss_y:
        parents[boss_x] = boss_y








T = int(input())
for tc in range(1, T+1):
    # V : 정점의 갯수
    # E : 간선의 갯수
    V, E = list(map(int, input().split()))

    # 엣지
    edges = []
    for _ in range(E):
        A, B, C = list(map(int, input().split()))

        # 간선에 대한 정보를 저장하겠다
        edges.append( (A,B,C) )

    # 가중치를 기준으로 정렬해보겠다
    edges.sort(key = lambda x : x[2])

    # 정점을 기준으로 만들어보자
    parents = [i for i in range(V+1)]

    # 현재까지 선택한 간선의 수
    E_cnt = 0

    # MST 가중치 합
    cumSum_weight = 0

    for u, v, w in edges:
        # u와 v가 연결 안되어있다면 연결해라
        if find_set(u) != find_set(v):
            union(u, v)

            E_cnt += 1
            cumSum_weight += w

            # 모든 노드 번호까지 다 돌았으며 그만 탐색하고 종료해뿌리
            if E_cnt == V:
                break


    print(f'#{tc} {cumSum_weight}')