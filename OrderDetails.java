package com.amazonaws.accessor;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
/*Author : Ashwini.
 * OrderDetails like Item Cost, ItemId and TrackingId.
 * If a user puts an order this class will be executed.
 * 
 */

@DynamoDBTable(tableName = "OrderDetails")
public class OrderDetails implements DynamoDBEntity {
	public String ItemId;
	public String Itemcost;
	public String TrackingId;

	/*
	 * Each item has an Id. Using this id we can find out Item cost.
	 * 
	 */
	@DynamoDBHashKey(attributeName = "ItemId")
	public String getItemId() {
		return ItemId;
	}

	public void setRestaurantName(String Itemcost) {
		this.Itemcost = Itemcost;
	}

	@DynamoDBAttribute(attributeName = "Itemcost")
	public String getItemcost() {
		return Itemcost;
	}

	public void setItemcost(String Itemcost) {
		this.Itemcost = Itemcost;
	}

	@DynamoDBAttribute(attributeName = "TrackingId")
	public String getTrackingId() {
		return TrackingId;
	}

	public void setTrackingId(String TrackingId) {
		this.TrackingId = TrackingId;
	}

	public void validate() {
		// TODO
	}

}
