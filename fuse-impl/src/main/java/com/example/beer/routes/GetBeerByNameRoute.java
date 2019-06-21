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
public class GetBeerByNameRoute extends RouteBuilder {
	@BeanInject
	private BeerService mBeerService;
	
    @Override
    public void configure() throws Exception {
        from("direct:GetBeer")
                .process( new Processor(){

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String name = exchange.getIn().getHeader("name", String.class);
                        if(name == null) {
                            throw new IllegalArgumentException("must provide a name");
                        }
                        Beer b = mBeerService.getBeerByName(name);

                        exchange.getIn().setBody(b == null? new Beer(): b);
                    }
                })
                .marshal().json(JsonLibrary.Jackson);
    }
}
