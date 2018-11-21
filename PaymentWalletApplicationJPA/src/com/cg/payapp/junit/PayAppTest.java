package com.cg.payapp.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cg.payapp.exception.PayAppException;
import com.cg.payapp.service.PayAppService;
import com.cg.payapp.service.PayAppServiceImpl;

public class PayAppTest 
{
	//TestClass cases for name
			@Test(expected=PayAppException.class)
		    public void test_ValidateName_null() throws PayAppException{
		        PayAppService service=new PayAppServiceImpl();
		        service.validateName(null);
		    }
		    
		    @Test
		    public void test_validateName_v1() throws PayAppException{
		    
		        String name="Aete121";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateName(name);
		        assertEquals(false,result);
		    }
		    @Test
		    public void test_validateName_v2() throws PayAppException{
		    
		        String name="Amita";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateName(name);
		        assertEquals(true,result);
		    }
		    @Test
		    public void test_validateName_v3() throws PayAppException{
		    
		        String name="amita";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateName(name);
		        assertEquals(false,result);
		    }
		    
		    //TestClass cases for Mobile number	    
		    
		    @Test
		    public void test_validateMobNo_v1() throws PayAppException{
		        String mobNo="ABCD91828288";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateMobileNo(mobNo);
		        assertEquals(false,result);
		    }
		    @Test
		    public void test_validateMobNo_v2() throws PayAppException{
		    
		        String mobNo="9922974725";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateMobileNo(mobNo);
		        assertEquals(true,result);
		    }
		    @Test
		    public void test_validateMobNo_v3() throws PayAppException{
		    
		        String mobNo="992297";
		        PayAppService service=new PayAppServiceImpl();
		        boolean result= service.validateMobileNo(mobNo);
		        assertEquals(false,result);
		    }

}
