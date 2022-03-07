prost :: Integer -> Bool
prost 1 = False
prost a = null (listaDelilaca a)
  where listaDelilaca a = [x | x <- [2..(a-1)], mod a x == 0]
