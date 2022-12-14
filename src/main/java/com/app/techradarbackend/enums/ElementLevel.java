package com.app.techradarbackend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementLevel {
    ADOPT(1, "ADOPT", "We have experience and trust in this technology. There is no doubt that it is proven and mature for use. For a particular use case, we see this as the best choice."),
    TRIAL(2, "TRIAL", "Recommended for use on a trial basis. Not completely proven. More experience is needed."),
    ASSESS(3, "ASSESS", "We see a lot of potential in this technology, but it needs more research and validation."),
    HOLD(4, "HOLD", "Avoid if possible. Flawed or not mature enough. There are better alternatives now.");

    private final int levelId;
    private final String levelName;
    private final String levelDescription;
}
