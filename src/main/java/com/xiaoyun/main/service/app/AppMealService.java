package com.xiaoyun.main.service.app;

import java.util.List;

import com.xiaoyun.main.model.Meal;
import com.xiaoyun.main.service.base.BaseService;

public interface AppMealService extends BaseService<Meal> {

	List<Meal> getMealList();
}
