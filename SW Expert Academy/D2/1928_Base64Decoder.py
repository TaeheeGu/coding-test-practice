#1928. Base64 Decoder D2
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5PR4DKAG0DFAUq&categoryId=AV5PR4DKAG0DFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=2

#라이브러리 사용 없이 구현
T = int(input())

testcase = []

for i in range(T):
  testcase.append(input())
  
encoding_64 = [] #인토딩 표 생성
for i in range(26):
  encoding_64.append(chr(65+i)) #아스키 코드 > 문자
for i in range(26):
  encoding_64.append(chr(ord('a')+i)) #문자 > 아스키 코드 > 문자
for i in range(10):
  encoding_64.append(str(i))
encoding_64.append('+')
encoding_64.append('/')

for i in range(T):
  test = testcase[i]
  ascii_bit = ''
  result = ''
  
  for j in range(len(test)):
    bit = encoding_64.index(test[j]) #해당 원소의 인덱스
    bit = str(bin(bit))[2:] #'0b' 제거
    
    while len(bit) < 6: #길이에 맞춰 0 삽입
      bit = '0' + bit
      
    ascii_bit += bit

  for j in range(0, len(ascii_bit), 8): #8자리(1바이트)씩
    result += chr(int('0b' + ascii_bit[j:j+8], 2)) #이진수을 10진수로, 10진수(아스크코드)를 문자로
  print("#{} {}".format((i+1), result))


# 라이브러리 사용
from base64 import b64decode

T = int(input())

testcase = []

for i in range(T):
  testcase.append(input())
    
for i in range(T):
  test = testcase[i]
  result = b64decode(test).decode('UTF-8')

  print("#{} {}".format((i+1), result))