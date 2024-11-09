package com.giocondalabs.objects.beans;

public record Authorization(
    String jti,
    String sub,
    String vid
) { }
