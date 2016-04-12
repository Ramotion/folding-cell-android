package com.ramotion.foldingcell;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HeightsCalculationUnitTest {

    @Mock
    Context mMockContext;

    @Test
    public void defaultLogic() throws Exception {
        FoldingCell fc = new FoldingCell(mMockContext);

        ArrayList<Integer> actualHeights1 = fc.calculateHeightsForAnimationParts(50, 180, 0);
        ArrayList<Integer> expectedHeights1 = new ArrayList<>(Arrays.asList(50, 50, 50, 30));
        assertEquals("Heights array is not correct", expectedHeights1, actualHeights1);

        ArrayList<Integer> actualHeights2 = fc.calculateHeightsForAnimationParts(50, 100, 0);
        ArrayList<Integer> expectedHeights2 = new ArrayList<>(Arrays.asList(50, 50));
        assertEquals("Heights array is not correct", expectedHeights2, actualHeights2);

    }

    @Test(expected = IllegalStateException.class)
    public void defaultLogicError() throws Exception {
        FoldingCell fc = new FoldingCell(mMockContext);
        fc.calculateHeightsForAnimationParts(50, 80, 0);
    }

    @Test
    public void extendedLogic() throws Exception {
        FoldingCell fc = new FoldingCell(mMockContext);

        ArrayList<Integer> actualHeights1 = fc.calculateHeightsForAnimationParts(50, 160, 2);
        ArrayList<Integer> expectedHeights1 = new ArrayList<>(Arrays.asList(50, 50, 30, 30));
        assertEquals("Heights array is not correct", expectedHeights1, actualHeights1);

        ArrayList<Integer> actualHeights2 = fc.calculateHeightsForAnimationParts(50, 161, 2);
        ArrayList<Integer> expectedHeights2 = new ArrayList<>(Arrays.asList(50, 50, 31, 30));
        assertEquals("Heights array is not correct", expectedHeights2, actualHeights2);
    }

    @Test(expected = IllegalStateException.class)
    public void extendedLogicError() throws Exception {
        FoldingCell fc = new FoldingCell(mMockContext);
        fc.calculateHeightsForAnimationParts(50, 201, 2);
    }

}