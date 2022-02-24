open Printf
let rec print_list = function 
[] -> ()
| e::l -> print_int e ; print_string " " ; print_list l;;

(*
Ueubung7 
 *)
 (* TEIL 1 *)
 (* : int -> bool *)
(* 
- : int -> bool
- : int -> int -> int
- : (int -> int) -> int -> int
- : 'a * 'a -> 'a list
- : 'a list -> 'b -> 'a list * 'a list * 'b
*)
fun i -> i = 1 ;;
fun x -> fun y -> x+y;;
fun f -> fun x -> f x + x;;
fun (x,y) -> [x;y];;
fun l -> fun x -> (l@l, l, x);;


(fun i -> i = 1) 1;;
(fun x -> fun y -> x+y) 10 2;;
(fun f -> fun x -> f x + x) (fun x -> 1) 2;;
(fun (x,y) -> [x;y]) (1,2);;
(fun l -> fun x -> (l@l, l, x)) [1] 2;;

(* TEIL 2 *)
(* a *)

let signum x  = 
  if x < 0 then -1 
    else if x = 0 then 0 
      else 1;;
signum (-23);;
signum 20;;

(* b *)

let rec divrest n l =
  match l  with
  [] -> []
  | h::t -> (h mod n) :: (divrest n t);;


let divrest1 n = List.map (fun x -> (x mod n));;

(* print_list (divrest1 2 [1;2;3;4]) *)

(* c *)
let rec isPrimeBase n m c = match n with
  1 -> c+1
  | x -> if ((m mod x) = 0) then  (isPrimeBase (n-1) m (c+1)) else (isPrimeBase (n-1) m c);;

let isPrime n = (isPrimeBase n n 0) = 2;;

(* printf "%B" (isPrime 13);;
print_int (isPrimeBase 13 13 0);; *)
let rec primlist n = match n with
  1 -> []
  | x -> if (isPrime x) then 
            n :: primlist (n-1)
         else primlist (n-1);;

print_list (primlist 10000);;



(* TEIL 3 *)

let rec cutoff r l = 
  match l with
  [] -> []
  | h :: [] -> r
  | h :: t -> cutoff (r @ [h]) t;;


(* 
cutoff [1] [2;3];;
cutoff <-- [<poly>]
cutoff --> <fun>
cutoff* <-- [<poly>; <poly>]
cutoff <-- [<poly>; <poly>]
cutoff --> <fun>
cutoff* <-- [<poly>]
cutoff* --> [<poly>; <poly>]
cutoff* --> [<poly>; <poly>]
- : int list = [1; 2]


*)

(* b
cutoff [1] [2;3];;
cutoff <-- [1]
cutoff --> <fun>
cutoff* <-- [2; 3]
cutoff <-- [1; 2]
cutoff --> <fun>
cutoff* <-- [3]
cutoff* --> [1; 2]
cutoff* --> [1; 2]
- : int list = [1; 2]
*)

(* c
Currying ist kaskadierung von Funktion
*)

(* TEIL 4 *)
(* a *)
let rec appn f n x = 
  match n with 
  0 -> x
  | _ -> appn f (n-1) (f x);;

(* print_int (appn (fun x -> x+1) 3 0);; *)

(* b *)
let rec iterate l =
  match l with  
  [] -> []
  | h :: [] -> [h] 
  | a::b::t -> if a < b then a::iterate (b::t) 
                else b::iterate (a::t);;
let rec length_inner l n = match l with 
[] -> n
| h :: t -> length_inner t (n+1);;
let length l = length_inner l 0;;
let bubble_sort l = appn iterate (length l) l;;
(* print_list (bubble_sort [3;1;3;2]) *)

(* c *)
(* 
Parametrischer Polymorphismus: polymorphic functions are written without mention of any specific type, and can thus apply a single abstract implementation to any number of types in a transparent way. 
Generische Funktion 

Adhoc Polymorphismus: polymorphic functions can be applied to arguments of different types,
funktion overloading
Operator Overloading
*)