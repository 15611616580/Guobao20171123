package utils;


import java.util.Map;

import cart.bean.AddcartBean;
import cart.bean.OrderBean;
import cart.bean.QurryBean;
import homepage.bean.HomeBean;
import mine.bean.Login;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import sort.bean.Commodity_pagingBean;
import sort.bean.Sort_lift;
import sort.bean.Sort_right;
import sort.bean.detailsBean;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
//
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();
    @POST
    Observable<Login> getDengLu(@Url String name, @QueryMap Map<String, String> paw);
    @GET("product/getCatagory")
    Observable<Sort_lift> lift();
    @GET
    Observable<Sort_right> right(@Url String s);
    @GET
    Observable<Commodity_pagingBean> xia(@Url String s);
    @GET
    Observable<detailsBean> spxq(@Url String ss);
    @GET
    Observable<AddcartBean> add(@Url String s);
    @GET
    Observable<QurryBean> qurry(@Url String s);
    @GET
    Observable<AddcartBean> delete(@Url String s);
    @GET
    Observable<AddcartBean> addDd(@Url String s);
    @GET
    Observable<OrderBean> Ddlb(@Url String s);






}
