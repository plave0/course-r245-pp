
parni :: Int -> Int -> [Int]
parni a b = filter even [a..b]

neparni :: Int -> Int -> [Int]
neparni a b = filter odd [a..b]
