package com.foodApp.Dao;

import com.foodApp.Dto.FoodItem;

public interface FoodItemDao
{
  public FoodItem add(FoodItem foodItem);
  public FoodItem update(FoodItem foodItem);
  public FoodItem getOne(int foodId);
  public boolean delete(int foodId);
}
