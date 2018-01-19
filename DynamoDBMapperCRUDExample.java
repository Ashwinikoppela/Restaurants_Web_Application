package com.amazonaws.accessor;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
/*@Author : Ashwini.
 * 
 * Example of DynamoDBMapper.
 */

public class DynamoDBMapperCRUDExample {

	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

	static DynamoDBMapper mapper = new DynamoDBMapper(client);

	public void testCRUDOperations() {
		CatalogItem item = new CatalogItem();
		item.setNameOfSong("endhkoemito");
		item.setYear("2008");
		item.setFavsong("hellohelloliyla");

		// Save the item (book).
		mapper.save(item);

		// Retrieve the item.
		CatalogItem itemRetrieved = mapper.load(CatalogItem.class, "Arjith", "2017");
		System.out.println("Item retrieved:");
		System.out.println(itemRetrieved);

		// Update the item.
		itemRetrieved.setNameOfSong("yeyemetoo");
		itemRetrieved.setFavsong("Favsong");
		itemRetrieved.setYear("2004");

		mapper.save(itemRetrieved);
		System.out.println("Item updated:");
		System.out.println(itemRetrieved);

		OrderDetails orderDetails = mapper.load(OrderDetails.class, "", "");

		@SuppressWarnings("deprecation")
		DynamoDBMapperConfig config = new DynamoDBMapperConfig(DynamoDBMapperConfig.ConsistentReads.CONSISTENT);
		CatalogItem updatedItem = mapper.load(CatalogItem.class, "yeyemetoo", "2004", config);
		System.out.println("Retrieved the previously updated item:");
		System.out.println(updatedItem);

		// Delete the item.
		mapper.delete(updatedItem);

		// Try to retrieve deleted item.
		CatalogItem deletedItem = mapper.load(CatalogItem.class, updatedItem.getFavsong(), updatedItem.getYear(),
				config);
		if (deletedItem == null) {
			System.out.println("Done - Sample item is deleted.");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamoDBMapperCRUDExample object = new DynamoDBMapperCRUDExample();
		object.testCRUDOperations();

		System.out.println("Example complete!");
	}

}
