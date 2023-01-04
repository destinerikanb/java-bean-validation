package com.destinerikanb.javavalidation;

import com.destinerikanb.javavalidation.container.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SampleData {

    @NotNull
    private Data<@NotBlank @Size(min = 5) String> data;

    public Data<String> getData() {
        return data;
    }

    public void setData(Data<String> data) {
        this.data = data;
    }
}
