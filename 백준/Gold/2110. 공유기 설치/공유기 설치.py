n, c = map(int, input().split())

loc = []
for i in range(n):
    loc.append(int(input()))

loc.sort()

start =1
end = loc[-1]-loc[0]
ans =1 
def binary_search(arr, start, end):
    
    while start <= end:
        temp = arr[0]
        cnt = 0
        mid = (start + end)//2

        for i in range(1, len(arr)):   
            if(arr[i]- temp >= mid):
                temp = arr[i]
                cnt= cnt +1

        if(cnt < c-1):
            end = mid-1

        else:
            ans = mid
            start = mid +1

    print(ans)

binary_search(loc, start, end)    
