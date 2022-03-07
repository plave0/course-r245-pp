izDekadne :: Integer -> Integer -> Integer
izDekadne 0 osn = 0
izDekadne x osn = (mod x osn) + 10 * izDekadne (div x osn) osn

uDekadnu :: Integer -> Integer -> Integer
uDekadnu 0 osn = 0
uDekadnu x osn = osn * (uDekadnu (div x 10) osn) + (mod x 10)
