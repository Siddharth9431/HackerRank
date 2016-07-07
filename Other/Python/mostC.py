import collections

s = str(input())

c = sorted(collections.Counter(s).most_common(), key = lambda x:(-x[1],x[0]))[:3]

for i, j in c :
	print('%s %d' %(i, j))
	
