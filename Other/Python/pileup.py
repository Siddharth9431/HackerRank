from collections import deque

t = int(input())

for i in range(t) :
	n = int(input())
	
	s = deque(int(x) for x in input().split(' '))
	
	if s[0] < s[-1] :
		temp = s.pop()
	else :
		temp = s.popleft()
		
	while len(s) > 0 :
		if temp >= s[-1] and s[0] <= s[-1] :
			temp = s.pop()
		elif temp >= s[0] :
			temp = s.popleft()
		else :
			print('No')
			s.clear()
			break
		if not len(s) : print('Yes')
	
