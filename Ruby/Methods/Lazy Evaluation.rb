require 'prime'

palindrome_prime = -> (n) do 
    Prime.each.lazy.select{|x| x.to_s == x.to_s.reverse}.first(n)
end

p palindrome_prime.(gets.to_i)