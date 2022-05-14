#1926. 간단한 369게임 D2
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

n = int(input())

game = ['3', '6', '9'] #박수치는 경우
for i in range(1, n+1):
  num = (str(i)) #각 자리에서 비교위해 문자열로 치환
  count = 0 #박수치는 횟수
  for j in range(len(num)): #숫자의 자리수 마다
    if num[j] in game: #3, 6, 9 포함여부
      count += 1 #포함하는 경우 박수 횟수 증가
  if count > 0: #3, 6, 9가 하나라도 포함된 경우
    num = '-' * count #박수 횟수 만큼 '-'
  print(num, end=' ')
