
mod = 1000000007

def squareSubSeq(a, b):
	m = len(a)
	n = len(b)
	
	DP = [[0 for x in range(n)] for x in range(m)]
	
	DP[0][0] = 1 if a[0] == b[0] else 0
	
	for i in range(1, n):
		DP[0][i] = DP[0][i - 1] + (1 if a[0] == b[i] else 0)
		DP[0][i] = DP[0][i] % mod
		
			
			
	for i in range(1, m):
		DP[i][0] = DP[i - 1][0]
		DP[i][0] = DP[i][0] % mod
		
	for i in range(1, m):
		for j in range(1, n):
			
			DP[i][j] = DP[i - 1][j] + DP[i][j - 1] + (0 if a[i] == b[j] else -DP[i - 1][j - 1])
			DP[i][j] = DP[i][j] % mod
	return DP[m - 1][n - 1]

def subStrings(s):
	l = len(s)
	A = 0
	
	for i in range(1, l):
		A = A + squareSubSeq(s[i:], s[:i])
		A = A % mod
	return A
	
T = int(input())

for k in range(T):
	print(subStrings(input()))
