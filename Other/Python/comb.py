from itertools import combinations

s = input().split()

a = sorted(list(s[0]))

b = int(s[1])

i = 1

while i <= b :
	for j in list(combinations(a, i)) :
		print("".join(j))
	i = i + 1
