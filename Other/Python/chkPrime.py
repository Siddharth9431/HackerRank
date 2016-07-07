import math

T = int(input().strip())

for i in range(T):
	n = int(input())
	
	flag = True
	
	if(n == 1):
		flag = False
	
	for j in range(2, int(math.sqrt(n) + 1)):
		if(n % j == 0):
			flag = False
			
	if(flag):
		print('Prime')
	else:
		print('Not Prime')		
	
	
