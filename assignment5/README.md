
# SRP violation
### class Order are doing many things are same time and can be modify for many reasons

# OCP violation
### code is not close for modification
~~~python
    def pay(self, payment_type, security_code):
        if payment_type == "debit":
            print("Processing debit payment type")
            print(f"Verifying security code: {security_code}")
            self.status = "paid"
        elif payment_type == "credit":
            print("Processing credit payment type")
            print(f"Verifying security code: {security_code}")
            self.status = "paid"
        else:
            raise Exception(f"Unknown payment type: {payment_type}")
~~~
# SRP Solution
~~~python
class ProductItem:

    def __init__(self,product,quantities ):
        self.product = product
        self.quantities = quantities


class Product:
    def __init__(self,price):
        self.price=price

class Order:
    def __init__(self):
        self.status = "open"
        self.productItems=[]

    def add_item(self,productItem):
        self.productItems.append(productItem)

class ComputePrice:
    def total_price(self,order):
        total = 0
        for item in order.productItems:
            total += item.quantities * item.product.prices
        return total
~~~
# OCP Solution
~~~python
class Payment:
    def pay(self,security_code):
        pass

class DebitPayment(Payment):
    def pay(self,security_code):
        print("Processing debit payment type")
        print(f"Verifying security code: {security_code}")


class CreditPayment(Payment):
    def pay(self,security_code):
        print("Processing credit payment type")
        print(f"Verifying security code: {security_code}")

~~~
