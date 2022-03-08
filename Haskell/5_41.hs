
-- concat
spoji :: [[a]] -> [a]
spoji = foldl (++) [] 
