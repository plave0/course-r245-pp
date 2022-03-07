harm :: Integer -> [Double]
harm 1 = [1.0]
harm n = harm (n-1) ++ [recip (fromInteger n)] 
