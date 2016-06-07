def transcode(string)
    stringEnc = string.force_encoding(Encoding::UTF_8)
    return stringEnc
end