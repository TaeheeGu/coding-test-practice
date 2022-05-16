# 1215. [S/W 문제해결 기본] 3일차 - 회문1 D3
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV14QpAaAAwCFAYi&categoryId=AV14QpAaAAwCFAYi&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

T = 10

result = []
for i in range(T):
    length = int(input())
    testcase = []
    for _ in range(8):
        testcase.append(input())

    count = 0
    for i in range(8):
        for j in range(8 - length + 1): #검사 할 인덱스 주의
            #가로 검사
            string = testcase[i][j:j+length] #가로의 경우 슬라이싱
            if string == string[::-1]: #문자열 역순
                count += 1
            #세로 검사
            string = ''
            for k in range(length):
                string += testcase[j + k][i] #세로의 경우 row 인덱스와 col 인덱스 주의
            if string == string[::-1]:
                count += 1

    result.append(count)

for i in range(T):
    print("#{} {}".format((i+1), result[i]))