package com.JatinCodes.mockito.mockitodemo.business;

/**
 * Implemented Mock method :
 * Easy to implement and less tedious to maintain code
 * In case of Stub if we are writing n test cases , then we also need to write n classes
 * So because of Mock we only need to write n tests.
 *
 * After this we made the code more short :
 * by adding @1 and @2
 * Also added ExtendWith , InjectMocks , Mock annotations
 *
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  // imp to add this else will not work
class SomeBusinessImplMockTest {

    @Mock // @1
    private DataService dataServiceMock;

    @InjectMocks  // @2
    private SomeBusinessImpl businessImpl;

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        // @1 DataService dataServiceMock = mock(DataService.class);
        // through below we can directly assign value , instead of creating many classes to test many cases
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 5});
        // @2 : SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);  // this is done to assign value
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }
    // Below 2 codes tell how we can write small codes
    @Test
    void findTheGreatestFromAllData_OneValueTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}