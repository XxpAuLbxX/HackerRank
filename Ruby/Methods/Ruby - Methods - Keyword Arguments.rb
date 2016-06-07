$hash = {   k_to_c: Proc.new { |k| k - 273.15 } ,
            f_to_c: Proc.new { |f| (f - 32) * 5.0/9.0},
            c_to_f: Proc.new { |c| c * 5.0/9.0 + 32},
            c_to_k: Proc.new { |c| c + 273.15},
            k_to_f: Proc.new { |k| k * 5.0/9.0 + 32 + 273.15},
            f_to_k: Proc.new { |f| (f - 32) * 5.0/9.0 + 273.15}
}

def convert_temp (temp, input_scale: 'kelvin', output_scale: 'celsius')
    return temp if input_scale == output_scale
    sym = "#{input_scale[0]}_to_#{output_scale[0]}".to_sym
    proc = $hash[sym]
    if proc
      proc.call(temp)
    else
      temp
    end
end