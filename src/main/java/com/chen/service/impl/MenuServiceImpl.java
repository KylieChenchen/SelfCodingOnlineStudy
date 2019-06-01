package com.chen.service.impl;

import com.chen.dao.MenuMapper;
import com.chen.service.MenuService;
import com.chen.vo.VMenuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuDao;
    @Override
    public List<VMenuInfo> findMenu() {
        return menuDao.findMenu();
    }
}
