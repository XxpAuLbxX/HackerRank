def count_multibyte_char(string)
    string.each_char.count{|x| x.bytesize>1} 
end