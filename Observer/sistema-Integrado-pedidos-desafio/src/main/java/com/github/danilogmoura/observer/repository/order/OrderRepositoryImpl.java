package com.github.danilogmoura.observer.repository.order;

import com.github.danilogmoura.observer.model.Order;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private static final String FILE_NAME = "orders.xml";
    private final XStream xstream = new XStream();

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> findAll() {
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("orders", List.class);
        xstream.alias("order", Order.class);

        return (List<Order>) xstream.fromXML(this.getClass().getResource("/" + FILE_NAME));
    }
}
