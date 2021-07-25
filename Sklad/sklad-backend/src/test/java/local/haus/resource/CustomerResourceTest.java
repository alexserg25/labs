package local.haus.resource;

import static local.haus.prototype.CustomersPrototype.aCustomer;
import static local.haus.prototype.SuppliersPrototype.aSupplier;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import local.haus.persist.CustomerRepository;
import local.haus.persist.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class CustomerResourceTest {

  MockMvc mockMvc;
  ObjectMapper objectMapper;

  CustomerRepository repository;

  @BeforeEach
  void setUp() {
    repository = mock(CustomerRepository.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new CustomerResource(repository)).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  void create() throws Exception {
    when(repository.save(any())).thenReturn(aCustomer());
    mockMvc.perform(post("/api/customers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aCustomer())))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(objectMapper.writeValueAsString(aCustomer())));
  }

  @Test
  void delete() {
  }

  @Test
  void findAll() throws Exception {
    when(repository.findAll()).thenReturn(Collections.singletonList(aCustomer()));
    mockMvc.perform(get("/api/customers/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            content().json(objectMapper.writeValueAsString(Collections.singletonList(aCustomer()))))
        .andExpect(status().isOk());
  }
}