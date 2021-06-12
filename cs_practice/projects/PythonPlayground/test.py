def summation(n, term):
    total, k = 0, 1
    while k <= n:
        total, k = total + term(k), k + 1
    return total

def identity(x):
    return x

def square(x):
    return x * x
    
def sum_naturals(n):
    return summation(n, identity)

def pi_term(x):
    return 8 / ((4*x-3) * (4*x-1))

def pi_sum(n):
    return summation(n, pi_term)

for x in range(0, 10):
    if x % 2 == 0:
        print(x)
    else:
        print("haha")

class Iterable(object):

    def __init__(self, values):
        self.values = values
        self.location = 0

    def __iter__(self):
        return self

    def next(self):
        if self.location == len(self.values):
            raise StopIteration
        value = self.values[self.location]
        self.location += 1
        return value

def main():
    print("Hello World")

main()
