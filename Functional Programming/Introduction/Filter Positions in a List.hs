f :: [Int] -> [Int]
{-
    splits list into 3 parts, first (odd) element thrown away, even kept (x) and
    then run recursively with the rest of the list starting at the next odd element
-}
f (_:x:xs) = x : f xs 
f _ = [] -- done

-- This part deals with the Input and Output and can be used as it is. Do not modify it.
main = do
   inputdata <- getContents
   mapM_ (putStrLn. show). f. map read. lines $ inputdata