package com.hs.openframeanalysis.zzzzzz.static_proxy;

public class  海外代购 extends AbstractObject{
    //代购对客户的引用
    private 客户 kehu;

    public 海外代购(客户 kehu) {
        this.kehu = kehu;
    }

    @Override
    protected void operation() {
        System.out.println("do something before real peration...");
        if (null==kehu){
            kehu=new 客户();
        }
        kehu.operation();
        System.out.println("do something after real peration...");
    }
}
