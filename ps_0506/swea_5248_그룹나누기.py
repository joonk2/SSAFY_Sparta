# def find(x):
#     if parents[x] != x:
#         parents[x] = find(parents[x])
#     return parents[x]

# def union(x,y):
#     boss_x = find(x)
#     boss_y = find(y)
#     if boss_x != boss_y:
#         parents[boss_y] = boss_x



# T = int(input())
# for tc in range(1, T+1):
#     N, M = map(int, input().split())
#     data = list(map(int, input().split()))
    
#     # parents = []
#     # for i in range(1, N+1):
#     #     parents.append(i)
#     parents = [i for i in range(N+1)]
#     # print(parents)

#     for i in range(0, M*2, 2):
#         a = data[i]
#         b = data[i+1]
#         union(a,b)

#     group = set()
#     for i in range(1, N+1):
#         group.add(find(i))

#     print(f"#{tc} {len(group)}")











def find_set(x):
	while rep[x] != x:
		x = rep[x]
	return x


def union(x,y):
	rep[find_set(y)] = find_set(x)



T = int(input())
# test case
for tc in range(1, T+1):
	# N, M
	N, M = list(map(int, input().split()))
	
	# arr
	arr = list(map(int, input().split()))
	
	# rep
	rep = [i for i in range(N+1)]
	
	
	# M만큼 n1, n2 반복 할당하고 union
	for i in range(M):
		n1 = arr[i*2]
		n2 = arr[i*2 + 1]
		union(n1, n2)
	
	# i가 어떤 집합의 대표에 속하면 cnt++
	cnt = 0
	for i in range(1, N+1):
		if rep[i] == i:
			cnt += 1
	
	print(f"#{tc} {cnt}")
