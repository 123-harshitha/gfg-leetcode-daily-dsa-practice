package greedy;
class BusTicketChange {

    public static boolean canServe(int[] arr) {
        int count5 = 0, count10 = 0;

        for (int bill : arr) {
            if (bill == 5) {
                count5++;
            }
            else if (bill == 10) {
                if (count5 == 0) return false;
                count5--;
                count10++;
            }
            else { // bill == 20
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                }
                else if (count5 >= 3) {
                    count5 -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    // ✅ Main method
    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 10, 20};
        System.out.println(canServe(arr));
    }
}
