import sys

input = sys.stdin.readline

survey = input().split()
choices = list(map(int, input().split()))

def solution(survey, choices):
    answer = ''
    mbti_arr = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    point_arr = [0]*8
    mbti_string = ''
    for i in range(len(survey)):
        if choices[i] <= 3:
            mbti = survey[i][0]
            point = 4 - choices[i]
        if choices[i] >= 5:
            mbti = survey[i][1]
            point = choices[i] - 4
        if choices[i] == 4:
            continue
        mbti_string += mbti * point
    
    for i in range(len(mbti_string)):
        for j in range(len(mbti_arr)):
            if mbti_arr[j] == mbti_string[i]:
                point_arr[j] += 1

    for i in range(0, len(point_arr), 2):
        if point_arr[i] >= point_arr[i+1]:
            answer += mbti_arr[i]
        else:
            answer += mbti_arr[i+1]

    return answer