def func_any(hash)
    # Check and return if any key object within the hash is of the type Integer
    hash.any? { |key, value| key.is_a? Integer }
end

def func_all(hash)
    # Check and return if all the values within the hash are Integers and are < 10
    hash.all? { |key, value| (value.is_a? Integer) && (value < 10) }
end

def func_none(hash)
    # Check and return if none of the values within the hash are nil
    hash.any?
end

def func_find(hash)
    # Check and return the first object that satisfies the property
    # [key, value] pair where the key and value are both Integers and the value is < 20 
    # or [key, value] pair where the key is a String and the value is a String starting 
    # with the character `a`
    hash.find {|key, value| ((key.is_a? Integer) && (value.is_a? Integer) && (value < 20)) || ((key.is_a? String) && (value[0] == 'a'))}
end