package ch2.sec5.ex22;



class Order implements Comparable<Order> {
    private final String stockName;
    private final boolean buyOrder;
    private final double price;
    private int quantity;

    public Order(String stockName, boolean buyOrder, int quantity, double price) {
        this.stockName = stockName;
        this.buyOrder = buyOrder;
        this.quantity = quantity;
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }

    public boolean isBuyOrder() {
        return buyOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Order other) {
        if (buyOrder && other.buyOrder) {
            return Double.compare(other.price, price);
        } else if (!buyOrder && !other.buyOrder) {
            return Double.compare(price, other.price);
        } else {
            return buyOrder ? -1 : 1;
        }
    }

    @Override
    public String toString() {
        return "{" + quantity + ", " + price + "}";
    }
}
