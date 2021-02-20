import abc

# Define the abstract classes here
from collections import Counter


class Movable(abc.ABCMeta):
    @abc.abstractmethod
    def move(cls):
        return None


class Displayable(abc.ABCMeta):
    @abc.abstractmethod
    def display(cls):
        return None


class Flyable(abc.ABCMeta):
    @abc.abstractmethod
    def fly(cls):
        return None





# Define the normal classes here

class Part(Displayable):
    # Constructor
    def __init__(self, partNo, price):
        self.__partNo = partNo
        self.__price = price

    @property
    def partNo(self):
            return self.__partNo

    @partNo.setter
    def partNo(self, partNo):
            self.__partNo=partNo

    @property
    def price(self):
            return self.__price

    @price.setter
    def price(self, price):
            self.__price=price

    def display(cls):
        return super().display()

class Machine(Part, abc.ABCMeta):
    # Constructor
    def __init__(cls, machineName, partNo, price):
        super().__init__(partNo, price)
        cls.__machineName = machineName
        cls.__parts = []

    @property
    def machineName(self):
        return self.__machineName
    @machineName.setter
    def machineName(self, machineName):
        self.__machineName=machineName
    
    # Methods here
    @abc.abstractmethod
    def doWork(cls):
        return None
    @abc.abstractmethod
    def addPart(cls, part):
        cls.__parts.append(part)
    @abc.abstractmethod
    def removePart(cls, partNo):
        cls.__parts.remove(partNo)
    @abc.abstractmethod
    def findDuplicatePart(cls):
        return Counter(cls.__parts)
    @abc.abstractmethod
    def display(cls):
        return super().display()



class MovablePart(Part, Movable):
    # Constructor
    def __init__(self, partNo, price, type):
        super().__init__(partNo, price)
        self.__type = type

    @property
    def type(cls):
        return cls.__type
    @type.setter
    def type(cls, type):
        cls.__type=type

    def move(cls):
        return super().move()



class JetFighter(Flyable):
    # Constructor
    def __init__(self, model, speed):
        self.__model = model
        self.__speed = speed

    @property
    def model(self):
        return self.__model
    @model.setter
    def model(self, model):
        self.__model=model
    
    @property
    def speed(self):
        return self.__speed
    @speed.setter
    def speed(self, speed):
        self.__speed=speed
    # Methods here
    def fly(self):
        return None

    def fly(cls):
        return super().fly()


class Robot(JetFighter, Machine):
    # Constructor
    def __init__(self, machineName, cpu, model, speed):
        JetFighter().__init__(model, speed)
        Machine().__init__(machineName)
        self.__cpu=cpu

    @property
    def cpu(self):
        return self.__cpu
    @cpu.setter
    def cpu(self, cpu):
        self.__cpu=cpu
        

    # Methods here
    def getExpensivePartsByType(cls):
        return list(Part.partNo())

    def getMovablePartsByType(cls):
        movablePart={MovablePart.type() : list(MovablePart.partNo())}

        return movablePart
    
    def fly(cls):
        pass

    def doWork(cls):
        return
    def display(cls):
        return "Machine:"+str(cls.__machineName)+"\nCPU:"+str(cls.__cpu)+"\nThis Machine has This parts\n"+"Part No:"+str(cls.__partNo)+"\nPrice"+str(cls.__price)

def main():
    robo = Robot('MTX', 'M1X', 'F-16', 1000)
    robo.addPart(Part(111, 100))
    robo.addPart(Part(222, 200))
    robo.addPart(Part(333, 300))
    robo.addPart(Part(222, 300))
    robo.addPart(MovablePart(555, 300, "TypeA"))
    robo.addPart(Part(111, 100))
    robo.addPart(Part(111, 100))
    robo.addPart(MovablePart(777, 300, "TypeB"))
    robo.display()
    print()
    print("\n Robot test flight----")
    robo.fly()
    print("\nDuplicated part list----")
    partFreq = robo.findDuplicatedParts()
    for partNo in partFreq.keys():
        print(partNo,'=>', partFreq[partNo], 'times')
    print("\nExpensive part list----")
    expensiveParts = robo.getExpensiveParts(200)
    for part in expensiveParts:
        part.display()
    print("\nMovable part list----")
    movableParts = robo.getMovablePartsByType()
    for type, parts in movableParts.items():
        print("type =", type)
        for part in parts:
            part.display()
        print()
    print("\nAsk movable to move----")
    movableParts = robo.getMovableParts()
    for part in movableParts:
        part.move()

main()