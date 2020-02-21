package jp.co.htv.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import jp.co.htv.demo.entity.Province;

/**
 * Province Service Class
 * @author hainp
 *
 */
public interface ProvinceService {
	List<Province> findAll(Sort sort);
}
