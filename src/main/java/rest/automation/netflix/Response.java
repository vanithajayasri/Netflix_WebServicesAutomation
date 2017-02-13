package rest.automation.netflix;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status.Family;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

/**
 * A object represents restful service call response
 *
 * @author VIC
 */
public class Response {
  //Client response from Jersey
  private ClientResponse clientResponse;
  //Response start time in Nano seconds
  private long startTime;
  //Response end time in Nano seconds
  private long endTime;

  Response(ClientResponse clientResponse) {
    this.clientResponse = clientResponse;
  }

  void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  void setEndTime(long endTime) {
    this.endTime = endTime;
  }

 
}
