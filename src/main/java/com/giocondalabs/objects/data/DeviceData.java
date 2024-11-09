package com.giocondalabs.objects.data;

import static com.giocondalabs.utils.GeneralHelper.validateString;

public record DeviceData(
    String androidId,
    Integer sdkInt,
    String realiseVersion,
    String brand,
    String model
) {

    public boolean isValid() {
        return (
            (validateString(androidId)) &&
            (sdkInt != null) &&
            (validateString(realiseVersion)) &&
            (validateString(brand)) &&
            (validateString(model))
        );
    }
}
