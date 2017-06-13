package e2e;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author stjep
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = E2eTests.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableAutoConfiguration
public class E2eTests {

    @Value("${application.url}")
    String applicationUrl;

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void thisShouldWork() {
        ResponseEntity<String> postEntity = this.testRestTemplate
                .postForEntity("http://" + this.applicationUrl + "/?message=msg", null, String.class);
        then(postEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertEquals("msg", postEntity.getBody());
        
        @SuppressWarnings("rawtypes")
        ResponseEntity<List> entity = this.testRestTemplate
                .getForEntity("http://" + this.applicationUrl + "/", List.class);
        then(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertTrue(entity.getBody().contains("msg"));
    }
}
