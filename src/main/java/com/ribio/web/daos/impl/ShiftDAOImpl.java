package com.ribio.web.daos.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.source.DataSourceConnector;
import com.ribio.web.domains.Shift;

@Repository
public class ShiftDAOImpl {
	private static Logger logger = Logger.getLogger(ShiftDAOImpl.class);

	@Autowired
	DataSourceConnector dsConnector;

	public List<Shift> getAllShifts() throws DataServiceException {
		List<Shift> shifts = null;
		try {
			Session session = dsConnector.getSession();
			session.beginTransaction();

			Query<Shift> query = session.createQuery("from Shift", Shift.class);
			shifts = query.list();

			logger.info("Shifts data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(e.getMessage(), e);
		}
		return shifts;
	}
}
