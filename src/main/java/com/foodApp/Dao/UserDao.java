package com.foodApp.Dao;

import com.foodApp.Dto.User;

public interface UserDao
{
  public User add(User u);
  public User update(User u);
  public User getOne(int userId);
  public boolean delete(int userId);
}
