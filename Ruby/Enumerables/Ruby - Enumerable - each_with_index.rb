def skip_animals(animals, skip)
    animals.collect.with_index { |animal, index| "#{index}:#{animal}" }.drop(skip)
end