-- This function should return a list [area, volume].
--solve :: Double -> Double -> [Double] -> [Double] -> [Double]
solve l r a b =
    let y x = sum $ zipWith (*) a $ map (x **) b
        step = 0.001
        stepList = map y [l,l+step .. r-step]
        area = step * sum stepList
        sqr x = x * x
        vol  = pi * step * sum (map sqr stepList)
    in  [area, vol]
