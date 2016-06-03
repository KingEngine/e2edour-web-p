


import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinNewsRes;

import com.e2edour.common.utils.JaxbUtil;
import junit.framework.TestCase;
import org.junit.Test;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-config/application_mvc.xml")
public class JokeTest extends TestCase {

    @Test
    public void testBeanToXml() {
        //将java对象转换为XML字符串
       /* WexinTextRes weixinRes = new WexinTextRes();
        weixinRes.setContent("xx");
        JaxbUtil requestBinder = new JaxbUtil(WexinTextRes.class,
                JaxbUtil.CollectionWrapper.class);
        String retXml = requestBinder.toXml(weixinRes);
        System.out.println("xml:\n" + retXml);*/

        WeixinNewsRes weixinNewsRes = new WeixinNewsRes();
        List<WeixinNewsRes.Item> items = new ArrayList<WeixinNewsRes.Item>();
        WeixinNewsRes.Item item = new WeixinNewsRes.Item();
        item.setDescription("");
        items.add(item);
        weixinNewsRes.setItems(items);
        JaxbUtil requestBinder = new JaxbUtil(WeixinNewsRes.class,
                JaxbUtil.CollectionWrapper.class);
        String retXml = requestBinder.toXml(weixinNewsRes);
        System.out.println("xml:\n" + retXml);
    }

    public void testXmlToBean() {
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
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//
            WeiXinReq req = (WeiXinReq) unmar.unmarshal(new StringReader(xml));
            System.out.println("ToUserName--:" + req.getToUserName());
            System.out.println("FromUserName--:" + req.getFromUserName());
            System.out.println("CreateTime--:" + req.getCreateTime());
            System.out.println("MsgType--:" + req.getMsgType());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
