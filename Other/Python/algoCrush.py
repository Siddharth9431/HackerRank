n, m = map(int, input().split(' '))

l = [0] * (n + 2)

for _ in range(m):
	a, b, k = map(int, input().split(' '))
	
	l[a] = l[a] + k
	l[b + 1] = l[b + 1] - k
	
x = 0
y = 0

for i in range(1, n + 1):
	x = x + l[i]
	y = max(y, x)

print(y)
