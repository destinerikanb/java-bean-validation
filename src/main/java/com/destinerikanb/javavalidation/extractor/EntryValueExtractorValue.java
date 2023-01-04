package com.destinerikanb.javavalidation.extractor;

import com.destinerikanb.javavalidation.container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryValueExtractorValue implements ValueExtractor<Entry<?, @ExtractedValue ?>> {

    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver valueReceiver) {
        //Untuk multiple value dapat menggunakan method value, keyedValue, dan indexedValue
        //value -> untuk valuenya saja
        //keyedValue -> ingin memberi tahu object apa yang error
        //indexedValue -> ingin memberi tahu index mana yang error
        valueReceiver.keyedValue(null, "value", originalValue.getKey());
    }
}
