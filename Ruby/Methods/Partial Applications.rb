combination = -> (n) do
    n_fact = (1..n).reduce(1, :*)
    -> (r) do
        r_fact = (1..r).reduce(1, :*)
        n_r_fact = (1..n-r).reduce(1, :*)
        n_fact / (r_fact * n_r_fact)
    end
end

n = gets.to_i
r = gets.to_i
nCr = combination.(n)
puts nCr.(r)