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

print(sum_naturals(10))
print(summation(10, square))
print(pi_sum(1e6))