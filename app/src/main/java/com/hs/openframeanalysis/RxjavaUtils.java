package com.hs.openframeanalysis;

import android.graphics.Bitmap;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.http.PUT;

public class RxjavaUtils {

    /**
     * 第一步：创建被观察者
     */
    public static void RxjavaCreateDemo() {
        //Observable.create 方式创建被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("Hello");
                emitter.onNext("Imooc");
                emitter.onComplete();
            }
        });
        //通过just方法创建被观察者
        Observable<String> observable1 = Observable.just("hello", "Imooc");

        //通过from方法来创建被观察者
        String[] paramteers = {"hello", "Imooc"};
        Observable<String> observable2 = Observable.fromArray(paramteers);

        /**
         * 第二步：创建观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        /**
         * 第三部：订阅
         */
        observable.subscribe(observer);
        observable1.subscribe(observer);
        observable2.subscribe(observer);
        Observable.just("hello")
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Throwable {
                        return getBitmap(s);
                    }
                }).subscribe(new Consumer<Bitmap>() {
            @Override
            public void accept(Bitmap bitmap) throws Throwable {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Throwable {

            }
        }, new Action() {
            @Override
            public void run() throws Throwable {

            }
        });

    }

    private static Bitmap getBitmap(String s) {
        return null;
    }


    public static void RxjavaTest() {
        Observable<Boolean>
                observable = new Observable<Boolean>() {
            @Override
            protected void subscribeActual(@NonNull Observer<? super Boolean> observer) {

            }
        };
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Boolean aBoolean) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
