class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String line) {
            String[] items = line.split(",");
            this.name = items[0];
            this.time = Integer.parseInt(items[1]);
            this.amount = Integer.parseInt(items[2]);
            this.city = items[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>(); // <name, Transaction>
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>()); 
            map.get(t.name).add(t);
        }

        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);

            List<Transaction> transactionList = map.get(t.name);
            if (!isValidTransaction(transactionList, t)) { // compare current transaction with the list
                res.add(transaction);
            }
        }
        return res;
    }

    // helper to determine if transaction is invalid
    public boolean isValidTransaction(List<Transaction> list, Transaction currentT) {
            if (currentT.amount > 1000) {
                return false;
            }
            for (Transaction t: list) {
                // Order doesnt matter
                // if any 2 transaction <= 60 min and diff city, add both
                if (Math.abs(t.time-currentT.time ) <= 60 && !currentT.city.equals(t.city) ) {
                    return false;
                }
            }
            return true;
    }


}
