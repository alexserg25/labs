package local.haus.resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

class UnitResourceTest {

  MockMvc mockMvc;
  ObjectMapper objectMapper;
//
//  UnitRepository repository;
//
//  @BeforeEach
//  void setUp() {
//    repository = mock(UnitRepository.class);
//    mockMvc = MockMvcBuilders.standaloneSetup(new UnitResource(repository)).build();
//    objectMapper = new ObjectMapper();
//  }
//
//  @Test
//  void create() throws Exception {
//    when(repository.save(any())).thenReturn(aUnit());
//    mockMvc.perform(post("/api/units")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(objectMapper.writeValueAsString(aUnit())))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//        .andExpect(content().json(objectMapper.writeValueAsString(aUnit())));
//  }
//
//  @Test
//  void delete() {
//  }
//
//  @Test
//  void findAll() throws Exception {
//    when(repository.findAll()).thenReturn(Collections.singletonList(aUnit()));
//    mockMvc.perform(get("/api/units/all")
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(
//            content().json(objectMapper.writeValueAsString(Collections.singletonList(aUnit()))))
//        .andExpect(status().isOk());
//  }
}