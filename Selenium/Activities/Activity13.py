from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Home title is: ", driver.title)

    cols = driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Number of columns: " ,len(cols))

    rows = driver.find_elements(By.XPATH,"//table[contains(@class, 'striped')]/tbody/tr")
    print("Number of rows: " ,len(rows));

    thirdRowData = driver.find_elements(By.XPATH,"//table[contains(@class,'striped')]/tbody/tr[3]/td")
    for cell in thirdRowData:
        print("Third Row Data: ",cell.text)

    secondRowSecondData =  driver.find_element(By.XPATH,"//table[contains(@class,'striped')]/tbody/tr[2]/td[2]");
    print("Second row second data: ",secondRowSecondData.text);

    driver.close();

   