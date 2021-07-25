package local.haus.resource;

import static local.haus.prototype.SalesPrototype.aSale;
import static local.haus.prototype.UnitsPrototype.aUnit;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import local.haus.persist.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SaleResourceTest {
  MockMvc mockMvc;
  ObjectMapper objectMapper;

  SaleRepository repository;

  @BeforeEach
  void setUp() {
    repository = mock(SaleRepository.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new SaleResource(repository)).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void create() throws Exception {
    when(repository.save(any())).thenReturn(aSale());
    mockMvc.perform(post("/api/sales")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aSale())))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(aSale())));
  }

  @Test
  void delete() {
  }

  @Test
  void findAll() throws Exception {
    when(repository.findAll()).thenReturn(Collections.singletonList(aSale()));
    mockMvc.perform(get("/api/sales/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content().json(objectMapper.writeValueAsString(Collections.singletonList(aSale()))))
        .andExpect(status().isOk());
  }
}