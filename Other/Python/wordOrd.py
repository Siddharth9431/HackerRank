from collections import OrderedDict

n = int(input())

l = OrderedDict()

for i in range(0, n) :
	a = input()
	if a in l.keys() :
		l[a] = l[a] + 1
	else :
		l[a] = 1

print(len(l.keys()))

for k in l.keys():
	print(l[k], end = ' ')



	
