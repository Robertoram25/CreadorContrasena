import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    private static final Map<Character, String[]> letterToSymbolMap = new HashMap<>();
    private static final Random random = new Random();

    static {
        letterToSymbolMap.put('A', new String[]{"4", "@"});
        letterToSymbolMap.put('S', new String[]{"5", "$"});
        letterToSymbolMap.put('E', new String[]{"3"});
        letterToSymbolMap.put('I', new String[]{"1", "!"});
        letterToSymbolMap.put('O', new String[]{"0"});
        letterToSymbolMap.put('C', new String[]{"("});
        letterToSymbolMap.put('B', new String[]{"8"});
        letterToSymbolMap.put('D', new String[]{")"});
        letterToSymbolMap.put('F', new String[]{"#"});
        letterToSymbolMap.put('G', new String[]{"6", "9"});
        letterToSymbolMap.put('H', new String[]{"#"});
        letterToSymbolMap.put('J', new String[]{"?"});
        letterToSymbolMap.put('K', new String[]{"<"});
        letterToSymbolMap.put('L', new String[]{"1", "|"});
        letterToSymbolMap.put('M', new String[]{"^"});
        letterToSymbolMap.put('N', new String[]{"^"});
        letterToSymbolMap.put('P', new String[]{"9"});
        letterToSymbolMap.put('Q', new String[]{"0", "9"});
        letterToSymbolMap.put('R', new String[]{"2"});
        letterToSymbolMap.put('T', new String[]{"7"});
        letterToSymbolMap.put('U', new String[]{"_"});
        letterToSymbolMap.put('V', new String[]{"<"});
        letterToSymbolMap.put('W', new String[]{"/"});
        letterToSymbolMap.put('X', new String[]{"*"});
        letterToSymbolMap.put('Y', new String[]{"%"});
        letterToSymbolMap.put('Z', new String[]{"2"});
    }

    public static String convertString(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                result.append(transformCharacter(ch));
            }
        }

        return result.toString();
    }

    private static String transformCharacter(char ch) {
        char upperChar = Character.toUpperCase(ch);
        if (letterToSymbolMap.containsKey(upperChar)) {
            String[] symbols = letterToSymbolMap.get(upperChar);
            String symbol = symbols[random.nextInt(symbols.length)];
            return randomCase(symbol, ch);
        } else {
            return String.valueOf(randomCase(String.valueOf(ch), ch));
        }
    }

    private static String randomCase(String str, char originalChar) {
        int choice = random.nextInt(3);  // Genera un número entre 0 y 2
        if (choice == 0) {
            return str.toLowerCase();  // Retorna la cadena en minúsculas
        } else if (choice == 1) {
            return str.toUpperCase();  // Retorna la cadena en mayúsculas
        } else {
            return String.valueOf(originalChar);  // Retorna la letra original
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String input = "Mi Casa Azul";
        String converted = convertString(input);

        System.out.println("Cadena original: " + input);
        System.out.println("Cadena convertida: " + converted);
    }
}