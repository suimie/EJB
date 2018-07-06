<?xml version="1.0" encoding="UTF-8"?>


<persistence version="2.1"
	xmlns="http://xmlns.jcp.org/xml/ns/persistence" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence 
	http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	
	<persistence-unit name="punit1">

		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpa" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="root" />
		<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
		
		</properties>
		
	</persistence-unit>

</persistence>