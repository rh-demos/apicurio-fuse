package com.example.beer.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import com.example.beer.dto.Beer;

/*
    This is a stub for the Driver endpoint that just returns some itelimatics data.
    Only to be used for mock testing.

 */


@Component
public class GetBeerByNameRoute extends RouteBuilder {
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
                        Beer b = new Beer();
                        b.setCountry("Denmark");
                        b.setName(name);
                        b.setRating(new BigDecimal(5));
                        b.setStatus("N/A");
                        b.setType("Pilsner");

                        exchange.getIn().setBody(b);
                    }
                })
                .marshal().json(JsonLibrary.Jackson);
    }
}
