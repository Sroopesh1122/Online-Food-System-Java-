package com.foodApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.foodApp.Connection.ConnectionFactory;
import com.foodApp.Dto.FoodItem;
import com.foodApp.Exception.CustomException;

public class FoodItemDaoImpl implements FoodItemDao {
	
	Connection connection=null;
	
	public FoodItemDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}
	

	@Override
	public FoodItem add(FoodItem foodItem) throws CustomException {
		String query = "INSERT INTO FOOD_ITEMS (RESTAURANT_ID,NAME,DESCRIPTION,PRICE,CATEGORY,AVAILABILITY,IMG) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query ,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, foodItem.getRestaurantId());
			preparedStatement.setString(2, foodItem.getName());
			preparedStatement.setString(3,foodItem.getDescription());
			preparedStatement.setDouble(4, foodItem.getPrice());
			preparedStatement.setString(5, foodItem.getCategory());
			preparedStatement.setInt(6, foodItem.getAvailability());
			preparedStatement.setString(7, foodItem.getImg());
			if(preparedStatement.executeUpdate() > 0)
			{
				ResultSet keys = preparedStatement.getGeneratedKeys();
				if(keys.next())
				{
					foodItem.setFoodId(keys.getInt(1));
				}
				return foodItem;
				
			}else {
			  throw new CustomException("Failed to Add");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FoodItem update(FoodItem foodItem) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem getOne(int foodId) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int foodId) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}

}
