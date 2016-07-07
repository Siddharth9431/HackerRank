
N = int(input())

L = [int(x) for x in input().split()]

temp = int(L[N - 1] // 2) + L[N - 1] % 2 

for i in range(N - 2, -1, -1):
	temp = int((L[i] + temp) // 2) + (L[i] + temp) % 2 
	
	
print(temp)
