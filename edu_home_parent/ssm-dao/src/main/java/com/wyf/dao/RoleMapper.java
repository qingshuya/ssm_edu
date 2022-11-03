package com.wyf.dao;

import com.wyf.domain.Role;
import com.wyf.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    // 查询所有角色信息&条件查询
    public List<Role> findAllRole(Role role);

    // 根据角色id查询所关联的菜单id
    public List<Integer> findAllMenuIdByRoleId(int roleId);

    /**
     *  为角色分配菜单列表：本质上是向中间表中插入数据
     *  1.要删除该角色在中间表的关联信息
     *  2.为角色分配关联信息 ===》避免数据重复
     */
    public void deleteRoleMenu(Integer rid);

    public void saveRoleMenu(Role_menu_relation roleMenuRelation);

    // 根据角色id删除角色信息：注意：因为角色和菜单有关联关系，因此删除之前要先清空关联关系
    public void deleteRole(Integer rid);


}
