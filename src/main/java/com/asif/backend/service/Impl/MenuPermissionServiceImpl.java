package com.asif.backend.service.Impl;

import com.asif.backend.common.Utils.Helper;
import com.asif.backend.common.constant.ApplicationConstant;
import com.asif.backend.common.constant.ErrorId;
import com.asif.backend.common.exception.RmsServerException;
import com.asif.backend.generic.service.AbstractService;
import com.asif.backend.model.Menu;
import com.asif.backend.model.MenuPermission;
import com.asif.backend.model.Role;
import com.asif.backend.payload.request.MenuPermissionDto;
import com.asif.backend.repository.MenuPermissionRepository;
import com.asif.backend.repository.MenuRepository;
import com.asif.backend.repository.RoleRepository;
import com.asif.backend.service.MenuPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service
public class MenuPermissionServiceImpl extends AbstractService<MenuPermission, MenuPermissionDto>
        implements MenuPermissionService {

    private final MenuPermissionRepository menuPermissionRepository;
    private final RoleRepository roleRepository;

    private final MenuRepository menuRepository;

    public MenuPermissionServiceImpl(MenuPermissionRepository menuPermissionRepository, RoleRepository roleRepository,
                                     MenuRepository menuRepository) {
        super(menuPermissionRepository);
        this.menuPermissionRepository = menuPermissionRepository;
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    protected <T> T convertToResponseDto(MenuPermission menuPermission) {
        return null;
    }

    @Override
    protected MenuPermission convertToEntity(MenuPermissionDto menuPermissionDto) {
        return saveOrUpdate(menuPermissionDto);
    }

    @Override
    protected MenuPermission convertToEntity(MenuPermissionDto menuPermissionDto, MenuPermission entity) {
        return null;
    }

    /**
     * This method is responsible for assign menu to a specific role via Menu Permission entity
     *
     * @param dto {@link MenuPermissionDto}
     * @return MenuPermission
     * <p>
     * the return is an entity of MenuPermission
     */
    private MenuPermission saveOrUpdate(MenuPermissionDto dto) {
        Optional<MenuPermission> optionalPermission = menuPermissionRepository.findByRoleId(dto.getRoleId());

        //checking if permission exist with given role id
        Set<Long> menuIds = dto.getMenuIds();
        if (optionalPermission.isEmpty()) {

            MenuPermission entity = new MenuPermission();

            Role role = roleRepository.findById(dto.getRoleId()).orElseThrow(() -> RmsServerException.notFound
                    (Helper.createDynamicCode(ErrorId.NOT_FOUND_DYNAMIC, ApplicationConstant.ROLE)));

            entity.setRole(role);

            Set<Menu> menuSet = new HashSet<>(menuRepository.findAllByIdIn(menuIds));

            entity.setMenuSet(menuSet);
            return entity;
        }

        MenuPermission menuPermission = optionalPermission.get();

        Set<Menu> menuSet = menuPermission.getMenuSet();


        Iterator<Menu> menuIterator = menuSet.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = menuIterator.next();

            //Removing menuIds from dto if those menu has already given permission
            if (menuIds.contains(menu.getId())) {
                menuIds.remove(menu.getId());
            } else {
                menuIterator.remove(); // removing those permitted menu whose menu id not contains in dto menuSet
            }
        }

        /**
         * check if there is any element in dto menuSet
         *
         * if any element is present that means new menu show add to existing Menu permission set
         */
        if (!CollectionUtils.isEmpty(menuIds)) {
            Set<Menu> newMenuSet = new HashSet<>(menuRepository.findAllByIdIn(menuIds));
            menuSet.addAll(newMenuSet);
        }

        menuPermission.setMenuSet(menuSet);
        return menuPermission;

    }
}
