package com.percival.beth.apptest.ui.flight;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by beth_ on 25/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlightPresenterTest {

    @Mock
    private IFlightView mockView;
    @Mock
    private FlightData mockData;
    @Mock
    private Flight mockFlight;
    @Mock
    private GetFlightsResponse mockGetFlightsResponse;

    private FlightPresenter mockPresenter;

    private static final GetFlightsResponse NULL_RESPONSE = null;

    @Before
    public void setUp() throws Exception {
        mockPresenter = new FlightPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetFlights_whenViewReadyIsCalled() {
        mockPresenter.onViewReady();

        verify(mockData).getFlights(mockPresenter);
    }

    @Test
    public void shouldCallPopulateList_whenDataReadyIsCalled() {
        mockPresenter.onDataReady(mockGetFlightsResponse);

        verify(mockView).populateList(mockGetFlightsResponse);
    }

    @Test
    public void shouldCallDisplayError_whenDataIsNull() {
        mockPresenter.onDataReady(NULL_RESPONSE);

        verify(mockView).displayError();
    }

}