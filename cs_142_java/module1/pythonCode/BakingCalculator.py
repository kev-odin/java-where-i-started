import math

cups_to_pound = 10.0 / 3.0
sugar_cups_to_pound = 1.0 / 2.0
tsp_to_ounces = 1.0 / 6.0


def bags_of_flour(cookie_count, loaf_count):
    cups_of_flour_cookie = 2.25 / 48.0
    cups_of_flour_loaf = 1.5
    bags = 1.0 / 5.0

    flour_for_cookies = cookie_count * cups_of_flour_cookie
    flour_for_loaf = loaf_count * cups_of_flour_loaf
    pounds_of_flour = convert_flour_pound(flour_for_cookies, flour_for_loaf)

    return math.ceil(pounds_of_flour * bags)


def containers_of_salt(cookie_count, loaf_count):
    tsp_of_salt_cookie = 1.0 / 48.0
    tsp_of_salt_loaf = 1.0 / 8.0
    container_per_ounce = 1.0 / 26.0

    salt_for_cookie = cookie_count * tsp_of_salt_cookie
    salt_for_loaf = loaf_count * tsp_of_salt_loaf
    ounces_of_salt = convert_tsp_ounces(salt_for_cookie, salt_for_loaf)

    return math.ceil(ounces_of_salt * container_per_ounce)


def convert_flour_pound(cookie_cup, loaf_cup):
    total_flour = cookie_cup + loaf_cup
    return total_flour / cups_to_pound


def convert_tsp_ounces(cookie_tsp, loaf_tsp):
    total = cookie_tsp + loaf_tsp
    return total * tsp_to_ounces


print(containers_of_salt(4, 4))
