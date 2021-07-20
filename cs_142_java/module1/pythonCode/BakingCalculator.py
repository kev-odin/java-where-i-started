cups_to_sugar = 10.0 / 3.0
sugar_cups_to_pound = 1.0 / 2.0
tsp_to_ounces = 1.0 / 6.0

def bags_of_flour(cookie_count, loaf_count):
    flour_count = cookie_count / loaf_count
def containers_of_salt(cookie_count, loaf_count):
    salt_count = cookie_count / loaf_count
    return salt_count

print(containers_of_salt(4, 4))