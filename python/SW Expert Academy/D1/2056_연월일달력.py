#2056번 연월일 달력
#https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&problemLevel=2&problemLevel=3&contestProbId=AV5QLkdKAz4DFAUq&categoryId=AV5QLkdKAz4DFAUq&categoryType=CODE&problemTitle=&orderBy=RECOMMEND_COUNT&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1

T = int(input())

testcase = []

for i in range(T):
  testcase.append(input())

thirty = ['04', '06', '09', '11']
thirty_one = ['01', '03', '05', '07', '08', '10', '12']

days = []
for i in range(1, 32):
  day = ''
  if i < 10:
    day += '0' + str(i)
    days.append(day)
  else:
    day = str(i)
    days.append(day)
    

for i in range(T):
  year = testcase[i][:4]
  month = testcase[i][4:6]
  day = testcase[i][6:8]
  result = year+'/'+month+'/'+day
  
  if month not in thirty and month not in thirty_one and month != '02':
    result = '-1'
  elif month in thirty:
    if day not in days[:31]:
      result = '-1'
  elif month in thirty_one:
    if day not in days:
      result = '-1'
  elif month == '02':
    if day not in days[:29]:
      result = '-1'
      
  print("#%d %s"%((i+1), result))
  
    