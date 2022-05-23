# 에라토스테네스의 체 알고리즘
import math  # sqrt 사용 위해

n = 1000  # 2부터 n(1000)까지의 모든 수에 대하여 소수 판별
# 처음엔 모든 수가 소수(True)인 것으로 초기화(0과 1은 제외)
array = [True for _ in range(n + 1)]

# 에라토스테네스의 체 알고리즘 수행
# 2부터 n의 제곱근까지의 모든 수를 확인하며
for i in range(2, int(math.sqrt(n)) + 1):
    if array[i]:  # i가 소수인 경우
        # i를 제외한 i의 모든 배수 지우기
        j = 2
        while i * j <= n:
            array[i * j] = False
            j += 1

# 모든 소수 출력
for i in range(2, n + 1):
    if array[i]:
        print(i, end=' ')

# 시간복잡도 = 선형 시간에 가까울 정도로 매우 빠르다 O(NloglogN)
# 하지만 각 자연수에 대한 소수 여부를 저장해야 하므로 메모리가 많이 필요
# 경우에 따라 메모리 측면에서 비 효율적
