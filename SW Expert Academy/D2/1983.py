# 1983. 조교의 성적 매기기 D2
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PwGK6AcIDFAUq&categoryId=AV5PwGK6AcIDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

T = int(input())

result = []
for i in range(T):
    n, k = map(int, input().split())
    student = []
    grade = [''] * n
    grades = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

    for j in range(n):
        middle, final, homework = map(int, input().split())
        score = middle * 0.35 + final * 0.45 + homework * 0.2
        student.append((j, score)) #학생번호 0 ~ (n-1) 인덱스 사용 주의
    student.sort(key=lambda x: x[1], reverse=True) #람다식 주의, 성적 내림차순 정렬

    for j in range(1, 11):
        for x in range(n//10*(j-1), n//10*j): #반복문 사용시 내부 변수 명 주의
            grade[student[x][0]] = grades[j-1]

    result.append(grade[k-1]) #인덱스에 주의

for i in range(T):
    print("#{} {}".format((i+1), result[i]))

