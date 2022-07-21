# 1289. 원재의 메모리 복구하기 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

T = int(input())

result = []
for t in range(T):
    memory = input()

    init = '0'*len(memory)

    count = 0
    for i in range(len(memory)):
        if memory[i] != init[i]:
            init = init[:i] + memory[i]*(len(memory) -i)
            count += 1

    result.append(count)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))
