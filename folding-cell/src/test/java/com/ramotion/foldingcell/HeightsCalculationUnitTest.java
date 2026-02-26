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
    private Context mMockContext;

    /**
     * Default dividing logic - content view splits to several parts with heights equal to title view
     * plus optional last small part that cover remained height
     */
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

    /**
     * Extended logic - when additional flips count is provided - content view splits onto two "main" parts
     * with same size as title view for first big flip. Remained space splits to number of parts provided by developer,
     * but height of each part must be equal or smaller than title view height
     */
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