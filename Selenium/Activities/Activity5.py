from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
  
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Declare actions variable
    actions = ActionChains(driver)

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/input-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Perform a LEFT CLICK action
    actions.click().pause(5).perform()
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after left click: ", active_side.text)
    
    
    actions.double_click().pause(10).perform() 
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after double click: ", active_side.text)

    actions.context_click().pause(5).perform()
    active_side = driver.find_element(By.CLASS_NAME, "active")
    print("Active side number after right click: ", active_side.text)    
    driver.close()