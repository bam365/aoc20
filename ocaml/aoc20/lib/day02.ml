open CCFun
open Printf


module PasswordSpec = struct
    type t = { min: int; max: int; c: char; pw: string }

    let make min max c pw = { min; max; c; pw }

    let (parser: t CCParse.t) =
        let open CCParse in
        let open Aoclib.Parsers in
        pure make <*> positive_int
                  <*> skip_spaces *> string "-" *> skip_spaces *> positive_int
                  <*> skip_spaces *> char_if (const true)
                  <*> skip_spaces *> string ":" *> skip_spaces *> to_end
 
    let is_valid t =
        let count = CCString.to_list t.pw |> CCList.count ((=) t.c) in
        t.min <= count && count <= t.max
end


let day02 () = 
    CCIO.read_lines_l stdin
    |> List.map (CCParse.parse_string_exn PasswordSpec.parser)
    |> CCList.count PasswordSpec.is_valid
    |> printf "%d\n"