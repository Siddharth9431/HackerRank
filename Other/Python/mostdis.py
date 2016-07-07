import math
import itertools
n = int(input())

l = []

for i in range(n) :
	q = tuple(int(x) for x in input().split())
	
	l.append(q)
	
dist = 0.000000

a = itertools.combinations(l, 2)

for i, j in a :
	temp = math.hypot(i[0] - j[0], i[1] - j[1])
	if temp > dist :
		dist = temp

print('%.6f' %dist)
