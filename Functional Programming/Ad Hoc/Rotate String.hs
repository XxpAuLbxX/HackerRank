import Control.Applicative
import Control.Monad
import System.IO

main = do
    n_temp <- getLine
    let n = read n_temp :: Int
    forM_ [1..n] $ \a0  -> do
        s <- getLine
        putStrLn $ unwords $ map (rotate s) [1..(length s)]

rotate :: String -> Int -> String  
rotate xs n = zipWith const (drop n (cycle xs)) xs  