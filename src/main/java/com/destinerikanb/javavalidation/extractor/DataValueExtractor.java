package com.destinerikanb.javavalidation.extractor;

import com.destinerikanb.javavalidation.container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver valueReceiver) {
        //Yang akan kita validasi adalah data
        Object data = originalValue.getData();
        //Untuk mengambil data extracted value dan memasukkannya ke dalam receiver
        //receiver digunakan untuk memberi tahu data mana yang diterima
        //nodeName kita buat null karena tidak butuh node karena bukan nested object misalnya
        valueReceiver.value(null, data);
    }
}
