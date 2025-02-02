class Fraction:
    def __init__(self, num, deno):
        self.num = num
        self.deno = deno

    def set_num(self, num):
        self.num = num

    def set_deno(self, deno):
        if deno != 0:
            self.deno = deno
        else:
            print("Denominator cannot be zero.")

    def get_num(self):
        return self.num

    def get_deno(self):
        return self.deno

    def display(self):
        print(f"{self.num}/{self.deno}")


fraction1 = Fraction(3, 4)
fraction2 = Fraction(5, 6)

fraction1.display()
fraction2.display()


fraction1.set_num(7)
fraction1.set_deno(8)
fraction1.display()
