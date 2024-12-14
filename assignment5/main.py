class OrderItem:

    def __init__(self,product,quantitie ):
        self.product = product
        self.quantitie = quantitie



class Product:
    def __init__(self,price):
        self.price=price

class Order:
    def __init__(self):
        self.status = "open"
        self.orderItems=[]

class ComputePrice:
    def total_price(self,order):
        total = 0
        for item in self.order.orderItems:
            total += item.quantitie * item.prices
        return total

class Payment:
    def pay(self):
        pass;

class DebitPayment(Payment):
    def pay(self):
        print("Processing debit payment type")
        print(f"Verifying security code: {security_code}")


class CreditPayment(Payment):
    def pay(self):
        print("Processing credit payment type")
        print(f"Verifying security code: {security_code}")







