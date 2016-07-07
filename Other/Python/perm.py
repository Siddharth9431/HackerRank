from itertools import permutations

s = input().split()

a = sorted(list(s[0]))

b = int(s[1])

c = list(permutations(a,b))

for i in c :
	print("".join(i))
