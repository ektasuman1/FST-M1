from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
  
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Declare actions variable
    wait = WebDriverWait(driver, 20)
   
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)

    textbox = driver.find_element(By.ID, "input-text")
   
    textbox_toggle = driver.find_element(By.ID, "toggleInput")
    
    print("Text box is enabled: ", textbox.is_enabled())
   
    textbox_toggle.click()
    
    print("Text box is enabled: ", textbox.is_enabled())
    textbox.send_keys("Hello")

    driver.close()