package chapter2.section5.exercise22;

import java.util.PriorityQueue;

@SuppressWarnings("ClassEscapesDefinedScope")
public class StockMarketTrading {
    private final PriorityQueue<Order> buyers;
    private final PriorityQueue<Order> sellers;

    public StockMarketTrading() {
        buyers = new PriorityQueue<>();
        sellers = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        StockMarketTrading market = new StockMarketTrading();
        market.addOrder(new Order("AAPL", true, 100, 150.0));
        market.addOrder(new Order("AAPL", false, 50, 160.0));
        market.addOrder(new Order("AAPL", false, 75, 140.0));
        market.addOrder(new Order("AAPL", true, 200, 130.0));
        System.out.println("Buyers: " + market.buyers);
        System.out.println("Sellers: " + market.sellers);
    }

    public void addOrder(Order order) {
        if (order.isBuyOrder()) buyers.add(order);
        else sellers.add(order);
        executeTrades();
    }

    @SuppressWarnings("DataFlowIssue")
    private void executeTrades() {
        while (!buyers.isEmpty() && !sellers.isEmpty() && buyers.peek().getPrice() >= sellers.peek().getPrice()) {
            Order buyer = buyers.poll();
            Order seller = sellers.poll();
            int quantity = Math.min(buyer.getQuantity(), seller.getQuantity());
            System.out.println("Trade executed: " + quantity + " shares of " + buyer.getStockName() + " at $" + buyer.getPrice());

            buyer.setQuantity(buyer.getQuantity() - quantity);
            seller.setQuantity(seller.getQuantity() - quantity);

            if (buyer.getQuantity() > 0) buyers.add(buyer);
            if (seller.getQuantity() > 0) sellers.add(seller);
        }
    }
}
