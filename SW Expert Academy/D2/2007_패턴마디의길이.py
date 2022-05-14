# 2007. 패턴 마디의 길이 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

T = int(input())

testcase = []
for i in range(T):
    testcase.append(input())

for i in range(T):
    test = testcase[i]
    pattern = test[0]
    end_point = 1
    while True:
        if pattern == test[len(pattern):len(pattern) * 2]: # 패턴 유효성 검사
            break
        pattern = test[:end_point] # 패턴 정의
        end_point += 1
    print("#{} {}".format((i+1), len(pattern)))