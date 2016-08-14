from collections import deque
import math
import time
import gc

class BigObject:
    def __init__(self):
        self.value = 0
        self.list = deque()
    def push(self):
        self.list.append(float(self.value))
        self.value += 1
    def pop(self):
        self.list.popleft()
    def sum(self):
        s = 0.0
        for i in self.list:
            s += math.sin(i) - math.log(math.fabs(i+1.0)) + math.pow(3.0, i)
        return s

n = 5000000
s = []
result = 0.0
time_start = time.time()

for i in range(0, n):
    s.append(BigObject())
for i in range(0, n):
    for j in range(0, 10):
        s[i].push()
    for j in range(0, 9):
        s[i].pop()
    result += s[i].sum()

s = []
gc.collect()
time_end = time.time()
print("Finished")
input()
print("Time: " + str(time_end - time_start))
