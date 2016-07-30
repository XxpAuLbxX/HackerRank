f :: Int -> [Int] -> [Int]
f _ [] = []
f n arr = 
    if (head arr) < n 
    then (head arr) : f n (tail arr) -- if less add to list and check rest
        else f n (tail arr) -- else throw away and check rest of list

-- The Input/Output section. You do not need to change or modify this part
main = do 
    n <- readLn :: IO Int 
    inputdata <- getContents 
    let 
        numbers = map read (lines inputdata) :: [Int] 
    putStrLn . unlines $ (map show . f n) numbers