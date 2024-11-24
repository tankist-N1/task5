public class ChessMove {
    public static boolean canMove(String piece, String start, String end) {
        int startX = start.charAt(0) - 'A';
        int startY = start.charAt(1) - '1';
        int endX = end.charAt(0) - 'A';
        int endY = end.charAt(1) - '1';

        switch (piece) {
            case "Pawn":
                return (startX == endX && (endY - startY == 1 || (startY == 1 && endY - startY == 2)));
            case "Knight":
                return (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) ||
                        (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2);
            case "Bishop":
                return Math.abs(startX - endX) == Math.abs(startY - endY);
            case "Rook":
                return startX == endX || startY == endY;
            case "Queen":
                return startX == endX || startY == endY || Math.abs(startX - endX) == Math.abs(startY - endY);
            case "King":
                return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(canMove("Rook", "A8", "H8")); // true
        System.out.println(canMove("Bishop", "A7", "G1")); // true
        System.out.println(canMove("Queen", "C4", "D6")); // false
    }
}