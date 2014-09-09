package com.thumbwar.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-09T22:39:11.529+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> userID;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> password;
}
