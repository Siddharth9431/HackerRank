--
solve :: Double -> Double -> [Double] -> [Double] -> [Double]
solve l r a b =
	let
		step = 0.001
		polynomial x = sum $ zipWith (*) a $ map (x **) b
		stepList = map polynomial [l, (l + step) .. (r - step)]
		area = step * sum stepList
		square x = x * x
		volume = pi * step * sum (map square stepList)
		in [area, volume]
