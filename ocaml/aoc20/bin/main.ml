module ProgMap = CCMap.Make(CCString)

let prog_map = 
    let open ProgMap in
    empty
    |> add "2" Aoc20.Day02.day02


let () = 
    match ProgMap.get (Sys.argv.(1)) prog_map with
    | Some(prog) -> prog ()
    | None -> failwith "No solution for that day"
