def mask_article(str, arr)
    arr.each { |i| str.gsub!(i, strike(i)) }
    return str
end

def strike(str)
    tmp = "<strike>".concat(str).concat"</strike>"
    return tmp
end