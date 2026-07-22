package com.cognizant.junitmockitopractice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    ExternalApi mockApi;

    @InjectMocks
    MyService service;

    // Exercise 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // Exercise 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        when(mockApi.getData()).thenReturn("Mock Data");

        service.fetchData();

        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();
    }

    // Exercise 3: Argument Matching
    @Test
    public void testArgumentMatching() {
        when(mockApi.getDataById(anyLong())).thenReturn("Data for ID");
        when(mockApi.getDataById(1L)).thenReturn("Data for ID 1");

        String result = service.fetchDataById(1L);

        assertEquals("Data for ID 1", result);
        verify(mockApi).getDataById(eq(1L));
    }

    // Exercise 4: Handling Void Methods
    @Test
    public void testVoidMethod() {
        // void methods do nothing by default — just verify
        doNothing().when(mockApi).sendData(anyString());

        service.sendData("Hello");

        verify(mockApi).sendData("Hello");
    }

    // Exercise 5: Multiple Return Values
    @Test
    public void testMultipleReturnValues() {
        when(mockApi.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data")
                .thenReturn("Third Data");

        assertEquals("First Data",  service.fetchData());
        assertEquals("Second Data", service.fetchData());
        assertEquals("Third Data",  service.fetchData());
    }

    // Exercise 6: Verifying Interaction Order
    @Test
    public void testInteractionOrder() {
        when(mockApi.getData()).thenReturn("Data");
        when(mockApi.getDataById(1L)).thenReturn("Data 1");

        service.fetchData();
        service.fetchDataById(1L);
        service.fetchData();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).getDataById(1L);
        inOrder.verify(mockApi).getData();
    }

    // Exercise 7: Void Methods with Exceptions
    @Test
    public void testVoidMethodThrowsException() {
        doThrow(new RuntimeException("Send failed"))
                .when(mockApi).sendData(anyString());

        assertThrows(RuntimeException.class, () -> service.sendData("Hello"));
        verify(mockApi).sendData("Hello");
    }
}
