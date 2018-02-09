package dataload;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataLoadIntegrationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void corsWithAnnotation() throws Exception {
    ResponseEntity<DataLoad> entity = this.restTemplate.exchange(
        RequestEntity.get(uri("/loadservice")).header(HttpHeaders.ORIGIN, "http://localhost:9000").build(),
        DataLoad.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("http://localhost:9000", entity.getHeaders().getAccessControlAllowOrigin());
    DataLoad dataload = entity.getBody();
    assertEquals("Thiago Leoncio!", dataload.getContent());
  }

  @Test
  public void corsWithJavaconfig() {
    ResponseEntity<DataLoad> entity = this.restTemplate.exchange(
        RequestEntity.get(uri("/loadservice-javaconfig")).header(HttpHeaders.ORIGIN, "http://localhost:9000").build(),
        DataLoad.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals("http://localhost:9000", entity.getHeaders().getAccessControlAllowOrigin());
    DataLoad dataload = entity.getBody();
    assertEquals("Thiago Leoncio!", dataload.getContent());
  }

  private URI uri(String path) {
    return restTemplate.getRestTemplate().getUriTemplateHandler().expand(path);
  }

}
