def comb(arr, num):
    ans = []
    ## 정의된 값인지 확인한다.
    if num > len(arr):
        return ans
    ## Base Case
    if num == 1:
        for a in arr:
            ans.append([a])
    ## General Case
    elif num > 1:
        for a in range(len(arr) - num + 1):  ## i가 시작하는 값 - len(arr) - (n-1)이고 이 때 n은 lst로부터 추출할 개수와 같다.
            for temp in comb(arr[a + 1:], num - 1):
                ans.append([arr[a]] + temp)

    return ans