phone_number = int(input())

area_code = phone_number //10000000
middle = phone_number //10000 % 1000
last_four = phone_number % 10000


print(f'({area_code}) {middle}-{last_four}')

