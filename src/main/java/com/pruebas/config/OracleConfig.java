package com.pruebas.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import oracle.jdbc.pool.OracleDataSource;

/**
 * Clase de configuración parámetros conexión oracle
 * @author Z052886
 *
 */
@Configuration
public class OracleConfig {
	
//	@Value("${url.oracle}")
	private String urlOracle = "jdbc:oracle:thin:@localhost:1521:xe";     

//	@Value("${user.oracle}")
	private String userOracle = "system";

//	@Value("${pass.oracle}")
	private String passOracle = "oracle";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OracleConfig.class);
	
	@Bean
	DataSource dataSource() throws SQLException{
		
		if(urlOracle == null || urlOracle.isEmpty() || "".equals(urlOracle)) {
			LOGGER.error("NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - url.oracle. LA APLICACION SE TERMINARÁ");
		} else if(userOracle == null || userOracle.isEmpty() || "".equals(userOracle)) {
			LOGGER.error("NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - user.oracle");
		} else if(passOracle == null || passOracle.isEmpty() || "".equals(passOracle)) {
			LOGGER.error("NO SE ENCUENTRA LA CONFIGURACIÓN DE ORACLE. REVISAR CONFIG-SERVICE - pass.oracle");
		}
		
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(userOracle);
		dataSource.setPassword(passOracle);
		dataSource.setURL(urlOracle);
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		
		return dataSource;
	}

}