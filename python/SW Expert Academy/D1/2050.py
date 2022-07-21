# 2050. 알파벳을 숫자로 변환 D1
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5QLGxKAzQDFAUq&categoryId=AV5QLGxKAzQDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=4

string = input()

for i in range(len(string)):
    num = ord(string[i])
    if num >= 97:
        print(num - 96, end=' ') #ord('a') == 97
    else:
        print(num - 64, end=' ') #ord('A') == 65