
num = [20,12,3,1]


# sorting the numbers
for i in range(0,len(num)-1) :
    for j in range (1,len(num)-i):
        print(j-1,j)    
        if num[j-1] > num[j]:  # swap
            temp = num[j-1]
            num[j-1] = num[j]
            num[j] = temp
        print (num)    
    print(' round done')
    

