package com.amazonaws.accessor;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "MusicList")
public class CatalogItem implements DynamoDBEntity {

	public String NameOfSong;
	public String Year;
	public String Favsong;

	@DynamoDBHashKey(attributeName = "NameOfSong")
	public String getNameOfSong() {
		return NameOfSong;
	}

	public void setNameOfSong(String NameOfSong) {
		this.NameOfSong = NameOfSong;
	}

	@DynamoDBRangeKey(attributeName = "Year")
	public String getYear() {
		return Year;
	}

	public void setYear(String Year) {
		this.Year = Year;
	}

	@DynamoDBAttribute(attributeName = "Favsong")
	public String getFavsong() {
		return Favsong;
	}

	public void setFavsong(String Favsong) {
		this.Favsong = Favsong;
	}

	public void validate() {
		// TODO
	}
}