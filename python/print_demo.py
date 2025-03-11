import math
import turtle as turtle
import requests
import os


print(f'{1+2-3/4*5}')
print('" \'打印。。。 \' "')
print('上一行\n下一行')
print('''   
君不见黄河之水天上来
奔流到海不复回

''')
# print(1/0)

print(math.log2(16))
# math.log2(16)
print(math.log(27, 3))
print(len('Hello World'))
print(type(1))
print(type(1.0))
print(type(True))
print(type("True"))
print(type(None))
print(type(type(None)))
print('abc'[2] == "aabc"[3])
print('abc'[2] == 'c')

strs = ['aa', 'bb', 'cc']
maps = list(map(lambda s1: s1 + "s1", strs))
print(strs)
for s1 in maps:
    print(f'{s1}-----{s1}')
a = strs.append('dd')
print(a)  # 是None

prices = [100, 300, 500, 700, 200, 400, 600]
sortd_prices = sorted(prices, reverse=True, key=lambda p: p * -1)
print(sortd_prices)
i = 0
while True:
    if i % 3 == 2 and i % 5 == 3 and i % 7 == 2:
        print('i=', i)
        i += 1
    else:
        i += 1
        if i > 10000:
            break


class Dog:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def speak(self):
        print('嗷呜')


haer = Dog('馒头', 4)
print(f'{haer.name} {haer.age}')
haer.speak()

print(ord('😄'))
# print(ord(''))

# enumerate()
# response = requests.get('https://dev-bank-rec-video.situdata.com/dist/#/login')
# print(response)
turtle.speed(100)
for i in range(500):
    turtle.fd(300)
    turtle.right(179)

with open('/Users/song/Desktop/思图材料.txt', 'r') as f:
    while True:
        rstr = f.readline()
        if rstr != '':
            print(rstr)
        else:
            break


def add(param1, param2):
    return param1 + param2


def calculate_1_param(param1, func):
    print(func(param1))


calculate_1_param(3, lambda p1: p1 * 3)
calculate_1_param(3, lambda p1: p1 ** 3)
