package com.foodApp.Dao;

import com.foodApp.Dto.Restaurant;

public interface RestaurantDao
{
  public Restaurant add(Restaurant r);
  public Restaurant update(Restaurant r);
  public Restaurant getOne(int restaurantId);
  public boolean delete(int restaurantId);
}
