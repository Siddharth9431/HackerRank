a = int(input())

d = {}

for i in range (0, a) :
	b = input().split()
	d[b[0]] = sum(map(float, b[1:])) / 3 
print("%.2f" % d[input()]) 
