package org.example;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class createMock {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = EasyMock.createMock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }
    @Test
    public void testAddAndSubtract(){
        //add the behavior to add numbers
        EasyMock.expect(calcService.add(20.0,10.0)).andReturn(30.0);

        //subtract the behavior to subtract numbers
        EasyMock.expect(calcService.subtract(20.0,10.0)).andReturn(10.0);

        //activate the mock
        EasyMock.replay(calcService);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

        //verify call to calcService is made or not
        EasyMock.verify(calcService);
    }

}
