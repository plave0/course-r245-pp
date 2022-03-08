
zbirPar :: Int -> [(Int, Int)]
zbirPar n = [(x,y) | x <- [1..n], y <- [1..n], y == n - x]
