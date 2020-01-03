package com.example.graphql.resolvers;

import java.util.Map;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

public class AuthDirective implements SchemaDirectiveWiring {
	
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> schemaDirectiveWiringEnv) {
       
    	String targetAuthRole = (String) schemaDirectiveWiringEnv.getDirective().getArgument("role").getValue();

        GraphQLFieldDefinition field = schemaDirectiveWiringEnv.getElement();
        DataFetcher originalDataFetcher = field.getDataFetcher();
        
        DataFetcher authDataFetcher = new DataFetcher() {
            @Override
            public Object get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
                
//            	Map<String, Object> contextMap = dataFetchingEnvironment.getContext();      
//                AuthorisationCtx authContext = (AuthorisationCtx) contextMap.get("authContext");

                if (targetAuthRole.equals("admin")) {
                        return originalDataFetcher.get(dataFetchingEnvironment);
                } else {
                    return null;
                }
                
            }
        };
        //
        // now change the field definition to have the new authorising data fetcher
        return field.transform(builder -> builder.dataFetcher(authDataFetcher));
    }
    
}