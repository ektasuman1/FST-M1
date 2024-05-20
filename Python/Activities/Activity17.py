import pandas


data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "All Might"],
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)
print(dataframe)
# Write the data to a csv file
dataframe.to_csv("credential.csv", index=False)