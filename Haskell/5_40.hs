
poslednji :: [a] -> a
poslednji = foldl1 (\acc x -> x)
