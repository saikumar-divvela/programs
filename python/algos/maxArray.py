def max_subarray(A):
    max_ending_here = max_so_far = 0
    for x in A:
        max_ending_here = max(0, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far


#A=[-1,-2,3]
A= [-2,1,-3,4,-1,2,1,-5,4,12]
#A=[-1,-2,0,4,-3]
print (max_subarray(A))
print('hello')
