import numpy

def match(grid, pattern):
	for i in range(len(grid) - len(pattern) + 1):
		if pattern[0] in grid[i]:
			temp = grid[i].index(pattern[0])
			temp = temp, temp + len(pattern[0])
			
			for j in range(len(pattern)):
				if pattern[j] != grid[i + j][temp[0] : temp[1]]:
					break
				if j == (len(pattern) - 1):
					return 'YES'
	return 'NO'	


T = int(input())

for t in range(T):
	R , C = map(int, input().split())
	
	L = [input() for _ in range(R)]
	
	r , c = map(int, input().split())
	
	l = [input() for _ in range(r)]
	
	
	print(match(L,l))
	
	

