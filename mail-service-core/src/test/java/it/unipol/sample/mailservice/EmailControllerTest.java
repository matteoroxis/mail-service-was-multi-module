//package it.unipol.sample.mailservice;
//
//import it.unipol.sample.mailservice.controller.EmailController;
//import it.unipol.sample.mailservice.model.Email;
//import it.unipol.sample.mailservice.service.EmailService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = EmailController.class, secure = false)
//public class EmailControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmailService emailService;
//
//    Logger logger = LoggerFactory.getLogger(EmailControllerTest.class);
//
//    Email mockEmail = new Email();
//
//    String exampleEmailJson = "{\"active\":\"true\"," +
//            "\"createdAt\":\"2018-11-15T17:57:01.926\"," +
//            "\"updatedAt\":\"2018-11-15T17:57:01.926\"," +
//            "\"id\":\"10001\"," +
//            "\"subject\":\"Test Mail from PostgreSQL\"," +
//            "\"to\":\"matt.rossi@reply.it\"," +
//            "\"body\":\"Questa è una mail di test\"}";
//
//    @Test
//    public void retrieveBodyMail() throws Exception {
//
//        Mockito.when(emailService.getEmail(Long.valueOf("10001"))).thenReturn(mockEmail);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/email/10001").accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        logger.info(result.getResponse().getContentAsString());
//
//        JSONAssert.assertEquals(exampleEmailJson,result.getResponse().getContentAsString(),false);
//
//    }
//
//
//}
