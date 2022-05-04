#1244번 [S/W 문제해결 응용] 2일차 - 최대 상금
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

t = int(input())

answer = []

for i in range(t):
  board, count = map(int, input().split())

#앞의 자리부터 최대 값과 교환 필요
#최대값이 여러개 존재하는 경우 조합으로 검사?

