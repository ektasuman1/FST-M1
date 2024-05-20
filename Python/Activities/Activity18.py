import pandas


dataframe = pandas.read_csv('credential.csv')

print(dataframe["Usernames"])
print(dataframe["Usernames"][1]+"|"+dataframe["Passwords"][1])
print(dataframe.sort_values("Usernames"))
print(dataframe.sort_values("Passwords", ascending=False))