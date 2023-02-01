from itertools import product
import copy 


case = [1,2,3,4]
case_lst = list(product(case, repeat = 5))
N = int(input())

board_original = [list(map(int, input().split())) for i in range(N)]

def up(board):
    for j in range(N):
        pointer = 0
        for i in range(1, N):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                # 포인터가 가리키는 수가 0일 때
                if board[pointer][j] == 0:
                    board[pointer][j] = tmp
                # 포인터가 가리키는 수와 현재 위치의 수가 같을 때
                elif board[pointer][j]  == tmp:
                    board[pointer][j] *= 2
                    pointer += 1
                # 포인터가 가리키는 수와 현재 위치의 수가 다를 때
                else:
                    pointer += 1
                    board[pointer][j] = tmp
    return board

# DOWN
def down(board):
    for j in range(N):
        pointer = N - 1
        for i in range(N - 2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[pointer][j] == 0:
                    board[pointer][j] = tmp
                elif board[pointer][j]  == tmp:
                    board[pointer][j] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[pointer][j] = tmp
    return board

# LEFT
def left(board):
    for i in range(N):
        pointer = 0
        for j in range(1, N):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][pointer] == 0:
                    board[i][pointer] = tmp
                elif board[i][pointer]  == tmp:
                    board[i][pointer] *= 2
                    pointer += 1
                else:
                    pointer += 1
                    board[i][pointer]= tmp
    return board

# RIGHT
def right(board):
    for i in range(N):
        pointer = N - 1
        for j in range(N - 2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][pointer] == 0:
                    board[i][pointer] = tmp
                elif board[i][pointer]  == tmp:
                    board[i][pointer] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[i][pointer] = tmp
    return board

# def board_up(board):
#     for i in range(N):
#         count = 0
#         for j in range(1, N):
#             if board[j][i]:
#                 temp = board[j][i]
#                 if (board[count][i] == 0): # 0일때 위로 땡기기
#                     board[count][i] = temp
#                     board[j][i] = 0
#                 elif (board[count][i] == temp): # 수가 같을 때
#                     board[count][i] *= 2
#                     board[j][i] = 0
#                     count +=1
#                 else:#수가 다를 때
#                     count +=1
#     return board

# def board_down(board):
#     for i in range(N):
#         count = N-1
#         for j in range(N-2, -1, -1):
#             if board[j][i]:
#                 temp = board[j][i]
#                 if (board[count][i] == 0): # 0일때 위로 땡기기
#                     board[count][i] = temp
#                     board[j][i] = 0
#                 elif (board[count][i] == temp): # 수가 같을 때
#                     board[count][i] *= 2
#                     board[j][i] = 0
#                     count -=1
#                 else:#수가 다를 때
#                     count -=1
#     return board


# def board_left(board):
#     for j in range(N):
#         count = 0
#         for i in range(1, N):
#             if board[j][i]:
#                 temp = board[j][i]
#                 if (board[j][count] == 0): # 0일때 위로 땡기기
#                     board[j][count] = temp
#                     board[j][i] = 0
#                 elif (board[j][count] == temp): # 수가 같을 때
#                     board[j][count] *= 2
#                     board[j][i] = 0
#                     count +=1
#                 else:#수가 다를 때
#                     count +=1
#     return board
    

# def board_right(board):
#     for j in range(N):
#         count = N-1
#         for i in range(N-2, -1, -1):
#             if board[j][i]:
#                 temp = board[j][i]
#                 if (board[j][count] == 0): # 0일때 위로 땡기기
#                     board[j][count] = temp
#                     board[j][i] = 0
#                 elif (board[j][count] == temp): # 수가 같을 때
#                     board[j][count] *= 2
#                     board[j][i] = 0
#                     count -=1
#                 else:#수가 다를 때
#                     count -=1
#     return board

def move(board, case):
    if(case==0):
        return up(board)
    elif case==1:
        return down(board)
    elif case==2:
        return left(board)
    else:
        return right(board)

def dfs(board, cnt):
    global ans
    if cnt == 5:
        for i in range(N):
            for j in range(N):
                ans = max(ans, board[i][j])
        return

    for i in range(4):
        tmp_board = move(copy.deepcopy(board), i)
        dfs(tmp_board, cnt + 1)

ans = 0
dfs(board_original, 0)
print(ans)