nzd :: Integer -> Integer -> Integer
nzd a 0 = a
nzd a b = nzd b (mod a b)
