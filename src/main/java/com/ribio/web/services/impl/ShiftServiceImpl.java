package com.ribio.web.services.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ribio.web.daos.exception.DataServiceException;
import com.ribio.web.daos.impl.ShiftDAOImpl;
import com.ribio.web.domains.Shift;
import com.ribio.web.services.exception.BusinessServiceException;

@Service
public class ShiftServiceImpl{

	private static Logger logger = Logger.getLogger(ShiftServiceImpl.class);

	@Autowired
	ShiftDAOImpl shiftDAO;


	public List<Shift> getAllShifts() throws BusinessServiceException {
		List<Shift> shifts = null;
		try {
			shifts = shiftDAO.getAllShifts();
		} catch (DataServiceException e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
		logger.info("Organizations retrieved successfully.");
		return shifts;
	}

}