
public class Ellipsis {
    @SafeVarargs
    public static <T> T[] asArray(T... ts) {
        return ts;
    }

    public static <T> T[] arrayOfTwo(T a, T b) {
        return asArray(a, b);
    }

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        String[] starr =  asArray("Hello", "World");
        System.out.println(starr);
        String[] starr2 = arrayOfTwo("Hello", "Problem");
    }
}

//Objeect -> String

//List -> List<String>