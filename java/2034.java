import java.util.*;

class Price {
    public int time;
    public int price;
    public boolean disabled;

    public Price(int t, int p) {
        time = t;
        price = p;
    }
}

class StockPrice {

    public StockPrice() {
        maxQueue = new PriorityQueue<>((p1, p2) -> p2.price - p1.price);
        minQueue = new PriorityQueue<>((p1, p2) -> p1.price - p2.price);
        times = new HashMap<>();
        curTime = 0;
    }

    Queue<Price> maxQueue;
    Queue<Price> minQueue;
    Map<Integer, Price> times;
    int curTime;
    
    public void update(int timestamp, int price) {
        Price p = new Price(timestamp, price);

        if (times.containsKey(timestamp)) {
            times.get(timestamp).disabled = true;
        }

        times.put(timestamp, p);
        if (timestamp >= curTime) {
            curTime = timestamp;
        }

        maxQueue.offer(p);
        minQueue.offer(p);
    }
    
    public int current() {
        return times.get(curTime).price;
    }
    
    public int maximum() {
        Price p = maxQueue.peek();
        while (!times.containsKey(p.time) || p.disabled) {
            maxQueue.poll();
            p = maxQueue.peek();
        }

        return p.price;
    }
    
    public int minimum() {
        Price p = minQueue.peek();
        while (!times.containsKey(p.time) || p.disabled) {
            minQueue.poll();
            p = minQueue.peek();
        }

        return p.price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */