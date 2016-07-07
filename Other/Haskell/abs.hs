f [] = []
f arr = [abs (head arr)] ++ f (tail arr)
