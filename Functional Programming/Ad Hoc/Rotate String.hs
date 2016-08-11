import Control.Monad

rotate :: [a] -> [a]
rotate (x:xs) = xs:x

main = do
  input <- getLine
  inputs <- replicateM (read input) getLine
  rotate "string"
  print inputs