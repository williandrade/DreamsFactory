package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.TagDAO;
import com.dreamsfactory.dto.TagDTO;
import com.dreamsfactory.entity.Tag;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.TagMapper;

@Stateless
@LocalBean
public class TagSession {

	@EJB
	private TagDAO tagDAO;

	@Inject
	private TagMapper tagMapper;

	public TagDTO findById(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("ID");
		}
		Tag tag = tagDAO.findById(id);
		return tagMapper.tagToTagDTO(tag);
	}

	public List<TagDTO> completeByName(String name) throws Exception {
		Set<Tag> tags = new HashSet<>();

		try {
			name = name.trim();

			if (name == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new ArgumentMissingException("Name");
		}

		tags.addAll(tagDAO.searchByName(name));

		List<TagDTO> result = new ArrayList<>(tagMapper.tagsToTagDTOs(tags));
		return result;
	}

	public List<TagDTO> findAll() throws Exception {
		Set<Tag> tags = tagDAO.findAll();

		List<TagDTO> result = new ArrayList<>(tagMapper.tagsToTagDTOs(tags));

		return result;
	}

	public TagDTO create(TagDTO tagDTO) throws Exception {
		try {
			tagDTO.setName(tagDTO.getName().trim());

			if (tagDTO.getName() == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new ArgumentMissingException("Name");
		}

		Tag tag = tagMapper.tagDTOToTag(tagDTO);
		tag = tagDAO.insert(tag);
		return tagMapper.tagToTagDTO(tag);
	}

	public TagDTO update(TagDTO tagDTO) throws Exception {
		if (tagDTO.getId() == null) {
			throw new ArgumentMissingException("ID");
		}

		try {
			tagDTO.setName(tagDTO.getName().trim());

			if (tagDTO.getName() == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new ArgumentMissingException("Name");
		}

		Tag tag = tagMapper.tagDTOToTag(tagDTO);
		tag = tagDAO.update(tag);
		return tagMapper.tagToTagDTO(tag);
	}

	public void delete(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("ID");
		}
		tagDAO.delete(id);
	}
}
