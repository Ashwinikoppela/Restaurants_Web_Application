package com.amazonaws.accessor;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "RestaurantsList")

public class RestaurantsList implements DynamoDBEntity
{
	public String RestaurantName;
	public String FoodItem;
	public String ItemId;

	 @DynamoDBHashKey(attributeName="RestaurantName")  
	    public String getRestaurantName()
	    { 
	    	return RestaurantName;
	    }
	    public  void setRestaurantName(String RestaurantName) 
	    {
	    	this.RestaurantName = RestaurantName;
	    }
	    
	    @DynamoDBAttribute(attributeName="FoodItem")  
	    public String getFoodItem() {
	    	return FoodItem; 
	    	}
	    public void setFoodItem(String FoodItem)
	    { 
	    	this.FoodItem = FoodItem;
	    }
	    
	    @DynamoDBAttribute(attributeName="ItemId")  
	    public String getItemId() { 
	    	return ItemId; 
	    	}
	    public void setItemId(String ItemId) {
	    	this.ItemId = ItemId; 
	    	}
	    public void validate() {
	    	//TODO
	    }
	    
	  
	
	}
