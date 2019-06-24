package com.example.beer.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import com.example.beer.service.BeerService;
import com.example.beer.dto.Beer;
import org.apache.camel.BeanInject;

@Component
public class FindBeersByStatusRoute extends RouteBuilder {
	@BeanInject
	private BeerService mBeerService;
	
    @Override
    public void configure() throws Exception {
        from("direct:FindBeersByStatus")
                .process( new Processor(){

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String status = exchange.getIn().getHeader("status", String.class);
                        if(status == null) {
                            throw new IllegalArgumentException("must provide a status");
                        }

                        exchange.getIn().setBody(mBeerService.getBeerByStatus(status));
                    }
                })
                .marshal().json(JsonLibrary.Jackson);
    }
}
