from itertools import product

a = list(int(x) for x in input().split())

b = list(int(x) for x in input().split())

c = list(product(a,b))

for i, j in c :
	print('(%d, %d)' %(i, j), end = ' ')


