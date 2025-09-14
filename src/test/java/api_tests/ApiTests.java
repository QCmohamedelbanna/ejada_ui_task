package api_tests;


import api_utili.API_Config;
import api_utili.API_Responses;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.core.Is.is;


public class ApiTests {

    API_Responses apiResponses = new API_Responses();

    @BeforeTest
    public void API_Init(){
        baseURI = API_Config.API_URL;
    }

    @Test
    public void assertThatGetAllBooksSuccessfully(){
        Response booksResponse = apiResponses.getAllBooks();
        int statusCode = booksResponse.getStatusCode();
        System.out.println("status code = " + statusCode);
        Assert.assertEquals(statusCode,200,"GET all books are failed");
    }
    @Test
    public void assertThatGetOneBookByIdSuccessfully(){
        Response bookIdResponse = apiResponses.getBookById("1");

        int bookId = bookIdResponse.getBody().jsonPath().getInt("id");
        System.out.println("Book Id is: " + bookId);
        Assert.assertEquals(bookId,1,"Not the right book is retrieved");

        String entityType = bookIdResponse.getBody().jsonPath().getString("entityType");
        System.out.println("Type is : " + entityType);
        Assert.assertEquals(entityType,"BOOK", "Type isn't Books");

        String bookNameInAllBooksApi = apiResponses.getAllBooks().getBody().jsonPath().getString("[0].name");
        String bookName = bookIdResponse.getBody().jsonPath().getString("name");
        System.out.println("Book Name is: " + bookName);
        System.out.println("book Name In All Books API is: " + bookNameInAllBooksApi);
        Assert.assertEquals(bookName,bookNameInAllBooksApi,"It's not the right Name for this book");

        String bookTypeInAllBooksApi = apiResponses.getAllBooks().getBody().jsonPath().getString("[0].type");
        String bookType = bookIdResponse.getBody().jsonPath().getString("type");
        System.out.println("Book Type is: " + bookType);
        System.out.println("book Type In All Books API is: " + bookTypeInAllBooksApi);
        Assert.assertEquals(bookType,bookTypeInAllBooksApi,"It's not the right Type for this books");

        String bookAvailabilityInAllBooksApi = apiResponses.getAllBooks().getBody().jsonPath().getString("[0].available");
        String bookAvailability = apiResponses.getBookById("1").getBody().jsonPath().getString("available");
        System.out.println("Book Availability is: " + bookAvailability);
        System.out.println("book Availability In All Books API is: " + bookAvailabilityInAllBooksApi);
        Assert.assertEquals(bookAvailability,bookAvailabilityInAllBooksApi,"Books isn't available !");

    }
    @Test
    public void assertThatPostOrderSuccessfully(){
        Response response = apiResponses.postAnOrder();

        apiResponses.cashedOrder.then().log().body();

        boolean isCreated = response.getBody().jsonPath().getBoolean("created");
        Assert.assertTrue(isCreated,"Order isn't posted");
        Assert.assertFalse(response.getBody().jsonPath().getString("orderId").isEmpty());
    }
    @Test
    public void assertThatCreatedOrderIsDisplayedInOrdersList(){
        Response response = apiResponses.getOrderByOrderId();
        response.then().log().body();

        String orderIdFromPostOrder = apiResponses.getOrderIdFromPostOrder();
        String orderIdFromGetOrder = response.getBody().jsonPath().getString("id");
        System.out.println("Order Id from Post Order: " + orderIdFromPostOrder);
        System.out.println("Order Id from Get Order By Id: " + orderIdFromGetOrder);
        Assert.assertEquals(orderIdFromGetOrder,orderIdFromPostOrder, "It's not the right Order");

        int bookIdFromGetOrder = response.getBody().jsonPath().getInt("bookId");
        int bookIdFromPostOrder = apiResponses.getBookId();
        System.out.println("bookIdFromGetOrder :" + bookIdFromGetOrder);
        System.out.println("bookIdFromPostOrder :" + bookIdFromPostOrder);
        Assert.assertEquals(bookIdFromGetOrder,bookIdFromPostOrder,"It's not the bookId which has created an order");

        String cashedName = apiResponses.clientName;
        String customerNameInGetOrder = response.getBody().jsonPath().getString("customerName");
        System.out.println("Cashed Customer Name: " + cashedName);
        System.out.println("Customer Name: " + customerNameInGetOrder);
        Assert.assertEquals(customerNameInGetOrder,cashedName,"It's not customer who created the order");
    }
    @Test
    public void assertThatValidationMessageDisplayedWithInvalidOrderId(){
        Response response = apiResponses.updateOrder();
        response.then().log().body();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,404, "It's a valid URL");

        String errorMsg = response.getBody().jsonPath().getString("error");
        System.out.println("Error Message is: " + errorMsg);
        Assert.assertTrue(errorMsg.contains("No order with id "));

    }
    @Test
    public void assertThatOrderIsDeletedSuccessfully(){
        Response response = apiResponses.deleteOrder();
        response.then().log().body();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204,"Order isn't deleted");

    }

}
