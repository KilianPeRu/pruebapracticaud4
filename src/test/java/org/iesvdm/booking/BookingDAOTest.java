package org.iesvdm.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookingDAOTest {

    private BookingDAO bookingDAO;
    private Map<String, BookingRequest> bookings;

    @BeforeEach
    public void setup() {
        bookings = new HashMap<>();
        bookingDAO = new BookingDAO(bookings);
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas (bookings) con la que
     * construyes el objeto BookingDAO bajo testeo.
     * Comprueba que cuando invocas bookingDAO.getAllBookingRequest
     * obtienes las 2 peticiones.
     */
    @Test
    void  getAllBookingRequestsTest() {
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),2,true);
        BookingRequest bookingRequest2 = new BookingRequest("9", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),3,true);
        String book1 = bookingDAO.save(bookingRequest);
        String book2 = bookingDAO.save(bookingRequest2);
        Collection<BookingRequest> mapa = bookingDAO.getAllBookingRequests();

        System.out.println(mapa);
        System.out.print(book1);
        System.out.print(book2 + "\n");
        System.out.print(bookingDAO.getAllBookingRequests());

        Map<String, BookingRequest> map = new HashMap<>();
        map.put(book1, bookingRequest);
        map.put(book2, bookingRequest2);


        assertThat(bookingDAO.getAllBookingRequests()).isEqualTo(map.get(bookingRequest));
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.getAllUUIDs
     * obtienes las UUIDs de las 2 peticiones guardadas.
     */
    @Test
    void getAllUUIDsTest() {
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),2,true);
        BookingRequest bookingRequest2 = new BookingRequest("9", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),3,true);
        String book1 = bookingDAO.save(bookingRequest);
        String book2 = bookingDAO.save(bookingRequest2);
        Collection<BookingRequest> mapa = bookingDAO.getAllBookingRequests();


        Map<String, BookingRequest> map = new HashMap<>();
        map.put(book1, bookingRequest);
        map.put(book2, bookingRequest2);

        assertThat(bookingDAO.getAllUUIDs()).isEqualTo(map.keySet());
    }


    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * Comprueba que cuando invocas bookingDAO.get con el UUID
     * obtienes las respectivas 2 peticiones guardadas.
     */
    @Test
    void getTest() {
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),2,true);
        BookingRequest bookingRequest2 = new BookingRequest("9", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),3,true);
        String book1 = bookingDAO.save(bookingRequest);
        String book2 = bookingDAO.save(bookingRequest2);
        Collection<BookingRequest> mapa = bookingDAO.getAllBookingRequests();

        assertThat(bookingRequest).isEqualTo(bookingDAO.get(book1));
        assertThat(bookingRequest2).isEqualTo(bookingDAO.get(book2));
    }

    /**
     * Crea 2 peticiones de reserva (BookingRequest)
     * agrégalas a las reservas mediante bookingDAO.save.
     * A continuación, borra la primera y comprueba
     * que se mantiene 1 reserva, la segunda guardada.
     */
    @Test
    void deleteTest() {
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),2,true);
        BookingRequest bookingRequest2 = new BookingRequest("9", LocalDate.of(2024,05,17),LocalDate.of(2024,05,18),3,true);
        String book1 = bookingDAO.save(bookingRequest);
        String book2 = bookingDAO.save(bookingRequest2);
        bookingDAO.delete(book1);
        Collection<BookingRequest> mapa = bookingDAO.getAllBookingRequests();


        Map<String, BookingRequest> map = new HashMap<>();
        map.put(book2, bookingRequest2);

        assertThat(bookingDAO.getAllUUIDs()).isEqualTo(map.keySet());
    }

    /**
     * Guarda 2 veces la misma petición de reserva (BookingRequest)
     * y demuestra que en la colección de bookings están repetidas
     * pero con UUID diferente
     *
     */
    @Test
    void saveTwiceSameBookingRequestTest() {

    }

}
