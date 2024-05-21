from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
  
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Declare actions variable
    wait = WebDriverWait(driver, 20)
   

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Page title is: ", driver.title)

    driver.find_element(By.XPATH,"//button[@class='ui violet button']").click()

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME,"h1"),"HELLO!"))
    matchHello = driver.find_element(By.TAG_NAME,"h1").text
    print(matchHello)

    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME,"h3"),"I'm late!"))
    match_late = driver.find_element(By.TAG_NAME,"h3").text
    print(match_late)

    driver.close()