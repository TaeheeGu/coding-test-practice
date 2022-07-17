# 1204번 [S/W 문제해결 기본] 1일차 - 최빈수 구하기
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())


def sovle(grade):
    d = [0] * 101

    for i in range(1000):
        d[grade[i]] += 1  # 계수정렬

    max = 0
    result = 0
    for i in range(0, 101):
        if d[-1 - i] > max:  # 뒤에서 확인
            max = d[-1 - i]
            result = 101 - 1 - i  # 최빈수 중 최대 값의 인덱스

    return result


answer = []

for i in range(1, T + 1):
    n = int(input())
    grade = list(map(int, input().split()))
    result = sovle(grade)
    answer.append(result)

for test_case in range(1, T + 1):
    print("#{} {}".format(test_case, answer[test_case - 1]))
