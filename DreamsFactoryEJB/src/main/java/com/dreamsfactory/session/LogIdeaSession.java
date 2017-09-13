package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.LogIdeaDAO;
import com.dreamsfactory.dto.LogIdeaDTO;
import com.dreamsfactory.entity.LogIdea;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.LogIdeaMapper;

@Stateless
@LocalBean
public class LogIdeaSession {

	@Inject
	private LogIdeaMapper logIdeaMapper;

	@EJB
	private LogIdeaDAO logIdeaDAO;

	public LogIdeaDTO create(LogIdeaDTO logIdeaDTO) throws Exception {
		if (logIdeaDTO.getIdeaId() == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (logIdeaDTO.getUserId() == null) {
			throw new ArgumentMissingException("UserId");
		}
		if (logIdeaDTO.getLog() == null || logIdeaDTO.getLog().trim().isEmpty()) {
			throw new ArgumentMissingException("Log");
		}

		logIdeaDTO.setLogDate(new Date());

		LogIdea log = logIdeaMapper.logIdeaDTOToLogIdea(logIdeaDTO);
		log = logIdeaDAO.insert(log);
		logIdeaDTO = logIdeaMapper.logIdeaToLogIdeaDTO(log);
		return logIdeaDTO;
	}

	public List<LogIdeaDTO> findByIdeaId(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("IdeaId");
		}

		Set<LogIdea> logSet = logIdeaDAO.findByIdeaId(id);
		Set<LogIdeaDTO> dtoSet = logIdeaMapper.logIdeasToLogIdeaDTOs(logSet);

		return new ArrayList<LogIdeaDTO>(dtoSet);
	}

	public LogIdeaDTO findLastByIdeaId(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("IdeaId");
		}

		LogIdea log = logIdeaDAO.findLastByIdeaId(id);
		LogIdeaDTO logIdeaDTO = logIdeaMapper.logIdeaToLogIdeaDTO(log);
		return logIdeaDTO;
	}

	public List<LogIdeaDTO> findByUserId(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("IdeaId");
		}

		Set<LogIdea> logSet = logIdeaDAO.findByUserId(id);
		Set<LogIdeaDTO> dtoSet = logIdeaMapper.logIdeasToLogIdeaDTOs(logSet);

		return new ArrayList<LogIdeaDTO>(dtoSet);
	}

	public LogIdeaDTO findLastByUserId(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("IdeaId");
		}

		LogIdea log = logIdeaDAO.findLastByUserId(id);
		LogIdeaDTO logIdeaDTO = logIdeaMapper.logIdeaToLogIdeaDTO(log);
		return logIdeaDTO;
	}
}
