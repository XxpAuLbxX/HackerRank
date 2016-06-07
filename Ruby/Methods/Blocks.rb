def factorial
    yield
end

n = gets.to_i
factorial do 
    @num = 1
    while n > 1
        @num = n * @num
        n -= 1
    end
    puts @num
end