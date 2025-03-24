"""
3
4 47FE
5 79E12
8 41DA16CD
"""

hexademical_to_binary = {
    '1' : 1,
    '2' : 2,
    '3' : 3,
    '4' : 4,
    '5' : 5,
    '6' : 6,
    '7' : 7,
    '8' : 8,
    '9' : 9,
    'A' : 10,
    'B' : 11,
    'C' : 12,
    'D' : 13,
    'E' : 14,
    'F' : 15
}

T = int(input())
for tc in range(1, T+1):
    N, hexadecimal = input().split()
    N = int(N)
    res = ""
    for i in hexadecimal:
        decimal = hexademical_to_binary[i]
        binary = ""


        for j in range(3,-1,-1):
            if (decimal & (1<<j)):
                binary += "1"
            else:
                binary += "0"

        res += binary

    print(f'#{tc} {res}')
