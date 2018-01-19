package com.amazonaws.accessor;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
/*@author : Ashwini.
 * CustomerList class used to set the User Account Details like
 * Login Id and Password.
 */


@DynamoDBTable(tableName = "CustomersList")
public class CustomersList implements DynamoDBEntity
{
	public String Loginid;
	public String Password;
	@DynamoDBHashKey(attributeName = "Loginid")
	public String getLoginId()
	{
		/* It returns LoginId of customer Account.
		 *  using GET method.
		 */
		return Loginid;
	}
	public void setLoginId(String Loginid)
	{
		/* set the LoginId.  
		 * Parameter is Loginid.
		 */
		this.Loginid = Loginid;
	}
	 @DynamoDBAttribute(attributeName = "Password")
	public String getPassword()
	{
		 /* It returns Password of customer Account.
			 *  using GET method.
			 */
		return Password;
	}
	public void setPassword(String Password)
	{
		/*set the Password.  
		 * Parameter is Password.
		 * It takes the parameter and set to current password.
		 */
		this.Password = Password;
	}
	 public void validate() {
	    
	    }
	
	
}