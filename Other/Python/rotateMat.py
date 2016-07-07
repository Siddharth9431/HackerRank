from copy import deepcopy

q = [int(x) for x in input().split(' ')]

l = []

for _ in range(q[0]):
	a = [int(x) for x in input().split(' ')]
	l.append(a)
	
def rotate(mat, m, n, r):
	k = min(m, n) // 2
	
	rows = []
	
	for i in range(k):
		row = []
		
		for j in range(i, m - 1 - i):
			row.append(mat[j][i])
			
		for j in range(i, n - 1 - i):
			row.append(mat[m - 1 - i][j])
		
		for j in range(m - 1 - i, i, -1):
			row.append(mat[j][n - 1 - i])
		
		for j in range(n - 1 - i, i, -1):
			row.append(mat[i][j])
		rows.append(row)
		
	M = deepcopy(mat)

	for i in range(k):
		row = rows[i]
		shift = r % len(row)
		
		ndx = -shift
		
		for j in range(i, m - 1 - i):
			M[j][i] = row[ndx]
			ndx = ndx + 1
			ndx = ndx % len(row)
			
		for j in range(i, n - 1 - i):
			M[m - 1 - i][j] = row[ndx]
			ndx = ndx + 1
			ndx = ndx % len(row)
		
		for j in range(m - 1 - i, i, -1):
			M[j][n - 1 - i] = row[ndx]
			ndx = ndx + 1
			ndx = ndx % len(row)
		
		for j in range(n - 1 - i, i, -1):
			M[i][j] = row[ndx]
			ndx = ndx + 1
			ndx = ndx % len(row) 
	for k in M:
		print(" ".join(map(str, k))) 

rotate(l, q[0], q[1], q[2])
	



	
