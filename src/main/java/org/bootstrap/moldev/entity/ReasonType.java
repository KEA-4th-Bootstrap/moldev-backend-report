package org.bootstrap.moldev.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bootstrap.moldev.util.EnumField;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ReasonType implements EnumField {
    PROFANITY(1, "Profanity"),
    HATE_SPEECH(2, "Hate Speech"),
    SEXUAL_CONTENT(3, "Sexual Content"),
    VIOLENCE(4, "Violence"),
    SPAM(5, "Spam"),
    HARMFUL_CONTENT(6, "Harmful Content");

    private final Integer code;
    private final String desc;
}
