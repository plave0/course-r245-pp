delioci :: Integer -> [Integer]
delioci 1 = [1]
delioci n = [x | x <- [2..n-1], mod n x == 0]
