--Only fill up the blanks for the function named len
--Do not modify the structure of the template in any other way
len :: [a] -> Int
-- list comprehension to set all elements of the array to 1 and sum them
len lst = sum [1 | _ <- lst]