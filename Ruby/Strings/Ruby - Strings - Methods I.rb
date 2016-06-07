def process_text(strings)
    str = ""
    strings.each do |i|
        str.concat(i.strip.concat(" "))
    end
    str = str.chop
end