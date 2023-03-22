package com.JatinCodes.mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simpleTest(){

        List listMock = mock(List.class);
        //assign listMock.size() a value of 3
        when(listMock.size()).thenReturn(3);

        assertEquals(3,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(3,listMock.size());

    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        //assign listMock.size() a value of 3
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size()); // by default last value will be called
        assertEquals(2, listMock.size()); // by default last value will be called
    }

    @Test
    void specificParameters() {
        List listMock = mock(List.class);
        //listMock.size() => 3
        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals(null, listMock.get(1)); // by default returns a null
    }

    @Test
    void genericParameters() {
        List listMock = mock(List.class);
        //listMock.size() => 3
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
        assertEquals("SomeOtherString", listMock.get(0)); // this will return the "SomeOtherString" for every value
        assertEquals("SomeOtherString", listMock.get(1));
    }
}
