package com.giocondalabs.objects.request;

import com.giocondalabs.objects.data.DeviceData;
import com.giocondalabs.objects.data.VisitorData;

public record RegisterRequest(
    Integer versionCode,
    String versionName,
    VisitorData visitorData,
    DeviceData deviceData
) {

    public boolean isValid() {
        return
            visitorData != null &&
            visitorData.isValid() &&
            deviceData != null &&
            deviceData.isValid();
    }
}
