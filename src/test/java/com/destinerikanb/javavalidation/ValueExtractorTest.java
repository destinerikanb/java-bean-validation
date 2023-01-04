package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.container.Data;
import com.destinerikanb.javavalidation.container.DataInteger;
import com.destinerikanb.javavalidation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest{

    @Test
    void testSampleData() {

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setData("   ");

        validate(sampleData);
    }

    @Test
    void testSampleEntry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");
        sampleEntry.getEntry().setValue("");

        validate(sampleEntry);
    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }
}
