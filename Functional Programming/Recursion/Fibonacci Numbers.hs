--Contributed by Ron Watkins
module Main where

-- Fibonacci sequence solved using fib(n) = fib(n-1) + fib(n-2) recursively
fib n = 
    if n == 1
        then 0  
        else if n == 2
            then 1
            else fib (n-1) + fib (n-2) 


-- This part is related to the Input/Output and can be used as it is
-- Do not modify it
main = do
    input <- getLine
    print . fib . (read :: String -> Int) $ input
