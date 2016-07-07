import heapq

def team(iq):
	
	teamD = {}
	
	def insert(key, value):
		if key in teamD:
			teamD[key].append(value)
			heapq.heapify(teamD[key])
		else:
			teamD[key] = [value]
			
	for i in sorted(iq):
		if i - 1 in teamD:
			temp = heapq.heappop(teamD[i - 1])
			
			insert(i, temp + 1)
			
			if not teamD[i - 1]:
				del teamD[i - 1]
		else:
			insert(i, 1)
			
	return min(heapq.heappop(teamD[j]) for j in teamD)
	
	
def main():
	T = int(input())

	for _ in range(T):
		L = [int(x) for x in input().split()]
		
		N = L[0]
		A = L[1:]
		
		if N == 0:
			print(0)
		else:
			print(team(A))

if __name__ == "__main__":
	main()
			
			
