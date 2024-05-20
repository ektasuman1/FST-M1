numlist1 = [1,2,3,4]
numlist2 = [5,6,7,8]
numlist3=[]

for item in numlist1:
    if item%2 !=0:
        numlist3.append(item)
        print(numlist3)

for item in numlist2:        
    if item%2==0:
        numlist3.append(item)
        print(numlist3)

  