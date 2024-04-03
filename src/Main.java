public class Main {
    public static void main(String[] args) {
        String eingabe = "33";
        try {
            float ergebnis = parseMyFloat(eingabe);
            System.out.println("Float Zahl: " + ergebnis);
        } catch (NumberFormatException e) {
            System.out.println("Ungültiges Format für Float Zahl");
        }
    }
    public static float parseMyFloat(String string) throws NumberFormatException {
        if (string == null || string.isEmpty())
            throw new NumberFormatException("null String");
        int index = 0;
        boolean negativ = false;
        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            negativ = string.charAt(index) == '-';
            index++;
        }
        int ganzeZahl = 0;
        for (; index < string.length() && Character.isDigit(string.charAt(index)); index++) {
            ganzeZahl = ganzeZahl * 10 + Character.getNumericValue(string.charAt(index));
        }
        if (index < string.length() && string.charAt(index) == '.') {
            index++;
            float dezimalWert = 0.0f;
            float divisor = 10.0f;
            for (; index < string.length() && Character.isDigit(string.charAt(index)); index++) {
                dezimalWert += Character.getNumericValue(string.charAt(index)) / divisor;
                divisor *= 10.0f;
            }
            return negativ ? -(ganzeZahl + dezimalWert) : ganzeZahl + dezimalWert;
        } else {
            return negativ ? -ganzeZahl : ganzeZahl;
        }
    }
}