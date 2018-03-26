package com.percival.beth.apptest.ui.location;

import android.content.Context;

import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.network.response.GetLocationsResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
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
    private Location mockGetLocationsResponse;

    private LocationPresenter mockPresenter;

    private static final Location NULL_RESPONSE = null;
    private static final int LIST_ITEM_POSITION = 1;

    @Before
    public void setUp() throws Exception {
        mockPresenter = new LocationPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetLocations_whenViewReadyIsCalled() {
        mockPresenter.onViewReady();

        verify(mockData).getLocations(mockPresenter);
    }

    @Test
    public void shouldCallPopulateList_whenDataReadyIsCalled() {
        mockPresenter.onDataReady(mockGetLocationsResponse);

        verify(mockView).populateList(mockGetLocationsResponse);
    }

    @Test
    public void shouldCallDisplayError_whenDataIsNull() {
        mockPresenter.onDataReady(NULL_RESPONSE);

        verify(mockView).displayError();
    }

    @Test
    public void shouldCallGetLocationDetails_whenListItemSelectedIsCalled() {
        mockPresenter.listItemSelected(mockLocation);

        verify(mockView).openHolidayDetailsActivity(mockLocation);
    }

    @Test
    public void shouldCallDisplayError_whenLocationDetailsAreNull() {
        mockPresenter.listItemSelected(null);

        verify(mockView).displayError();
    }

}