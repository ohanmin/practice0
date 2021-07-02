package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.EmpDTO;
import poly.persistance.mapper.IEmpMapper;
import poly.service.IEmpService;

@Service("EmpService")
public class EmpService implements IEmpService{
	@Resource(name="EmpMapper")
	IEmpMapper empMapper;
	@Override
	public List<EmpDTO> getEmpList() {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(this.getClass());
		List<EmpDTO> rList = empMapper.getEmpList();
		List<EmpDTO> pList = new ArrayList<>();
		for(EmpDTO eDTO : rList) {
			log.info("ename : "+ eDTO.getEname());
			log.info("empno: " +eDTO.getEmpno());
			if(Integer.parseInt(eDTO.getEmpno()) %2==0) {
				pList.add(eDTO);
			}
		}
		return pList;
	}
	@Override
	public List<EmpDTO> getManagerList() {
		// TODO Auto-generated method stub

		return empMapper.getManagerList();
	}

}
