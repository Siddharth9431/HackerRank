f :: Int -> [Int] -> [Int]
f _ [] = []
f n arr = do
			replicate n (head arr) ++ f n (tail arr)



main :: IO ()
main = getContents >>=
       mapM_ print. (\(n:arr) -> f n arr). map read. words

