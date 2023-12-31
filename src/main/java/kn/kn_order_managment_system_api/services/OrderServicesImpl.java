package kn.kn_order_managment_system_api.services;

import jakarta.transaction.Transactional;
import kn.kn_order_managment_system_api.Repository.interfaces.OrderDAO;
import kn.kn_order_managment_system_api.dto.OrderDTO;
import kn.kn_order_managment_system_api.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class OrderServicesImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<OrderDTO> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void saveOrder(OrderDTO order) {
    orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public OrderDTO getOrder(int order_id) {
        return orderDAO.getOrder(order_id);
    }

    @Override
    public List<OrderDTO> findAll(Specification cs) throws Exception {
        return orderDAO.findAll(cs);
    }

    @Override
    @Transactional
    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }
}
