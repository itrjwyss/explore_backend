package com.giocondalabs.objects.data;

import static com.giocondalabs.utils.GeneralHelper.isValidEmail;
import static com.giocondalabs.utils.GeneralHelper.isValidPassword;
import static com.giocondalabs.utils.GeneralHelper.validateString;

public record VisitorData(
    String name,
    String lastName,
    String picture,
    String email,
    String password,
    Long countryId,
    Long stateId,
    Long cityId
) {

    public boolean isValid() {
        return validateString(name) &&
            validateString(lastName) &&
            isValidEmail(email) &&
            isValidPassword(password) &&
            countryId != null && countryId > 0;
    }
}
