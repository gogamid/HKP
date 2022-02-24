(* 
pattern matching makes code read easily and better than if else statements
| is or 
_ match everything 
*)
open Printf

let not1 x = 
  match x with
    true -> false
  | false -> true;;

printf "%B\n" (not1 false);;

let rec sum n = 
  match n with
    1 -> 1
    | _ -> n + sum (n - 1);;
printf "%d\n" (sum 2);;

let rec power x n = match n with
  0 -> 1
  | _ -> x * power x (n-1);;

printf "%d\n" (power 2 3);;