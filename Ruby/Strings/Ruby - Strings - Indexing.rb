def serial_average(fixedString)
    tmp1 = "#{fixedString[4,5]}".to_f
    tmp2 = "#{fixedString[10,5]}".to_f
    tmp = (tmp1 + tmp2) / 2
    retString = "#{fixedString[0, 4]}#{tmp.round(2)}"
end