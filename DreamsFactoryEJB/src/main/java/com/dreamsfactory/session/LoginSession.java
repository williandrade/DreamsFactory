package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.dto.SignInDTO;
import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.util.Constants;
import com.dreamsfactory.util.Md5ConverterUtil;

@Stateless
@LocalBean
public class LoginSession {

	@EJB
	private UserSession userSession;

	public UserDTO signIn(SignInDTO signInDTO) throws Exception {

		if (signInDTO.getLogin() == null || signInDTO.getLogin().trim().isEmpty()) {
			throw new ArgumentMissingException("login");
		}
		if (signInDTO.getPassword() == null || signInDTO.getPassword().trim().isEmpty()) {
			throw new ArgumentMissingException("password");
		}

		UserDTO fromDb = userSession.findByLogin(signInDTO.getLogin());

		if (fromDb == null) {
			throw new Exception("The user do not Exist");
		}

		if (!fromDb.getPassword().equals(Md5ConverterUtil.getMD5Hex(signInDTO.getPassword()))) {
			throw new Exception("The password is wrong");
		}

		fromDb = this.updateUuid(fromDb);

		return fromDb;
	}

	public UserDTO signUp(UserDTO userDTO) throws Exception {
		this.validUser(userDTO);

		UserDTO onDb = userSession.findByLogin(userDTO.getLogin());

		if (onDb != null) {
			throw new Exception("The user already Exist");
		}

		String md5Pass = Md5ConverterUtil.getMD5Hex(userDTO.getPassword());
		userDTO.setPassword(md5Pass);

		userDTO = userSession.create(userDTO);

		return userDTO;
	}

	private UserDTO updateUuid(UserDTO fromDb) throws Exception {
		Date lastUuid = fromDb.getUuidGenerationDate();

		if (!this.isInTime(lastUuid)) {
			fromDb.setUuid(UUID.randomUUID().toString());
			fromDb.setUuidGenerationDate(new Date());

			fromDb = userSession.update(fromDb);

			lastUuid = fromDb.getUuidGenerationDate();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(lastUuid);
		cal.add(Calendar.MINUTE, Constants.USER_EXPIRATION_TIME);

		fromDb.setExpirationDate(cal.getTime());

		return fromDb;
	}

	private void validUser(UserDTO user) throws Exception {
		List<String> arguments = new ArrayList<>();

		if (user.getFirstName() == null || user.getPassword().trim().isEmpty()) {
			arguments.add("FirstName");
		}
		if (user.getLastName() == null || user.getPassword().trim().isEmpty()) {
			arguments.add("lastName");
		}
		// if (user.getBirthDate() == null) {
		// arguments.add("birthDate");
		// }
		if (user.geteMail() == null || user.getPassword().trim().isEmpty()) {
			arguments.add("eMail");
		}
		if (user.getLogin() == null || user.getPassword().trim().isEmpty()) {
			arguments.add("login");
		}
		if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			arguments.add("password");
		}

		if (!arguments.isEmpty()) {
			String[] arr = arguments.toArray(new String[arguments.size()]);
			throw new ArgumentMissingException(arr);
		}
	}

	private Boolean isInTime(Date date) {
		Boolean result = false;

		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			cal.add(Calendar.MINUTE, Constants.USER_EXPIRATION_TIME);

			if (cal.getTime().after(new Date())) {
				result = true;
			}
		}

		return result;
	}
}
