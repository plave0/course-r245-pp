tipJednacine :: Double -> Double -> Double -> String
tipJednacine a b c = if a == 0 then "Degenerisana"
  else if (b*b - 4*a*c) > 0 then "Dva resenja"
  else if (b*b - 4*a*c) < 0 then "Nema resenja"
  else "Jedno resenje"

