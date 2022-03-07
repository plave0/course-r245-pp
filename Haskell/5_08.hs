proizvodPrvih :: Integer -> Integer
proizvodPrvih 1 = 1
proizvodPrvih a = a * proizvodPrvih(a - 1)
