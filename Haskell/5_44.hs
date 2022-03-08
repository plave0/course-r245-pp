
ubaci :: Int -> Int -> [Int] -> [Int]
ubaci k n lst = firstHalf ++ [n] ++ secondHalf
  where splitList = splitAt k lst
        firstHalf = fst splitList
        secondHalf = snd splitList
