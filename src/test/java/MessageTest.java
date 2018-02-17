import com.zdzioch.message.domain.Message;
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
            Message message = new Message.MessageBuilder()
                    .withSubject(subject)
                    .withBody(body)
                    .withFrom(sentFrom)
                    .withTo(sentTo)
                    .build();

            Assert.assertEquals("subject", message.getSubject());
            Assert.assertEquals("body", message.getBody());
            Assert.assertEquals("from", message.getFrom());
            Assert.assertEquals("to", message.getTo());
        }
    }

