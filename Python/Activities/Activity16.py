class Car:
    'This car represent Car details'

    def __init__(self,manufacturer, model, make, transmission, color) :
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer +" "+self.model+"has started moving")

    def stop(self):
        print(self.manufacturer +" "+self.model+"has stopped moving")
        
car1 = Car ("Toyoto","gg","2023","23","34")
car2 = Car ("Maruti","gg","2023","23","34")
car3 = Car ("Suzuki","gg","2023","23","34")

car1.accelerate()
car1.stop()