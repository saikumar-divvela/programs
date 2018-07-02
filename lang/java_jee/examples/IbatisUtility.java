package com.theatre.utils;

import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisUtility {
	private static SqlMapClient sqlMap;
		static {
			try {
				String resource ="properties/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader ("properties/SqlMapConfig.xml");
				sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			}	 catch(Exception exp) {
				System.err.println("Exception getting Sqlmap client:" + exp.getMessage());
				exp.printStackTrace();
			}
		}
	public static SqlMapClient getSqlMapInstance () {
		return sqlMap;
	}
}


