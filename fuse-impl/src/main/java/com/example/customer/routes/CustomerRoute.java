package com.example.customer.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.example.customer.dto.Customer;
import com.example.customer.dto.CustomerList;

/*
    This is a stub for the Driver endpoint that just returns some itelimatics data.
    Only to be used for mock testing.

 */


@Component
public class CustomerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct://get-customer-by-id")
                .process( new Processor(){

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Integer id = exchange.getIn().getHeader("id", Integer.class);
                        if(id == null) {
                            throw new IllegalArgumentException("must provide an in");
                        }
                        Customer c = new Customer();
                        c.setName("Hans Hansen");
                        c.setAge("23");
                        c.setEmail("hhansen@redhat.com");
                        c.setId(id);
                        exchange.getIn().setBody(c);
                    }
                })
                .marshal().json(JsonLibrary.Jackson);

        from("direct://get-customer-list")
                .process(new Processor(){
                
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Customer c0 = new Customer();
                        c0.setId(1);
                        c0.setAge("22");
                        c0.setName("Hans Hansen");
                        c0.setEmail("hhansen@redhat.com");
                        Customer c1 = new Customer();
                        c1.setId(2);
                        c1.setAge("50");
                        c1.setName("Lars Larsen");
                        c1.setEmail("llarsen@redhat.com");

                        CustomerList list = new CustomerList();
                        list.addCustomersItem(c0);
                        list.addCustomersItem(c1);
                        exchange.getIn().setBody(list);
                    }
                })
                .marshal().json(JsonLibrary.Jackson);
    }
}
