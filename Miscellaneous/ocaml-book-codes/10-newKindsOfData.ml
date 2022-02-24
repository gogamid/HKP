type colour = 
Red 
| Green 
| Blue 
| Yellow
| RGB of int * int * int ;;

let components c = match c with
Red -> (255, 0, 0)
| Green -> (0, 255, 0)
| Blue -> (0, 0, 255)
| Yellow -> (255, 255, 0)
| RGB (r, g, b) -> (r, g, b);;

components (Red)

type 'a option = None | Some of 'a;;

let nothing = None;;

let number = Some 50;;


type 'a sequence = Nil | Cons of 'a * 'a sequence;;


type rect =
Square of int
| Rect of int * int;;

let  area a = match a with
Square x -> x * x
| Rect (x, y) -> x * y;;

let rec rotate a = match a with 
Square x ->  a
| Rect (w, h) -> Rect (w, w);;