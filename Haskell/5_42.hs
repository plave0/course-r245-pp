
sufiks :: [a] -> [[a]]
sufiks = foldr (\x acc -> (x:head acc):acc) [[]]
