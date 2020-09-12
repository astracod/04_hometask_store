package com.company.store;

import java.io.IOException;

public interface MenuAction {
    String getActionName();
    void execute(Menu menu) throws IOException;
}
