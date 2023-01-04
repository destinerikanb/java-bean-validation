package com.destinerikanb.javavalidation.extractor;

import com.destinerikanb.javavalidation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExtractor
        implements ValueExtractor<@ExtractedValue(type = java.lang.Integer.class) DataInteger> {

    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger originalValue, ValueReceiver valueReceiver) {
        valueReceiver.value(null, originalValue.getData());
    }
}
