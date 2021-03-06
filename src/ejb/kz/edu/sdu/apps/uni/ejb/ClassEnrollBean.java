package kz.edu.sdu.apps.uni.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kz.edu.sdu.apps.uni.client.IClassEnrollLocal;
import kz.edu.sdu.apps.uni.client.IClassEnrollRemote;
import kz.edu.sdu.apps.uni.client.dto.ClassDTO;
import kz.edu.sdu.apps.uni.client.dto.ClassSearchFilterDTO;
import kz.edu.sdu.apps.uni.client.exceptions.ClassNotExistsException;
import kz.edu.sdu.apps.uni.ejb.db.ClassEntity;
import kz.edu.sdu.apps.uni.ejb.interfaces.IClassUtilLocal;

@Stateless
public class ClassEnrollBean implements IClassEnrollLocal,IClassEnrollRemote{
	
	@PersistenceContext
	EntityManager em;
	
	@EJB IClassUtilLocal classUtil;
	
	@Override
	public List<ClassDTO> search(ClassSearchFilterDTO filter,int page,int size) {
		String query="Select clazz From ClassEntity clazz left join fetch clazz.termEntity left join fetch clazz.subjectEntity left join fetch clazz.facultyEntity";
		String where=" where ";
		
		boolean and=false;
		boolean isWhere=false;
		if(filter.getFacultyId()!=null) { 
			where+=String.format("clazz.facultyEntity.facultyId=%s",filter.getFacultyId());
			and=true;
			isWhere=true;
		}
		
		if(filter.getTermId()!=null) { 
			where+=(and?" and ":"")+String.format(" clazz.termEntity.termId=%s",filter.getTermId());
			and=true;
			isWhere=true;
		}
		
		if(filter.getSubjectId()!=null) { 
			where+=(and?" and ":"")+String.format(" clazz.subjectEntity.subjectId=%s",filter.getSubjectId());
			and=true;
			isWhere=true;
		}
		
		if(!isWhere) return null;
		
		query+=where;
		System.out.println(query);
		
		List<ClassEntity> classes=em.createQuery(query).getResultList();
		List<ClassDTO> classDtoList=new ArrayList<ClassDTO>();
		
		for(ClassEntity c:classes) {
			classDtoList.add(c.toClassDTO());
		}
		
		return classDtoList;
	}

	@Override
	public ClassDTO getClassById(long id) throws ClassNotExistsException {
		ClassEntity foundClass=classUtil.getClassById(id);
		return foundClass.toClassDTO();
	}		
}
