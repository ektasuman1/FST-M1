from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
  
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

 
    print("Page title is: ", driver.title)

    actions = ActionChains(driver)

    # Perform all action in line is done using ActionChains directly
    actions.send_keys("E").key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()

    driver.close()