open CCFun


let read_numbers () = 
    CCIO.read_lines_l stdin
    |> List.map CCString.trim
    |> List.filter (fun s -> not (CCString.is_empty s))
    |> List.map int_of_string 


module Parsers = struct
    open CCParse

    let skip_spaces = skip_chars is_space

    let positive_int = chars1_if is_num |> map int_of_string

    let to_end = chars_if (const true)
end
