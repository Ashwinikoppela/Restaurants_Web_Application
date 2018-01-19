package com.amazonaws.accessor;

import java.util.Optional;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.Builder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.ecs.model.TaskOverride;
import com.amazonaws.util.Classes;

/*@Author: Ashwini.
 * DynamoDBAccessor class is for creating CRUD operations.
 * Create, Read, Update, Delete operations.
 */
public class DynamoDBAccessor {

	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
	static DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);

	public <T extends DynamoDBEntity> void save(final T entity) {
		dynamoDBMapper.save(entity, (DynamoDBSaveExpression) null);
	}

	// TODO DynamoDb Mapper Config for a saving the items in DB.
	public <T extends DynamoDBEntity> void save(final T entity, final DynamoDBMapperConfig config)
			throws AmazonClientException, AmazonServiceException {
		entity.validate();
		try {
			dynamoDBMapper.save(entity, config);
		} catch (final RuntimeException e) {
			throw e;
		}
	}

	public <T extends DynamoDBEntity> Optional<T> get(final Class<T> entityClass, final String HashKey,
			final Optional<String> rangeKey) throws AmazonClientException, AmazonServiceException {

		final T entity;
		if (rangeKey.isPresent()) {
			entity = dynamoDBMapper.load(entityClass, HashKey, rangeKey.get());
		} else {
			entity = dynamoDBMapper.load(entityClass, HashKey);
		}
		return Optional.ofNullable(entity);

	}

}
