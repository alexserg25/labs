public class StringOperation {

    public String generationString(int lengthString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= lengthString; i++) {
            Character letter = (char) (Math.random() * ('z' - 'A') + 'A');
            sb.append((letter > 'Z' && letter < 'a') ? " ": letter.toString());
        }

        return sb.toString();
    }
}
