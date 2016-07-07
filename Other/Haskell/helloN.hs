hello_worlds n = do
	if n > 0
	then do
		putStrLn "Hello World"
		hello_worlds (n-1)
	else return()
			


main = do
   n <- readLn :: IO Int
   hello_worlds n
