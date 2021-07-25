package local.haus.resource;

import static local.haus.prototype.SaleItemsPrototype.aSaleItem;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import local.haus.persist.SaleItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SaleItemResourceTest {
  MockMvc mockMvc;
  ObjectMapper objectMapper;

  SaleItemRepository repository;

  @BeforeEach
  void setUp() {
    repository = mock(SaleItemRepository.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new SaleItemResource(repository)).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void create() throws Exception {
    when(repository.save(any())).thenReturn(aSaleItem());
    mockMvc.perform(post("/api/sale_items")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aSaleItem())))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(aSaleItem())));
  }

  @Test
  void delete() {
  }

  @Test
  void findAll() throws Exception {
    when(repository.findAll()).thenReturn(Collections.singletonList(aSaleItem()));
    mockMvc.perform(get("/api/sale_items/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content().json(objectMapper.writeValueAsString(Collections.singletonList(aSaleItem()))))
        .andExpect(status().isOk());
  }
}