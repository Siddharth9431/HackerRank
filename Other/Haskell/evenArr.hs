f :: [Int] -> [Int]
f [] = []
f [x] = []
f [x,y] = [y]
f lst = [head (tail lst)] ++ f (tail (tail lst))


main = do
   inputdata <- getContents
   mapM_ (putStrLn. show). f. map read. lines $ inputdata
