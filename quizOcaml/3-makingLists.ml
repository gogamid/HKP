(*
**** List*** 
List has head and tail. Head is first element and tail is list except first element
*** List operations ***
 :: is cons operator, add element to the front only of the  list 
@ is append operation, it combines two lists
 *)
 open Printf
 let rec print_list = function 
[] -> ()
| e::l -> print_int e ; print_string " " ; print_list l;;

 let rec evens l = 
  match l with
   _::a::t -> a:: evens t
  | _ -> [];;

(* print_list (evens [2; 4; 2; 4; 2]);; *)

let rec count_true l n = 
  match l with
  [] -> n
  | h :: t -> count_true t (if h then n+1 else n);;

(* print_int (count_true [true; false; true] 0);; *)

let rec rev l = match l with
  [] -> []
  | [a] -> l
  | h :: t -> rev t @ [h];;

let rec make_palindrom l = 
  match l with
  [] -> []
  | [a] -> [a]
  | h :: t -> [h] @ make_palindrom t @ [h];;
(* print_list (make_palindrom [1;2;3]);; *)

let isPalindrom l = (rev l) = l;;

printf "%B" (isPalindrom [1;2;3;2;1])

let rec drop_last l = 
  match l with
  [] -> []
  | [a] -> []
  | h :: t -> [h] @ drop_last t;;
(* print_list (drop_last [1;2]);; *)

let rec member n l = match l with
  [] -> false
  | h :: t -> if n = h then true else member n t;;

(* printf "%B\n" (member 2 [1]);; *)

let rec make_set l = match l with
  [] -> []
  | h :: t -> (if (member h t) then [] else [h]) @ make_set t;;

(* print_list (make_set [1;2;3;2;3]);; *)


