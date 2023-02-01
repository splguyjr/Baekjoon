import sys

n = int(sys.stdin.readline())
s=0

for _ in range(n):
    
    op = sys.stdin.readline().split()

    if op[0] == "all":
        s = (1<<21) - 1
    elif op[0] == "empty":
        s = 0
    else:
        oper = op[0]
        num = int(op[1]) -1

        if(oper == "add"):
            s = s | (1<<num)

        elif op[0] == "remove":
            s = s & ~(1<<num)
        elif op[0] == "check":
            if(s & (1 << num) == 0):
                print(0)
            else:
                print(1)
        elif op[0] == "toggle":
            s = s ^(1<<num)
        