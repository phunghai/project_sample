package jp.co.htv.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.htv.demo.entity.Province;
import jp.co.htv.demo.repository.ProvinceRepository;

/**
 * Province Service Implement
 * @author hainp
 *
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
	/** Province Repository **/
	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public List<Province> findAll(Sort sort) {
		return provinceRepository.findAll();
	}

	@Override
	public List<Province> findAllByOrderByCodeAsc() {
		return provinceRepository.findAllByOrderByCodeAsc();
	}

}
