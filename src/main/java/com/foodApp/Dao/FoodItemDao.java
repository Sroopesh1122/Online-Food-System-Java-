package com.foodApp.Dao;

import java.util.List;

import com.foodApp.Dto.FoodItem;
import com.foodApp.Exception.CustomException;

public interface FoodItemDao
{
  public FoodItem add(FoodItem foodItem) throws CustomException;
  public FoodItem update(FoodItem foodItem) throws CustomException ;
  public FoodItem getOne(int foodId) throws CustomException ;
  public boolean delete(int foodId) throws CustomException ;
  public int totalFoodItem (int restaurantId ,String text) throws CustomException;
  public List<FoodItem> getFoodItem (int restaurantId ,String text ,int page ,int limit) throws CustomException;
}
