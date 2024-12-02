package com.foodApp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		String query="SELECT * FROM FOOD_ITEMS WHERE FOOD_ID=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, foodId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				FoodItem foodItem = new FoodItem();
				foodItem.setFoodId(rs.getInt(1));
				foodItem.setRestaurantId(rs.getInt(2));
				foodItem.setName(rs.getString(3));
				foodItem.setDescription(rs.getString(4));
				foodItem.setPrice(rs.getDouble(5));
				foodItem.setCategory(rs.getString(6));
				foodItem.setAvailability(rs.getInt(7));
				foodItem.setCreatedAt(rs.getTimestamp(8));
				foodItem.setImg(rs.getString(9));
				return foodItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomException(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean delete(int foodId) throws CustomException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int totalFoodItem(int restaurantId,String text) throws CustomException {
		String query;
		if(text !=null)
    	{
    		query = "SELECT COUNT(*) FROM FOOD_ITEMS WHERE RESTAURANT_ID = ? AND ( NAME LIKE ? OR CATEGORY LIKE ?) ";
    	}else {
    		query = "SELECT COUNT(*) FROM FOOD_ITEMS WHERE RESTAURANT_ID = ?";
    	}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, restaurantId);
			if(text!=null)
			{
				preparedStatement.setString(2, "%"+text+"%");
				preparedStatement.setString(3, "%"+text+"%");
			}
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
    @Override
	public List<FoodItem> getFoodItem(int restaurantId,String text,int page,int limit) throws CustomException {
    	String query = null;
    	int skip = (page -1 )* limit;
    	if(text !=null)
    	{
    		query = "SELECT * FROM FOOD_ITEMS WHERE RESTAURANT_ID = ? AND ( NAME LIKE ? OR CATEGORY LIKE ?)  LIMIT ? OFFSET ?";
    	}else {
    		query = "SELECT * FROM FOOD_ITEMS WHERE RESTAURANT_ID = ?  LIMIT ? OFFSET ?";
    	}
    	List<FoodItem> foodItems = new ArrayList();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, restaurantId);
			if(text!=null)
			{
				preparedStatement.setString(2, "%"+text+"%");
				preparedStatement.setString(3, "%"+text+"%");
				preparedStatement.setInt(4, limit);
				preparedStatement.setInt(5, skip);
			}else {
				preparedStatement.setInt(2, limit);
				preparedStatement.setInt(3, skip);
			}
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				FoodItem foodItem = new FoodItem();
				foodItem.setFoodId(rs.getInt(1));
				foodItem.setRestaurantId(rs.getInt(2));
				foodItem.setName(rs.getString(3));
				foodItem.setDescription(rs.getString(4));
				foodItem.setPrice(rs.getDouble(5));
				foodItem.setCategory(rs.getString(6));
				foodItem.setAvailability(rs.getInt(7));
				foodItem.setCreatedAt(rs.getTimestamp(8));
				foodItem.setImg(rs.getString(9));
				foodItems.add(foodItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodItems;
	}
	

}
