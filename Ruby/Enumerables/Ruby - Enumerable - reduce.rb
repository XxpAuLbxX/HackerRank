def sum_terms(n)
    (1..n).inject(0) { |product, n| product + (n * n + 1) }
end