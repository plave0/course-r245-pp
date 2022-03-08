
savrseni :: Int -> [Int]
savrseni n = [x | x <- [2..(n-1)], x == sum (filter (\m -> mod x m == 0) [1..x-1])]

