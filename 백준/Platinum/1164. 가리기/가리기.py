import sys
import copy

n, m = map(int, input().split())
x= []

for i in range (n):
    x.append(list(map(str, sys.stdin.readline().strip())))

def colorable_A(x, i, j): # x배열의 i,j를 시작점으로 A로 칠할 수 있는가
    if i + 1 < n and j + 3 < m:
        if x[i][j] != 'X':
          return False
        if x[i+1][j] != 'X':
          return False
        if x[i+1][j+1] != 'X':
          return False
        if x[i+1][j+2] != 'X':
          return False
        if x[i+1][j+3] != 'X':
          return False
        if x[i][j+3] != 'X':
          return False
        return True
        
    return False

def color_A(x, i, j): # x배열의 i,j를 시작점으로 삼아 A로 칠해주는 함수
    x[i][j] = 'A'
    x[i+1][j] = 'A'
    x[i+1][j+1] = 'A'
    x[i+1][j+2] = 'A'
    x[i+1][j+3] = 'A'
    x[i][j+3] = 'A'

    return x

def islegal (x): # BB로 칠할 수 있는지 우선 확인 후 안되면 colorable_A를 통해 확인 -> 색칠가능한 모양인지 확인
    a = copy.deepcopy(x)
    for i in range (n):
        for j in range(m):
            if a[i][j] == 'X':
                if j + 1 < m and a[i][j + 1] == 'X':
                    a[i][j] = 'B'
                    a[i][j + 1] = 'B'
                elif colorable_A(a, i, j):
                        a = color_A(a, i, j)
                else:
                    return False      
    return True

def cover_x(x): 
    if islegal(x) == False:
        return False

    else:
        for i in range(n):
            for j in range(m):
                if colorable_A(x, i, j):
                    a = copy.deepcopy(x)
                    if islegal(color_A(a, i, j)): # A로 칠해도 여전히 legal인지 확인
                        x = color_A(x, i , j)
        for i in range(n): #남은 X는 모두 B로 칠해야함.
            for j in range(m):
                if x[i][j] == 'X':
                    x[i][j] = 'B'
        return x

def print_x(x):
    for i in range(n):
            for j in range(m):
                print(x[i][j], end ='')
            print()

temp = cover_x(x)
if temp:
    print_x(x)
else:
    print(-1)