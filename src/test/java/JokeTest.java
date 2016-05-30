


import com.e2edour.app.facade.req.WeiXinReq;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-config/application_mvc.xml")
public class JokeTest extends TestCase {

    @Test
    public void testXml() {


        String xml = "<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a test]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(WeiXinReq.class);
            Unmarshaller unmar = jc.createUnmarshaller();
            WeiXinReq req = (WeiXinReq) unmar.unmarshal(new StringReader(xml));
            System.out.println("ToUserName--:"+req.getToUserName());
            System.out.println("FromUserName--:"+req.getFromUserName());
            System.out.println("CreateTime--:"+req.getCreateTime());
            System.out.println("MsgType--:"+req.getMsgType());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
