package com.company.store;

import java.io.IOException;

public interface MenuAction {
    int getActionName(int i);
    void execute(Menu menu) throws IOException;
/*    void execute(int article, int quantity);
    void execute(int article);*/
}
