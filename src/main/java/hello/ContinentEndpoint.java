package hello;

import io.spring.generated.GetContinentRequest;
import io.spring.generated.GetContinentResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.FileNotFoundException;

/**
 * Created by gelu on 16.03.2015.
 */
@Endpoint
public class ContinentEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/generated";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContinentRequest")
    @ResponsePayload
    public GetContinentResponse getContinent(@RequestPayload GetContinentRequest request) throws FileNotFoundException {
        GetContinentResponse response = new GetContinentResponse();
        response.setContinentIndex(777);
        throw new FileNotFoundException("asd");
//        return response;
    }
}
