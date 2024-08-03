package com.example.booking_apartments.check_location_test;

import com.example.booking_apartments.service.GeoCoderManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.example.booking_apartments.check_location_test.GeoCoderTestConstant.GEO_RESPONSE_VALUE;
import static com.example.booking_apartments.constant.BookingApplicationConstant.GET_APARTMENTS_BY_LOCATION;
import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Matchers.anyString;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CheckLocationGeoTest {

    @Autowired
    private MockMvc mockMvc;

  /*  @MockBean
    private GeoCoderManagerService geoCoderManagerService;*/
    public final static String LATITUDE = "55.795495";
    public final static String LONGITUDE = "37.783327";

    public final static String URL_TEST = "test_url";

    @Test
    public void checkGetApartmentByLocationPositiveTest() throws Exception {
//when we want to get nothing after calling the method
        // Mockito.doNothing().when(geoCoderManagerService.requestToGeo("test"));

      //  Mockito.when(geoCoderManagerService.requestToGeo(anyString())).thenReturn(GEO_RESPONSE_VALUE);
        mockMvc.perform(MockMvcRequestBuilders.get(GET_APARTMENTS_BY_LOCATION)
                        .param("latitude", LATITUDE)
                        .param("longitude",LONGITUDE))
                .andExpect(MockMvcResultMatchers.status().is(200));
        //  .andExpect((ResultMatcher) jsonPath("$").isArray())
        // .andExpect((ResultMatcher) jsonPath("$", Matchers.not(empty())));
    }


    /*@GetMapping(GET_APARTMENTS_BY_LOCATION)
    public List<ApartmentInfoDto> getApartmentByLocation(@RequestParam String latitude, @RequestParam String longitude) {

        return apartmentService.getApartmentsByLocation(latitude, longitude);
    }*/
}
