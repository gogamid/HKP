open Printf
let rec print_list = function 
[] -> ()
| e::l -> print_int e ; print_string " " ; print_list l;;


(* Teil 1 *)

(* a rekuriv *)
let rec exist l e = match l with
  [] -> false
  | h :: t -> if e = h then true 
              else exist t e;;

(* printf "%B" (exist [1;2;3] 4);; *)

(* a fold_right *)

let frExist l e = List.fold_right (fun x y -> (x = e) || y ) l false;;
(* printf "%B"  (frExist [1;1;2;1] 1 );; *)

(* b recursiv*)
let rec filter l f = match l with
  [] -> l
 | h :: t -> if (f h) then h::filter t f else filter t f;;
(* print_list (filter [1; -1;0; -12; 1; -100] (fun x -> x >= 0));; *)

(* b fold_right *)
let frFilter l f = List.fold_right (fun x y -> if (f x) then x::y else y) l [];;
(* print_list (frFilter [1; -1;0; -12; 1; -100] (fun x -> x >= 0)); *)

(* Teil 2 *)
    
 
(* exist ist endrekursiv weil der Aufruf exist t e ist die letzte Aktion im rekursiven Zweig
f(x) =  exist l e
g(x) = false
P(x) = []
r(x) exist t e *)

(* filter ist aber nicht endrekursiv weil  es gibt noch h:: im rekursiven Zweig *)
(* b filter in endrekurisive form *)
let rec filter_inner l f a = match l with
[] -> a
| h :: t -> if (f h) then filter_inner t f (h::a) 
                else filter_inner t f a;;
let rec filter1 l f = filter_inner l f [];;

(* print_list (filter1 [1; -1;0; -12; 1; -100] (fun x -> x >= 0));; *)

(* Teil 3 *)
(* a) 
Typkonstruktor - 
Datenkonstruktor - *)


(* b *)
type pizza = 
Margarita
| Tuna;;

type drink =
Pepsi
| Cola;;

type car = VW | BMW;;


(* c *)

(* bubblesort lib *)
let rec appn f n x = 
  match n with 
  0 -> x
  | _ -> appn f (n-1) (f x);;

let rec iterate l =
  match l with  
  [] -> []
  | h :: [] -> [h] 
  | a::b::t -> if a < b then a::iterate (b::t) 
                else b::iterate (a::t);;
let bubble_sort l = appn iterate (List.length l) l;;

(* bubblesort lib *)
let pizzas = [Margarita; Tuna; Margarita; Tuna; Tuna;];;
bubble_sort pizzas;; (*sortiert nach reihenfolge von deklarierte Datenstruktur*)

(* d *)
type 'a sequence = 
| Nil
| Cons of 'a * 'a sequence;;

let list_of_pizzas = Cons (Margarita, Cons (Tuna, Cons (Margarita, Nil)));;


(* e ?? *)
type ('a, 'b) xxx  = 
|A of 'a
|B of 'b;;

let s = [A Margarita; B Cola]


(* Teil  4*)
type 'a single = |None |Some of 'a;;
type 'a tree = 
| Empty 
| Buildtree of 'a * 'a tree * 'a tree;;

let onetree = Buildtree(1, Empty, Empty);;
let twotree = Buildtree(2, Empty, Empty);;
let subtree = Buildtree(3, onetree, twotree);;
let largetree = Buildtree(4,subtree, twotree);;

let rec deeptraverse x = match x with
Empty -> []
| Buildtree (i, l, r ) -> ([i] @ deeptraverse l) @ deeptraverse r;;

(* print_list (deeptraverse largetree);; *)
(* a *)
let leftSubtree x = match x with
Empty -> None
| Buildtree (i, Empty, r) -> None
| Buildtree (i, l, r) -> Some l;;

leftSubtree largetree;;
(* b *)
let max a b = if a < b then b else a;;


let tiefe x = 
  let rec tiefe_inner x n = match x with
    Empty -> n
    | Buildtree (i, l, r) -> max (tiefe_inner l (n+1)) (tiefe_inner r (n+1))
in 
tiefe_inner x 0;;

(* print_int (tiefe largetree);; *)

(* c *)
let rec treemap f x = match x with
Empty -> Empty
| Buildtree ( i, l, r) -> Buildtree ( f i, treemap f l, treemap f r);; 

(* print_list( deeptraverse largetree);;
print_string "\n";;
print_list (deeptraverse (treemap (fun x -> x * 5) largetree));; *)

(* d *)
let at_level t level =
  let rec at_level_aux t acc counter = match t with
    | Empty -> acc
    | Buildtree (x, l, r) ->
      if counter=level then
        x :: acc
      else
        at_level_aux l (at_level_aux r acc (counter + 1)) (counter + 1)
  in
    at_level_aux t [] 0;;

let rec iterate_levels x n nMax = 
  if (n = nMax) then (at_level x nMax)
  else (at_level x n) @ (iterate_levels x (n + 1) nMax);;

let  breadthtraverse x = iterate_levels x 0 (tiefe x);;

(* print_list (breadthtraverse largetree);;
print_int (tiefe largetree); *)