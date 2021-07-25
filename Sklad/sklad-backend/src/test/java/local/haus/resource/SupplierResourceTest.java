package local.haus.resource;

import static local.haus.prototype.SuppliersPrototype.aSupplier;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import local.haus.persist.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SupplierResourceTest {

  MockMvc mockMvc;
  ObjectMapper objectMapper;

  SupplierRepository repository;


  @BeforeEach
  void setUp() {
    repository = mock(SupplierRepository.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new SupplierResource(repository)).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void create() throws Exception {
    when(repository.save(any())).thenReturn(aSupplier());
    mockMvc.perform(post("/api/suppliers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aSupplier())))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(aSupplier())));
  }

  @Test
  void delete() {
  }

  @Test
  void findAll() throws Exception {
    when(repository.findAll()).thenReturn(Collections.singletonList(aSupplier()));
    mockMvc.perform(get("/api/suppliers/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content().json(objectMapper.writeValueAsString(Collections.singletonList(aSupplier()))))
        .andExpect(status().isOk());
  }
}