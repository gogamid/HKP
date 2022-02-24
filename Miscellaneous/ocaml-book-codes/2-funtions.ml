(* Questions k2 *)
let multiplyByTen x = x * 10;;
let areNonZero a b = a <> 0 && b <> 0;;

let rec sum n = 
  if n = 1 then 1 else 
    n + sum (n - 1);;

(* print_int (sum 2);; *)

let rec power x n = if n = 0 then 1 else
  x * power x (n - 1);;
(* print_int (power 2 3);; *)

