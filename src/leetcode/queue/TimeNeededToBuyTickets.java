package leetcode.queue;

class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;

        int counter = 0;
        int index = 0;
        while (true) {
            if (tickets[k] == 0) {
                return counter;
            }

            if (index == len) index = 0;

            if (tickets[index] > 0) {
                counter++;
                tickets[index]--;
            }

            index++;
        }
    }
}
