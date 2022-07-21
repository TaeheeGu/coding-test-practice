# 1974. 스도쿠 검증 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5Psz16AYEDFAUq&categoryId=AV5Psz16AYEDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3&problemLevel=1%2C2%2C3&&&&&&&&&

#정답일 경우 1, 오답일 경우 0

T = int(input())

result = []
for t in range(T):
    testcase = []
    for _ in range(9):
        arr = list(map(int, input().split()))
        testcase.append(arr)
    verify = 1
    breaker = False
    for i in range(9):
        row_verify = [] #가로 검증
        col_verify = [] #세로 검증
        box_verify = [] #3*3 박스 검증
        for j in range(9):
            if testcase[i][j] not in row_verify and \
                    testcase[j][i] not in col_verify and \
                    testcase[i//3 * 3 + j % 3][i//3 * 3 + j//3] not in box_verify:
                row_verify.append(testcase[i][j])
                col_verify.append(testcase[j][i])
                box_verify.append(testcase[i//3 * 3 + j % 3][i//3 * 3 + j//3]) #3*3 box를 차례로 검사하기 위한 인덱스 접근
            else:
                verify = 0 #한번이라도 틀리면 더 이상 검사할 필요 없다.
                breaker = True
                break
        if breaker: #이중 반복문 탈출
            break
    result.append(verify)

for t in range(T):
    print("#{} {}".format((t+1), result[t]))
