package api_utili;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import java.util.HashMap;



public class API_Responses {

    API_Base apiBase = new API_Base();
    Faker faker = new Faker();
    public String clientName = faker.name().firstName();
    String clientEmail = faker.internet().emailAddress();
    private String cashedToken;
    public Response cashedOrder;


    public Response getAllBooks(){
        return apiBase.get("/books");
    }

    public Response getBookById(String bookId){
        return apiBase.get("/books"+"/"+bookId);
    }

    public Response postAnOrder(){
        ensureToken();
        HashMap<String,Object> requestBody = new HashMap<>();
        requestBody.put("bookId",getBookId());
        requestBody.put("customerName", clientName);
        cashedOrder = apiBase.post(requestBody,"/orders",cashedToken);
        return cashedOrder;
    }

    public Response getOrderByOrderId(){
        ensureToken();
        postAnOrder();
        return apiBase.get("/orders/",cashedToken,cashedOrder.getBody().jsonPath().getString("orderId"));
    }

    public Response updateOrder(){
        HashMap<String,Object> requestBody = new HashMap<>();
        requestBody.put("customerName",clientName);
        return apiBase.patch(getTokenFromRegistration(),requestBody,"/orders/", "Test111");
    }

    public Response deleteOrder(){
        getTokenFromRegistration();
        postAnOrder();
        String orderId = cashedOrder.getBody().jsonPath().getString("orderId");

        return apiBase.delete(cashedToken,"/orders/",orderId);
    }


    public int getBookId(){
        return  getAllBooks().getBody().jsonPath().getInt("[0].id");
    }

    public String getTokenFromRegistration() {
        HashMap<String,Object> requestBody = new HashMap<>();
        requestBody.put("clientName", clientName);
        requestBody.put("clientEmail", clientEmail);
        Response response = apiBase.post(requestBody, "/api-clients");
        response.then().log().body();
         cashedToken = response.getBody().jsonPath().getString("accessToken");
         return cashedToken;
    }

    public String getOrderIdFromPostOrder(){
        ensureCreatedOrder();
        cashedOrder.getBody().jsonPath().getString("orderId");
        return   cashedOrder.getBody().jsonPath().getString("orderId");
    }




    private void ensureToken(){
        if (cashedToken == null){
            cashedToken = getTokenFromRegistration();
        }
    }

    private void ensureCreatedOrder(){
        cashedOrder.then().log().body();
        if (cashedOrder == null){
            cashedOrder = postAnOrder();

        }
    }



}
