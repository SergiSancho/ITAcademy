package model;

public class TicketDetail<ID> {
    private ID ticketId;
    private ID productId;
    private int quantity;

    public TicketDetail(ID ticketId, ID productId, int quantity) {
        this.ticketId = ticketId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public ID getTicketId() {
        return ticketId;
    }

    public void setTicketId(ID ticketId) {
        this.ticketId = ticketId;
    }

    public ID getProductId() {
        return productId;
    }

    public void setProductId(ID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

