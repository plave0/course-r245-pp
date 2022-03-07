nadovezi :: [a] -> [a] -> Int -> [a]
nadovezi l1 l2 n
  | n <= 0 = l1
  | otherwise = concat $ replicate n l2
