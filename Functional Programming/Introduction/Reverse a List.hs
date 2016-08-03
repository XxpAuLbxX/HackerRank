-- runs recursively to the end of the list then adds to the end of the new list contiously and reverses
rev [] = []
rev l = rev (tail l) ++ [head l]