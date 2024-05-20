user1 = input("Enter User 1 input :");
user2 = input("Enter User 2 input :");

print(user1,user2)

if(user1 == user2):
    print("Its a Tie")
elif user1 == 'rock':
    if user2 == 'scissors':
        print("User1 Won")
    else:
        print("User2 Won")
elif user1 == 'paper':
    if user2 == 'rock':
        print("User1 Won")
    else:
        print("User2 Won") 
elif user1 == 'scissors':
    if user2 == 'paper':
        print("User1 Won")
    else:
        print("User2 Won")
else:
    print("Invalid Input")