import com.zdzioch.message.domain.Message;
import com.zdzioch.message.domain.MessageFactory;
import com.zdzioch.message.service.MessageDTO;
import org.junit.Assert;
import org.junit.Test;


    public class MessageTest {
        /// od czerwono napisanych do podkreslonych

        @Test
        public void shouldCreateMessageWithRequiredFields() {
            String sentTo = "to";
            String sentFrom = "from";
            String body = "body";
            String subject = "subject";

            MessageDTO messageDTO = new MessageDTO();
            messageDTO.setTo(sentTo);
            messageDTO.setFrom(sentFrom);
            messageDTO.setBody(body);
            messageDTO.setSubject(subject);
            Message message = new MessageFactory().createFrom(messageDTO);


            Assert.assertEquals("subject", message.getSubject());
            Assert.assertEquals("body", message.getBody());
            Assert.assertEquals("from", message.getFrom());
            Assert.assertEquals("to", message.getTo());
        }
    }

