package kn.kn_order_managment_system_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_lines")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderline_id")
    private int orderLineId;
    @JoinColumn(name = "order_id")
    private int orderId;
    @JoinColumn(name = "product_id")
    private int productId;

    @JoinColumn(name = "quantity")
    private int quantity;

    public OrderLine(int orderId, int product_id, int quantity) {
        this.orderId = orderId;
        this.productId = product_id;
        this.quantity = quantity;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
