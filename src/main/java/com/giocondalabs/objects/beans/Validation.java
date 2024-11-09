package com.giocondalabs.objects.beans;

import com.giocondalabs.entities.identity.HistoryEntity;

public record Validation(
    HistoryEntity history,
    String sub,
    Long vid
) { }
