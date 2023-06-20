package kn.kn_order_managment_system_api.services;

import kn.kn_order_managment_system_api.entity.OrderLine;

import java.util.List;

public interface OrderLineService {
    public List<OrderLine> getAllOrderLines();
    public void saveOrderLine(OrderLine orderLine);
    public OrderLine getOrderLine(int orderLine_id);
    public void deleteOrderLine(int orderLine_id);
}
