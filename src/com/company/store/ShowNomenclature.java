package com.company.store;

public class ShowNomenclature implements MenuAction {

    private MyStore store;
    private String name;
    private int num ;

    public ShowNomenclature(MyStore store) {
        this.name = "Просмотр списка товаров";
        this.store = store;
    }


    @Override
    public String getActionName() {
        return  name;
    }

    @Override
    public void execute(Menu menu) {
        store.showNomenclature();
    }

}
