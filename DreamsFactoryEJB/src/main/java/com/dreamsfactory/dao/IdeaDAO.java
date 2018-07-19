package com.dreamsfactory.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.dto.IdeaSearchDTO;
import com.dreamsfactory.entity.Idea;

@Stateless
@LocalBean
public class IdeaDAO extends GenericDAO<Idea> {

	public IdeaDAO() {
		super(Idea.class);
	}

	public List<IdeaSearchDTO> findAllBasic() {
		String hql = "Select new com.dreamsfactory.dto.IdeaSearchDTO(i.id, i.name, i.shortDescription) from Idea i";
		Query query = this.getEm().createQuery(hql);
		return query.getResultList();
	}

	public List<IdeaSearchDTO> findTop(Integer qtd) {
		String hql = "Select new com.dreamsfactory.dto.IdeaSearchDTO(i.id, i.name, i.shortDescription, count(li.id)) from Idea i left join i.likeIdeaSet as li group by i.id order by count(li.id) desc";
		Query query = this.getEm().createQuery(hql);
		query.setMaxResults(qtd);
		return query.getResultList();
	}

}
