type regex = 
| E
| L of char 
| Union of regex * regex
| Concat of regex * regex
;;

let rec matching x = match x with
(E , [] ) -> true
| (L c1, [c2] ) -> c1 = c2
| (Union (r1,r2), w ) -> matching (r1, w)|| matching (r2, w)
| (Concat (r1, r2), w ) -> matching (r1, w)
| _ -> false;;