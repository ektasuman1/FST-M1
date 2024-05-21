from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/target-practice")
   
    print("Home title is: ", driver.title)

    thirheader = driver.find_element(By.XPATH,"//h3[@class='ui yellow header']")
    print("Third Header: ",thirheader.text)
    fifthheader=driver.find_element(By.XPATH,"//h5[@class='ui green header']").value_of_css_property('color')
    print("Fifth Header: ",fifthheader)
    violet_button = driver.find_element(By.CLASS_NAME, "violet")
    print("Violet button's classes are: ", violet_button.get_attribute("class"))

    greytext = driver.find_element(By.CLASS_NAME,"grey")
    print("Grey text: ", greytext.text)

    driver.close()





