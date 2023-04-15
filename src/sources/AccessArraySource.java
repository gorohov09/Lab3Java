package sources;

import events.AccessArray;

import java.io.IOException;

public class AccessArraySource {
    AccessArray accessArray;

    public AccessArraySource(AccessArray accessArray) {
        this.accessArray = accessArray;
    }

    public void generateEvent() throws IOException {
        accessArray.Handler();
    }
}
