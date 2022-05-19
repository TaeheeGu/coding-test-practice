# 2047. 신문 헤드라인 D1
# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5QKsLaAy0DFAUq&categoryId=AV5QKsLaAy0DFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=3

string = input()

upper = ''
for char in string:
    if ord('a') <= ord(char) <= ord('z'):
        upper += chr(ord(char) - ord('a') + 65)
    else:
        upper += char
print(upper)
