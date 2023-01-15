import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {

    private record StockData(int timestamp, int price){}
    private final Map<Integer, Integer> timestampToPrice;
    private final PriorityQueue<StockData> minHeapForPrice;
    private final PriorityQueue<StockData> maxHeapForPrice;
    private int mostRecentTimestamp;

    public StockPrice() {
        timestampToPrice = new HashMap<>();
        minHeapForPrice = new PriorityQueue<>((x, y) -> x.price - y.price);
        maxHeapForPrice = new PriorityQueue<>((x, y) -> y.price - x.price);
    }

    public void update(int timestamp, int price) {
        timestampToPrice.put(timestamp, price);
        mostRecentTimestamp = Math.max(mostRecentTimestamp, timestamp);
        minHeapForPrice.add(new StockData(timestamp, price));
        maxHeapForPrice.add(new StockData(timestamp, price));
    }

    public int current() {
        return timestampToPrice.get(mostRecentTimestamp);
    }

    public int maximum() {
        //lazy update
        while (this.maxHeapForPrice.peek().price != this.timestampToPrice.get(this.maxHeapForPrice.peek().timestamp)) {
            this.maxHeapForPrice.poll();
        }
        return this.maxHeapForPrice.peek().price;
    }

    public int minimum() {
        //lazy update
        while (this.minHeapForPrice.peek().price != this.timestampToPrice.get(this.minHeapForPrice.peek().timestamp)) {
            this.minHeapForPrice.poll();
        }
        return this.minHeapForPrice.peek().price;
    }
}