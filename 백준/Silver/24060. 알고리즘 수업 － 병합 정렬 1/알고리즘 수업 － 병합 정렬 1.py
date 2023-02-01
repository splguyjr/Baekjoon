n,save = list(map(int, input().split()))
count = 0
def mergeSort(n, s):
    h = (n+1) // 2
    m = n-h
    if (n > 1):
        u = s[:h]
        v = s[h:]
        mergeSort(h, u) #h = u의 크기
        mergeSort(m, v) #m = v의 크기
        merge(h,m,u,v,s)

def merge(h,m,u,v,s):#u,v를 합치는데 정렬시키면서 합치기
    i=0
    j=0
    k = 0
    global count
    while (i<h and j<m):
        if u[i] < v[j]:
            s[k] = u[i]
            i += 1
        else:
            s[k] = v[j]
            j +=1
        count += 1
        
        if count == save:
            print(s[k])
            return 0
        k+=1

    if(i<h):
        while(i != h):
            s[k] = u[i]
            count += 1
           
            if count == save:
                print(s[k])
                return 0
            i += 1
            k += 1
    elif(j<m):
        while(j != m):
            s[k] = v[j]
            count += 1
            
            if count == save:
                print(s[k])
                return 0
            j += 1
            k += 1
            


s = list(map(int, input().split()))
mergeSort(n,s)

if count < save:
     print(-1)