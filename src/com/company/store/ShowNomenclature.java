package com.company.store;

public class ShowNomenclature implements MenuAction {
    /*   private Product product;
        private int quantity = 1;

        public CartItem(Product product, int quantity) {
            this.product = product;
            setQuantity(quantity);
        }*/
    private MyStore store;
    private String name;
    private int num ;

    public ShowNomenclature() {
        this.name = "Просмотр списка товаров :";
        this.store = new MyStore();
    }


    @Override
    public int getActionName(int i) {
        System.out.println(name);
        return this.num = 1 + i;
    }

    @Override
    public void execute(Menu menu) {
        store.showNomenclature();
    }



/*    @Override
    public void execute(int article, int quantity) {

    }

    @Override
    public void execute(int article) {

    }*/


}
