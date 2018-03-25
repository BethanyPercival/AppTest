package com.percival.beth.apptest.ui.location;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by beth_ on 25/03/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocationPresenterTest {

    @Mock
    private ILocationView mockView;
    @Mock
    private LocationData mockData;
    @Mock
    private Location mockLocation;
    @Mock
    private GetLocationsResponse mockGetPlantDetailsResponse;

    private LocationPresenter mockPresenter;

    private static final String ERROR_MESSAGE = "There was an error";
    private static final int LIST_ITEM_POSITION = 1;
    private static final int MOCK_LOCATION_NULL = 1;

    @Before
    public void setUp() throws Exception {
        mockPresenter = new LocationPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetLocations_whenViewReadyIsCalled() {
        mockPresenter.OnViewReady();

        verify(mockData).getLocations();
    }

    @Test
    public void shouldCallPopulateList_whenDataReadyIsCalled() {
        List<Location> list = new ArrayList<>();
        list.add(mockLocation);
        when(mockGetPlantDetailsResponse.getLocationList()).thenReturn(list);

        mockPresenter.onDataReady(mockGetPlantDetailsResponse);

        verify(mockView).populateList(mockLocation);
    }

    @Test
    public void shouldCallDisplayError_whenDataErrorIsCalled() {
        mockPresenter.onDataError(ERROR_MESSAGE);

        verify(mockView).displayError(ERROR_MESSAGE);
    }

    @Test
    public void shouldCallGetLocationDetails_whenListItemSelectedIsCalled() {
        mockPresenter.listItemSelected(LIST_ITEM_POSITION);

        verify(mockData).getLocationDetails(LIST_ITEM_POSITION);
    }

    @Test
    public void shouldCallOpenHolidayDetails_whenLocationDetailsAreNotNull() {
        when(mockData.getLocationDetails(LIST_ITEM_POSITION)).thenReturn(mockLocation);

        verify(mockView).openHolidayDetailsActivity(mockLocation);
    }

    @Test
    public void shouldCallDisplayError_whenLocationDetailsAreNull() {
        when(mockData.getLocationDetails(LIST_ITEM_POSITION)).thenReturn(null);

        verify(mockView).displayError(ERROR_MESSAGE);
    }

}