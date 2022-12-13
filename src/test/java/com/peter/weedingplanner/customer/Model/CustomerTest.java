package com.peter.weedingplanner.customer.Model;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@AllArgsConstructor
@Tag("model")
class CustomerTest {


    @Test
    void getId() {
        Customer dummyCustomer = Customer.builder()
            .id(12L)
            .firstName("dummy")
            .lastName("doe")
            .email("dummy@email.com")
            .build();

        assertEquals(12L, dummyCustomer.getId());
        assertNotEquals(1L, dummyCustomer.getId());
        Customer buddy = Customer.builder()
                .build();
        assertNotEquals(buddy, buddy.getId());
        assertEquals(null, buddy.getId());
    }

    @Test
    void getFirstName() {
        Customer dummyCustomer = Customer.builder()
                .firstName("dummy")
                .lastName("doe")
                .email("dummy@email.com")
                .build();

        assertEquals("dummy", dummyCustomer.getFirstName());
        assertNotEquals(null, dummyCustomer.getFirstName());
    }

    @Test
    void getLastName() {
        Customer dummyCustomer = Customer.builder()
                .firstName("dummy")
                .lastName("doe")
                .email("dummy@email.com")
                .build();

        assertEquals("doe", dummyCustomer.getLastName());
        assertNotEquals("dymmu", dummyCustomer.getLastName());
        assertNotEquals(null, dummyCustomer.getLastName());
    }

    @Test
    void getEmail() {

        Customer dummyCustomer = Customer.builder()
                .firstName("dummy")
                .lastName("doe")
                .email("dummy@email.com")
                .build();

        assertEquals("dummy@email.com", dummyCustomer.getEmail());
        assertNotEquals("dummy", dummyCustomer.getEmail());
        assertNotEquals(null, dummyCustomer.getEmail());
    }


}