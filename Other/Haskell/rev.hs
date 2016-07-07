f :: [Int] -> [Int]
f [] = []
f [x] = [x]
f lst = [last lst] ++ f (init lst)


