import java.util.function.BiConsumer;
public class HelloFunctional {
public static void main(String[] args)  {
BiConsumer<String,Integer> sapa =
(nama,nim) -> System.out.println("Hallo word, I am " + nama + ", " + nim);
sapa.accept("Defita Dwi Wulandary", 240202856);

}
}